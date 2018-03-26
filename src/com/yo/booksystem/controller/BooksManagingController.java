package com.yo.booksystem.controller;

import com.yo.booksystem.entity.BookEntity;
import com.yo.booksystem.model.Bookcategory;
import com.yo.booksystem.model.Publisher;
import com.yo.booksystem.service.BookManagingService;
import com.yo.booksystem.service.CategoryService;
import com.yo.booksystem.service.PublisherService;
import com.yo.booksystem.service.serviceImpl.BookManagingServiceImpl;
import com.yo.booksystem.service.serviceImpl.CategoryServiceImpl;
import com.yo.booksystem.service.serviceImpl.PublisherServiceImpl;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

/**
 * Created by Yoy on 2017/5/26.
 */
public class BooksManagingController {
    private Stage picStage = new Stage();
    private CategoryService categoryService = new CategoryServiceImpl();
    private PublisherService publisherService = new PublisherServiceImpl();
    private BookManagingService bookManagingService = new BookManagingServiceImpl();
    private String imgPath;
    @FXML
    private TextField searchName;
    @FXML
    private TextField bookname;
    @FXML
    private TextField price;
    @FXML
    private ComboBox<String> bookcategoryCom;
    @FXML
    private TextField author;
    @FXML
    private ComboBox<String> publisherCom;
    @FXML
    private ImageView img;
    @FXML
    private TextArea description;
    @FXML
    private TableView<BookEntity> BookEntityTableView;
    @FXML
    private TableColumn<BookEntity,String> booknameColumn;
    @FXML
    private TableColumn<BookEntity,String> priceColum;
    @FXML
    private TableColumn<BookEntity,String> remainColum;
    @FXML
    private TableColumn<BookEntity,String> authorColum;
    @FXML
    private TableColumn<BookEntity,String> publisherColumn;
    @FXML
    private TableColumn<BookEntity,String> descriptionColum;
    @FXML
    private TableColumn<BookEntity,String> bookcategoryColum;

    @FXML
    private void saveBook(){
        if (isInputValid()){
            bookManagingService.saveBook(bookname.getText(),price.getText(),author.getText(),bookcategoryCom.getSelectionModel().getSelectedItem().toString(),publisherCom.getSelectionModel().getSelectedItem().toString(),imgPath,description.getText());
        }
        this.setBookTableData(this.getAllBookEntities());
        this.clear();
    }

    private boolean isInputValid(){
        return true;
    }

    @FXML
    public void searchBooks(){
        this.setBookTableData(bookManagingService.searchPublishers(searchName.getText()));
    }

    @FXML
    private void selectPicture(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPEG","*.jpg"),new FileChooser.ExtensionFilter("PNG","*.png"));
        // Show save file dialog
        File file = fileChooser.showOpenDialog(picStage);

        imgPath = file.getPath();
//        System.out.println(file.getAbsolutePath());
//        img.setImage(new Image(file.getAbsolutePath()));
//        img.setImage(Image.impl_fromPlatformImage(file));
        img.setImage(new Image("file:"+imgPath));
    }

    private void showBookDetails(BookEntity book) {
        if (book != null) {
            // Fill the labels with info from the person object.
            bookname.setText(book.getBookname());
            price.setText(String.valueOf(book.getPrice()));
            author.setText(book.getAuthor());
            description.setText(book.getDescription());
            img.setImage(new Image("file:"+book.getImg()));
        } else {
            // Book is null, remove all the text.
           clear();
        }
    }

    @FXML
    private void initialize() {
            // Initialize the person table with the two columns.
        booknameColumn.setCellValueFactory(cellData -> cellData.getValue().booknameProperty());
        priceColum.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().priceProperty().getValue().toString()));
        remainColum.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().remainProperty().getValue().toString()));
        descriptionColum.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
        authorColum.setCellValueFactory(cellData -> cellData.getValue().authorProperty());
        bookcategoryColum.setCellValueFactory(cellData -> cellData.getValue().bookcategoryProperty());
        publisherColumn.setCellValueFactory(cellData -> cellData.getValue().publisherProperty());
        List<Bookcategory> bookcategories = categoryService.selectAllCategory();
        List<Publisher> publishers = publisherService.selectAllPublishers();
        for (Bookcategory bookcategory:bookcategories) {
            bookcategoryCom.getItems().add(bookcategory.getCategoryname());
        }

        for (Publisher publisher: publishers) {
            publisherCom.getItems().add(publisher.getPubname());
        }

        // Clear book details.
        showBookDetails(null);

        // Listen for selection changes and show the book details when changed.
        BookEntityTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showBookDetails(newValue));
    }

    @FXML
    private void clear(){
        bookname.setText(null);
        price.setText(null);
        author.setText(null);
        description.setText(null);
        img.setImage(null);
    }

    public void setBookTableData(ObservableList<BookEntity> bookEntities){
        BookEntityTableView.setItems(bookEntities);
    }

    public ObservableList<BookEntity> getAllBookEntities() {
        return bookManagingService.getBooksTableData(bookManagingService.selectAllBooks());
    }
}
