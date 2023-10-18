package com.example.assignmentone;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.CheckBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class MotorcycleController implements Initializable {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis categoryAxis;

    @FXML
    private NumberAxis numberAxis;

    @FXML
    private CheckBox topSpeedCheckBox;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button buttonViewTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Verify that the code is working
        barChart.getData().addAll(DBUtility.getCharDataFromDB());

        XYChart.Series<String, Integer> newData = new XYChart.Series<>();
        newData.setName("2023");
        newData.getData().add(new XYChart.Data<>("Yamaha1", 120));
        newData.getData().add(new XYChart.Data<>("Yamaha1", 120));
        newData.getData().add(new XYChart.Data<>("Yamaha1", 120));

        barChart.getData().addAll(newData);
    }

    @FXML
    void viewTable_onClick(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "Motorcycle-table-view.fxml", "Motorcycle Stats!");
    }
}