package com.yo.booksystem.controller;

import com.yo.booksystem.entity.BookcategoryEntity;
import com.yo.booksystem.model.Bookcategory;
import com.yo.booksystem.service.CategoryService;
import com.yo.booksystem.service.serviceImpl.CategoryServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Created by Yoy on 2017/5/24.
 */
public class CategoriesManagingController {
    @FXML
    private TextField categoryName;
    @FXML
    private TextArea categoryDescription;
    @FXML
    private TextField searchName;

    @FXML
    private TableView<BookcategoryEntity> bookcategoryTableView;
    @FXML
    private TableColumn<BookcategoryEntity,String> categoryNameColumn;
    @FXML
    private TableColumn<BookcategoryEntity,String> categoryDescriptionColumn;

    private ObservableList<BookcategoryEntity> bookcategoryEntities = FXCollections.observableArrayList();
    private CategoryService categoryService = new CategoryServiceImpl();

    @FXML
    public void saveCategory(){
        categoryService.saveCategory(categoryName.getText(),categoryDescription.getText());
        this.setBookcategoryTableData(this.getAllBookcategoryEntities());
        this.clear();
    }

    @FXML
    public void searchCategories(){
        this.clearBookcategoryItems();
        this.setBookcategoryTableData(categoryService.searchCategories(searchName.getText()));
    }

    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        categoryNameColumn.setCellValueFactory(cellData -> cellData.getValue().categorynameProperty());
        categoryDescriptionColumn.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
    }

    @FXML
    private void clear(){
        categoryName.setText(null);
        categoryDescription.setText(null);
    }

    public void setBookcategoryTableData(ObservableList<BookcategoryEntity> bookcategoryEntities){
        bookcategoryTableView.setItems(bookcategoryEntities);
    }

    private void clearBookcategoryItems(){
        bookcategoryTableView.setItems(null);
    }
    public ObservableList<BookcategoryEntity> getAllBookcategoryEntities() {
        return categoryService.getBookcategoryTableData(categoryService.selectAllCategory());
    }
}
