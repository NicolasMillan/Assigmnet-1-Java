package com.example.assignmentone;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Motorcycle-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("MotorcycleStats");
        stage.getIcons().add(new Image("file:target/classes/com/example/assignmentone/Motorcycle_Favicon.jpg"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        launch();
//        Motorcycle newMotorcycle123 = new Motorcycle(1,"Yamaha",150,150,150,2400);
//        System.out.println(DBUtility.insertMotorcyclesIntoDB(newMotorcycle123));
    }
}