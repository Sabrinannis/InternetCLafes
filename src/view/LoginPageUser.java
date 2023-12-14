package view;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class LoginPageUser {

	private GridPane gp;
	private Label login_lb, username_lb, password_lb;
	private TextField username_fl;
	private PasswordField password_pf;
	private Button login_btn;

	public void initialize() {
		this.gp = new GridPane();
		this.login_lb = new Label("Login");
		this.username_lb = new Label("Username");
		this.username_fl = new TextField();
		this.password_lb = new Label("Password");
		this.password_pf = new PasswordField();
		this.login_btn = new Button("Login");
		
		this.gp.add(login_lb, 0, 0);
		this.gp.add(username_lb, 0, 1);
		this.gp.add(username_fl, 0, 2);
		this.gp.add(password_lb, 0, 3);
		this.gp.add(password_pf, 0, 4);
		this.gp.add(login_btn, 0, 5);
		Scene scene;
		scene = new Scene(gp,900, 400);
		
		GridPane.setHalignment(login_btn, HPos.CENTER);
		GridPane.setHalignment(login_lb, HPos.CENTER);
		GridPane.setColumnSpan(login_btn, 2);
		GridPane.setColumnSpan(login_lb, 2);
		this.login_lb.setFont(Font.font(36));
		this.gp.setAlignment(Pos.CENTER);
		this.gp.setVgap(30);
		this.gp.setHgap(30);
		this.username_fl.setFocusTraversable(false);
		this.password_pf.setFocusTraversable(false);
	}

	
	public void setAction() {
		this.login_btn.setOnMouseClicked(event -> {
			if (this.username_fl.getText().equals("bypass"))
//				StageManager.getInstance().setScene(new HomeView().getScene());
			System.out.println("User login, and redirect user to home");
		});
	}

}