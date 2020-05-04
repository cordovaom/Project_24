import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

public class SQLConnection {

	private static Connection connection;

	//open connection
	public static void openConnection() {
		String user = "project_24";
		String password = "V00841463";
		String database = "project_24";

		String url = "jdbc:mysql://3.234.246.29:3306/" + database;

		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//close connection
	public static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//return list of all people
	public static void showAll() {
		try {
			String query = "SELECT employee_id, first_name, last_name, email FROM field_staff";

			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);

			System.out.println("QUERY: " + query);
			System.out.println("=== RESULTS === ");

			while(rs.next()) {
				System.out.println("ID: "+ rs.getInt("employee_id") + ", Name: " + rs.getString("first_name")+ " " + rs.getString("last_name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	//adds New person to field staff table
	public static void addFieldStaff(double salary, String first_name, String last_name,
			String email, String phone, Integer manager, String street, 
			String city, String state, Integer zip, Integer crew) {
			
			try {	
				Integer employee_id=-1;
				
				String query = "INSERT INTO employees (first_name, last_name, email, phone_number, manager_id, street, city, state, zip_code, salary) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				PreparedStatement pst = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			

				pst.setString(1, first_name);
				pst.setString(2, last_name);
				if(email == null)
					pst.setNull(3, Types.VARCHAR);
				else
					pst.setString(3, email);
				pst.setString(4, phone);
				if(manager == null)
					pst.setNull(5, Types.INTEGER);
				else
					pst.setInt(5, manager);
				pst.setString(6, street);
				pst.setString(7, city);
				pst.setString(8, state);
				pst.setInt(9, zip);
				pst.setDouble(10, salary);

				pst.executeUpdate();	
				
				ResultSet rs = pst.getGeneratedKeys();
				
				if (rs.next()) {
					employee_id = rs.getInt(1);
				}
				
				query = "INSERT INTO field_staff (employee_id, crew_id) VALUES (?, ?)";

				pst = connection.prepareStatement(query);
				pst.setInt(1, employee_id);
				pst.setInt(2, crew);
				
				pst.executeUpdate();
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//adds New person to office staff table
	public static void addOfficeStaff(double salary, String first_name, String last_name,
			String email, String phone, Integer manager, String street, 
			String city, String state, Integer zip, Integer office) {

		try {
			Integer employee_id=-1;
			
			String query = "INSERT INTO employees (first_name, last_name, email, phone_number, manager_id, street, city, state, zip_code, salary) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement pst = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		

			pst.setString(1, first_name);
			pst.setString(2, last_name);
			if(email == null)
				pst.setNull(3, Types.VARCHAR);
			else
				pst.setString(3, email);
			pst.setString(4, phone);
			if(manager == null)
				pst.setNull(5, Types.INTEGER);
			else
				pst.setInt(5, manager);
			pst.setString(6, street);
			pst.setString(7, city);
			pst.setString(8, state);
			pst.setInt(9, zip);
			pst.setDouble(10, salary);

			pst.executeUpdate();	
			
			ResultSet rs = pst.getGeneratedKeys();
			
			if (rs.next()) {
				employee_id = rs.getInt(1);
			}
			
			query = "INSERT INTO office_staff (employee_id, office_number) VALUES (?, ?)";

			pst = connection.prepareStatement(query);
			pst.setInt(1, employee_id);
			pst.setInt(2, office);
			
			pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
		
	//adds New person to mechanics table
	public static void addMechanic(double salary, String first_name, String last_name,
			String email, String phone, Integer manager, String street, 
			String city, String state, Integer zip) {

		try {	
			Integer employee_id=-1;
			
			String query = "INSERT INTO employees (first_name, last_name, email, phone_number, manager_id, street, city, state, zip_code, salary) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement pst = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		

			pst.setString(1, first_name);
			pst.setString(2, last_name);
			if(email == null)
				pst.setNull(3, Types.VARCHAR);
			else
				pst.setString(3, email);
			pst.setString(4, phone);
			if(manager == null)
				pst.setNull(5, Types.INTEGER);
			else
				pst.setInt(5, manager);
			pst.setString(6, street);
			pst.setString(7, city);
			pst.setString(8, state);
			pst.setInt(9, zip);
			pst.setDouble(10, salary);

			pst.executeUpdate();	
			
			ResultSet rs = pst.getGeneratedKeys();
			
			if (rs.next()) {
				employee_id = rs.getInt(1);
			}
			
			query = "INSERT INTO mechanics (employee_id) VALUES (?)";

			pst = connection.prepareStatement(query);
			pst.setInt(1, employee_id);
			
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//adds New equipment to equipment table
	public static void addEquipment(String serial, String manufacturer, double price, Date date) {

			try {	
				String query = "INSERT INTO equipment (serial_number, manufacturer, price, purchase_date) VALUES (?, ?, ?, ?)";

				PreparedStatement pst = connection.prepareStatement(query);
				

				pst.setString(1, serial);
				pst.setString(2, manufacturer);
				pst.setDouble(3, price);
				pst.setDate(4, date);

				pst.executeUpdate();		
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	//adds New repair log to repairs table
	public static void addRepairs(Integer mechanic, Integer equipment, Date date) {

			try {	
				String query = "INSERT INTO repairs (mechanic_id, equipment_id, repair_date) VALUES (?, ?, ?)";

				PreparedStatement pst = connection.prepareStatement(query);
				
				pst.setInt(1, mechanic);
				pst.setInt(2, equipment);
				pst.setDate(4, date);

				pst.executeUpdate();		
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	//adds New person to subcontractors table
	public static void addContractor(String first_name, String last_name,
			String email, String phone, String street, 
			String city, String state, Integer zip, double salary) {

			try {	
				String query = "INSERT INTO subcontractors (first_name, last_name, email, phone_number, street, city, state, zip_code, salary) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

				PreparedStatement pst = connection.prepareStatement(query);
				

				pst.setString(1, first_name);
				pst.setString(2, last_name);
				if(email.equals(null))
					pst.setNull(3, Types.VARCHAR);
				else
					pst.setString(3, email);
				pst.setString(4, phone);
				pst.setString(5, street);
				pst.setString(6, city);
				pst.setString(7, state);
				pst.setInt(8, zip);
				pst.setDouble(9, salary);

				pst.executeUpdate();		
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	//adds New person to customers table
	public static void addCustomer(String first_name, String last_name,
			String email, String phone, String street, 
			String city, String state, Integer zip) {

			try {	
				String query = "INSERT INTO customers (first_name, last_name, email, phone_number, street, city, state, zip_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

				PreparedStatement pst = connection.prepareStatement(query);
					

				pst.setString(1, first_name);
				pst.setString(2, last_name);
				if(email.equals(null))
						pst.setNull(3, Types.VARCHAR);
				else
						pst.setString(3, email);
				pst.setString(4, phone);
				pst.setString(5, street);
				pst.setString(6, city);
				pst.setString(7, state);
				pst.setInt(8, zip);

				pst.executeUpdate();		
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	//adds New job record to jobs table
	public static void addJobs(double price, Integer crew, Integer customer, Integer contractor) {

			try {	
				String query = "INSERT INTO jobs (price, crew_id, customer_id, contractor_id) VALUES (?, ?, ?, ?)";

				PreparedStatement pst = connection.prepareStatement(query);
					

				pst.setDouble(1, price);
				pst.setInt(2, crew);
				pst.setInt(3, customer);
				if(contractor == 0)
					pst.setNull(4, Types.INTEGER);
				else
					pst.setInt(4, contractor);

				pst.executeUpdate();		
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	//adds New inventory to inventory table
	public static void addInventory(String name, double price, Integer quantity, Date date) {

			try {	
				String query = "INSERT INTO inventory (name, price, quantity, expiration_date) VALUES (?, ?, ?, ?)";

				PreparedStatement pst = connection.prepareStatement(query);
					

				pst.setString(1, name);
				pst.setDouble(2, price);
				pst.setInt(3, quantity);
				pst.setDate(4, date);

				pst.executeUpdate();		
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	//states what inventory will be used for a job
	public static void addJobMaterial(Integer job, Integer inventory) {

				try {	
					String query = "INSERT INTO job_materials (job_id, inventory_id) VALUES (?, ?)";

					PreparedStatement pst = connection.prepareStatement(query);
						

					pst.setInt(1, job);
					pst.setInt(2, inventory);

					pst.executeUpdate();		
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
	
	//adds New license to license table
	public static void addLicense(String title, Integer contractor, Date acquire, Date expire) {

			try {	
				String query = "INSERT INTO license (tile, contractor_id, acuired_date, expiration_date) VALUES (?, ?, ?, ?)";

				PreparedStatement pst = connection.prepareStatement(query);
						

				pst.setString(1, title);
				pst.setInt(2, contractor);
				pst.setDate(3, acquire);
				pst.setDate(4, expire);

				pst.executeUpdate();		
						
				} catch (Exception e) {
						e.printStackTrace();
				}
			}
	
	//adds New crew to crew table
	public static void addCrew(String name) {

				try {	
					String query = "INSERT INTO crews (crew_name) VALUES (?)";

					PreparedStatement pst = connection.prepareStatement(query);
							

					pst.setString(1, name);

					pst.executeUpdate(); 		
							
					} catch (Exception e) {
							e.printStackTrace();
					}
				}
//----------------------------------------------------------------------------------------------------	
	
	//removes employee from office staff, field staff, or mechanics with given id
	public static void removeEmployee(Integer id) {

		try {
			String query = "DELETE FROM employees WHERE employee_id = ?";

			PreparedStatement pst = connection.prepareStatement(query);

			pst.setInt(1, id);

			pst.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//removes equipment  with given identifiers
	public static void removeEquipment(Integer id) {

		try {
			String query = "DELETE FROM equipment WHERE equipment_id =?";

			PreparedStatement pst = connection.prepareStatement(query);

			pst.setInt(1, id);
			
			pst.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//removes subcontractor  with given id
	public static void removeContractor(Integer contractor) {

		try {
			String query = "DELETE FROM subcontractors WHERE contractor_id = ?";

			PreparedStatement pst = connection.prepareStatement(query);

			pst.setInt(1, contractor);
			
			pst.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//removes subcontractor  with given id
	public static void removeCustomer(Integer id) {

		try {
			String query = "DELETE FROM customers WHERE customer_id = ?";

			PreparedStatement pst = connection.prepareStatement(query);

			pst.setInt(1, id);
			
			pst.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//removes subcontractor  with given id
	public static void removeInventory(Integer id) {

		try {
			String query = "DELETE FROM inventory WHERE inventory_id = ?";

			PreparedStatement pst = connection.prepareStatement(query);

			pst.setInt(1, id);
			
			pst.executeUpdate(); // executeUpdate when the query modifies the DB
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//removes subcontractor  with given identifiers
	public static void removeLicense(String title, Integer contractor) {

		try {
			String query = "DELETE FROM inventory WHERE (title, contractor_id) = (?, ?)";

			PreparedStatement pst = connection.prepareStatement(query);

			pst.setString(1, title);
			pst.setInt(1, contractor);
			
			pst.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//removes screw with given id
	public static void removeCrew(Integer id) {

			try {
				String query = "DELETE FROM crews WHERE crew_id = ?";

				PreparedStatement pst = connection.prepareStatement(query);

				pst.setInt(1, id);
				
				pst.executeUpdate(); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
//----------------------------------------------------------------------------------------	
	
	//Updates field staff with employee id = id
	public static void updateFieldStaff(Integer id, String first_name, String last_name,
			String email, String phone, Integer manager, String street, 
			String city, String state, Integer zip, Integer crew, double salary) {
		
			String oldFirst = "";
			String oldLast = "";
			String oldEmail = "";
			String oldPhone = "";
			Integer oldCrew = 0;
			Integer oldManager = 0;
			String oldStreet = "";
			String oldCity = "";
			String oldState = "";
			Integer oldZip = 0;
			double oldSalary = 0.00;

			try {
				String query = "SELECT * FROM employees WHERE employee_id = ?";

				PreparedStatement pst = connection.prepareStatement(query);
				
				pst.setInt(1, id);
				
				ResultSet rs = pst.executeQuery();
				
				while(rs.next()) {
					oldFirst = rs.getString("first_name");
					oldLast = rs.getString("last_name");
					oldEmail = rs.getString("email");
					oldPhone = rs.getString("phone_number");
					oldManager = rs.getInt("manager_id");
					oldStreet = rs.getString("street");
					oldCity = rs.getString("city");
					oldState = rs.getString("state");
					oldZip = rs.getInt("zip_code");
					oldSalary = rs.getDouble("salary");
				}
				
				query = "SELECT * FROM field_staff WHERE employee_id = ?";

				pst = connection.prepareStatement(query);
				
				pst.setInt(1, id);
				
				rs = pst.executeQuery();
				
				while(rs.next()) {
					oldCrew = rs.getInt("crew_id");
				}

				query = "UPDATE employees SET first_name=?, last_name=?, email=?, phone_number=?, manager_id=?, street=?, city=?, state=?, zip_code=?, salary=? WHERE employee_id = ?";

				pst = connection.prepareStatement(query);
				
				if(first_name.equals(""))
					pst.setString(1, oldFirst);
				else
					pst.setString(1, first_name);		
				if(last_name.equals(""))
					pst.setString(2, oldLast);
				else
					pst.setString(2, last_name);
				if(email.equals(""))
					if(oldEmail == null)
						pst.setNull(3, Types.VARCHAR);
					else
						pst.setString(3, oldEmail);
				else
					pst.setString(3, email);
				if(phone.equals(""))
					pst.setString(4, oldPhone);
				else
					pst.setString(4, phone);
		
				if(manager == 0)
					if(oldManager == 0)
						pst.setNull(5, Types.INTEGER);
					else
						pst.setInt(5, oldManager);
				else
					pst.setInt(6, manager);
				if(street.equals(""))
					pst.setString(6, oldStreet);
				else
					pst.setString(6, street);
				if(city.equals(""))
					pst.setString(7, oldCity);
				else
					pst.setString(7, city);
				if(state.equals(""))
					pst.setString(8, oldState);
				else
					pst.setString(8, state);
				if(zip == 0)
					pst.setInt(9, oldZip);
				else
					pst.setInt(9, zip);
				if(salary == 0)
					pst.setDouble(10, oldSalary);
				else pst.setDouble(10, salary);
				
				pst.setInt(11, id);

				pst.executeUpdate();
				
				query = "UPDATE field_staff SET crew_id=? WHERE employee_id = ?";

				pst = connection.prepareStatement(query);
				
				if(crew == 0)
					pst.setInt(1, oldCrew);
				else
					pst.setInt(1, crew);
				
				pst.setInt(2, id);

				pst.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	//Updates office staff with employee id = id
	public static void updateOfficeStaff(Integer id, String first_name, String last_name,
			String email, String phone, Integer manager, String street, 
			String city, String state, Integer zip, Integer office, double salary) {
			String oldFirst = "";
			String oldLast = "";
			String oldEmail = "";
			String oldPhone = "";
			Integer oldOffice = 0;
			Integer oldManager = 0;
			String oldStreet = "";
			String oldCity = "";
			String oldState = "";
			Integer oldZip = 0;
			double oldSalary = 0.00;

			try {
				String query = "SELECT * FROM office_staff WHERE employee_id = ?";

				PreparedStatement pst = connection.prepareStatement(query);
				
				pst.setInt(1, id);
				
				ResultSet rs = pst.executeQuery();
				
				while(rs.next()) {
					oldFirst = rs.getString("first_name");
					oldLast = rs.getString("last_name");
					oldEmail = rs.getString("email");
					oldPhone = rs.getString("phone_number");
					oldManager = rs.getInt("manager_id");
					oldStreet = rs.getString("street");
					oldCity = rs.getString("city");
					oldState = rs.getString("state");
					oldZip = rs.getInt("zip_code");
					oldSalary = rs.getDouble("salary");
				}
				
				query = "SELECT * FROM office_staff WHERE employee_id = ?";

				pst = connection.prepareStatement(query);
				
				pst.setInt(1, id);
				
				rs = pst.executeQuery();
				
				while(rs.next()) {
					oldOffice = rs.getInt("office_number");
				}
				
				query = "UPDATE employees SET first_name=?, last_name=?, email=?, phone_number=?, manager_id=?, street=?, city=?, state=?, zip_code=?, salary=? WHERE employee_id = ?";
				
				pst = connection.prepareStatement(query);
				
				if(first_name.equals(""))
					pst.setString(1, oldFirst);
				else
					pst.setString(1, first_name);		
				if(last_name.equals(""))
					pst.setString(2, oldLast);
				else
					pst.setString(2, last_name);
				if(email.equals(""))
					if(oldEmail == null)
						pst.setNull(3, Types.VARCHAR);
					else
						pst.setString(3, oldEmail);
				else
					pst.setString(3, email);
				if(phone.equals(""))
					pst.setString(4, oldPhone);
				else
					pst.setString(4, phone);
		
				if(manager == 0)
					if(oldManager == 0)
						pst.setNull(5, Types.INTEGER);
					else
						pst.setInt(5, oldManager);
				else
					pst.setInt(6, manager);
				if(street.equals(""))
					pst.setString(6, oldStreet);
				else
					pst.setString(6, street);
				if(city.equals(""))
					pst.setString(7, oldCity);
				else
					pst.setString(7, city);
				if(state.equals(""))
					pst.setString(8, oldState);
				else
					pst.setString(8, state);
				if(zip == 0)
					pst.setInt(9, oldZip);
				else
					pst.setInt(9, zip);
				if(salary == 0)
					pst.setDouble(10, oldSalary);
				else pst.setDouble(10, salary);

				pst.executeUpdate();
				
				query = "UPDATE office_staff SET office_number=? WHERE employee_id = ?";

				pst = connection.prepareStatement(query);
				
				if(office == 0)
					pst.setInt(1, oldOffice);
				else
					pst.setInt(1, office);
				
				pst.setInt(2, id);

				pst.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	//Updates mechanic with employee id = id
	public static void updateMechanics(Integer id, String first_name, String last_name,
				String email, String phone, Integer manager, String street, 
				String city, String state, Integer zip, double salary) {
				String oldFirst = "";
				String oldLast = "";
				String oldEmail = "";
				String oldPhone = "";
				Integer oldManager = 0;
				String oldStreet = "";
				String oldCity = "";
				String oldState = "";
				Integer oldZip = 0;
				double oldSalary = 0.00;

				try {
					String query = "SELECT * FROM office_staff WHERE employee_id = ?";

					PreparedStatement pst = connection.prepareStatement(query);
					
					pst.setInt(1, id);
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()) {
						oldFirst = rs.getString("first_name");
						oldLast = rs.getString("last_name");
						oldEmail = rs.getString("email");
						oldPhone = rs.getString("phone_number");
						oldManager = rs.getInt("manager_id");
						oldStreet = rs.getString("street");
						oldCity = rs.getString("city");
						oldState = rs.getString("state");
						oldZip = rs.getInt("zip_code");
						oldSalary = rs.getDouble("salary");
					}
					
					query = "UPDATE employees SET first_name=?, last_name=?, email=?, phone_number=?, manager_id=?, street=?, city=?, state=?, zip_code=?, salary=? WHERE employee_id = ?";
					
					pst = connection.prepareStatement(query);
					
					if(first_name.equals(""))
						pst.setString(1, oldFirst);
					else
						pst.setString(1, first_name);		
					if(last_name.equals(""))
						pst.setString(2, oldLast);
					else
						pst.setString(2, last_name);
					if(email.equals(""))
						if(oldEmail == null)
							pst.setNull(3, Types.VARCHAR);
						else
							pst.setString(3, oldEmail);
					else
						pst.setString(3, email);
					if(phone.equals(""))
						pst.setString(4, oldPhone);
					else
						pst.setString(4, phone);
			
					if(manager == 0)
						if(oldManager == 0)
							pst.setNull(5, Types.INTEGER);
						else
							pst.setInt(5, oldManager);
					else
						pst.setInt(6, manager);
					if(street.equals(""))
						pst.setString(6, oldStreet);
					else
						pst.setString(6, street);
					if(city.equals(""))
						pst.setString(7, oldCity);
					else
						pst.setString(7, city);
					if(state.equals(""))
						pst.setString(8, oldState);
					else
						pst.setString(8, state);
					if(zip == 0)
						pst.setInt(9, oldZip);
					else
						pst.setInt(9, zip);
					if(salary == 0)
						pst.setDouble(10, oldSalary);
					else pst.setDouble(10, salary);

					pst.executeUpdate();
		
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	//Updates subcontractor.
	public static void updateContractor(Integer id, String first_name, String last_name, String email, String phone, String street, String city, String state, Integer zip, double salary) {
			String oldFirst = "";
			String oldLast = "";
			String oldEmail = "";
			String oldPhone = "";
			String oldStreet = "";
			String oldCity = "";
			String oldState = "";
			Integer oldZip = 0;
			double oldSalary = 0.00;

			try {
				String query = "SELECT * FROM subcontractors WHERE contractor_id = ?";

				PreparedStatement pst = connection.prepareStatement(query);
					
				pst.setInt(1, id);
						
				ResultSet rs = pst.executeQuery();
					
				while(rs.next()) {
					oldFirst = rs.getString("first_name");
					oldLast = rs.getString("last_name");
					oldEmail = rs.getString("email");
					oldPhone = rs.getString("phone_number");
					oldStreet = rs.getString("street");
					oldCity = rs.getString("city");
					oldState = rs.getString("state");
					oldZip = rs.getInt("zip_code");
					oldSalary = rs.getDouble("salary");
				}
					
				query = "UPDATE subcontractors SET first_name=?, last_name=?, emial=?, phone_number, street, city, state, zip, salary WHERE contractor_id = ?";

				pst = connection.prepareStatement(query);
					
				if(first_name.equals(""))
					pst.setString(1, oldFirst);
				else
					pst.setString(1, first_name);		
				if(last_name.equals(""))
					pst.setString(2, oldLast);
				else
					pst.setString(2, last_name);
				if(email.equals(""))
					pst.setString(3, oldEmail);
				else
					pst.setString(3, email);
				if(phone.equals(""))
					pst.setString(4, oldPhone);
				else
					pst.setString(4, phone);
				if(street.equals(""))
					pst.setString(6, oldStreet);
				else
					pst.setString(6, street);
				if(city.equals(""))
					pst.setString(7, oldCity);
				else
					pst.setString(7, city);
				if(state.equals(""))
					pst.setString(8, oldState);
				else
					pst.setString(8, state);
				if(zip == 0)
					pst.setInt(9, oldZip);
				else
					pst.setInt(9, zip);
				if(salary == 0)
					pst.setDouble(10, oldSalary);
				else pst.setDouble(10, salary);
				
				pst.setInt(11, id);

				pst.executeUpdate(); // executeUpdate when the query modifies the DB		
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	//Updates equipment with serial number and purchase date.
	public static void updateEquipment(Integer id, String serial, String manufacturer, double price, Date date) {
			String oldSerial = "";
			String oldManufacturer = "";
			double oldPrice = 0.00;
			Date oldDate = Date.valueOf("0001-01-01");

			try {
				String query = "SELECT * FROM equipment WHERE equipment_id = ?";

				PreparedStatement pst = connection.prepareStatement(query);
						
				pst.setInt(1, id);
						
						
				ResultSet rs = pst.executeQuery();
						
				while(rs.next()) {
					oldSerial =rs.getString("serial_number");
					oldManufacturer = rs.getString("manufacturer");
					oldPrice = rs.getDouble("price");
					oldDate = rs.getDate("purchase_date");
				}
					
				query = "UPDATE equipment SET manufacturer=?, price=?, serial_number=?, purchase_date=? WHERE equipment_id = ?";

				pst = connection.prepareStatement(query);
						
				if(manufacturer.equals(""))
					pst.setString(1, oldManufacturer);
				else
					pst.setString(1, manufacturer);		
				if(price == 0.00)
					pst.setDouble(2, oldPrice);
				else 
					pst.setDouble(2, price);
				if(serial.equals(""))
					pst.setString(3, oldSerial);
				else 
					pst.setString(3, serial);
				if(date == Date.valueOf("0001-01-01"))
					pst.setDate(4, oldDate);
				else 
					pst.setDate(4, date);
						
				pst.setInt(5, id);

				pst.executeUpdate(); // executeUpdate when the query modifies the DB		
						
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	//Updates customers.
	public static void updateCustomer(Integer id, String first_name, String last_name, String email, String phone, String street, String city, String state, Integer zip) {
			String oldFirst = "";
			String oldLast	= "";
			String oldEmail = "";
			String oldPhone = "";
			String oldStreet = "";
			String oldCity = "";
			String oldState = "";
			Integer oldZip = 0;

				try {
					String query = "SELECT * FROM customers WHERE customer_id = ?";

					PreparedStatement pst = connection.prepareStatement(query);
							
					pst.setInt(1, id);							
							
					ResultSet rs = pst.executeQuery();
							
					while(rs.next()) {
						oldFirst = rs.getString("first_name");
						oldLast	= rs.getString("last_name");
						oldEmail = rs.getString("email");
						oldPhone = rs.getString("phone_number");
						oldStreet = rs.getString("street");
						oldCity = rs.getString("city");
						oldState = rs.getString("state");
						oldZip = rs.getInt("zip_code");
					}
						
					query = "UPDATE customers SET first_name=?, last_name=?, email=?, phone_number=?, street=?, city=?, state=?, zip_code=? WHERE customer_id = ?";

					pst = connection.prepareStatement(query);
							
					if(first_name.equals(""))
						pst.setString(1, oldFirst);
					else
						pst.setString(1, first_name);
					if(last_name.equals(""))
						pst.setString(2, oldLast);
					else
						pst.setString(2, last_name);
					if(email.equals(""))
						pst.setString(3, oldEmail);
					else
						pst.setString(3, email);
					if(phone.equals(""))
						pst.setString(4, oldPhone);
					else
						pst.setString(4, phone);
					if(street.equals(""))
						pst.setString(5, oldStreet);
					else
						pst.setString(5, street);
					if(city.equals(""))
						pst.setString(6, oldCity);
					else
						pst.setString(6, city);
					if(state.equals(""))
						pst.setString(7, oldState);
					else
						pst.setString(7, state);
					if(zip == 0)
						pst.setInt(8, oldZip);
					else pst.setInt(8, zip);

					pst.executeUpdate(); // executeUpdate when the query modifies the DB		
							
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
	
	//Updates jobs
	public static void updateJob(Integer id, double price, Integer crew, Integer customer, Integer contractor) {
		double oldPrice = 0;
		Integer oldCrew = 0;
		Integer oldCustomer = 0;
		Integer oldContractor = 0;

			try {
				String query = "SELECT * FROM jobs WHERE job_id = ?";

				PreparedStatement pst = connection.prepareStatement(query);
						
				pst.setInt(1, id);							
						
				ResultSet rs = pst.executeQuery();
						
				while(rs.next()) {
					oldPrice = rs.getDouble("price");
					oldCrew = rs.getInt("crew_id");
					oldCustomer = rs.getInt("customer_id");
					oldContractor = rs.getInt("contractor_id");
				}
					
				query = "UPDATE jobs SET price=?, crew_id=?, customer_id=?, contractor_id=? WHERE job_id = ?";

				pst = connection.prepareStatement(query);
						
				if(price==0)
					pst.setDouble(1, oldPrice);
				else
					pst.setDouble(1, price);
				if(crew==0)
					pst.setInt(2, oldCrew);
				else
					pst.setInt(2, crew);
				if(customer==0)
					pst.setInt(3, oldCustomer);
				else
					pst.setInt(3, customer);
				if(contractor==0)
					if(oldContractor == 0)
						pst.setNull(4, Types.INTEGER);
					else
						pst.setInt(4, oldContractor);
				else
					pst.setInt(4, contractor);
				pst.setInt(5, id);
				

				pst.executeUpdate();		
						
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	//Updates inventory
	public static void updateInventory(Integer id, String name, double price, Integer quantity, Date date) {
		String oldName = "";
		double oldPrice = 0;
		Integer oldQuantity= 0;
		Date oldDate = Date.valueOf("0001-01-01");

			try {
				String query = "SELECT * FROM inventory WHERE inventory_id = ?";

				PreparedStatement pst = connection.prepareStatement(query);
						
				pst.setInt(1, id);							
						
				ResultSet rs = pst.executeQuery();
						
				while(rs.next()) {
					oldPrice = rs.getDouble("price");
					oldName = rs.getString("name");
					oldQuantity = rs.getInt("quantity");
					oldDate = rs.getDate("expiration_date");
				}
					
				query = "UPDATE inventory SET name=?, price=?, quantity=?, expiration_date=? WHERE inventory_id = ?";

				pst = connection.prepareStatement(query);
						
				if(name.contentEquals(""))
					pst.setString(1, oldName);
				else
					pst.setString(1, name);
				if(price==0)
					pst.setDouble(2, oldPrice);
				else
					pst.setDouble(2, price);
				if(quantity==0)
					pst.setInt(3, oldQuantity);
				else
					pst.setInt(3, quantity);
				if(quantity==0)
					if(oldDate==null)
						pst.setNull(4, Types.DATE);
					else
						pst.setDate(4, oldDate);
				else
					pst.setDate(4, date);
					pst.setInt(5, id);
				

				pst.executeUpdate(); // executeUpdate when the query modifies the DB		
						
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	//Updates crews
	public static void updateCrew(Integer id, String name) {

			try {
					
				String query = "UPDATE crews SET name=?WHERE crew_id = ?";

				PreparedStatement pst = connection.prepareStatement(query);
						
				pst.setString(1, name);
				pst.setInt(2, id);
				

				pst.executeUpdate(); // executeUpdate when the query modifies the DB		
						
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//displays field staff member with given id.
	public static String displayFieldStaffMember(Integer id) {
		String output="";
		try {
			String query = "SELECT * FROM employees, field_staff WHERE employees.employee_id = ? AND field_staff.employee_id=?";

			PreparedStatement pst = connection.prepareStatement(query);

			pst.setInt(1, id);
			pst.setInt(2, id);

			ResultSet rs = pst.executeQuery();

			while(rs.next())			
				output = "ID: " + rs.getInt(1) + ", Name: " + rs.getString("first_name") + " " + rs.getString("last_name") + 
						", Email: " + rs.getString("email")+"@gmail.com"+ ", Phone number: " + rs.getString("phone_number")+ ", Crew ID: " + rs.getInt("crew_id") + 
						", Manager ID: " + rs.getInt("manager_id")+ ", Address: " + rs.getString("Street")+" "+rs.getString("city")+" "+rs.getString("state")+ " "+rs.getInt("zip_code")+ ", Salary: " + rs.getDouble("salary");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}
	
	//displays office staff member with given id.
	public static String displayOfficeStaffMember(Integer id) {
		String output="";
		try {
			String query = "SELECT * FROM employees, office_staff WHERE employees.employee_id = ? AND office_staff.employee_id=?";

			PreparedStatement pst = connection.prepareStatement(query);

			pst.setInt(1, id);
			pst.setInt(2, id);

			ResultSet rs = pst.executeQuery();

			while(rs.next())			
				output = "ID: " + rs.getInt(1) + ", Name: " + rs.getString("first_name") + " " + rs.getString("last_name") + 
						", Email: " + rs.getString("email")+"@gmail.com"+ ", Phone number: " + rs.getString("phone_number")+ ", Office Number: " + rs.getInt("office_number")+ 
						", Manager ID: " + rs.getInt("manager_id")+ ", Address: " + rs.getString("Street")+" "+rs.getString("city")+" "+rs.getString("state")+ " "+rs.getInt("zip_code")+ ", Salary: " + rs.getDouble("salary");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}

	//displays mechanics member with given id.
	public static String displayMechanicsMember(Integer id) {
		String output="";
		try {
			String query = "SELECT * FROM employees, mechanics WHERE employees.employee_id = ? AND mechanics.employee_id=?";

			PreparedStatement pst = connection.prepareStatement(query);

			pst.setInt(1, id);
			pst.setInt(2, id);

			ResultSet rs = pst.executeQuery();

			while(rs.next())			
				output = "ID: " + rs.getInt(1) + ", Name: " + rs.getString("first_name") + " " + rs.getString("last_name") + 
						", Email: " + rs.getString("email")+"@gmail.com"+ ", Phone number: " + rs.getString("phone_number")+ 
						", Manager ID: " + rs.getInt("manager_id")+ ", Address: " + rs.getString("Street")+" "+rs.getString("city")+" "+rs.getString("state")+ " "+rs.getInt("zip_code")+ ", Salary: " + rs.getDouble("salary");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}
	
	//displays equipment with given id.
	public static String displayEquipment(Integer id) {
		String output="";
		try {
			String query = "SELECT * FROM equipment WHERE equipment_id = ?";

			PreparedStatement pst = connection.prepareStatement(query);

			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			while(rs.next())			
				output = "ID: " + rs.getInt(1) +", Serial Number: " + rs.getString(2) + ", Manufacturer: " + rs.getString("manufacturer") + 
						", Cost: " + rs.getDouble("price")+ ", Purchased on: " + rs.getDate("purchase_date");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}

	//displays repair log.
	public static ArrayList<String> displayRepairedBy(Integer id) {
		ArrayList<String> output = new ArrayList<String>();
		try {
			String query = "SELECT * FROM repairs WHERE mechanic_id = ?";
			
			PreparedStatement pst = connection.prepareStatement(query);
			
			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			while(rs.next())			
				output.add("Mechanic: " + rs.getInt(1) + ", equipment: " + rs.getInt(2) + ", Repair Date: " + rs.getDate(3));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}

	//display subcontractor with given id.
	public static String displaySubcontractor(Integer id) {
		String output="";
		try {
			String query = "SELECT * FROM subcontractors WHERE contractor_id = ?";
			
			PreparedStatement pst = connection.prepareStatement(query);

			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			while(rs.next())			
				output = "ID: " + rs.getInt(1) + ", Name: " + rs.getString("first_name") + " " + rs.getString("last_name") + 
				", Email: " + rs.getString("email")+"@gmail.com"+ ", Phone number: " + rs.getString("phone_number")+
				", Address: " + rs.getString("Street")+" "+rs.getString("city")+" "+rs.getString("state")+ " "+rs.getInt("zip_code")+
				", Salary: " + rs.getDouble("salary");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}
	
	//display customer with given id.
	public static String displayCustomer(Integer id) {
			String output="";
			try {
				String query = "SELECT * FROM customers WHERE customer_id = ?";
				
				PreparedStatement pst = connection.prepareStatement(query);

				pst.setInt(1, id);

				ResultSet rs = pst.executeQuery();

				while(rs.next())			
					output = "ID: " + rs.getInt(1) + ", Name: " + rs.getString("first_name") + " " + rs.getString("last_name") + 
					", Email: " + rs.getString("email")+"@gmail.com"+ ", Phone number: " + rs.getString("phone_number")+
					", Address: " + rs.getString("Street")+" "+rs.getString("city")+" "+rs.getString("state")+ " "+rs.getInt("zip_code");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return output;
		}

	//display job with given id.
	public static String displayJob(Integer id) {
			String output="";
			try {
				String query = "SELECT * FROM jobs WHERE job_id = ?";
				
				PreparedStatement pst = connection.prepareStatement(query);

				pst.setInt(1, id);

				ResultSet rs = pst.executeQuery();

				while(rs.next())			
					output = "ID: " + rs.getInt(1) + ", Price: " + rs.getDouble(2) + 
					", Crew ID: " + rs.getInt(3)+ ", Subcontractor: " + rs.getInt(4);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return output;
		}
		
	//display Inventory.
	public static ArrayList<String> displayInventory() {
				ArrayList<String> output = new ArrayList<String>();
				try {
					String query = "SELECT * FROM inventory";
					
					Statement st = connection.prepareStatement(query);

					ResultSet rs = st.executeQuery(query);
					while(rs.next()) {
						output.add("ID: " + rs.getInt(1) + ", Name: " + rs.getString(2) + 
						", Price: " + rs.getDouble(3)+ ", Quantity: " + rs.getInt(4)+", Expiration Date: " + rs.getDate(5));
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				return output;
			}
	
	//displays all licenses held by subcontractor with given id.
	public static ArrayList<String> displayLicenses(Integer id) {
			ArrayList<String> output = new ArrayList<String>();
			try {
				String query = "SELECT * FROM licenses WHERE contractor_id = ?";
				
				PreparedStatement pst = connection.prepareStatement(query);
				
				pst.setInt(1, id);

				ResultSet rs = pst.executeQuery();

				while(rs.next())			
					output.add("Title: " + rs.getString(1) + ", Contractor ID: " + rs.getInt(2) + ", Acquire Date: " + rs.getDate(3)+ ", Expiration Date: " + rs.getDate(3));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return output;
		}
	
	//displays all material used for job with given id.
	public static ArrayList<String> displayJobMaterials(Integer id) {
			ArrayList<String> output = new ArrayList<String>();
			try {
				String query = "SELECT * FROM job_materials WHERE job_id = ?";
				
				PreparedStatement pst = connection.prepareStatement(query);
				
				pst.setInt(1, id);

				ResultSet rs = pst.executeQuery();

				while(rs.next())			
					output.add("Job: " + rs.getInt(1) + ", Invnetory: " + rs.getInt(2));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return output;
		}
	
	//display job with given id.
	public static String displayCrew(Integer id) {
				String output="";
				try {
					String query = "SELECT * FROM crews WHERE crew_id = ?";
					
					PreparedStatement pst = connection.prepareStatement(query);

					pst.setInt(1, id);

					ResultSet rs = pst.executeQuery();

					while(rs.next())			
						output = "ID: " + rs.getInt(1) + ", Name: " + rs.getString(2) + 
						", Number of members: " + rs.getInt(3);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				return output;
			}
	
		
//	public static void main(String[] args) {
//
//		openConnection();
//		for(String x : displayInventory())
//			System.out.println(x);
//		
//		addOfficeStaff(21000.00, "Tom", "Timothy",
//				"blast", "703.111.1115", 100, "1111 Street Dr.", 
//				"City", "ST", 12345, 9999);
//		
//		System.out.println(displayFieldStaffMember(100));
//		
//		removeEmployee(125);
//		closeConnection();
//	}
}
