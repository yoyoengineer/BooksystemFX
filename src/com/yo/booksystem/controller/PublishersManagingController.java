package com.yo.booksystem.controller;

import com.yo.booksystem.entity.PublisherEntity;
import com.yo.booksystem.service.PublisherService;
import com.yo.booksystem.service.serviceImpl.PublisherServiceImpl;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Created by Yoy on 2017/5/26.
 */
public class PublishersManagingController {
    @FXML
    private TextField pubname;
    @FXML
    private TextField pubconnector;
    @FXML
    private TextField phonenum;
    @FXML
    private TextArea description;
    @FXML
    private TableView<PublisherEntity> publisherEntityTableView;
    @FXML
    private TableColumn<PublisherEntity,String> pubnameColumn;
    @FXML
    private TableColumn<PublisherEntity,String> pubconnectorColum;
    @FXML
    private TableColumn<PublisherEntity,String> phonenumColum;
    @FXML
    private TableColumn<PublisherEntity,String> descriptionColum;
    @FXML
    private TextField searchName;

    private PublisherService publisherService = new PublisherServiceImpl();
    @FXML
    private void savePublisher(){
        if (isInputValid()){
            publisherService.savePublisher(pubname.getText(),pubconnector.getText(),phonenum.getText(),description.getText());
        }
        this.setPublisherTableData(this.getAllPublisherEntities());
        this.clear();
    }

    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        pubnameColumn.setCellValueFactory(cellData -> cellData.getValue().pubnameProperty());
        pubconnectorColum.setCellValueFactory(cellData -> cellData.getValue().pubconnectorProperty());
        phonenumColum.setCellValueFactory(cellData -> cellData.getValue().phonenumProperty());
        descriptionColum.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
    }

    @FXML
    private void clear(){
        pubname.setText(null);
        pubconnector.setText(null);
        phonenum.setText(null);
        description.setText(null);
    }

    @FXML
    public void searchPublishers(){
        this.setPublisherTableData(publisherService.searchPublishers(searchName.getText()));
    }

    private boolean isInputValid(){
        return true;
    }

    public void setPublisherTableData(ObservableList<PublisherEntity> publisherEntities){
        publisherEntityTableView.setItems(publisherEntities);
    }

    public ObservableList<PublisherEntity> getAllPublisherEntities() {
        return publisherService.getPublisherTableData(publisherService.selectAllPublishers());
    }

}
