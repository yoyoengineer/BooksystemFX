package com.yo.booksystem.controller;

import com.yo.booksystem.entity.BookinEntity;
import com.yo.booksystem.model.Book;
import com.yo.booksystem.service.BookManagingService;
import com.yo.booksystem.service.BookinService;
import com.yo.booksystem.service.serviceImpl.BookManagingServiceImpl;
import com.yo.booksystem.service.serviceImpl.BookinServiceImpl;
import com.yo.booksystem.utils.DateUtil;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yoy on 2017/5/26.
 */
public class BookStorageController {
    private BookManagingService bookManagingService = new BookManagingServiceImpl();
    private BookinService bookinService = new BookinServiceImpl();
    private  Map<String, Integer>map = new HashMap<String,Integer>();
    @FXML
    private ComboBox<String> booksCom;
    @FXML
    private TextField bookNum;
    @FXML
    private TextField searchDate;
    @FXML
    private Label currentNum;
    @FXML
    private TableView<BookinEntity> bookinHistoryEntityTableView;
    @FXML
    private TableColumn<BookinEntity,String> booknameHisColumn;
    @FXML
    private TableColumn<BookinEntity,String> inNumHisColum;
    @FXML
    private TableColumn<BookinEntity,String> inDateHisColum;
    @FXML
    private TableView<BookinEntity> bookinEntityTableView;
    @FXML
    private TableColumn<BookinEntity,String> booknameColumn;
    @FXML
    private TableColumn<BookinEntity,String> priceColumn;
    @FXML
    private TableColumn<BookinEntity,String> NumColumn;
    @FXML
    private TextField inDate;
    @FXML
    private TextField totalNum;

    private ObservableList<BookinEntity> bookinEntities = FXCollections.observableArrayList();;
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        booknameHisColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBookname()));
        inNumHisColum.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getInnum())));
        inDateHisColum.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIndate().toString()));
        List<Book> books = bookManagingService.selectAllBooks();
//        System.out.println(books.size());
        for (Book book:books) {
            booksCom.getItems().add(book.getBookname());
        }
        this.clearBookinEntitis();
        // Listen for selection changes and show the book details when changed.
        bookinHistoryEntityTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showBookinDetails(newValue));
    }

    private void clearBookinEntitis(){
        bookinEntities.removeAll();
//        System.out.println("size:"+bookinEntities.size());
//        System.out.println(bookinEntities);
    }
    private void showBookinDetails(BookinEntity newValue) {
        this.clearBookinEntitis();
        if (newValue != null) {

            // Fill the labels with info from the person object.
//            booknameColumn.setText(newValue.getBookname());
//            NumColumn.setText(String.valueOf(newValue.getInnum()));
            inDate.setText(newValue.getIndate());
            Book book = bookManagingService.getBookByName(newValue.getBookname());
            newValue.setPrice(book.getPrice());
            bookinEntities.add(newValue);
            this.setBookinTableDataInfo(bookinEntities);
//            System.out.println(bookinEntities.size());
//            System.out.println(bookinEntities);
//            priceColumn.setText(String.valueOf(book.getPrice()));
            totalNum.setText(String.valueOf(book.getRemain()));
        } else {
            // Bookin is null, remove all the text.
            clearAll();
        }
        this.showBookins();
    }

    private void showBookins(){
        booknameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBookname()));
        NumColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getInnum())));
        priceColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPrice())));
    }

    @FXML
    private void add(){
        Date date = DateUtil.getTime();
        String bookName = booksCom.getSelectionModel().getSelectedItem().toString();
        Book book = bookManagingService.getBookByName(bookName);
        float price = book.getPrice();
        int inNum = Integer.parseInt(bookNum.getText());
        BookinEntity bookinEntity = new BookinEntity(inNum,bookName,date,price);
        bookinEntities.add(bookinEntity);
        this.setBookinTableData(bookinEntities);
        booknameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBookname()));
        NumColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getInnum())));
        priceColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPrice())));
        inDate.setText(date.toString());
        currentNum.setText(book.getRemain().toString());
        Integer totalNumvalue=0;
        for (BookinEntity bookinentity: bookinEntities) {
            if (bookinentity.getBookname().equals(bookName)){
                totalNumvalue += bookinentity.getInnum();
            }
        }
        map.put(bookName,totalNumvalue);
        totalNum.setText(totalNumvalue.toString());
        this.clear();
    }

    @FXML
    private void delete(){
        int index = bookinEntityTableView.getSelectionModel().getSelectedIndex();
        if (index>=0){
            bookinEntityTableView.getItems().remove(index);
        }
    }

    private boolean isInputValid(){
        return true;
    }

    @FXML
    private void clear(){
        bookNum.setText(null);
    }

    private void clearAll(){
        bookinEntityTableView.getItems().removeAll();
        currentNum.setText("0");
        inDate.setText(null);
        totalNum.setText(null);
    }

    @FXML
    private void inBook(){
        String bookName;
        int BookNum;
        for (Map.Entry<String,Integer> entry:map.entrySet()) {
            bookName = entry.getKey();
            BookNum = entry.getValue();
            bookinService.inBook(entry.getKey(),entry.getValue());
            int newBookNum = bookManagingService.getBookByName(entry.getKey()).getRemain() + BookNum;
            bookManagingService.updateBookRemain(bookName,newBookNum);
        }
//        this.initialize();
        this.setBookinHisTableData(this.getAllBookinEntities());
        this.clearAll();
        this.clearBookinEntitis();
    }

    public void setBookinHisTableData(ObservableList<BookinEntity> bookinEntities){
        bookinHistoryEntityTableView.setItems(bookinEntities);
    }

    public void setBookinTableDataInfo(ObservableList<BookinEntity> bookinEntities){
        for (int i =0; i<bookinEntityTableView.getItems().size();i++){
            bookinEntityTableView.getItems().remove(i);
        }
        bookinEntityTableView.getItems().removeAll();
        bookinEntityTableView.setItems(bookinEntities);
    }

    public void setBookinTableData(ObservableList<BookinEntity> bookinEntities){
        bookinEntityTableView.setItems(bookinEntities);
    }

    public ObservableList<BookinEntity> getAllBookinEntities() {
        return bookinService.getBookinsTableData(bookinService.selectAllBookin());
    }
}
