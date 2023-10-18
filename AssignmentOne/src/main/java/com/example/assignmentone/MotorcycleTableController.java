package com.example.assignmentone;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class MotorcycleTableController implements Initializable {

    @FXML
    private TableColumn<Motorcycle, String> brandColumn;

    @FXML
    private Button buttonAddStats;

    @FXML
    private TableColumn<Motorcycle, Integer> ccColumn;

    @FXML
    private TableColumn<Motorcycle, Integer> hpColumn;

    @FXML
    private TableColumn<Motorcycle, Integer> modelIdColumn;

    @FXML
    private TableColumn<Motorcycle, Double> priceColumn;

    @FXML
    private TableColumn<Motorcycle, Integer> topSpeedColumn;

    @FXML
    private TableView<Motorcycle> tableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        System.out.println(DBUtility.getMotorcyclesFromDB());
        ArrayList<Motorcycle> motorcycles = DBUtility.getMotorcyclesFromDB();

        modelIdColumn.setCellValueFactory(new PropertyValueFactory<>("modelId"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
        ccColumn.setCellValueFactory(new PropertyValueFactory<>("cc"));
        hpColumn.setCellValueFactory(new PropertyValueFactory<>("hp"));
        topSpeedColumn.setCellValueFactory(new PropertyValueFactory<>("topSpeed"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));

        tableView.getItems().addAll(motorcycles);

    }
    @FXML
    void buttonViewGraph(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "Motorcycle-view.fxml", "Motorcycle Graphic");
    }
}