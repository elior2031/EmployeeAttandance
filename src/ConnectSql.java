

//import Login.*;
/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;*/

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.text.StyledEditorKit.BoldAction;

public class ConnectSql {

	private Data d;

	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;

	private Statement Connect() {

		try {
			Class.forName("org.sqlite.JDBC");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Open DB");

		try {
			connection = DriverManager.getConnection("jdbc:sqlite:newSql.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(30);

			return connection.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}


	public int connect() { // 1- false , 2 - no Active , 0 - true
		// TODO Auto-generated method stub
		d = new Data();
		try {
			Statement stmt = Connect();

			rs = stmt.executeQuery("SELECT ID, Password ,Permission  FROM Employee");
			while (rs.next()) {
				System.out.println((rs.getInt("ID") == d.getID()) && (d.getPass().equals(rs.getString("Password"))));
				System.out.println(
						(rs.getInt("ID") + "==" + d.getID()) + "&&" + (d.getPass() + " " + (rs.getString("Password"))));
				if ((rs.getInt("ID") == d.getID()) && (d.getPass().equals(rs.getString("Password")))) {

					int ret = rs.getInt("Permission");
					rs.close();
					stmt.close();
					return ret;

				}
			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return -1;
	}

	public boolean EnterExit(int E) {
		d = new Data();
		try {

			Statement stmt = Connect();
			System.out.println(
					"INSERT INTO Time VALUES (" + d.getID() + "," + d.getDate() + "," + d.getTime() + "," + E + ")");
			rs = stmt.executeQuery("SELECT * FROM Time");
			while (rs.next())
				if ((rs.getInt("ID") == d.getID()) && (rs.getString("Date").equals(d.getDate()))
						&& (rs.getString("Time").equals(d.getTime())) && rs.getInt("MovementType") == E)
					return false;


			stmt.executeUpdate(
					"INSERT INTO Time VALUES (" + d.getID() + "," + d.getDate() + "," + d.getTime() + "," + E + ")");
			stmt.close();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated
			e.printStackTrace();
		}
		System.out.println("X");
		return false;
	}


	public boolean AddNewUser(String Name,String Password, int manager, int permission , String Address, String Phone ,String  Birthday) {
		d = new Data();
		try {
			Statement stmt = Connect();
			rs = stmt.executeQuery("SELECT max(id) FROM Employee");
			int max= rs.getInt(1)+1;
			System.out.println(
					"INSERT INTO Employee VALUES ("+max+" , \""+ Name + "\" , \"" + Password + "\" , " + manager + " , " 
			+permission+ " , \""+Address+"\" , \""+Phone+"\" , \""+Birthday+"\")");
			/*rs = stmt.executeQuery("SELECT * FROM Time");
			while (rs.next())
				if ((rs.getInt("ID") == d.getID()) && (rs.getString("Date").equals(d.getDate()))
						&& (rs.getString("Time").equals(d.getTime())) && rs.getInt("MovementType") == E)
					return false;*/


			stmt.executeUpdate(
					"INSERT INTO Employee VALUES ("+max+" , \""+ Name + "\" , \"" + Password + "\" , " + manager + " , " 
							+permission+ " , \""+Address+"\" , \""+Phone+"\" , \""+Birthday+"\")");
			stmt.close();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated
			e.printStackTrace();
		}
		System.out.println("X");
		return false;
		}
	

	
}
