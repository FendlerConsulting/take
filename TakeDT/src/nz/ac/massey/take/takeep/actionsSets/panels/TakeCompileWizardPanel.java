package nz.ac.massey.take.takeep.actionsSets.panels;

import java.util.LinkedList;

import nz.ac.massey.take.takeep.actionsSets.wizards.TakeCompilerWizard;
import nz.ac.massey.take.takeep.editor.TakeEditor;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.ui.wizards.TypedElementSelectionValidator;
import org.eclipse.jdt.internal.ui.wizards.TypedViewerFilter;
import org.eclipse.jdt.ui.IJavaElementSearchConstants;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.views.navigator.ResourceComparator;

public class TakeCompileWizardPanel extends WizardPage {

	public TakeCompileWizardPanel(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	private String packageName = "generated.nz.ac";
	private String className = "KB";

	private String sourceOutputLocation = "src";

	private boolean includeTakeLibrary = false;
	private String includeTakeLibraryLocation = "lib";
	
	private LinkedList<String> importStatements = new LinkedList<String>();

	private LinkedList<String> additionalInterfaces = new LinkedList<String>();

	private boolean autoAnotate = true;
	private boolean sourceTransform = true;

	@Override
	public void createControl(Composite parent) {

		initializeDialogUnits(parent);

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setFont(parent.getFont());

		int nColumns = 4;

		GridLayout layout = new GridLayout();
		layout.numColumns = nColumns;
		composite.setLayout(layout);

		addNamingPanel(composite, nColumns);
		addLocationPanel(composite, nColumns);

		addImportPanel(composite, nColumns);

		addInterfacePanel(composite, nColumns);

		addCheckPanel(composite, nColumns);

		this.setControl(composite);
	}

	private void addNamingPanel(Composite parent, int numcols) {
		Composite topLevel = new Composite(parent, SWT.NONE);
		topLevel.setLayout(new GridLayout(3, false));
		topLevel.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false, numcols, 1));

		Label pnLbl = new Label(topLevel, SWT.CENTER);
		pnLbl.setText("Package Name");

		final Text pnTB = new Text(topLevel, SWT.SINGLE);
		pnTB.setText(this.packageName);
		pnTB.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true,
				false));
		pnTB.addListener(SWT.Modify, new Listener() {

			@Override
			public void handleEvent(Event event) {
				TakeCompileWizardPanel.this.packageName = pnTB.getText();

			}
		});

		final IWorkbenchPage iworkbenchpage = getWorkbench();
		if (iworkbenchpage == null)
			return;

		Button pnbtn = new Button(topLevel, SWT.PUSH);
		pnbtn.setText("Browse");

		pnbtn.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					SelectionDialog dialog = JavaUI
							.createPackageDialog(
									getShell(),
									JavaCore
											.create(getProjectFromWorkbench(iworkbenchpage)),
									SWT.NONE);

					if (dialog.open() == IDialogConstants.CANCEL_ID)
						return;

					Object[] types = dialog.getResult();
					if (types == null || types.length == 0)
						return;

					for (Object o : types) {
						// org.eclipse.jdt.internal.core.PackageFragment
						String elementName = ((IPackageFragment) o)
								.getElementName();
						pnTB.setText(elementName);
						TakeCompileWizardPanel.this.packageName = elementName;
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		Label cnLbl = new Label(topLevel, SWT.CENTER);
		cnLbl.setText("Class Name");

		final Text cnTB = new Text(topLevel, SWT.SINGLE);
		cnTB.setText(this.className);
		cnTB.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true,
				false));
		cnTB.addListener(SWT.Modify, new Listener() {

			@Override
			public void handleEvent(Event event) {
				TakeCompileWizardPanel.this.className = cnTB.getText();

			}
		});
	}

	private void addLocationPanel(Composite parent, int numcols) {
		Composite topLevel = new Composite(parent, SWT.NONE);
		topLevel.setLayout(new GridLayout(3, false));
		topLevel.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false, numcols, 1));

		Label lLbl = new Label(topLevel, SWT.CENTER);
		lLbl.setText("Source Output Location Folder");

		final Text lTB = new Text(topLevel, SWT.SINGLE);
		lTB.setText(this.sourceOutputLocation);
		lTB.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true,
				false));

		lTB.addListener(SWT.Modify, new Listener() {

			@Override
			public void handleEvent(Event event) {
				TakeCompileWizardPanel.this.sourceOutputLocation = lTB
						.getText();

			}
		});

		IWorkbenchPage iworkbenchpage = getWorkbench();
		if (iworkbenchpage == null)
			return;

		final IProject project = getProjectFromWorkbench(iworkbenchpage);

		Button lcbtn = new Button(topLevel, SWT.PUSH);
		lcbtn.setText("Browse");

		lcbtn.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				try {

					IFolder chooseFolder = chooseFolder(project, "Title",
							"message", project.getLocation());
					if (chooseFolder == null)
						return;
					TakeCompileWizardPanel.this.sourceOutputLocation = chooseFolder
							.getProjectRelativePath().toString();
					lTB
							.setText(TakeCompileWizardPanel.this.sourceOutputLocation);


				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		
		try {
		TakeEditor.getProjectClassLoader(JavaCore.create(project)).loadClass("nz.org.take.rt.AbstractIterator");
		} catch (ClassNotFoundException e1) {
			
			includeTakeLibrary = true;
			final Button ilcbtn = new Button(topLevel, SWT.CHECK);
			ilcbtn.setText("Install Take Runtime Library");
			ilcbtn.setSelection(includeTakeLibrary);
			
			final Text ilTB = new Text(topLevel, SWT.SINGLE);
			ilTB.setText(this.includeTakeLibraryLocation);
			ilTB.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true,
					false));

			ilTB.addListener(SWT.Modify, new Listener() {

				@Override
				public void handleEvent(Event event) {
					TakeCompileWizardPanel.this.includeTakeLibraryLocation = ilTB.getText();

				}
			});
			
			
			final Button ilbtn = new Button(topLevel, SWT.PUSH);
			ilbtn.setText("Browse");
			
			Label note = new Label(topLevel,SWT.LEFT);
			note.setText("Note: manual addition to classpath needed");
			
			ilbtn.addSelectionListener(new SelectionListener() {

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
				}

				@Override
				public void widgetSelected(SelectionEvent e) {
					try {

						IFolder chooseFolder = chooseFolder(project, "Title",
								"message", project.getLocation());
						if (chooseFolder == null)
							return;
						TakeCompileWizardPanel.this.includeTakeLibraryLocation = chooseFolder
								.getProjectRelativePath().toString();
						ilTB
								.setText(TakeCompileWizardPanel.this.includeTakeLibraryLocation);


					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}
			});
			
			ilcbtn.addSelectionListener(new SelectionListener(){

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {}

				@Override
				public void widgetSelected(SelectionEvent e) {
					includeTakeLibrary = ilcbtn.getSelection();
					ilbtn.setEnabled(includeTakeLibrary);
					ilTB.setEnabled(includeTakeLibrary);
				}});
		}


	}

	private IFolder chooseFolder(IProject currProject, String title,
			String message, IPath initialPath) {
		Class[] acceptedClasses = new Class[] { IFolder.class };
		ISelectionStatusValidator validator = new TypedElementSelectionValidator(
				acceptedClasses, false);
		ViewerFilter filter = new TypedViewerFilter(acceptedClasses, null);

		ILabelProvider lp = new WorkbenchLabelProvider();
		ITreeContentProvider cp = new WorkbenchContentProvider();

		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
				getShell(), lp, cp);
		dialog.setValidator(validator);
		dialog.setTitle(title);
		dialog.setMessage(message);
		dialog.addFilter(filter);
		dialog.setInput(currProject);
		dialog.setComparator(new ResourceComparator(ResourceComparator.NAME));
		IResource res = currProject.findMember(initialPath);
		if (res != null) {
			dialog.setInitialSelection(res);
		}

		if (dialog.open() == Window.OK) {
			return (IFolder) dialog.getFirstResult();
		}
		return null;
	}

	private void addImportPanel(Composite parent, int numcols) {
		// Composite topLevel = new Composite(parent, SWT.NONE);
		// topLevel.setLayout(new GridLayout(1,false));
		// topLevel.setLayoutData(new
		// GridData(GridData.FILL,GridData.FILL,true,true,numcols,1));
		//
		// Label iLbl = new Label(topLevel,SWT.CENTER);
		// iLbl.setText("Additional Import Statements");
		//
		// final Text iTB = new Text(topLevel,SWT.MULTI | SWT.V_SCROLL);
		// iTB.setText(sourceOutputLocation);
		// iTB.setLayoutData(new GridData(GridData.FILL,
		// GridData.FILL,true,true));
		// iTB.addListener(SWT.Modify, new Listener(){
		// @Override
		// public void handleEvent(Event event) {
		// importStatements.clear();
		// StringTokenizer st = new
		// StringTokenizer(iTB.getText(),iTB.getLineDelimiter());
		//
		// while(st.hasMoreTokens())
		// {
		// importStatements.add(st.nextToken());
		// }
		//
		// }});

		Composite topLevel = new Composite(parent, SWT.NONE);
		topLevel.setLayout(new GridLayout(2, false));
		topLevel.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
				true, numcols, 1));

		Label iLbl = new Label(topLevel, SWT.CENTER);
		iLbl.setText("Additional Import Statements");
		iLbl.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
				true, 2, 1));

		final List interfaceList = new List(topLevel, SWT.SINGLE);
		interfaceList.setLayoutData(new GridData(GridData.FILL, GridData.FILL,
				true, true));
		Composite right = new Composite(topLevel, SWT.NONE);
		right.setLayout(new GridLayout(1, false));

		Button addBtn = new Button(right, SWT.PUSH);
		addBtn.setText("Add");

		IWorkbenchPage iworkbenchpage = getWorkbench();
		if (iworkbenchpage == null)
			return;

		final IProject project = getProjectFromWorkbench(iworkbenchpage);

		addBtn.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					SelectionDialog dialog = JavaUI.createTypeDialog(
							getShell(), getWizard().getContainer(), project,
							IJavaElementSearchConstants.CONSIDER_ALL_TYPES,
							true);

					if (dialog.open() == IDialogConstants.CANCEL_ID)
						return;

					Object[] types = dialog.getResult();
					if (types == null || types.length == 0)
						return;

					for (Object o : types) {
						// org.eclipse.jdt.internal.core.BinaryType
						String elementName = ((IMember) o).getParent()
								.getParent().getElementName()
								+ "." + ((IMember) o).getElementName();
						interfaceList.add(elementName);
						TakeCompileWizardPanel.this.importStatements
								.add(elementName);
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		Button removeBtn = new Button(right, SWT.PUSH);
		removeBtn.setText("Remove");

		removeBtn.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				for (int i : interfaceList.getSelectionIndices()) {

					TakeCompileWizardPanel.this.importStatements
							.remove(interfaceList.getItem(i));
					interfaceList.remove(i);
				}

			}
		});

	}

	private void addInterfacePanel(Composite parent, int ncols) {
		Composite topLevel = new Composite(parent, SWT.NONE);
		topLevel.setLayout(new GridLayout(2, false));
		topLevel.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
				true, ncols, 1));

		Label iLbl = new Label(topLevel, SWT.CENTER);
		iLbl.setText("Additional Implemented Interfaces");
		iLbl.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
				true, 2, 1));

		final List interfaceList = new List(topLevel, SWT.SINGLE);
		interfaceList.setLayoutData(new GridData(GridData.FILL, GridData.FILL,
				true, true));
		Composite right = new Composite(topLevel, SWT.NONE);
		right.setLayout(new GridLayout(1, false));

		Button addBtn = new Button(right, SWT.PUSH);
		addBtn.setText("Add");

		IWorkbenchPage iworkbenchpage = getWorkbench();
		if (iworkbenchpage == null)
			return;

		final IProject project = getProjectFromWorkbench(iworkbenchpage);

		addBtn.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					SelectionDialog dialog = JavaUI.createTypeDialog(
							getShell(), getWizard().getContainer(), project,
							IJavaElementSearchConstants.CONSIDER_INTERFACES,
							true);

					if (dialog.open() == IDialogConstants.CANCEL_ID)
						return;

					Object[] types = dialog.getResult();
					if (types == null || types.length == 0)
						return;

					for (Object o : types) {
						String elementName = ((IMember) o).getParent()
								.getParent().getElementName()
								+ "." + ((IMember) o).getElementName();
						interfaceList.add(elementName);
						TakeCompileWizardPanel.this.additionalInterfaces
								.add(elementName);

					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		Button removeBtn = new Button(right, SWT.PUSH);
		removeBtn.setText("Remove");

		removeBtn.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				for (int i : interfaceList.getSelectionIndices()) {
					TakeCompileWizardPanel.this.additionalInterfaces
							.remove(interfaceList.getItem(i));
					interfaceList.remove(i);

				}

			}
		});
	}

	public static IWorkbenchPage getWorkbench() {
		IWorkbench iworkbench = PlatformUI.getWorkbench();
		if (iworkbench == null) {
			System.out.println("no i workbench");
			return null;
		}
		IWorkbenchWindow iworkbenchwindow = iworkbench
				.getActiveWorkbenchWindow();
		if (iworkbenchwindow == null) {
			System.out.println("no i workbenchwindows");
			return null;
		}
		IWorkbenchPage iworkbenchpage = iworkbenchwindow.getActivePage();
		if (iworkbenchpage == null) {
			System.out.println("no i workbenchpage");
			return null;
		}
		return iworkbenchpage;
	}

	private void addCheckPanel(Composite parent, int numcols) {
		Composite topLevel = new Composite(parent, SWT.NONE);
		topLevel.setLayout(new GridLayout(2, false));
		topLevel.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false, numcols, 1));

		final Button aabtn = new Button(topLevel, SWT.CHECK);
		aabtn.setText("Auto Annotate");
		aabtn.setSelection(this.isAutoAnotate());
		
        aabtn.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}

			@Override
			public void widgetSelected(SelectionEvent e) {
				autoAnotate = aabtn.getSelection();
			}});
        
		final Button ppbtn = new Button(topLevel, SWT.CHECK);
		ppbtn.setText("Pretty Print Source");
		ppbtn.setSelection(this.isSourceTransform());
		
		ppbtn.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}

			@Override
			public void widgetSelected(SelectionEvent e) {
				sourceTransform = ppbtn.getSelection();
			}});
		
	}

	public String getPackageName() {
		return this.packageName;
	}

	public String getClassName() {
		return this.className;
	}

	public String getSourceOutputLocation() {
		return this.sourceOutputLocation;
	}

	public LinkedList<String> getImportStatements() {
		return this.importStatements;
	}

	public LinkedList<String> getAdditionalInterfaces() {
		return this.additionalInterfaces;
	}

	public boolean isAutoAnotate() {
		return this.autoAnotate;
	}

	public boolean isSourceTransform() {
		return this.sourceTransform;
	}

	public static IProject getProjectFromWorkbench(IWorkbenchPage iworkbenchpage) {
		IResource res = extractSelection(iworkbenchpage.getSelection());

		if (res == null) {
			res = extractResource(iworkbenchpage.getActiveEditor());
		}

		if (res == null) {
			return null;
		}
		return res.getProject();
	}

	public static IResource extractSelection(ISelection sel) {
		if (!(sel instanceof IStructuredSelection))
			return null;
		IStructuredSelection ss = (IStructuredSelection) sel;
		Object element = ss.getFirstElement();
		if (element instanceof IResource)
			return (IResource) element;
		if (!(element instanceof IAdaptable))
			return null;
		IAdaptable adaptable = (IAdaptable) element;
		Object adapter = adaptable.getAdapter(IResource.class);
		return (IResource) adapter;
	}

	public static IResource extractResource(IEditorPart editor) {
		IEditorInput input = editor.getEditorInput();
		if (!(input instanceof IFileEditorInput))
			return null;
		return ((IFileEditorInput) input).getFile();
	}

	public boolean isIncludeTakeLibrary() {
		return includeTakeLibrary;
	}

	public String getIncludeTakeLibraryLocation() {
		return includeTakeLibraryLocation;
	}
}
