package eclipseplugintemplate.wizard.page.panel;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class SamplePanel extends JPanel {
	private JTable table;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public SamplePanel() {
		setLayout(null);
		
		table = new JTable();
		table.setBounds(90, 85, 384, 262);
		add(table);
		
		textField = new JTextField();
		textField.setBounds(117, 398, 195, 44);
		add(textField);
		textField.setColumns(10);

	}
}
