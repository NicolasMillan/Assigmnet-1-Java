package com.example.assignmentone;

import javafx.scene.chart.XYChart;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class DBUtility {

        // variables for username, password and connection url
        private static String user = "Becerra200533728";
        private static String pass = "sEXWhk6Xb6";
        private static String connectURL = "jdbc:mysql://172.31.22.43/" + user;

        // static method to insert data to db
        public static int insertMotorcyclesIntoDB(Motorcycle motorcycle) throws SQLException {
            int modelId = -1;
            ResultSet resultSet = null;

            // store the sql statement to insert data
            String sql = "INSERT INTO motorcycleStats(brand, cc, hp, topSpeed, price) VALUES (?, ?, ?, ?, ?);";

            // try with resource block
            // anything inside the () will be automatically closed if the exception occurs or not
            try(
                    Connection conn = DriverManager.getConnection(connectURL, user, pass);
                    PreparedStatement preparedStatement = conn.prepareStatement(sql, new String[]{"modelId"});
            )
            {
                // run prepared statement and attach data instead of ?
                preparedStatement.setString(1,motorcycle.getBrand());
                preparedStatement.setInt(2,motorcycle.getCc());
                preparedStatement.setInt(3,motorcycle.getHp());
                preparedStatement.setInt(4,motorcycle.getTopSpeed());
                preparedStatement.setDouble(5,motorcycle.getPrice());
                // execute the query
                preparedStatement.executeUpdate();

                // add result set
                resultSet = preparedStatement.getGeneratedKeys();

                while (resultSet.next()){
                    modelId = resultSet.getInt(1);
                }

            } catch (Exception e){
                e.printStackTrace();
            } finally {
                if(resultSet != null){
                    resultSet.close();
                }
            }

            return modelId;
        }
        public static ArrayList<Motorcycle> getMotorcyclesFromDB(){
            ArrayList<Motorcycle> motorcycles = new ArrayList<>();

            String sql = "SELECT motorcycleStats.brand, motorcycleStats.cc, motorcycleStats.hp, motorcycleStats.topSpeed, motorcycleStats.Price, motorcycleStats.modelId\n" +
                    "FROM motorcycleStats;";
            try (
                    Connection conn = DriverManager.getConnection(connectURL, user, pass);
                    Statement statement = conn.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql);
                    ){

                while (resultSet.next()){
                    int modelId = resultSet.getInt("modelId");
                    String brand = resultSet.getString("brand");
                    int cc = resultSet.getInt("cc");
                    int hp = resultSet.getInt("hp");
                    int topSpeed = resultSet.getInt("topSpeed");
                    double price = resultSet.getDouble("price");

                    Motorcycle newmotorcycle = new Motorcycle(modelId,brand,cc,hp,topSpeed,price);
                    motorcycles.add(newmotorcycle);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            return motorcycles;
        }

    public static XYChart.Series<String, Integer> getCharDataFromDB() {
        XYChart.Series<String, Integer> charData = new XYChart.Series<>();
        charData.setName("2019");
        ArrayList<Motorcycle> motorcycles = getMotorcyclesFromDB();

//        charData.getData().add(new XYChart.Data<>("Yamaha1", 120));
//        charData.getData().add(new XYChart.Data<>("Harley-Davidson", 140));
//        charData.getData().add(new XYChart.Data<>("Ducati", 220));

        //Use a for loop and add data to variable chartData
        for (Motorcycle motorcycle:motorcycles){
            charData.getData().add(new XYChart.Data<>(motorcycle.getBrand(),motorcycle.getTopSpeed()));
        }


        return charData;
    }
}
