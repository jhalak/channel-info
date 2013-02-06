package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class DbHandler {
	public static Connection getConnection() {
		Connection conn = null;
		try{
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:/opt/projects/workspace-jhalak/java/channel-info/src/db/database.db");
			return conn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
	public static Statement getQueryStatement() {
		Connection conn = null;
	    Statement statement = null;
	    try {
			conn = DbHandler.getConnection();
			statement = conn.createStatement();
	    }catch(Exception e) {
	    	JOptionPane.showMessageDialog(null, e);
	    }
	    return statement;
	}
	
	public static Object[][] getChennelList() {
	    List<Object[]> data = new ArrayList<Object[]>();
	    
		try {
			ResultSet resultSet = DbHandler.getQueryStatement().executeQuery("SELECT * FROM chennels");

			int numcols = resultSet.getMetaData().getColumnCount();
			while (resultSet.next()) {
				Object[] rowData = new Object[numcols];
				for (int i = 0; i < rowData.length; ++i) {
					rowData[i] = resultSet.getObject(i + 1);
				}
				data.add(rowData);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return data.toArray(new Object[0][0]);   
	}
}
