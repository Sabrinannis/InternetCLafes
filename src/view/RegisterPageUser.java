package view;

import controller.UserController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class RegisterPageUser extends Application {
		
	//initialize all of requirement
	Stage stage;
	Scene scene;
	BorderPane bpane;
	GridPane gpane;
	FlowPane fpane;
	VBox vbox;
	Hyperlink hplink;
	MenuBar menuBar;
	Menu menu;
	MenuItem menuToLogin;
	
	Label TitleForm, h2lb, lb_UserName, lb_Password, lb_ConfirmPass, lb_UserAge, lb_UserRole;
	TextField tf_UserName;
	PasswordField pf_Password, pf_ConfirmPass;
	Spinner<Integer> sp_UserAge;
	ComboBox<String> cb_UserRole;
	Button btn_submit;
	
	private void initializeMenu() {
		menuBar = new MenuBar();
		menu = new Menu("Get In Method");
		menuToLogin = new MenuItem("Login");
		menuBar.getMenus().add(menu);
		menu.getItems().add(menuToLogin);
	}
	
	private void initialize() {
		bpane = new BorderPane();
		vbox = new VBox();
		gpane = new GridPane();
		
		TitleForm = new Label("REGISTER PAGE");
		h2lb = new Label("Start your account here!");
		
		//Username Input
		lb_UserName = new Label("Username: ");
		tf_UserName = new TextField();
		
		//Password input
		lb_Password = new Label("Password: ");
		pf_Password = new PasswordField();
		
		//confirm pass
		lb_ConfirmPass = new Label("Confirm Password: ");
		pf_ConfirmPass = new PasswordField();
		
		//age spinner
		lb_UserAge = new Label("Age: ");
		sp_UserAge = new Spinner<>(13, 65, 13);
		
		//choose role
		lb_UserRole = new Label("Role: ");
		cb_UserRole = new ComboBox<>();
		cb_UserRole.getItems().addAll("Admin", "Customer", "Operator", "Computer Technician");
		
		btn_submit = new Button("Register");
		
		initializeMenu();
		//init menu at here
		vbox.getChildren().add(TitleForm);
		vbox.getChildren().add(h2lb);
		vbox.setAlignment(Pos.BASELINE_LEFT);
		
		gpane.add(vbox, 0, 0);
		gpane.add(lb_UserName, 0, 1);
		gpane.add(tf_UserName, 1, 1);
		
		gpane.add(lb_Password, 0, 2);
		gpane.add(pf_Password, 1, 2);
		
		gpane.add(lb_ConfirmPass, 0, 3);
		gpane.add(pf_ConfirmPass, 1, 3);
		
		gpane.add(lb_UserAge, 0, 4);
		gpane.add(sp_UserAge, 1, 4);
		
		gpane.add(lb_UserRole, 0, 5);
		gpane.add(cb_UserRole, 1, 5);
		
		gpane.add(btn_submit, 0, 6);
		
		gpane.setVgap(12);
		
		gpane.setAlignment(Pos.BASELINE_LEFT);
		
		bpane.setTop(menuBar);
		bpane.setCenter(gpane);
		scene = new Scene(bpane,900, 500);
		System.out.println("Berhasil sini");
		
	}
	
	
	public void handling() {
		Alert a = new Alert(AlertType.NONE);
		
		btn_submit.setOnAction(e->{
			String message = UserController.registerUser(
					tf_UserName.getText(), pf_Password.getText(), 
					pf_ConfirmPass.getText(), sp_UserAge.getValue(),
					cb_UserRole.getSelectionModel().getSelectedItem()
				);
			if(message.equals("Success")) {
				new LoginPageUser(stage);		
			}else {
				a.setAlertType(AlertType.ERROR);
				a.setContentText("Registration Error");
				a.show();	
			}
		});
		
		menuToLogin.setOnAction(e->{
			try {
		        new LoginPageUser(stage);
		        stage.show();  // Make the stage visible
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		});
	}
	
	private void setStyle() {
		TitleForm.setStyle("-fx-font-weight: bold;" + "-fx-font-family: Serif;" + "-fx-font-size: 36px;");
		h2lb.setStyle("-fx-font-family: Serif;" + "-fx-font-size: 20px;" + "-fx-text-fill:grey;");
		btn_submit.setStyle("-fx-background-color: red;" + "-fx-text-fill: white;" + "-fx-width: 350px;" + "-fx-font-weight: bold;");
	}
	
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		initialize();
		setStyle();
		handling();
		this.stage = stage;
		this.stage.setScene(scene);
		this.stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
