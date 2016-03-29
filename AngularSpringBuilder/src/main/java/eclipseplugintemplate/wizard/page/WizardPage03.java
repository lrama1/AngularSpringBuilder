package eclipseplugintemplate.wizard.page;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import eclipseplugintemplate.wizard.page.panel.Page03Panel;

public class WizardPage03 extends WizardPage {

	public WizardPage03(String pageName) {
		super(pageName);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void createControl(Composite parent) {
		Composite container = new Page03Panel(parent, this ,SWT.DOUBLE_BUFFERED);		


		container.setLayout(null);
		setControl(container);
		
		//if not blank, it displays the error message on the top portion of the Wizard Page
		//setErrorMessage("Please fill blahh");
		
		//set to false to disallow the Next button, otherwise set to true to enable Next
		setPageComplete(false);

	}

}
