module internetCLafes {
	requires javafx.graphics;
	requires javafx.controls;
	requires java.sql;

	opens view;
	opens database;
	opens model;
}