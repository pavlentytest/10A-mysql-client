package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        /*
        File=>Project Structure=>Libriaries=>+=>From maven=> в строке поиска "mysql*"
        Выбираем=>mysql:mysql-connector-java:8.0.19
         */

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        // Строка подключения к базе данных
        // jdbc - java database connection
        // mysql - тип базы
        // user1 - название базы данных

        String url = "jdbc:mysql://195.19.44.146:3306/user1?serverTimezone=UTC";

        try {
            // подключение драйвера MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // создаем переменную connection
            connection = DriverManager.getConnection(url,"user1","user1");
            System.out.println("Connected...");
            // мы готоворим серверу, что готовы выполнить запрос
            statement = connection.createStatement();
            // результат SQL запроса
            resultSet = statement.executeQuery("SELECT * FROM Gorod");
            // до тех пор пока есть row (запись)
            while(resultSet.next()) {
                String column = resultSet.getString("strana");
                System.out.println("Column1: "+ column);
            }
        } catch (SQLException | ClassNotFoundException e) {
            // ловим исключение
            e.printStackTrace();
        }







    }
}
