package eclipseplugintemplate.wizard.page.panel;

import java.util.Map;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class Page02Panel extends Composite {
	private Text basePackageNameField;
	private Text controllerPackageNameField;
	private Text domainPackageNameField;
	private Text mongoHostNameField;
	private Text mongoPortNameField;
	private Text mongoDBNameField;
	private Button useMongoCheckbox;
	private Button prepForMySQLCheckbox;
	private Button prepForOracleCheckbox;
	private Combo springVersionDropdown;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Page02Panel(Composite parent, final WizardPage container, int style) {
		super(parent, style);
		
		basePackageNameField = new Text(this, SWT.BORDER);
		basePackageNameField.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				validatePackage(container, basePackageNameField.getText());
				controllerPackageNameField.setText(basePackageNameField.getText() + ".controller" );
				domainPackageNameField.setText(basePackageNameField.getText() + ".web.domain" );
			}
		});
		basePackageNameField.setBounds(177, 46, 444, 27);
		
		Label lblBasePackageName = new Label(this, SWT.RIGHT);
		lblBasePackageName.setBounds(10, 46, 161, 27);
		lblBasePackageName.setText("Base Package Name:");
		
		controllerPackageNameField = new Text(this, SWT.BORDER);
		controllerPackageNameField.setEditable(false);
		controllerPackageNameField.setEnabled(false);
		controllerPackageNameField.setBounds(177, 79, 444, 27);
		
		domainPackageNameField = new Text(this, SWT.BORDER);
		domainPackageNameField.setEditable(false);
		domainPackageNameField.setEnabled(false);
		domainPackageNameField.setBounds(177, 112, 444, 27);
		
		Label lblControllerPackage = new Label(this, SWT.RIGHT);
		lblControllerPackage.setBounds(21, 79, 150, 17);
		lblControllerPackage.setText("Controller Package:");
		
		Label lblDomainModelPackage = new Label(this, SWT.RIGHT);
		lblDomainModelPackage.setBounds(21, 112, 150, 17);
		lblDomainModelPackage.setText("Domain Package:");
		
		useMongoCheckbox = new Button(this, SWT.CHECK);
		useMongoCheckbox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(useMongoCheckbox.getSelection()){
					mongoHostNameField.setEnabled(true);
					mongoPortNameField.setEnabled(true);
					mongoDBNameField.setEnabled(true);
				}else{
					mongoHostNameField.setEnabled(false);
					mongoPortNameField.setEnabled(false);
					mongoDBNameField.setEnabled(false);
				}
			}
		});
		useMongoCheckbox.setBounds(46, 191, 228, 24);
		useMongoCheckbox.setText("Use Mongo DB");
		
		Group grpMongoDbParams = new Group(this, SWT.NONE);
		grpMongoDbParams.setText("Mongo DB Params");
		grpMongoDbParams.setBounds(46, 221, 575, 180);
		
		mongoHostNameField = new Text(grpMongoDbParams, SWT.BORDER);
		mongoHostNameField.setText("localhost");
		mongoHostNameField.setEnabled(false);
		mongoHostNameField.setBounds(187, 47, 367, 27);
		
		mongoPortNameField = new Text(grpMongoDbParams, SWT.BORDER);
		mongoPortNameField.setText("27017");
		mongoPortNameField.setEnabled(false);
		mongoPortNameField.setBounds(187, 80, 129, 27);
		
		mongoDBNameField = new Text(grpMongoDbParams, SWT.BORDER);
		mongoDBNameField.setText("localdb");
		mongoDBNameField.setEnabled(false);
		mongoDBNameField.setBounds(187, 113, 203, 27);
		
		Label lblNewLabel_1 = new Label(grpMongoDbParams, SWT.NONE);
		lblNewLabel_1.setAlignment(SWT.RIGHT);
		lblNewLabel_1.setBounds(52, 47, 129, 17);
		lblNewLabel_1.setText("Host Name:");
		
		Label lblNewLabel_2 = new Label(grpMongoDbParams, SWT.NONE);
		lblNewLabel_2.setAlignment(SWT.RIGHT);
		lblNewLabel_2.setBounds(52, 80, 129, 17);
		lblNewLabel_2.setText("Port:");
		
		Label lblNewLabel_3 = new Label(grpMongoDbParams, SWT.NONE);
		lblNewLabel_3.setAlignment(SWT.RIGHT);
		lblNewLabel_3.setBounds(52, 113, 129, 17);
		lblNewLabel_3.setText("DB Name:");
		
		prepForMySQLCheckbox = new Button(this, SWT.CHECK);
		prepForMySQLCheckbox.setBounds(46, 431, 255, 24);
		prepForMySQLCheckbox.setText("Prep For MySQL");
		
		prepForOracleCheckbox = new Button(this, SWT.CHECK);
		prepForOracleCheckbox.setBounds(46, 461, 288, 24);
		prepForOracleCheckbox.setText("Prep For Oracle");
		
		Label lblSpringVersion = new Label(this, SWT.RIGHT);
		lblSpringVersion.setBounds(46, 512, 121, 17);
		lblSpringVersion.setText("Spring Version:");
		
		springVersionDropdown = new Combo(this, SWT.READ_ONLY);
		springVersionDropdown.setItems(new String[] {"3.x.x", "4.x.x"});
		springVersionDropdown.setBounds(193, 512, 400, 29);
		springVersionDropdown.select(0);

		validatePackage(container, basePackageNameField.getText());
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	private void validatePackage(WizardPage container,String packageName){
		if(packageName.trim().length() == 0){
			updateStatus(container, "Please specify a package name");
			return;			
		}
		if(packageName.trim().endsWith(".")){
			updateStatus(container, "Please specify a valid format for your package name");
			return;			
		}
		
		updateStatus(container, null);
	}
	
	
	private void updateStatus(WizardPage container,String message) {
		container.setErrorMessage(message);
		container.setPageComplete(message == null);
	}
	
	/*public Map<String, String> getMyScreenValuesAsMap(){
		
	}*/
	
	public String getBasePackageName(){
		return basePackageNameField.getText();
	}
	
	public String getControllerPackage(){
		return controllerPackageNameField.getText();
	}
	
	public String getDomainPackage(){
		return domainPackageNameField.getText();
	}
	
	public boolean useMongoDB(){
		return useMongoCheckbox.getSelection();
	}
	
	public String getMongoHostName(){
		return mongoHostNameField.getText();
	}
	
	public String getMongoPort(){
		return mongoPortNameField.getText();
	}
	
	public String getMongoDBName(){
		return mongoDBNameField.getText();
	}
	
	public boolean prepForOracle(){
		return prepForOracleCheckbox.getSelection();
	}
	
	public boolean prepForMySql(){
		return prepForMySQLCheckbox.getSelection();
	}
	
	public String getSpringVersion(){
		return springVersionDropdown.getText();
	}
}
