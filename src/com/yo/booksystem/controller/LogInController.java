package com.yo.booksystem.controller;

import com.yo.booksystem.service.Check;
import com.yo.booksystem.service.serviceImpl.CheckImpl;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LogInController {
	@FXML
	private TextField account;
	@FXML
	private PasswordField password;
	@FXML
	private AnchorPane mainBox;

	private Check check = new CheckImpl();
	private BorderPane rootLayout;
	private boolean verifier = false;
	private Stage primaryStage = null;

	@FXML
	public void LOGIN_M(ActionEvent event) {
//		System.out.println(check);
		verifier = check.verify(account.getText(), password.getText());
		if (verifier) {
			try {
				initRootLayout();
				showBooksellingview();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {

			this.primaryStage = (Stage) mainBox.getScene().getWindow();
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(super.getClass().getResource("/com/yo/booksystem/view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			// stage.setScene(new
			// Scene(FXMLLoader.load(super.getClass().getResource("/com/yo/booksystem/view/Bookselling.fxml"))));
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Shows the Bookselling overview inside the root layout.
	 */
	private void showBooksellingview() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(super.getClass().getResource("/com/yo/booksystem/view/Bookselling.fxml"));
			AnchorPane BooksellingOverview = (AnchorPane) loader.load();

			// Set Bookselling overview into the center of root layout.
			rootLayout.setCenter(BooksellingOverview);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void CLEAR_M(ActionEvent event) {
		account.setText(null);
		password.setText(null);
	}

}
