package nz.ac.massey.take.takeep.editor;

import nz.ac.massey.take.takeep.actionsSets.compileActions.TakeCompileToClasses;
import nz.ac.massey.take.takeep.actionsSets.compileActions.TakeCompileToInterfaces;
import nz.ac.massey.take.takeep.actionsSets.verifyActions.TakeRunVerifiers;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.texteditor.BasicTextEditorActionContributor;

public class TakeEditorActionContributor extends
		BasicTextEditorActionContributor {

	@Override
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		// TODO Auto-generated method stub
		super.contributeToToolBar(toolBarManager);

		toolBarManager.add(new TakeCompileToClasses());
		toolBarManager.add(new TakeCompileToInterfaces());
		toolBarManager.add(new TakeRunVerifiers());

	}

}
