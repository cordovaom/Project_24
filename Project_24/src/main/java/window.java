import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;

public class window extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel, mainMenu, employeeMenu, addEmployee, deleteEmployee, textDisplay, customerMenu, addCustomer, customerTextDisplay, deleteCustomer,inventoryMenu, addInventory, inventoryTextDisplay, deleteInventory, jobMenu, addJob, jobTextDisplay, contractorMenu, addContractor, contractorTextDisplay, deleteContractor;
	private JButton employees, customers, inventory, jobs, contractors;
	private JButton addToDatabase, deleteFromDatabase, updateDatabase, displayRequest, returnToMain,returnToEmployeeMenuFromAdd, returnToEmployeeMenuFromDelete, enterAddEmployee, enterDeleteEmployee, confermRequest, returnFromTD;
	private JButton addCustomerToDatabase, deleteCustomerFromDatabase, updateCustomerInDatabase, displayCustomerRequest, returnToMainFromCustomer, enterAddCustomer, returnToCustomerMenuFromAdd, customerConfermRequest, returnFromCTD, enterDeleteCustomer, returnToCustomerMenuFromDelete;
	private JButton addInventoryToDatabase, deleteInventoryFromDatabase, updateInventoryInDatabase, displayInventoryRequest, returnToMainFromInventory, enterAddInventory, returnToInventoryMenuFromAdd, returnFromITD, enterDeleteInventory, returnToInventoryMenuFromDelete;
	private JButton addJobToDatabase, updateJobInDatabase, displayJobRequest, returnToMainFromJob, enterAddJob, returnToJobMenuFromAdd, jobConfermRequest, returnFromJTD;
	private JButton addContractorToDatabase, deleteContractorFromDatabase, updateContractorInDatabase, displayContractorRequest, returnToMainFromContractor, enterAddContractor, returnToContractorMenuFromAdd, contractorConfermRequest, enterDeleteContractor, returnToContractorMenuFromDelete, returnFromConTD;
	private CardLayout cl;
	private JLabel employeeLabel, firstName, lastName, salary, email, phone, address, manager, cof, deleteEmployeeMenu, employeeIdUpdate;
	private JLabel customerLabel, customerFirstName, customerLastName, customerEmail, customerPhone, customerAddress, customerIdUpdate, deleteCustomerMenu;
	private JLabel inventoryLabel, inventoryName, inventoryPrice, inventoryQuantity, inventoryExpiration, inventoryIdUpdate, deleteInventoryMenu;
	private JLabel jobLabel, jobPrice, jobCrew, jobCustomer, jobContractor, jobIdUpdate;
	private JLabel contractorLabel, contractorFirstName, contractorLastName, contractorSalary, contractorEmail, contractorPhone, contractorAddress, contractorIdUpdate, deleteContractorMenu;
	private JTextField firstNameText, lastNameText, salaryText, emailText, phoneText1, phoneText2, phoneText3, addressText1, addressText2, addressText3, addressText4, managerText, cofText, requestID, deleteEmployeeMenuText, employeeIdUpdateText;
	private JTextField customerFirstNameText, customerLastNameText, customerEmailText, customerPhoneText1, customerPhoneText2, customerPhoneText3, customerAddressText1, customerAddressText2, customerAddressText3, customerAddressText4, customerIdUpdateText, requestCustomerID, deleteCustomerMenuText;
	private JTextField inventoryNameText, inventoryPriceText, inventoryQuantityText, inventoryExpirationText, inventoryIdUpdateText, deleteInventoryMenuText;
	private JTextField jobPriceText, jobCrewText, jobCustomerText, jobContractorText, jobIdUpdateText, requestJobID;
	private JTextField contractorFirstNameText, contractorLastNameText, contractorSalaryText, contractorEmailText, contractorPhoneText1, contractorPhoneText2, contractorPhoneText3, contractorAddressText1, contractorAddressText2, contractorAddressText3, contractorAddressText4, contractorIdUpdateText, requestContractorID, deleteContractorMenuText;
	private JTextArea outputLabel, customerOutputLabel, inventoryOutputLabel, jobOutputLabel, contractorOutputLabel;
	private JScrollPane scroll, customerScroll, inventoryScroll, jobScroll, contractorScroll;
	private String[] employeeTypes = {"Select One","Field Staff", "Office Staff", "Mechanics"};
	private JComboBox<String> employeeCB;          
	private boolean update;
	
	public window() {
		this.setTitle("Landscaping");
		this.setSize(515,410);
		this.setResizable(false); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		cl = new CardLayout();
				
		panel = new JPanel();
		panel.setLayout(cl);
//-----------------------------------------------------------
		mainMenu =new JPanel();		
		mainMenu.setLayout(null);
		
		employees = new JButton("Employees");
		employees.setBounds(20, 20, 100, 30);
		
		customers = new JButton("Customers");
		customers.setBounds(20, 120, 100, 30);
		
		inventory = new JButton("Inventory");
		inventory.setBounds(20, 220, 100, 30);
		
		jobs = new JButton("Jobs");
		jobs.setBounds(20, 320, 100, 30);
		
		contractors = new JButton("Subcontractors");
		contractors.setBounds(220, 20, 130, 30);
		
		mainMenu.add(employees);
		mainMenu.add(customers);
		mainMenu.add(inventory);
		mainMenu.add(jobs);
		mainMenu.add(contractors);

//---------------------------------------------------------------
		employeeLabel = new JLabel("Employees");
		employeeLabel.setBounds(225, 10, 250, 50);
		
		employeeMenu =new JPanel();
		employeeMenu.setLayout(null);
		
		
		employeeCB = new JComboBox<String>(employeeTypes);
		employeeCB.setBounds(20, 60, 100, 30);
		
		addToDatabase = new JButton("Add");
		addToDatabase.setBounds(20, 120, 100, 30);
		
		deleteFromDatabase = new JButton("Remove");
		deleteFromDatabase.setBounds(20, 180, 100, 30);
		
		updateDatabase = new JButton("Update");
		updateDatabase.setBounds(20, 240, 100, 30);
		
		displayRequest = new JButton("Search");
		displayRequest.setBounds(20, 300, 100, 30);

		returnToMain = new JButton("Back");
		returnToMain.setBounds(370, 300, 100, 30);
		
		employeeMenu.add(employeeCB);
		employeeMenu.add(employeeLabel);
		employeeMenu.add(addToDatabase);
		employeeMenu.add(deleteFromDatabase);
		employeeMenu.add(updateDatabase);
		employeeMenu.add(displayRequest);
		employeeMenu.add(returnToMain);
//--------------------------------------------------------------
		addEmployee =new JPanel();
		addEmployee.setLayout(null);
		
		update = false;
		
		firstName = new JLabel("First Name");
		firstName.setBounds(20, 20, 100, 30);
		
		lastName = new JLabel("Last Name");
		lastName.setBounds(20, 60, 100, 30);
		
		salary = new JLabel("Salary");
		salary.setBounds(20, 100, 100, 30);
		
		email = new JLabel("Email");
		email.setBounds(20, 140, 100, 30);
		
		phone = new JLabel("Phone Number");
		phone.setBounds(20, 180, 100, 30);
		
		address = new JLabel("Address");
		address.setBounds(20, 220, 100, 30);
		
		manager = new JLabel("manager ID");
		manager.setBounds(20, 260, 100, 30);
		
		cof = new JLabel("Crew ID");
		cof.setBounds(20, 298, 100, 30);
		
		employeeIdUpdate = new JLabel("Employee ID");
		employeeIdUpdate.setBounds(20, 333, 100, 30);
		employeeIdUpdate.setVisible(false);
		
		firstNameText = new JTextField(20);
		firstNameText.setBounds(120, 20, 200, 30);
		
		lastNameText = new JTextField(20);
		lastNameText.setBounds(120, 60, 200, 30);
		
		salaryText = new JTextField(20);
		salaryText.setBounds(120, 100, 200, 30);
		
		emailText = new JTextField(20);
		emailText.setBounds(120, 140, 200, 30);
		
		phoneText1 = new JTextField(20);
		phoneText1.setBounds(120, 180, 63, 30);
		
		phoneText2 = new JTextField(20);
		phoneText2.setBounds(187, 180, 66, 30);
		
		phoneText3 = new JTextField(20);
		phoneText3.setBounds(254, 180, 66, 30);
		
		addressText1 = new JTextField(20);
		addressText1.setBounds(120, 220, 100, 30);
		
		addressText2 = new JTextField(20);
		addressText2.setBounds(225, 220, 70, 30);
		
		addressText3 = new JTextField(20);
		addressText3.setBounds(300, 220, 30, 30);
		
		addressText4 = new JTextField(20);
		addressText4.setBounds(335, 220, 50, 30);
		
		managerText = new JTextField(20);
		managerText.setBounds(120, 260, 200, 30);
		
		cofText = new JTextField(20);
		cofText.setBounds(120, 298, 200, 30);
		
		employeeIdUpdateText = new JTextField(20);
		employeeIdUpdateText.setBounds(120, 333, 200, 30);
		employeeIdUpdateText.setVisible(false);
		
		enterAddEmployee = new JButton("Enter");
		enterAddEmployee.setBounds(395, 270, 100, 30);

		returnToEmployeeMenuFromAdd = new JButton("Back");
		returnToEmployeeMenuFromAdd.setBounds(395, 320, 100, 30);
		
		addEmployee.add(firstName);
		addEmployee.add(lastName);
		addEmployee.add(salary);
		addEmployee.add(email);
		addEmployee.add(phone);
		addEmployee.add(address);
		addEmployee.add(manager);
		addEmployee.add(cof);
		addEmployee.add(employeeIdUpdate);
		
		addEmployee.add(firstNameText);
		addEmployee.add(lastNameText);
		addEmployee.add(salaryText);
		addEmployee.add(emailText);
		addEmployee.add(phoneText1);
		addEmployee.add(phoneText2);
		addEmployee.add(phoneText3);
		addEmployee.add(addressText1);
		addEmployee.add(addressText2);
		addEmployee.add(addressText3);
		addEmployee.add(addressText4);
		addEmployee.add(managerText);
		addEmployee.add(cofText);
		addEmployee.add(employeeIdUpdateText);
		
		addEmployee.add(enterAddEmployee);
		addEmployee.add(returnToEmployeeMenuFromAdd);
//--------------------------------------------------------------
		textDisplay =new JPanel();		
		textDisplay.setLayout(null);
		
		outputLabel = new JTextArea("");
		outputLabel.setLineWrap(true);
		outputLabel.setWrapStyleWord(true);
		scroll = new JScrollPane(outputLabel);
		scroll.setBounds(10, 10, 480, 275);
		
		requestID = new JTextField(20);
		requestID.setBounds(40, 320, 200, 30);
		
		confermRequest= new JButton("search");
		confermRequest.setBounds(250, 320, 100, 30);
		
		returnFromTD = new JButton("Back");
		returnFromTD.setBounds(395, 320, 100, 30);
		
		textDisplay.add(scroll);
		textDisplay.add(returnFromTD);
		textDisplay.add(requestID);
		textDisplay.add(confermRequest);

//---------------------------------------------------------------
		deleteEmployee =new JPanel();
		deleteEmployee.setLayout(null);
			
		deleteEmployeeMenu = new JLabel("Employee Id: ");
		deleteEmployeeMenu.setBounds(50, 100, 100, 30);

		deleteEmployeeMenuText = new JTextField(20);
		deleteEmployeeMenuText.setBounds(125, 100, 200, 30);
		
		enterDeleteEmployee = new JButton("Remove");
		enterDeleteEmployee.setBounds(330, 100, 100, 29);

		returnToEmployeeMenuFromDelete = new JButton("Back");
		returnToEmployeeMenuFromDelete.setBounds(395, 320, 100, 30);
		
		deleteEmployee.add(deleteEmployeeMenu);
		deleteEmployee.add(deleteEmployeeMenuText);
		deleteEmployee.add(enterDeleteEmployee);
		deleteEmployee.add(returnToEmployeeMenuFromDelete);
//--------------------------------------------------------------
		customerLabel = new JLabel("customers");
		customerLabel.setBounds(225, 10, 250, 50);
		
		customerMenu =new JPanel();
		customerMenu.setLayout(null);
		
		addCustomerToDatabase = new JButton("Add");
		addCustomerToDatabase.setBounds(20, 40, 100, 30);
		
		deleteCustomerFromDatabase = new JButton("Remove");
		deleteCustomerFromDatabase.setBounds(20, 120, 100, 30);
		
		updateCustomerInDatabase = new JButton("Update");
		updateCustomerInDatabase.setBounds(20, 200, 100, 30);
		
		displayCustomerRequest = new JButton("search");
		displayCustomerRequest.setBounds(20, 280, 100, 30);

		returnToMainFromCustomer = new JButton("Back");
		returnToMainFromCustomer.setBounds(395, 320, 100, 30);
		
		customerMenu.add(customerLabel);
		customerMenu.add(addCustomerToDatabase);
		customerMenu.add(deleteCustomerFromDatabase);
		customerMenu.add(updateCustomerInDatabase);
		customerMenu.add(displayCustomerRequest);
		customerMenu.add(returnToMainFromCustomer);
//--------------------------------------------------------------
		addCustomer =new JPanel();
		addCustomer.setLayout(null);
		
		customerFirstName = new JLabel("First Name");
		customerFirstName.setBounds(20, 20, 100, 30);
		
		customerLastName = new JLabel("Last Name");
		customerLastName.setBounds(20, 60, 100, 30);
		
		customerEmail = new JLabel("Email");
		customerEmail.setBounds(20, 100, 100, 30);
		
		customerPhone = new JLabel("Phone Number");
		customerPhone.setBounds(20, 140, 100, 30);
		
		customerAddress = new JLabel("Address");
		customerAddress.setBounds(20, 180, 100, 30);
		
		customerIdUpdate = new JLabel("customer ID");
		customerIdUpdate.setBounds(20, 220, 100, 30);
		customerIdUpdate.setVisible(false);
		
		
		
		customerFirstNameText = new JTextField(20);
		customerFirstNameText.setBounds(120, 20, 200, 30);
		
		customerLastNameText = new JTextField(20);
		customerLastNameText.setBounds(120, 60, 200, 30);
		
		customerEmailText = new JTextField(20);
		customerEmailText.setBounds(120, 100, 200, 30);
		
		customerPhoneText1 = new JTextField(20);
		customerPhoneText1.setBounds(120, 140, 63, 30);
		
		customerPhoneText2 = new JTextField(20);
		customerPhoneText2.setBounds(187, 140, 66, 30);
		
		customerPhoneText3 = new JTextField(20);
		customerPhoneText3.setBounds(254, 140, 66, 30);
		
		customerAddressText1 = new JTextField(20);
		customerAddressText1.setBounds(120, 180, 100, 30);
		
		customerAddressText2 = new JTextField(20);
		customerAddressText2.setBounds(225, 180, 70, 30);
		
		customerAddressText3 = new JTextField(20);
		customerAddressText3.setBounds(300, 180, 30, 30);
		
		customerAddressText4 = new JTextField(20);
		customerAddressText4.setBounds(335, 180, 50, 30);
		
		customerIdUpdateText = new JTextField(20);
		customerIdUpdateText.setBounds(120, 220, 200, 30);
		customerIdUpdateText.setVisible(false);
		
		enterAddCustomer = new JButton("Enter");
		enterAddCustomer.setBounds(395, 260, 100, 30);

		returnToCustomerMenuFromAdd = new JButton("Back");
		returnToCustomerMenuFromAdd.setBounds(395, 320, 100, 30);
		
		addCustomer.add(customerFirstName);
		addCustomer.add(customerLastName);
		addCustomer.add(customerEmail);
		addCustomer.add(customerPhone);
		addCustomer.add(customerAddress);
		addCustomer.add(customerIdUpdate);
		
		addCustomer.add(customerFirstNameText);
		addCustomer.add(customerLastNameText);
		addCustomer.add(customerEmailText);
		addCustomer.add(customerPhoneText1);
		addCustomer.add(customerPhoneText2);
		addCustomer.add(customerPhoneText3);
		addCustomer.add(customerAddressText1);
		addCustomer.add(customerAddressText2);
		addCustomer.add(customerAddressText3);
		addCustomer.add(customerAddressText4);
		addCustomer.add(customerIdUpdateText);
		
		addCustomer.add(enterAddCustomer);
		addCustomer.add(returnToCustomerMenuFromAdd);
//--------------------------------------------------------------
		customerTextDisplay =new JPanel();		
		customerTextDisplay.setLayout(null);
		
		customerOutputLabel = new JTextArea("");
		customerOutputLabel.setLineWrap(true);
		customerOutputLabel.setWrapStyleWord(true);
		customerScroll = new JScrollPane(customerOutputLabel);
		customerScroll.setBounds(10, 10, 480, 275);
		
		requestCustomerID = new JTextField(20);
		requestCustomerID.setBounds(40, 320, 200, 30);
		
		customerConfermRequest= new JButton("search");
		customerConfermRequest.setBounds(250, 320, 100, 30);
		
		returnFromCTD = new JButton("Back");
		returnFromCTD.setBounds(395, 320, 100, 30);
		
		customerTextDisplay.add(customerScroll);
		customerTextDisplay.add(returnFromCTD);
		customerTextDisplay.add(requestCustomerID);
		customerTextDisplay.add(customerConfermRequest);

//---------------------------------------------------------------
		deleteCustomer =new JPanel();
		deleteCustomer.setLayout(null);
			
		deleteCustomerMenu = new JLabel("Customer Id: ");
		deleteCustomerMenu.setBounds(50, 100, 100, 30);

		deleteCustomerMenuText = new JTextField(20);
		deleteCustomerMenuText.setBounds(125, 100, 200, 30);
		
		enterDeleteCustomer = new JButton("Remove");
		enterDeleteCustomer.setBounds(330, 100, 100, 29);

		returnToCustomerMenuFromDelete = new JButton("Back");
		returnToCustomerMenuFromDelete.setBounds(395, 320, 100, 30);
		
		deleteCustomer.add(deleteCustomerMenu);
		deleteCustomer.add(deleteCustomerMenuText);
		deleteCustomer.add(enterDeleteCustomer);
		deleteCustomer.add(returnToCustomerMenuFromDelete);
//--------------------------------------------------------------
		inventoryLabel = new JLabel("Inventorys");
		inventoryLabel.setBounds(225, 10, 250, 50);
		
		inventoryMenu =new JPanel();
		inventoryMenu.setLayout(null);
		
		addInventoryToDatabase = new JButton("Add");
		addInventoryToDatabase.setBounds(20, 80, 100, 30);
		
		deleteInventoryFromDatabase = new JButton("Remove");
		deleteInventoryFromDatabase.setBounds(20, 160, 100, 30);
		
		updateInventoryInDatabase = new JButton("Update");
		updateInventoryInDatabase.setBounds(20, 240, 100, 30);
		
		displayInventoryRequest = new JButton("search");
		displayInventoryRequest.setBounds(20, 320, 100, 30);

		returnToMainFromInventory = new JButton("Back");
		returnToMainFromInventory.setBounds(370, 320, 100, 30);
		
		inventoryMenu.add(inventoryLabel);
		inventoryMenu.add(addInventoryToDatabase);
		inventoryMenu.add(deleteInventoryFromDatabase);
		inventoryMenu.add(updateInventoryInDatabase);
		inventoryMenu.add(displayInventoryRequest);
		inventoryMenu.add(returnToMainFromInventory);
//--------------------------------------------------------------
		addInventory =new JPanel();
		addInventory.setLayout(null);
		
		inventoryName = new JLabel("Name");
		inventoryName.setBounds(20, 20, 100, 30);
		
		inventoryPrice = new JLabel("Price");
		inventoryPrice.setBounds(20, 60, 100, 30);
		
		inventoryQuantity = new JLabel("Quantity");
		inventoryQuantity.setBounds(20, 100, 100, 30);
		
		inventoryExpiration = new JLabel("Expiration Date:");
		inventoryExpiration.setBounds(20, 140, 100, 30);
		
		inventoryIdUpdate = new JLabel("Inventory ID");
		inventoryIdUpdate.setBounds(20, 180, 100, 30);
		inventoryIdUpdate.setVisible(false);
		
		
		
		inventoryNameText = new JTextField(20);
		inventoryNameText.setBounds(120, 20, 200, 30);
		
		inventoryPriceText = new JTextField(20);
		inventoryPriceText.setBounds(120, 60, 200, 30);
		
		inventoryQuantityText = new JTextField(20);
		inventoryQuantityText.setBounds(120, 100, 200, 30);
		
		inventoryExpirationText = new JTextField(20);
		inventoryExpirationText.setBounds(120, 140, 200, 30);
		
		inventoryIdUpdateText = new JTextField(20);
		inventoryIdUpdateText.setBounds(120, 180, 200, 30);
		inventoryIdUpdateText.setVisible(false);
		
		enterAddInventory = new JButton("Enter");
		enterAddInventory.setBounds(395, 260, 100, 30);

		returnToInventoryMenuFromAdd = new JButton("Back");
		returnToInventoryMenuFromAdd.setBounds(395, 320, 100, 30);
		
		addInventory.add(inventoryName);
		addInventory.add(inventoryPrice);
		addInventory.add(inventoryQuantity);
		addInventory.add(inventoryExpiration);
		addInventory.add(inventoryIdUpdate);
		
		addInventory.add(inventoryNameText);
		addInventory.add(inventoryPriceText);
		addInventory.add(inventoryQuantityText);
		addInventory.add(inventoryExpirationText);
		addInventory.add(inventoryIdUpdateText);
		
		addInventory.add(enterAddInventory);
		addInventory.add(returnToInventoryMenuFromAdd);
//--------------------------------------------------------------
		inventoryTextDisplay =new JPanel();		
		inventoryTextDisplay.setLayout(null);
		
		inventoryOutputLabel = new JTextArea("");
		inventoryOutputLabel.setLineWrap(true);
		inventoryOutputLabel.setWrapStyleWord(true);
		inventoryScroll = new JScrollPane(inventoryOutputLabel);
		inventoryScroll.setBounds(10, 10, 480, 275);
		
		returnFromITD = new JButton("Back");
		returnFromITD.setBounds(395, 320, 100, 30);
		
		inventoryTextDisplay.add(inventoryScroll);
		inventoryTextDisplay.add(returnFromITD);

//---------------------------------------------------------------
		deleteInventory =new JPanel();
		deleteInventory.setLayout(null);
			
		deleteInventoryMenu = new JLabel("Inventory Id: ");
		deleteInventoryMenu.setBounds(50, 100, 100, 30);

		deleteInventoryMenuText = new JTextField(20);
		deleteInventoryMenuText.setBounds(125, 100, 200, 30);
		
		enterDeleteInventory = new JButton("Remove");
		enterDeleteInventory.setBounds(330, 100, 100, 29);

		returnToInventoryMenuFromDelete = new JButton("Back");
		returnToInventoryMenuFromDelete.setBounds(395, 320, 100, 30);
		
		deleteInventory.add(deleteInventoryMenu);
		deleteInventory.add(deleteInventoryMenuText);
		deleteInventory.add(enterDeleteInventory);
		deleteInventory.add(returnToInventoryMenuFromDelete);
//--------------------------------------------------------------
		
		jobLabel = new JLabel("jobs");
		jobLabel.setBounds(225, 10, 250, 50);
		
		jobMenu =new JPanel();
		jobMenu.setLayout(null);
		
		addJobToDatabase = new JButton("Add");
		addJobToDatabase.setBounds(20, 80, 100, 30);
		
		updateJobInDatabase = new JButton("Update");
		updateJobInDatabase.setBounds(20, 160, 100, 30);
		
		displayJobRequest = new JButton("Search");
		displayJobRequest.setBounds(20, 240, 100, 30);

		returnToMainFromJob = new JButton("Back");
		returnToMainFromJob.setBounds(370, 320, 100, 30);
		
		jobMenu.add(jobLabel);
		jobMenu.add(addJobToDatabase);
		jobMenu.add(updateJobInDatabase);
		jobMenu.add(displayJobRequest);
		jobMenu.add(returnToMainFromJob);
//--------------------------------------------------------------
		
		addJob =new JPanel();
		addJob.setLayout(null);
		
		jobPrice = new JLabel("Price");
		jobPrice.setBounds(20, 20, 100, 30);
		
		jobCrew = new JLabel("Crew Id");
		jobCrew.setBounds(20, 60, 100, 30);
		
		jobCustomer = new JLabel("Customer");
		jobCustomer.setBounds(20, 100, 100, 30);
		
		jobContractor = new JLabel("Contractor");
		jobContractor.setBounds(20, 140, 100, 30);
		
		jobIdUpdate = new JLabel("Job ID");
		jobIdUpdate.setBounds(20, 180, 100, 30);
		jobIdUpdate.setVisible(false);
		
		
		
		jobPriceText = new JTextField(20);
		jobPriceText.setBounds(120, 20, 200, 30);
		
		jobCrewText = new JTextField(20);
		jobCrewText.setBounds(120, 60, 200, 30);
		
		jobCustomerText = new JTextField(20);
		jobCustomerText.setBounds(120, 100, 200, 30);
		
		jobContractorText = new JTextField(20);
		jobContractorText.setBounds(120, 140, 200, 30);
		
		jobIdUpdateText = new JTextField(20);
		jobIdUpdateText.setBounds(120, 180, 200, 30);
		jobIdUpdateText.setVisible(false);
		
		enterAddJob = new JButton("Enter");
		enterAddJob.setBounds(395, 260, 100, 30);

		returnToJobMenuFromAdd = new JButton("Back");
		returnToJobMenuFromAdd.setBounds(395, 320, 100, 30);
		
		addJob.add(jobPrice);
		addJob.add(jobCrew);
		addJob.add(jobCustomer);
		addJob.add(jobContractor);
		addJob.add(jobIdUpdate);
		
		addJob.add(jobPriceText);
		addJob.add(jobCrewText);
		addJob.add(jobCustomerText);
		addJob.add(jobContractorText);
		addJob.add(jobIdUpdateText);
		
		addJob.add(enterAddJob);
		addJob.add(returnToJobMenuFromAdd);
//--------------------------------------------------------------
		
		jobTextDisplay =new JPanel();		
		jobTextDisplay.setLayout(null);
		
		jobOutputLabel = new JTextArea("");
		jobOutputLabel.setLineWrap(true);
		jobOutputLabel.setWrapStyleWord(true);
		jobScroll = new JScrollPane(jobOutputLabel);
		jobScroll.setBounds(10, 10, 480, 275);
		
		requestJobID = new JTextField(20);
		requestJobID.setBounds(40, 320, 200, 30);
		
		jobConfermRequest= new JButton("Search");
		jobConfermRequest.setBounds(250, 320, 100, 30);
		
		returnFromJTD = new JButton("Back");
		returnFromJTD.setBounds(395, 320, 100, 30);
		
		jobTextDisplay.add(jobScroll);
		jobTextDisplay.add(returnFromJTD);
		jobTextDisplay.add(requestJobID);
		jobTextDisplay.add(jobConfermRequest);

//---------------------------------------------------------------
		
		contractorLabel = new JLabel("contractors");
		contractorLabel.setBounds(225, 10, 250, 50);
		
		contractorMenu =new JPanel();
		contractorMenu.setLayout(null);
		
		addContractorToDatabase = new JButton("Add");
		addContractorToDatabase.setBounds(20, 80, 100, 30);
		
		deleteContractorFromDatabase = new JButton("Remove");
		deleteContractorFromDatabase.setBounds(20, 160, 100, 30);
		
		updateContractorInDatabase = new JButton("Update");
		updateContractorInDatabase.setBounds(20, 240, 100, 30);
		
		displayContractorRequest = new JButton("Search");
		displayContractorRequest.setBounds(20, 320, 100, 30);

		returnToMainFromContractor = new JButton("Back");
		returnToMainFromContractor.setBounds(370, 320, 100, 30);
		
		contractorMenu.add(contractorLabel);
		contractorMenu.add(addContractorToDatabase);
		contractorMenu.add(deleteContractorFromDatabase);
		contractorMenu.add(updateContractorInDatabase);
		contractorMenu.add(displayContractorRequest);
		contractorMenu.add(returnToMainFromContractor);
//--------------------------------------------------------------
		addContractor =new JPanel();
		addContractor.setLayout(null);
		
		contractorFirstName = new JLabel("First Name");
		contractorFirstName.setBounds(20, 20, 100, 30);
		
		contractorLastName = new JLabel("Last Name");
		contractorLastName.setBounds(20, 60, 100, 30);
		
		contractorSalary = new JLabel("Salary");
		contractorSalary.setBounds(20, 100, 100, 30);
		
		contractorEmail = new JLabel("Email");
		contractorEmail.setBounds(20, 140, 100, 30);
		
		contractorPhone = new JLabel("Phone Number");
		contractorPhone.setBounds(20, 180, 100, 30);
		
		contractorAddress = new JLabel("Address");
		contractorAddress.setBounds(20, 220, 100, 30);

		contractorIdUpdate = new JLabel("contractor ID");
		contractorIdUpdate.setBounds(20, 260, 100, 30);
		contractorIdUpdate.setVisible(false);
		
		
		contractorFirstNameText = new JTextField(20);
		contractorFirstNameText.setBounds(120, 20, 200, 30);
		
		contractorLastNameText = new JTextField(20);
		contractorLastNameText.setBounds(120, 60, 200, 30);
		
		contractorSalaryText = new JTextField(20);
		contractorSalaryText.setBounds(120, 100, 200, 30);
		
		contractorEmailText = new JTextField(20);
		contractorEmailText.setBounds(120, 140, 200, 30);
		
		contractorPhoneText1 = new JTextField(20);
		contractorPhoneText1.setBounds(120, 180, 63, 30);
		
		contractorPhoneText2 = new JTextField(20);
		contractorPhoneText2.setBounds(187, 180, 66, 30);
		
		contractorPhoneText3 = new JTextField(20);
		contractorPhoneText3.setBounds(254, 180, 66, 30);
		
		contractorAddressText1 = new JTextField(20);
		contractorAddressText1.setBounds(120, 220, 100, 30);
		
		contractorAddressText2 = new JTextField(20);
		contractorAddressText2.setBounds(225, 220, 70, 30);
		
		contractorAddressText3 = new JTextField(20);
		contractorAddressText3.setBounds(300, 220, 30, 30);
		
		contractorAddressText4 = new JTextField(20);
		contractorAddressText4.setBounds(335, 220, 50, 30);
		
		contractorIdUpdateText = new JTextField(20);
		contractorIdUpdateText.setBounds(120, 260, 200, 30);
		contractorIdUpdateText.setVisible(false);
		
		enterAddContractor = new JButton("Enter");
		enterAddContractor.setBounds(395, 270, 100, 30);

		returnToContractorMenuFromAdd = new JButton("Back");
		returnToContractorMenuFromAdd.setBounds(395, 320, 100, 30);
		
		addContractor.add(contractorFirstName);
		addContractor.add(contractorLastName);
		addContractor.add(contractorSalary);
		addContractor.add(contractorEmail);
		addContractor.add(contractorPhone);
		addContractor.add(contractorAddress);
		addContractor.add(contractorIdUpdate);
		
		addContractor.add(contractorFirstNameText);
		addContractor.add(contractorLastNameText);
		addContractor.add(contractorSalaryText);
		addContractor.add(contractorEmailText);
		addContractor.add(contractorPhoneText1);
		addContractor.add(contractorPhoneText2);
		addContractor.add(contractorPhoneText3);
		addContractor.add(contractorAddressText1);
		addContractor.add(contractorAddressText2);
		addContractor.add(contractorAddressText3);
		addContractor.add(contractorAddressText4);
		addContractor.add(contractorIdUpdateText);
		
		addContractor.add(enterAddContractor);
		addContractor.add(returnToContractorMenuFromAdd);
//--------------------------------------------------------------
		contractorTextDisplay =new JPanel();		
		contractorTextDisplay.setLayout(null);
		
		contractorOutputLabel = new JTextArea("");
		contractorOutputLabel.setLineWrap(true);
		contractorOutputLabel.setWrapStyleWord(true);
		contractorScroll = new JScrollPane(contractorOutputLabel);
		contractorScroll.setBounds(10, 10, 480, 275);
		
		requestContractorID = new JTextField(20);
		requestContractorID.setBounds(40, 320, 200, 30);
		
		contractorConfermRequest= new JButton("Search");
		contractorConfermRequest.setBounds(250, 320, 100, 30);
		
		returnFromConTD = new JButton("Back");
		returnFromConTD.setBounds(395, 320, 100, 30);
		
		contractorTextDisplay.add(contractorScroll);
		contractorTextDisplay.add(returnFromConTD);
		contractorTextDisplay.add(requestContractorID);
		contractorTextDisplay.add(contractorConfermRequest);

//---------------------------------------------------------------
		
		deleteContractor =new JPanel();
		deleteContractor.setLayout(null);
			
		deleteContractorMenu = new JLabel("Contractor Id: ");
		deleteContractorMenu.setBounds(50, 100, 100, 30);

		deleteContractorMenuText = new JTextField(20);
		deleteContractorMenuText.setBounds(125, 100, 200, 30);
		
		enterDeleteContractor = new JButton("Remove");
		enterDeleteContractor.setBounds(330, 100, 100, 29);

		returnToContractorMenuFromDelete = new JButton("Back");
		returnToContractorMenuFromDelete.setBounds(395, 320, 100, 30);
		
		deleteContractor.add(deleteContractorMenu);
		deleteContractor.add(deleteContractorMenuText);
		deleteContractor.add(enterDeleteContractor);
		deleteContractor.add(returnToContractorMenuFromDelete);
//--------------------------------------------------------------
		
		panel.add(mainMenu, "MM");
		panel.add(employeeMenu, "EM");
		panel.add(addEmployee, "AE");
		panel.add(textDisplay, "TD");
		panel.add(deleteEmployee, "DE");
		panel.add(customerMenu, "CM");
		panel.add(addCustomer, "AC");
		panel.add(customerTextDisplay, "CTD");
		panel.add(deleteCustomer, "DC");
		panel.add(inventoryMenu, "IM");
		panel.add(addInventory, "AI");
		panel.add(inventoryTextDisplay, "ITD");
		panel.add(deleteInventory, "DI");
		panel.add(jobMenu, "JM");
		panel.add(addJob, "AJ");
		panel.add(jobTextDisplay, "JTD");
		panel.add(contractorMenu, "ConM");
		panel.add(addContractor, "ACon");
		panel.add(contractorTextDisplay, "ConTD");
		panel.add(deleteContractor, "DCon");
		
		cl.show(panel, "MM");
		
		this.add(panel);
//---------------------------------------------------------------

	
		employees.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cl.show(panel, "EM");
				}});
		
		customers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "CM");
			}});
		
		inventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "IM");
			}});
		
		jobs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "JM");
			}});
		
		contractors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "ConM");
			}});
		
		addToDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					cl.show(panel, "AE");
					update = false;
			}});
		
		addCustomerToDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "AC");
				update = false;
		}});
		
		addInventoryToDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "AI");
				update = false;
		}});
		
		addJobToDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "AJ");
				update = false;
		}});
		
		addContractorToDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "ACon");
				update = false;
		}});
		
		displayRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					cl.show(panel, "TD");
			}});
		
		displayCustomerRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "CTD");
		}});
		
		displayInventoryRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "ITD");
				
				for(String x : SQLConnection.displayInventory())
					inventoryOutputLabel.setText(inventoryOutputLabel.getText() + "\n" + x);
		}});
		
		displayJobRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "JTD");
		}});
		
		displayContractorRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "ConTD");
		}});
		
		deleteFromDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					cl.show(panel, "DE");
			}});
		
		deleteCustomerFromDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "DC");
		}});
		
		deleteInventoryFromDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "DI");
		}});
		
		deleteContractorFromDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "DCon");
		}});
		
		updateDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "AE");
				update=true;
				employeeIdUpdate.setVisible(true);
				employeeIdUpdateText.setVisible(true);
		}});
		
		updateCustomerInDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "AC");
				update=true;
				customerIdUpdate.setVisible(true);
				customerIdUpdateText.setVisible(true);
		}});
		
		updateInventoryInDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "AI");
				update=true;
				inventoryIdUpdate.setVisible(true);
				inventoryIdUpdateText.setVisible(true);
		}});
		
		updateJobInDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "AJ");
				update=true;
				jobIdUpdate.setVisible(true);
				jobIdUpdateText.setVisible(true);
		}});
		
		updateContractorInDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "ACon");
				update=true;
				contractorIdUpdate.setVisible(true);
				contractorIdUpdateText.setVisible(true);
		}});
		
		enterAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!update) {
					if(e.getActionCommand().equals("field")) {
						SQLConnection.addFieldStaff(Double.valueOf(salaryText.getText()), firstNameText.getText(), lastNameText.getText(), emailText.getText(), phoneText1.getText()+"."+phoneText2.getText()+"."+phoneText3.getText(), Integer.valueOf(managerText.getText()), addressText1.getText(), addressText2.getText(), addressText3.getText(), Integer.valueOf(addressText4.getText()), Integer.valueOf(cofText.getText()));
					}else if(e.getActionCommand().equals("office")) {
						SQLConnection.addOfficeStaff(Double.valueOf(salaryText.getText()), firstNameText.getText(), lastNameText.getText(), emailText.getText(), phoneText1.getText()+"."+phoneText2.getText()+"."+phoneText3.getText(), Integer.valueOf(managerText.getText()), addressText1.getText(), addressText2.getText(), addressText3.getText(), Integer.valueOf(addressText4.getText()), Integer.valueOf(cofText.getText()));
					}else if(e.getActionCommand().equals("mechanic")) {
						SQLConnection.addMechanic(Double.valueOf(salaryText.getText()), firstNameText.getText(), lastNameText.getText(), emailText.getText(), phoneText1.getText()+"."+phoneText2.getText()+"."+phoneText3.getText(), Integer.valueOf(managerText.getText()), addressText1.getText(), addressText2.getText(), addressText3.getText(), Integer.valueOf(addressText4.getText()));
					}
					salaryText.setText("");
					firstNameText.setText("");
					lastNameText.setText("");
					emailText.setText("");
					phoneText1.setText("");
					phoneText2.setText("");
					phoneText3.setText("");
					addressText1.setText("");
					addressText2.setText("");
					addressText3.setText("");
					addressText4.setText("");
					managerText.setText("");
					cofText.setText("");
			
					cl.show(panel, "EM");
				}else{
					
					String s = salaryText.getText();
					String pn1 = phoneText1.getText();
					String pn2 = phoneText2.getText();
					String pn3 = phoneText3.getText();
					String a4 = addressText4.getText();
					String ma = managerText.getText();
					String id = employeeIdUpdateText.getText();
					String co = cofText.getText();
					String phoneNum="";
					Integer zipCode=0,  manager=0, eId=0, sal=0, cofV=0;
					
					
					if(pn1.equals("")|pn2.equals("")|pn3.equals(""))
						phoneNum="";
					else
						phoneNum=pn1+"."+pn2+"."+pn3;
					if(a4.equals(""))
						zipCode = 0;
					else 
						zipCode = Integer.valueOf(a4);
					if(ma.equals(""))
						manager = 0;
					else 
						manager = Integer.valueOf(ma);
					if(id.equals(""))
						eId = 0;
					else 
						eId = Integer.valueOf(id);
					if(s.equals(""))
						sal = 0;
					else 
						sal = Integer.valueOf(s);
					if(co.equals(""))
						cofV = 0;
					else 
						cofV = Integer.valueOf(co);
					
					if(e.getActionCommand().equals("field")) {
						SQLConnection.updateFieldStaff(eId, firstNameText.getText(), lastNameText.getText(), emailText.getText(), phoneNum, manager, addressText1.getText(), addressText2.getText(), addressText3.getText(), zipCode, cofV, sal);
					}else if(e.getActionCommand().equals("office")) {
						SQLConnection.updateOfficeStaff(eId, firstNameText.getText(), lastNameText.getText(), emailText.getText(), phoneNum, manager, addressText1.getText(), addressText2.getText(), addressText3.getText(), zipCode, cofV, sal);
					}else if(e.getActionCommand().equals("mechanic")) {
						SQLConnection.updateMechanics(eId, firstNameText.getText(), lastNameText.getText(), emailText.getText(), phoneNum, manager, addressText1.getText(), addressText2.getText(), addressText3.getText(), zipCode, sal);
					}
					salaryText.setText("");
					firstNameText.setText("");
					lastNameText.setText("");
					emailText.setText("");
					phoneText1.setText("");
					phoneText2.setText("");
					phoneText3.setText("");
					addressText1.setText("");
					addressText2.setText("");
					addressText3.setText("");
					addressText4.setText("");
					managerText.setText("");
					cofText.setText("");
					employeeIdUpdateText.setText("");
			
					cl.show(panel, "EM");
					employeeIdUpdate.setVisible(false);
					employeeIdUpdateText.setVisible(false);
				}
			}});
		
		enterAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!update) {
					SQLConnection.addCustomer(customerFirstNameText.getText(), customerLastNameText.getText(), customerEmailText.getText(), customerPhoneText1.getText()+"."+customerPhoneText2.getText()+"."+customerPhoneText3.getText(), customerAddressText1.getText(), customerAddressText2.getText(), customerAddressText3.getText(), Integer.valueOf(customerAddressText4.getText()));

					customerFirstNameText.setText("");
					customerLastNameText.setText("");
					customerEmailText.setText("");
					customerPhoneText1.setText("");
					customerPhoneText2.setText("");
					customerPhoneText3.setText("");
					customerAddressText1.setText("");
					customerAddressText2.setText("");
					customerAddressText3.setText("");
					customerAddressText4.setText("");
			
					cl.show(panel, "CM");
				}else{
					
					String pn1 = phoneText1.getText();
					String pn2 = phoneText2.getText();
					String pn3 = phoneText3.getText();
					String a4 = addressText4.getText();
					String id = customerIdUpdateText.getText();
					String phoneNum="";
					Integer zipCode=0, cId=0;
					
					
					if(pn1.equals("")|pn2.equals("")|pn3.equals(""))
						phoneNum="";
					else
						phoneNum=pn1+"."+pn2+"."+pn3;
					if(a4.equals(""))
						zipCode = 0;
					else 
						zipCode = Integer.valueOf(a4);
					if(id.equals(""))
						cId = 0;
					else 
						cId = Integer.valueOf(id);

					SQLConnection.updateCustomer(cId, customerFirstNameText.getText(), customerLastNameText.getText(), customerEmailText.getText(), phoneNum, customerAddressText1.getText(), customerAddressText2.getText(), customerAddressText3.getText(), zipCode);
					

					customerFirstNameText.setText("");
					customerLastNameText.setText("");
					customerEmailText.setText("");
					customerPhoneText1.setText("");
					customerPhoneText2.setText("");
					customerPhoneText3.setText("");
					customerAddressText1.setText("");
					customerAddressText2.setText("");
					customerAddressText3.setText("");
					customerAddressText4.setText("");
					customerIdUpdateText.setText("");
			
					cl.show(panel, "CM");
					customerIdUpdate.setVisible(false);
					customerIdUpdateText.setVisible(false);
				}
			}});
		
		enterAddInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!update) {
					SQLConnection.addInventory(inventoryNameText.getText(), Double.valueOf(inventoryPriceText.getText()), Integer.valueOf(inventoryQuantityText.getText()), Date.valueOf(inventoryExpirationText.getText()));

					inventoryNameText.setText("");
					inventoryPriceText.setText("");
					inventoryQuantityText.setText("");
					inventoryExpirationText.setText("");
			
					cl.show(panel, "IM");
				}else{
					String id = inventoryIdUpdateText.getText();
					String p = inventoryPriceText.getText();
					String q = inventoryQuantityText.getText();
					String ex = inventoryExpirationText.getText();
					Double price=0.0;  
					Integer	quant=0, eId; 
					Date expire = Date.valueOf("0001-01-01");
					
					if(id.equals(""))
						eId= 0;
					else
						eId= Integer.valueOf(inventoryIdUpdateText.getText());
					if(p.equals(""))
						price= 0.0;
					else
						price= Double.valueOf(inventoryPriceText.getText());
					if(q.equals(""))
						quant = 0;
					else 
						quant = Integer.valueOf(inventoryQuantityText.getText());
					if(ex.equals(""))
						expire = Date.valueOf("0001-01-01");
					else 
						expire = Date.valueOf(inventoryExpirationText.getText());
										
					SQLConnection.updateInventory(eId, inventoryNameText.getText(), price, quant, expire);
					
					inventoryNameText.setText("");
					inventoryPriceText.setText("");
					inventoryQuantityText.setText("");
					inventoryExpirationText.setText("");
					inventoryIdUpdateText.setText("");
			
					cl.show(panel, "IM");
					inventoryIdUpdate.setVisible(false);
					inventoryIdUpdateText.setVisible(false);
				}
			}});
		
		enterAddJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!update) {
					Integer con = 0;
					
					if(jobContractorText.getText().equals(""))
						con = 0;
					else
						con = Integer.valueOf(jobContractorText.getText());
					
					SQLConnection.addJobs(Double.valueOf(jobPriceText.getText()), Integer.valueOf(jobCrewText.getText()), Integer.valueOf(jobCustomerText.getText()), con);

					jobPriceText.setText("");
					jobCrewText.setText("");
					jobCustomerText.setText("");
					jobContractorText.setText("");
			
					cl.show(panel, "JM");
				}else{
					String id = jobIdUpdateText.getText();
					String p = jobPriceText.getText();
					String cr = jobCrewText.getText();
					String c = jobCustomerText.getText();
					String con = jobContractorText.getText();
					Double price;  
					Integer	crV, cV, conV, eId;
					
					if(id.equals(""))
						eId= 0;
					else
						eId= Integer.valueOf(jobIdUpdateText.getText());
					if(p.equals(""))
						price= 0.0;
					else
						price= Double.valueOf(jobPriceText.getText());
					if(cr.equals(""))
						crV = 0;
					else 
						crV = Integer.valueOf(jobCrewText.getText());
					if(c.equals(""))
						cV = 0;
					else 
						cV = Integer.valueOf(jobCustomerText.getText());
					if(con.equals(""))
						conV = 0;
					else 
						conV = Integer.valueOf(jobContractorText.getText());
					
					SQLConnection.updateJob(eId, price, crV, cV, conV);
					
					jobPriceText.setText("");
					jobCrewText.setText("");
					jobCustomerText.setText("");
					jobContractorText.setText("");
			
					cl.show(panel, "JM");
					jobIdUpdate.setVisible(false);
					jobIdUpdateText.setVisible(false);
				}
			}});
		
		enterAddContractor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!update) {
					SQLConnection.addContractor(contractorFirstNameText.getText(), contractorLastNameText.getText(), contractorEmailText.getText(), contractorPhoneText1.getText()+"."+contractorPhoneText2.getText()+"."+contractorPhoneText3.getText(), contractorAddressText1.getText(), contractorAddressText2.getText(), contractorAddressText3.getText(), Integer.valueOf(contractorAddressText4.getText()), Double.valueOf(contractorSalaryText.getText()));

					contractorFirstNameText.setText("");
					contractorLastNameText.setText("");
					contractorEmailText.setText("");
					contractorPhoneText1.setText("");
					contractorPhoneText2.setText("");
					contractorPhoneText3.setText("");
					contractorAddressText1.setText("");
					contractorAddressText2.setText("");
					contractorAddressText3.setText("");
					contractorAddressText4.setText("");
					contractorSalaryText.setText("");
			
					cl.show(panel, "ConM");
				}else{
					
					String pn1 = contractorPhoneText1.getText();
					String pn2 = contractorPhoneText2.getText();
					String pn3 = contractorPhoneText3.getText();
					String a4 = contractorAddressText4.getText();
					String s = contractorSalaryText.getText();
					String id = contractorIdUpdateText.getText();
					String phoneNum="";
					Integer zipCode=0, cId=0;
					double sal;
					
					
					if(pn1.equals("")|pn2.equals("")|pn3.equals(""))
						phoneNum="";
					else
						phoneNum=pn1+"."+pn2+"."+pn3;
					if(a4.equals(""))
						zipCode = 0;
					else 
						zipCode = Integer.valueOf(a4);
					if(s.equals(""))
						sal = 0.0;
					else 
						sal = Double.valueOf(s);
					if(id.equals(""))
						cId = 0;
					else 
						cId = Integer.valueOf(id);

					SQLConnection.updateContractor(cId, contractorFirstNameText.getText(), contractorLastNameText.getText(), contractorEmailText.getText(), phoneNum, contractorAddressText1.getText(), contractorAddressText2.getText(), contractorAddressText3.getText(), zipCode, sal);
					

					contractorFirstNameText.setText("");
					contractorLastNameText.setText("");
					contractorEmailText.setText("");
					contractorPhoneText1.setText("");
					contractorPhoneText2.setText("");
					contractorPhoneText3.setText("");
					contractorAddressText1.setText("");
					contractorAddressText2.setText("");
					contractorAddressText3.setText("");
					contractorAddressText4.setText("");
					contractorSalaryText.setText("");
					contractorIdUpdateText.setText("");
			
					cl.show(panel, "ConM");
					contractorIdUpdate.setVisible(false);
					contractorIdUpdateText.setVisible(false);
				}
			}});
		
		enterDeleteEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SQLConnection.removeEmployee(Integer.valueOf(deleteEmployeeMenuText.getText()));
				
				deleteEmployeeMenuText.setText("");
			
				cl.show(panel, "EM");
				
			}});
		
		enterDeleteCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SQLConnection.removeCustomer(Integer.valueOf(deleteCustomerMenuText.getText()));
				
				deleteCustomerMenuText.setText("");
			
				cl.show(panel, "CM");
				
			}});
		
		enterDeleteInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SQLConnection.removeInventory(Integer.valueOf(deleteInventoryMenuText.getText()));
				
				deleteInventoryMenuText.setText("");
			
				cl.show(panel, "IM");
				
			}});
		
		enterDeleteContractor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SQLConnection.removeContractor(Integer.valueOf(deleteContractorMenuText.getText()));
				
				deleteContractorMenuText.setText("");
			
				cl.show(panel, "ConM");
				
			}});
		
		confermRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String out="";
				if(e.getActionCommand().equals("field")) {
					if(requestID.getText().length()>0)
						out = SQLConnection.displayFieldStaffMember(Integer.parseInt(requestID.getText()));
					if(out.length()>0)
						outputLabel.setText(outputLabel.getText() + "\n" + out);
				}else if (e.getActionCommand().equals("office")) {
					if(requestID.getText().length()>0)
						out = SQLConnection.displayOfficeStaffMember(Integer.parseInt(requestID.getText()));
					if(out.length()>0)
						outputLabel.setText(outputLabel.getText() + "\n" + out);
				}else if (e.getActionCommand().equals("mechanic")) {
					if(requestID.getText().length()>0)
						out = SQLConnection.displayMechanicsMember(Integer.parseInt(requestID.getText()));
					if(out.length()>0)
						outputLabel.setText(outputLabel.getText() + "\n" + out);
				}
				requestID.setText("");
			}});
		
		customerConfermRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String out="";
				
					if(requestCustomerID.getText().length()>0)
						out = SQLConnection.displayCustomer(Integer.parseInt(requestCustomerID.getText()));
					if(out.length()>0)
						customerOutputLabel.setText(customerOutputLabel.getText() + "\n" + out);
					
				requestCustomerID.setText("");
			}});
		
		jobConfermRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String out="";
				
					if(requestJobID.getText().length()>0)
						out = SQLConnection.displayJob(Integer.parseInt(requestJobID.getText()));
					if(out.length()>0)
						jobOutputLabel.setText(jobOutputLabel.getText() + "\n" + out);
					
				requestJobID.setText("");
			}});
		
		contractorConfermRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String out="";
				
					if(requestContractorID.getText().length()>0)
						out = SQLConnection.displaySubcontractor(Integer.parseInt(requestContractorID.getText()));
					if(out.length()>0)
						contractorOutputLabel.setText(contractorOutputLabel.getText() + "\n" + out);
					
				requestContractorID.setText("");
			}});
		
		employeeCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = (String)employeeCB.getSelectedItem();
				if(msg.equals("Field Staff")) {
					enterAddEmployee.setActionCommand("field");
					confermRequest.setActionCommand("field");
					cof.setVisible(true);
					cofText.setVisible(true);
					cof.setText("Crew ID");
				}else if(msg.equals("Office Staff")) {
					enterAddEmployee.setActionCommand("office");
					confermRequest.setActionCommand("office");
					cof.setVisible(true);
					cofText.setVisible(true);
					cof.setText("Room Number");
				}else if(msg.equals("Mechanics")) {
					enterAddEmployee.setActionCommand("mechanic");
					confermRequest.setActionCommand("mechanic");
					cof.setVisible(false);
					cofText.setVisible(false);
				}
			}});
		
		ActionListener returnToMainMenu = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "MM");
			}};
		returnToMain.addActionListener(returnToMainMenu);
		returnToMainFromCustomer.addActionListener(returnToMainMenu);
		returnToMainFromInventory.addActionListener(returnToMainMenu);
		returnToMainFromJob.addActionListener(returnToMainMenu);
		returnToMainFromContractor.addActionListener(returnToMainMenu);
		
		ActionListener returnToEM = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "EM");
				outputLabel.setText("");
			}};
		returnToEmployeeMenuFromAdd.addActionListener(returnToEM);
		returnToEmployeeMenuFromDelete.addActionListener(returnToEM);
		returnFromTD.addActionListener(returnToEM);
		
		
		ActionListener returnToCM = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "CM");
				customerOutputLabel.setText("");
			}};
		returnToCustomerMenuFromAdd.addActionListener(returnToCM);
		returnToCustomerMenuFromDelete.addActionListener(returnToCM);
		returnFromCTD.addActionListener(returnToCM);
		
		ActionListener returnToIM = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "IM");
				inventoryOutputLabel.setText("");
			}};		
		returnToInventoryMenuFromAdd.addActionListener(returnToIM);
		returnToInventoryMenuFromDelete.addActionListener(returnToIM);
		returnFromITD.addActionListener(returnToIM);
		
		ActionListener returnToJM = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "JM");
				jobOutputLabel.setText("");
			}};
		returnToJobMenuFromAdd.addActionListener(returnToJM);
		returnFromJTD.addActionListener(returnToJM);
		
		ActionListener returnToConM = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "ConM");
				//contractorOutputLabel.setText("");
			}};
		returnToContractorMenuFromAdd.addActionListener(returnToConM);
		returnToContractorMenuFromDelete.addActionListener(returnToConM);
		returnFromConTD.addActionListener(returnToConM);
//-------------------------------------------------------------------------------------------------
		
		setState(JFrame.ICONIFIED);
		try {
			Thread.sleep(3);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		setState(JFrame.NORMAL);
		
		
		this.addWindowListener(new WindowAdapter() { 
	    	public void windowClosing(WindowEvent evt){SQLConnection.closeConnection();}  
	    });  
		
	}

	
	public static void main(String args[]) {
		SQLConnection.openConnection();
		new window();
	}
}