

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

	public boolean EnterExit(int E) {//1-Enter , 2-Exit
		d = new Data();
		try {

			Statement stmt = Connect();
			System.out.println(
					"INSERT INTO Time VALUES (" + d.getID() + "," + d.getDate() + "," + d.getTime() + "," + E + ")");
			System.out.println("SELECT max(time),Movement FROM Time where date = "+d.getDate()+" and ID = "+d.getID());;
			rs = stmt.executeQuery("SELECT max(time),Movement FROM Time where date = "+d.getDate()+" and ID = "+d.getID());
			rs.next();
			if (rs.getInt("Movement") == E) {
			//rs = stmt.executeQuery("SELECT * FROM Time");
			/*int ONE=0,TWO=0;
			if(E==1) ONE++;
			else TWO++;*/
			/*while (rs.next())
				/*if ((rs.getInt("ID") == d.getID()) && (rs.getString("Date").equals(d.getDate()))
						&& (rs.getString("Time").equals(d.getTime())) && rs.getInt("MovementType") == E)*/
			//	if()
					stmt.close();
					return false;

			}
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


	public int AddNewUser(String Name,String Password, int manager, int permission , String Address, String Phone ,String  Birthday) {
		d = new Data();
	
		Birthday=createDate(Birthday);		
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
			return max;

		} catch (SQLException e) {
			// TODO Auto-generated
			e.printStackTrace();
		}
		System.out.println("X");
		return -1;
		}
	
	public boolean IsHaveUser(int ID){
		try {
			Statement stmt = Connect();
			rs=stmt.executeQuery("select id from Employee");
			while(rs.next()) {
				if(rs.getInt("ID")==ID)
					return true;
			
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	private String createDate(String date) {
		String day=date.substring(0, 2);
		String month= date.substring(2, 4);
		String year = date.substring(4, 8);
		date = year+""+month+""+day;
		return date;
	}


	public void createTimeForUser() {
		// TODO Auto-generated method stub
		try {
			d=new Data();
			Statement stmt = Connect();
			rs=stmt.executeQuery("select * from Time");
			while(rs.next()) {
				System.out.println(rs.getInt("ID")+","+rs.getString("Date")+","+rs.getString("Time")+","+rs.getInt("Movement"));
				if(rs.getInt("ID")==d.getID() && 
						rs.getString("Date").substring(0, 6).equalsIgnoreCase(d.getDate().substring(0, 6))) {
					d.addTime(rs.getInt("ID"),rs.getString("Date"),rs.getString("Time"),rs.getInt("Movement"));
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
