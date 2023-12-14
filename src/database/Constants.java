package database;

public class Constants {
	public static int SCREEN_WIDTH = 800;
	public static int SCREEN_HEIGHT = 600;
	public static String USERNAME = "root";
	public static String PASSWORD = "";
	public static String HOST = "localhost";
	public static String PORT = "3306";
	public static String DATABASE = "clafes";
	public static String URL = String.format("jdbc:mysql://%s:%s/%s", HOST, PORT, DATABASE);
}
