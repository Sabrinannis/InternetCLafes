package view;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginPageUser {

	GridPane gp;
	BorderPane bp;
	VBox vb;
	Label login_lb, username_lb, password_lb;
	TextField username_fl;
	PasswordField password_pf;
	Button login_btn;
	
	Stage stage;
	Scene scene;;
	MenuBar menuBar;
	Menu menu;
	MenuItem menuToRegister;
	
	private void initializeMenu() {
		menuBar = new MenuBar();
		menu = new Menu("Get In Method");
		menuToRegister = new MenuItem("Register");
		menuBar.getMenus().add(menu);
		menu.getItems().add(menuToRegister);
	}

	public void initialize() {
		bp = new BorderPane();
		vb = new VBox();
		gp = new GridPane();
		login_lb = new Label("Login");
		username_lb = new Label("Username");
		username_fl = new TextField();
		password_lb = new Label("Password");
		password_pf = new PasswordField();
		login_btn = new Button("Login");
		
		initializeMenu();
		gp.add(login_lb, 0, 1);
		gp.add(username_lb, 0, 2);
		gp.add(username_fl, 1, 2);
		gp.add(password_lb, 0, 3);
		gp.add(password_pf, 1, 3);
		gp.add(login_btn, 0, 4);
		
		gp.setVgap(8);
		gp.setAlignment(Pos.BASELINE_LEFT);
		
		bp.setTop(menuBar);
		bp.setCenter(gp);;
		scene = new Scene(bp ,900, 500);
		
		GridPane.setHalignment(login_btn, HPos.CENTER);
		GridPane.setHalignment(login_lb, HPos.CENTER);
		GridPane.setColumnSpan(login_btn, 2);
		GridPane.setColumnSpan(login_lb, 2);
		login_lb.setFont(Font.font(36));
		gp.setAlignment(Pos.CENTER);
		gp.setVgap(30);
		gp.setHgap(30);
		username_fl.setFocusTraversable(false);
		password_pf.setFocusTraversable(false);
	}

	
	public void setAction() {
		login_btn.setOnMouseClicked(event -> {
			if (this.username_fl.getText().equals("bypass"))
//				StageManager.getInstance().setScene(new HomeView().getScene());
			System.out.println("User login, and redirect user");
		});
		
		menuToRegister.setOnAction(e->{
			try {
				new RegisterPageUser().start(stage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	
	public LoginPageUser(Stage stage) {
		initialize();
		setAction();
		this.stage = stage;
		this.stage.setResizable(false);
		this.stage.setScene(scene);
		this.stage.show();
	}
}