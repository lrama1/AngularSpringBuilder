package eclipseplugintemplate.wizard.page.panel;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.TouchListener;
import org.eclipse.swt.events.TouchEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Page03Panel extends Composite {
	private Text domainClassNameField;
	private Table domainAttributesTable;
	

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Page03Panel(Composite parent, final WizardPage container,int style) {
		super(parent, style);
		
		Label lblW = new Label(this, SWT.NONE);
		lblW.setBounds(10, 20, 311, 17);
		lblW.setText("Wizard Page 3 Panel");
		
		domainClassNameField = new Text(this, SWT.BORDER);
		domainClassNameField.setBounds(232, 71, 435, 27);
		
		Label lblSampleDomainClass = new Label(this, SWT.RIGHT);
		lblSampleDomainClass.setBounds(21, 71, 180, 17);
		lblSampleDomainClass.setText("Sample Domain Class:");
		
		domainAttributesTable = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		domainAttributesTable.setSelection(0);
		domainAttributesTable.setBounds(70, 135, 726, 301);
		domainAttributesTable.setHeaderVisible(true);
		domainAttributesTable.setLinesVisible(true);
		
		TableColumn tblAttributeNameColumn = new TableColumn(domainAttributesTable, SWT.NONE);
		tblAttributeNameColumn.setWidth(172);
		tblAttributeNameColumn.setText("Attribute");
		
		TableColumn tblDataTypeColumn = new TableColumn(domainAttributesTable, SWT.NONE);
		tblDataTypeColumn.setWidth(152);
		tblDataTypeColumn.setText("Data Type");
		
		TableColumn tblIsIdColumn = new TableColumn(domainAttributesTable, SWT.NONE);
		tblIsIdColumn.setWidth(164);
		tblIsIdColumn.setText("Id ID?");
		
		TableColumn tblFieldTypeColumn = new TableColumn(domainAttributesTable, SWT.NONE);
		tblFieldTypeColumn.setWidth(224);
		tblFieldTypeColumn.setText("Field Type");
		
		final List<List<Widget>> widgetRows = new ArrayList<List<Widget>>();
		
		
		Button addNewAttributeButton = new Button(this, SWT.NONE);
		addNewAttributeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
				List<Widget> widgets = new ArrayList<Widget>();
				final TableItem tableItem = new TableItem(domainAttributesTable, SWT.NONE);
				
				//Selector column
				TableEditor columnSelectorEditor = new TableEditor(domainAttributesTable);
				columnSelectorEditor.horizontalAlignment = SWT.LEFT;
				columnSelectorEditor.grabHorizontal = true;
				columnSelectorEditor.minimumWidth = 50;
				columnSelectorEditor.minimumHeight = 30;
			    Button radioButtonSelectorEditor = new Button(domainAttributesTable, SWT.CHECK);
			    radioButtonSelectorEditor.setText("X");
			    if(domainAttributesTable.getItems().length == 1){
			    	radioButtonSelectorEditor.setSelection(true);
			    	tableItem.setText(0, "X");
			    }
			    radioButtonSelectorEditor.addSelectionListener(new SelectionListener() {					
					@Override
					public void widgetSelected(SelectionEvent event) {
						if(!((Button)event.getSource()).getSelection())
							tableItem.setText(0, "");
						else
							tableItem.setText(0, "X");
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {						
					}
				});
			    columnSelectorEditor.setEditor(radioButtonSelectorEditor, tableItem, 0);
			    widgets.add(radioButtonSelectorEditor);
				
				//======================COLUMN 1 (ATTR NAME)
				tableItem.setText(1, "changeMe");
				TableEditor column1Editor = new TableEditor(domainAttributesTable);
				column1Editor.horizontalAlignment = SWT.LEFT;
				column1Editor.grabHorizontal = true;
				column1Editor.minimumWidth = 50;
				Text newEditor = new Text(domainAttributesTable, SWT.NONE);
				newEditor.setText("changeMe");					
				newEditor.addModifyListener(new ModifyListener() {					
					@Override
					public void modifyText(ModifyEvent arg0) {
					  String value = ((Text)arg0.getSource()).getText();	
					  tableItem.setText(1, value);		
					  validateAttrName(container, value);
					}
				});							
				column1Editor.setEditor(newEditor, tableItem, 1);
				widgets.add(newEditor);
				
				//======================COLUMN 2 (Data Type Dropdown)
				tableItem.setText(2, "String");
				TableEditor column2Editor = new TableEditor(domainAttributesTable);
				column2Editor.horizontalAlignment = SWT.LEFT;
				column2Editor.grabHorizontal = true;
				column2Editor.minimumWidth = 50;
				CCombo dataTypeCombo = new CCombo(domainAttributesTable, SWT.READ_ONLY);
			    dataTypeCombo.setText("String");
			    dataTypeCombo.add("String");
			    dataTypeCombo.add("Date");		
			    dataTypeCombo.add("Number");
			    dataTypeCombo.addModifyListener(new ModifyListener() {
					@Override
					public void modifyText(ModifyEvent arg0) {
						tableItem.setText(2, ((CCombo)arg0.getSource()).getText());
					}
				});
			    column2Editor.setEditor(dataTypeCombo, tableItem, 2);
			    widgets.add(dataTypeCombo);
			    
			    //======================COLUMN 3 (ID INDICATOR)
			    TableEditor column3Editor = new TableEditor(domainAttributesTable);
			    column3Editor.horizontalAlignment = SWT.LEFT;
			    column3Editor.grabHorizontal = true;
			    column3Editor.minimumWidth = 50;
			    column3Editor.minimumHeight = 30;
			    
			    Button radioButtonEditor = new Button(domainAttributesTable, SWT.RADIO);
			    radioButtonEditor.setText("X");

			    if(domainAttributesTable.getItems().length == 1){
			    	radioButtonEditor.setSelection(true);
			    	tableItem.setText(3, "X");
			    }
			    radioButtonEditor.addSelectionListener(new SelectionListener() {					
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						for(TableItem tableItemReset : domainAttributesTable.getItems())
							tableItemReset.setText(3, "");
						tableItem.setText(3, "X");
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {						
					}
				});
			    column3Editor.setEditor(radioButtonEditor, tableItem, 3);
			    widgets.add(radioButtonEditor);
			    
			  //======================COLUMN 4 (Field Type Dropdown)
				tableItem.setText(4, "TextField");
				TableEditor column4Editor = new TableEditor(domainAttributesTable);
				column4Editor.horizontalAlignment = SWT.LEFT;
				column4Editor.grabHorizontal = true;
				column4Editor.minimumWidth = 50;
				CCombo fieldTypeCombo = new CCombo(domainAttributesTable, SWT.READ_ONLY);
				fieldTypeCombo.setText("TextField");
				fieldTypeCombo.add("TextField");
				fieldTypeCombo.add("DropDown");		
				fieldTypeCombo.add("TextArea");
				fieldTypeCombo.addModifyListener(new ModifyListener() {
					@Override
					public void modifyText(ModifyEvent arg0) {
						tableItem.setText(4, ((CCombo)arg0.getSource()).getText());
					}
				});
				column4Editor.setEditor(fieldTypeCombo, tableItem, 4);
				widgets.add(fieldTypeCombo);
			    
			    widgetRows.add(widgets);
			    validateAttrsPresence(container);
				
			}
		});
		addNewAttributeButton.setBounds(119, 452, 202, 29);
		addNewAttributeButton.setText("Add Row");
		

		
		Button removeAttributeButton = new Button(this, SWT.NONE);
		removeAttributeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				TableItem[] items = domainAttributesTable.getItems();
				List<Integer> indexesToRemove = new ArrayList<Integer>();
				for(int i = 0; i < items.length; i++){
					if("X".equals(items[i].getText())){
						System.out.println("======================DELETING ROW==== " + i);
						List<Widget> widgets = widgetRows.get(i);
						for(Widget widget : widgets){
							widget.dispose();
						}
						indexesToRemove.add(i);
					}
				}
				int[] selectedIndexes = new int[indexesToRemove.size()];
				int i =0;
				for(Integer index : indexesToRemove){
					selectedIndexes[i++] = index;
				}

				domainAttributesTable.remove(selectedIndexes);
				System.out.println(domainAttributesTable.getItem(0).getText());
				for(int index = 0; index < domainAttributesTable.getItemCount(); index++){
					domainAttributesTable.setSelection(index);
				}
								
			}
		});
		removeAttributeButton.setBounds(337, 452, 91, 29);
		removeAttributeButton.setText("Delete Row");
		
		//validate screen
		validateAttrsPresence(container);

	}
	
	private void validateAttrName(WizardPage container, String attributeName){
		if(attributeName.trim().substring(0, 1).matches("[A-Z]")){
			updateStatus(container, "Attribute Name must start with a lowercase letter.");
			return;
		}
		updateStatus(container,null);
	}
	
	private boolean validateAttrsPresence(WizardPage container){
		if(domainAttributesTable.getItemCount() == 0){
			updateStatus(container, "Please add at least 1 attribute");
			return false;
		}
		updateStatus(container,null);
		return true;
	}
	
	private void updateStatus(WizardPage container, String message) {
		container.setErrorMessage(message);
		container.setPageComplete(message == null);
		System.out.println(message == null);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
