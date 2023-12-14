package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectDB {
	private static ConnectDB instance;

	public static ConnectDB getInstance() {
		if (instance == null)
			instance = new ConnectDB();
		return instance;
	}

	private Connection connection;

	private ConnectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Integer checkRow() {
		int ct = 0;
		ResultSet count;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) AS 'count' FROM userclafes");
			count = ps.executeQuery();
			if(count.next()){
				ct = count.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ct;
	}

	public <T> Vector<T> executePrepQuery(String query, StatementPreparer preparer, ResultSetParser<T> parser) {
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			preparer.prepare(ps);
			return parser.parse(ps.executeQuery());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Vector<T>();
	}

	public int executePrepUpdate(String query, StatementPreparer preparer) {
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			preparer.prepare(ps);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
