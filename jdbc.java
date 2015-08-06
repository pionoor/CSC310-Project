package jdbc;
import java.sql.*;

import java.util.*;

public class jdbc {

	public static void printMenu()
	{

		System.out.println("1. Simple Query");
		System.out.println("2. Advanced Query");
		System.out.println("3. Update");
		System.out.println("4. Insert");
		System.out.println("5. Delete");
		System.out.println("6. Quit");

	}

	public static Connection establishConnection(){

		Connection conn = null;
		try
		{
			//   jdbc:mysql://localhost/test?user=testuser&password=testpass
			String url = "jdbc:mysql://database2.cs.tamu.edu/ambago-db1?user=ambago&password=fishandchips";
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
			conn = DriverManager.getConnection (url);            
			System.out.println ("Database connection established");

		}
		catch (Exception e)
		{
			System.err.println ("Cannot connect to database server");
			System.out.println("Connection Issue: " + e.getMessage());
		} 

		return conn;
	}

	static void avgCompHrs (Connection conn) {
		Statement s;
		try {
			s = conn.createStatement ();

			s.executeQuery ("SELECT ROUND(AVG(CompletedHRS),0) AS \'compHRS\' FROM Student;");
			ResultSet rs = s.getResultSet ();

			int count = 0;
			while (rs.next ())
			{
				int idVal = rs.getInt ("compHRS");

				System.out.println ("\nAverage Completed HRS \n" + idVal);
				++count;
			}

			rs.close ();
			s.close ();
			System.out.println ("\n" + count + " rows were retrieved");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static void employedSeniors (Connection conn) {
		Statement s;
		try {
			s = conn.createStatement ();

			s.executeQuery ("SELECT Name AS \'Employed Seniors\' FROM Employee"
					+ " WHERE Employee.name IN (SELECT Name "
					+ " FROM Student "
					+ " WHERE CompletedHRS >=90 AND CompletedHRS <= 120);");

			ResultSet rs = s.getResultSet ();

			int count = 0;
			System.out.println ("\nEmployed Seniors");

			while (rs.next ())
			{
				String idVal = rs.getString("Employed Seniors");

				System.out.println (idVal);
				++count;
			}

			rs.close ();
			s.close ();
			System.out.println ("\n" + count + " rows were retrieved");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	static void addTuple (Connection conn, String TableName, String[] value) {
		PreparedStatement s = null;

		try {
			if (TableName == "College"){
				s = conn.prepareStatement ("INSERT INTO " + TableName + "(Name, NumFacultyMembers, NumStudents )" + " VALUES(?,?,?)");
				s.setString (1, value[0]);
				s.setInt (2, Integer.parseInt(value[1]));
				s.setInt (3, Integer.parseInt(value[2]));

			} else if (TableName == "FinancialPackage") {
				s = conn.prepareStatement ("INSERT INTO " + TableName + "(PackageID, TotalAwardAmount)" + " VALUES(?,?)");
				s.setInt (1, Integer.parseInt(value[0]));
				s.setInt (2, Integer.parseInt(value[1]));

			} else {
				System.out.println("Table Name was not recognized!");
				return;
			}

			int count = s.executeUpdate ();
			s.close ();
			System.out.println (count + " rows were inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


	static void updateTuple (Connection conn, String TableName, String attribute, String set, String where) {

		PreparedStatement s = null;
		try {

			if (TableName == "College"){
				if(attribute == "Name"){
					s = conn.prepareStatement("UPDATE College "
							+ "SET Name = ? "
							+ "WHERE Name = ?;") ;
					s.setString(1, set);
					s.setString(2, where);

				} 

				else if(attribute == "NumFacultyMembers"){

					s = conn.prepareStatement("UPDATE College "
							+ "SET NumFacultyMembers = ? "
							+ "WHERE NumFacultyMembers = ?;") ;
					s.setInt(1, Integer.parseInt(set));
					s.setInt(2, Integer.parseInt(where));
				}

				else if(attribute == "NumStudents"){
					s = conn.prepareStatement("UPDATE College "
							+ "SET NumStudents = ? "
							+ "WHERE NumStudents = ?;") ;
					s.setInt(1, Integer.parseInt(set));
					s.setInt(2, Integer.parseInt(where));
				} 
				else {
					System.out.println("Attribute Name was not recognized!");
				}


			} else if (TableName == "FinancialPackage") {
				if(attribute == "PackageID"){
					s = conn.prepareStatement("UPDATE FinancialPackage "
							+ "SET PackageID = ? "
							+ "WHERE PackageID = ?;") ;
					s.setInt(1, Integer.parseInt(set));
					s.setInt(2, Integer.parseInt(where));
				}
				else if(attribute == "TotalAwardAmount"){
					s = conn.prepareStatement("UPDATE FinancialPackage "
							+ "SET TotalAwardAmount = ? "
							+ "WHERE TotalAwardAmount = ?;") ;
					s.setInt(1, Integer.parseInt(set));
					s.setInt(2, Integer.parseInt(where));
				}

			} else {
				System.out.println("Table Name was not recognized!");
				return;

			}


			int count = s.executeUpdate ();
			s.close ();
			System.out.println (count + " Tuple was updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}



	static void delTuple (Connection conn, String TableName, String attribute, String value) {

		PreparedStatement s = null;
		try {

			if (TableName == "College"){
				if(attribute == "Name"){
					s = conn.prepareStatement("DELETE FROM College "
							+ "WHERE Name = ?;") ;
					s.setString(1, value);

				} 

				else if(attribute == "NumFacultyMembers"){

					s = conn.prepareStatement("DELETE FROM College "
							+ "WHERE NumFacultyMembers = ?;") ;
					s.setInt(1, Integer.parseInt(value));
				}

				else if(attribute == "NumStudents"){
					s = conn.prepareStatement("DELETE FROM College "
							+ "WHERE NumStudents = ?;") ;
					s.setInt(1, Integer.parseInt(value));
				} 
				else {
					System.out.println("Attribute Name was not recognized!");
				}


			} else if (TableName == "FinancialPackage") {
				if(attribute == "PackageID"){
					s = conn.prepareStatement("DELETE FROM FinancialPackage "
							+ "WHERE PackageID = ?;") ;
					s.setInt(1, Integer.parseInt(value));
				}
				else if(attribute == "TotalAwardAmount"){
					s = conn.prepareStatement("DELETE FROM FinancialPackage "
							+ "WHERE TotalAwardAmount = ?;") ;
					s.setInt(1, Integer.parseInt(value));
				}

			} else {
				System.out.println("Table Name was not recognized!");
				return;

			}


			int count = s.executeUpdate ();
			s.close ();
			System.out.println (count + " Tuple was deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}





	public static void main(String[] args) {

		Connection conn = establishConnection();

		printMenu();


		for(;;)
		{
			Scanner in = new Scanner(System.in);
			//in.useDelimiter("\n");
			System.out.println("");
			System.out.print("User input: ");
			int num = in.nextInt();

			if(num == 1)		//Simple Query
			{			
				avgCompHrs(conn);
				printMenu();
			}

			if(num == 2)		//Advanced Query
			{

				employedSeniors(conn);
				printMenu();

			}

			if(num == 3)		//UPDATE
			{
				System.out.println("Which relation would you like to Update?");
				System.out.println("1. College");
				System.out.println("2. Financial Package");
				System.out.print("User input: ");
				int numUpdate = in.nextInt();

				if(numUpdate == 1)
				{
					System.out.println("Which attribute would you like to update?");
					System.out.println("1. Name");
					System.out.println("2. NumFacultyMembers");
					System.out.println("3. NumStudents");
					System.out.print("User input: ");
					int numAttr = in.nextInt();

					if(numAttr == 1)
					{
						Scanner input = new Scanner(System.in);
						System.out.print("Input old value for attribute: \n");
						String oldValue = input.nextLine();
						System.out.print("Input new value for attribute: \n");
						String newValue = input.nextLine();
						updateTuple (conn, "College", "Name", newValue, oldValue);		
					}

					if(numAttr == 2)
					{
						Scanner input = new Scanner(System.in);
						System.out.print("Input old value for attribute: \n");
						String oldValue = input.nextLine();
						System.out.print("Input new value for attribute: \n");
						String newValue = input.nextLine();
						updateTuple (conn, "College", "NumFacultyMembers", newValue, oldValue);	

					}

					if(numAttr == 3)
					{
						Scanner input = new Scanner(System.in);
						System.out.print("Input old value for attribute: \n");
						String oldValue = input.nextLine();
						System.out.print("Input new value for attribute: \n");
						String newValue = input.nextLine();
						updateTuple (conn, "College", "NumStudents", newValue, oldValue);	
					}

				}

				if(numUpdate == 2)
				{
					System.out.println("Which attribute would you like to update?");
					System.out.println("");
					System.out.println("1. PackageID");
					System.out.println("2. TotalAwardAmount");
					System.out.println("");
					System.out.print("User input: ");
					int numAttr2 = in.nextInt();

					if(numAttr2 == 1)
					{
						Scanner input = new Scanner(System.in);
						System.out.print("Input old value for attribute: \n");
						String oldValue = input.nextLine();
						System.out.print("Input new value for attribute: \n");
						String newValue = input.nextLine();
						updateTuple (conn, "FinancialPackage", "PackageID", newValue, oldValue);

					}

					if(numAttr2 == 2)
					{
						Scanner input = new Scanner(System.in);
						System.out.print("Input old value for attribute: \n");
						String oldValue = input.nextLine();
						System.out.print("Input new value for attribute: \n");
						String newValue = input.nextLine();
						updateTuple (conn, "FinancialPackage", "TotalAwardAmount", newValue, oldValue);

					}


				}

				System.out.println("");
				printMenu();


			}

			if(num == 4)		//INSERT
			{
				System.out.println("Which relation would you like to insert into?");
				System.out.println("1. College");
				System.out.println("2. Financial Package");
				System.out.print("User input: ");
				int numInsert = in.nextInt();

				if(numInsert == 1)
				{
					System.out.print("Input new tuple seperated by space: \n");
					System.out.print("College(Name, Numfaculty, NumStudents) \n");

					Scanner input = new Scanner(System.in);
					String temp = input.nextLine();

					String[] elements = temp.split("\\s");

					addTuple (conn, "College", elements);

				}

				if(numInsert == 2)
				{
					System.out.print("Input new tuple seperated by space: \n");
					System.out.print("FinancialPackage(PackageID, TotalAwardAmount) \n");	

					Scanner input1 = new Scanner(System.in);
					String temp = input1.nextLine();

					String[] elements1 = temp.split("\\s");

					addTuple (conn, "FinancialPackage", elements1);




				}


				printMenu();

			}

			if(num == 5)		//DELETE
			{

				System.out.println("Which relation would you like to Delete from?");
				System.out.println("1. College");
				System.out.print("User input: ");
				int numUpdate = in.nextInt();

				if(numUpdate == 1)
				{
					System.out.println("Which attribute would you like to use as the Delete condition?");
					System.out.println("1. Name");
					System.out.println("2. NumFacultyMembers");
					System.out.println("3. NumStudents");
					System.out.print("User input: ");
					int numAttr = in.nextInt();

					if(numAttr == 1)
					{
						Scanner input = new Scanner(System.in);
						System.out.print("Input the value for attribute condition: \n");
						String deleteCondition = input.nextLine();

						delTuple (conn, "College", "Name", deleteCondition);		
					}

					if(numAttr == 2)
					{
						Scanner input = new Scanner(System.in);
						System.out.print("Input the value for attribute condition: \n");
						String deleteCondition = input.nextLine();

						delTuple (conn, "College", "NumFacultyMembers", deleteCondition);		

					}

					if(numAttr == 3)
					{
						Scanner input = new Scanner(System.in);
						System.out.print("Input the value for attribute condition: \n");
						String deleteCondition = input.nextLine();

						delTuple (conn, "College", "NumStudents", deleteCondition);		
					}

				}

				if(numUpdate == 2)
				{
					System.out.println("Which attribute would you like to update?");
					System.out.println("1. PackageID");
					System.out.println("2. TotalAwardAmount");
					System.out.print("User input: ");
					int numAttr2 = in.nextInt();

					if(numAttr2 == 1)
					{
						Scanner input = new Scanner(System.in);
						System.out.print("Input the value for attribute condition: \n");
						String deleteCondition = input.nextLine();

						delTuple (conn, "FinancialPackage", "PackageID", deleteCondition);		

					}

					if(numAttr2 == 2)
					{
						Scanner input = new Scanner(System.in);
						System.out.print("Input the value for attribute condition: \n");
						String deleteCondition = input.nextLine();

						delTuple (conn, "FinancialPackage", "TotalAwardAmount", deleteCondition);		

					}

				}
				printMenu();

			}

			if(num == 6)  //QUIT
			{
				System.out.println("");
				if (conn != null)
				{
					try
					{
						conn.close ();
						System.out.println ("Database connection terminated");
					}
					catch (Exception e) { /* ignore close errors */ }

					System.out.println("BYE!");
					break;

				}
			}



		}
	}
}
