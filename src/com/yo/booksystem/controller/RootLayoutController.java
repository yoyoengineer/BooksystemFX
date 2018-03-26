package com.yo.booksystem.controller;

import java.io.IOException;

import com.yo.booksystem.entity.BookinEntity;
import com.yo.booksystem.entity.BooksellingEntity;
import com.yo.booksystem.model.Bookselling;
import com.yo.booksystem.service.*;
import com.yo.booksystem.service.serviceImpl.*;
import com.yo.booksystem.view.BookStorageController;
import com.yo.booksystem.view.BooksellingController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class RootLayoutController {
	@FXML
	private BorderPane mainBox;

	private Stage primaryStage = null;
	private BorderPane rootLayout;
	private FXMLLoader loaderSub;
	private CategoryService categoryService = new CategoryServiceImpl();
	private PublisherService publisherService = new PublisherServiceImpl();
	private BookManagingService bookManagingService = new BookManagingServiceImpl();
	private BooksellingService booksellingService = new BooksellingServiceImpl();
	private BookinService bookinService = new BookinServiceImpl();
	@FXML
	public void showBookStorageView(){
		ObservableList<BookinEntity> bookinEntities = bookinService.getBookinsTableData(bookinService.selectAllBookin());
		showPage("BookStorage.fxml");
		BookStorageController bookStorageController = loaderSub.getController();
		bookStorageController.setBookinHisTableData(bookinEntities);
	}

	@FXML
	public void showBookSellingView(){
		ObservableList<BooksellingEntity> booksellingEntities = booksellingService.getBooksellingTableData(booksellingService.selectAllBooksellings());
		showPage("Bookselling.fxml");
		BooksellingController booksellingController = loaderSub.getController();
		booksellingController.setBooksellingHisTableData(booksellingEntities);
	}

	@FXML
	public void showCategoriesManagingView(){
		showPage("CategoriesManaging.fxml");
		CategoriesManagingController categoriesManagingController = loaderSub.getController();
		categoriesManagingController.setBookcategoryTableData(categoryService.getBookcategoryTableData(categoryService.selectAllCategory()));
	}

	@FXML
	public void showPublishersManagingView(){
		showPage("PublishersManaging.fxml");
		PublishersManagingController publishersManagingController = loaderSub.getController();
		publishersManagingController.setPublisherTableData(publisherService.getPublisherTableData(publisherService.selectAllPublishers()));
	}

	@FXML
	public void showBooksManagingView(){
		showPage("BooksManaging.fxml");
		BooksManagingController bookManagingController = loaderSub.getController();
		bookManagingController.setBookTableData(bookManagingService.getBooksTableData(bookManagingService.selectAllBooks()));
	}

	public void showPage(String page){
		try {
			initRootLayout();
			showView(page);
		} catch (Exception e) {
			e.printStackTrace();
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


			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Shows the Bookselling overview inside the root layout.
	 */
	private void showView(String view) {
		try {
			// Load person overview.
			loaderSub = new FXMLLoader();
			loaderSub.setLocation(super.getClass().getResource("/com/yo/booksystem/view/"+view));
			AnchorPane BooksellingOverview = (AnchorPane) loaderSub.load();

			// Set Bookselling overview into the center of root layout.
			rootLayout.setCenter(BooksellingOverview);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
