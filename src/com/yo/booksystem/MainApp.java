package com.yo.booksystem;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private AnchorPane LogInLayout;
//    private static MainApp mainApp = new MainApp();

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("BookSystem");
        this.primaryStage.getIcons().add(new Image("file:resources/images/bookshelf.png"));
        initLayout();
	}

//    private MainApp() {
//    }

//    public static MainApp getInstance(){
//	    return mainApp;
//    }

    /**
     * Initializes the root layout.
     */
    public void initLayout() {
        try {
            // Load layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LogInView.fxml"));
            LogInLayout = (AnchorPane) loader.load();

            // Show the scene containing LogInView layout.
            Scene scene = new Scene(LogInLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	/**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

	public static void main(String[] args) {
		launch(args);
	}
}
