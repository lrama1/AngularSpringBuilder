package eclipseplugintemplate.wizard;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

import eclipseplugintemplate.wizard.page.WizardPage02;
import eclipseplugintemplate.wizard.page.WizardPage03;
import eclipseplugintemplate.wizard.page.WizardPage04;
import eclipseplugintemplate.wizard.page.WizardPage05;
import eclipseplugintemplate.wizard.page.WizardPage06;
import eclipseplugintemplate.wizard.page.panel.Page02Panel;

public class AngularBuilderWizard extends Wizard implements INewWizard {
	
	WizardNewProjectCreationPage page01 = new WizardNewProjectCreationPage("");
	WizardPage02 page02 = new WizardPage02("");
	WizardPage03 page03 = new WizardPage03("");
	WizardPage04 page04 = new WizardPage04("");
	WizardPage05 page05 = new WizardPage05("");
	WizardPage06 page06 = new WizardPage06("");

	public AngularBuilderWizard() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub
		addPage(page01);
		addPage(page02);
		addPage(page03);
		addPage(page04);
		addPage(page05);
		addPage(page06);
	}

	
	@Override
	public boolean canFinish() {
	return 	this.getContainer().getCurrentPage().getClass().getSimpleName().equals("WizardPage06");

	}
	
	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		Map<String, String> mapOfValues = new LinkedHashMap<String, String>();
		Page02Panel wizardPage02Panel =  (Page02Panel)page02.getWizardPanel();
		
		
		return false;
	}

}
