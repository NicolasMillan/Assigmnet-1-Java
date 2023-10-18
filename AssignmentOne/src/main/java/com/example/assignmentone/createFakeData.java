package com.example.assignmentone;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Formatter;

public class createFakeData {
    // create insert statements for random data
    public static void createSQL(){
        SecureRandom secureRandom = new SecureRandom();
        String[] Brands = {"Harley-Davidson","Honda","Yamaha","Kawasaki","Suzuki","Ducati","KTM"};

        try(
                Formatter formatter = new Formatter("motorcycleStats.sql");
        ){
            // create a loop to get random 500 data
            for (int i = 0; i < 500; i++) {
                // Example - INSERT INTO sales(book_id, date_sold) VALUES (1, '2023-10-03');

                int randomIndex = secureRandom.nextInt(7); // Generates 0, 1, or 2
                String randomName = Brands[randomIndex];
                int hp = secureRandom.nextInt(145, 250);
                int cc = secureRandom.nextInt(600,1400);
                int topSpeed = secureRandom.nextInt(145,300);
                int price = secureRandom.nextInt(5000,30000);

//              LocalDate topSpeed = LocalDate.now().minusDays(secureRandom.nextInt(365));
                formatter.format("INSERT INTO motorcycleStats(brand, cc, hp, topSpeed, price) VALUES (%s, '%d', '%d', '%d', '%d');\n",randomName,cc,hp,topSpeed,price);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        createSQL();
//    }

}
