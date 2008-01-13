package nz.ac.massey.take.takeep.actionsSets;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;

public class TakeCompileToClasses extends Action implements IWorkbenchWindowActionDelegate {

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(IWorkbenchWindow window) {
		
		
	}

	@Override
	public void run(IAction action) {
		TakeCompilerWizard wizard = new TakeCompilerWizard();
	      

        Shell shell =
            PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
          WizardDialog dialog= new WizardDialog(shell, wizard);
          dialog.create();
          dialog.open();
		
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub
		
	}


}