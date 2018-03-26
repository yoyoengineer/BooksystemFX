package com.yo.booksystem.controller;

import com.yo.booksystem.entity.BooksellingEntity;
import com.yo.booksystem.model.Book;
import com.yo.booksystem.service.BookManagingService;
import com.yo.booksystem.service.BookinService;
import com.yo.booksystem.service.BooksellingService;
import com.yo.booksystem.service.serviceImpl.BookManagingServiceImpl;
import com.yo.booksystem.service.serviceImpl.BookinServiceImpl;
import com.yo.booksystem.service.serviceImpl.BooksellingServiceImpl;
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
public class  BooksellingController {
    private BookManagingService bookManagingService = new BookManagingServiceImpl();
    private BooksellingService booksellingService = new BooksellingServiceImpl();
    private BookinService bookinService = new BookinServiceImpl();
    private  Map<String, Integer>map = new HashMap<String,Integer>();
    @FXML
    private TextField totalPrice;
    @FXML
    private ComboBox<String> booksCom;
    @FXML
    private TextField bookNum;
    @FXML
    private TextField searchDate;
    @FXML
    private Label currentNum;
    @FXML
    private Label price;
    @FXML
    private TableView<BooksellingEntity> boughtBooksEntityTableView;
    @FXML
    private TableColumn<BooksellingEntity,String> booknameBouColumn;
    @FXML
    private TableColumn<BooksellingEntity,String> totNumBouColum;
    @FXML
    private TableColumn<BooksellingEntity,String> dealDateHisColum;
    @FXML
    private TableColumn<BooksellingEntity,String> totPriceBouColum;
    @FXML
    private TableView<BooksellingEntity> bookbuyEntityTableView;
    @FXML
    private TableColumn<BooksellingEntity,String> booknameColumn;
    @FXML
    private TableColumn<BooksellingEntity,String> priceColumn;
    @FXML
    private TableColumn<BooksellingEntity,String> NumColumn;
    @FXML
    private TextField dealDate;
    @FXML
    private TextField totalNum;

    private ObservableList<BooksellingEntity> booksellingEntities = FXCollections.observableArrayList();;
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        booknameBouColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBookName()));
        totPriceBouColum.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPrice()*cellData.getValue().getAmount())));
        dealDateHisColum.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTradedate().toString()));
        totNumBouColum.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAmount())));
        List<Book> books = bookManagingService.selectAllBooks();
//        System.out.println(books.size());
        for (Book book:books) {
            booksCom.getItems().add(book.getBookname());
        }
        this.clearBookinEntitis();
        // Listen for selection changes and show the book details when changed.
        boughtBooksEntityTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showBookinDetails(newValue));
    }

    private void clearBookinEntitis(){
        booksellingEntities.removeAll();
//        System.out.println("size:"+bookinEntities.size());
//        System.out.println(bookinEntities);
    }
    private void showBookinDetails(BooksellingEntity newValue) {
        this.clearBookinEntitis();
        if (newValue != null) {

            // Fill the labels with info from the person object.
//            booknameColumn.setText(newValue.getBookname());
//            NumColumn.setText(String.valueOf(newValue.getInnum()));
            dealDate.setText(String.valueOf(newValue.getTradedate()));
            Book book = bookManagingService.getBookByName(newValue.getBookName());
            newValue.setPrice(book.getPrice());
            booksellingEntities.add(newValue);
            this.setBooksellingTableDataInfo(booksellingEntities);
//            System.out.println(bookinEntities.size());
//            System.out.println(bookinEntities);
//            priceColumn.setText(String.valueOf(book.getPrice()));
            totalNum.setText(String.valueOf(book.getRemain()));
        } else {
            // Bookin is null, remove all the text.
            clearAll();
        }
        this.showBooksellings();
    }

    private void showBooksellings(){
        booknameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBookName()));
        NumColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAmount())));
        priceColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPrice())));
    }

    @FXML
    private void add(){
        Date date = DateUtil.getTime();
        String bookName = booksCom.getSelectionModel().getSelectedItem().toString();
        Book book = bookManagingService.getBookByName(bookName);
        float price = book.getPrice();
        int deaNum = Integer.parseInt(bookNum.getText());
        BooksellingEntity booksellingEntity = new BooksellingEntity(price,deaNum,date,book.getBookid(),bookName);
        booksellingEntities.add(booksellingEntity);
        this.setBooksellingTableData(booksellingEntities);
        totalPrice.setText(String.valueOf(deaNum*price));
        booknameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBookName()));
        NumColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAmount())));
        priceColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPrice())));
        dealDate.setText(date.toString());
        currentNum.setText(book.getRemain().toString());
        Integer totalNumvalue=0;
        for (BooksellingEntity booksellingEntity1: booksellingEntities) {
            if (booksellingEntity1.getBookName().equals(bookName)){
                totalNumvalue += booksellingEntity1.getAmount();
            }
        }
        map.put(bookName,totalNumvalue);
        totalNum.setText(totalNumvalue.toString());
        this.clear();
    }

    @FXML
    private void delete(){
        int index = bookbuyEntityTableView.getSelectionModel().getSelectedIndex();
        if (index>=0){
            bookbuyEntityTableView.getItems().remove(index);
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
        bookbuyEntityTableView.getItems().removeAll();
        currentNum.setText("0");
        dealDate.setText(null);
        totalNum.setText(null);
    }

    @FXML
    private void Done(){
        String bookName;
        int BookNum;
        for (Map.Entry<String,Integer> entry:map.entrySet()) {
            bookName = entry.getKey();
            BookNum = entry.getValue();
            booksellingService.dealDone(bookName,BookNum);
        }
//        this.initialize();
        this.setBooksellingHisTableData(this.getAllBookinEntities());
        this.clearAll();
        this.clearBookinEntitis();
    }

    public void setBooksellingHisTableData(ObservableList<BooksellingEntity> booksellingEntities){
        boughtBooksEntityTableView.setItems(booksellingEntities);
    }

    public void setBooksellingTableDataInfo(ObservableList<BooksellingEntity> bookinEntities){
        for (int i =0; i<bookbuyEntityTableView.getItems().size();i++){
            bookbuyEntityTableView.getItems().remove(i);
        }
        bookbuyEntityTableView.getItems().removeAll();
        bookbuyEntityTableView.setItems(bookinEntities);
    }

    public void setBooksellingTableData(ObservableList<BooksellingEntity> bookinEntities){
        bookbuyEntityTableView.setItems(bookinEntities);
    }

    public ObservableList<BooksellingEntity> getAllBookinEntities() {
        return booksellingService.getBooksellingTableData(booksellingService.selectAllBooksellings());
    }
}
