package cs585.nanwarin.plugin.dvt.popup.actions;

import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class VerifyFactoryPattern implements IObjectActionDelegate {

	private Shell shell;
	private ISelection selection;
	private IPackageFragment selectedPackage;
	
	private InitialPatternObj initialPattern;
	
	/**
	 * Constructor for Action1.
	 */
	public VerifyFactoryPattern() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		
		System.out.println("Action ID " + action.getId());

		if(action.getId().equals("cs585.nanwarin.plugin.dvt.initialObj")){
			selectedPackage = (IPackageFragment) ((IStructuredSelection)selection).getFirstElement();
			initialPattern = new InitialPatternObj(selectedPackage);
			initialPattern.verifyCaller();
			
			MessageDialog.openInformation(
					shell,
					"Dvt",
					"Complete");
		}
		
		
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

}
