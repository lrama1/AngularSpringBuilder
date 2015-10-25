package eclipseplugintemplate.wizard.page.panel;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;

public class Page02Panel extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Page02Panel(Composite parent, int style) {
		super(parent, style);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setBounds(67, 56, 283, 17);
		lblNewLabel.setText("Wizard Page 2 Panel");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
