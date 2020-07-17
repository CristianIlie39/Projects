import java.sql.*;

public class DatabaseConnection {

    private Connection databaseConnection;
    private PreparedStatement statement;

    public DatabaseConnection() {
        try {
            this.databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dealer?serverTimezone=UTC", "root", "123456789+");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //facem toate metodele de CRUD
    //metoda de Insert
    public void insertCar(Car carToInsert) {
        String insertCarQuery = "insert into cars(brand, model, year, color, fuel_type) values(?, ?, ?, ?, ?)"; //nu am trecut id-ul pt ca se autoincrementeaza
        try {
            statement = databaseConnection.prepareStatement(insertCarQuery);
            statement.setString(1, carToInsert.getBrand());
            statement.setString(2, carToInsert.getModel());
            statement.setString(3, carToInsert.getYear());
            statement.setString(4, carToInsert.getColor());
            statement.setString(5, carToInsert.getFuel_type());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted == 1) {
                System.out.println("Masina a fost introdusa cu succes in baza de date");
            } else {
                System.out.println("Masina nu a fost introdusa");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //metoda de Update
    public void updateCar(Car carToUpdate) {
        String updateCarQuery = "UPDATE cars SET color = ? where brand = ? and model = ?";
        try {
            statement = databaseConnection.prepareStatement(updateCarQuery);
            statement.setString(1, carToUpdate.getColor());
            statement.setString(2, carToUpdate.getBrand());
            statement.setString(3, carToUpdate.getModel());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 1) {
                System.out.println("Masina a fost updatata cu succes in baza de date");
            } else {
                System.out.println("Masina nu a fost updatata");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //metoda de Delete
    public void deleteCar(Car carToDelete) {
        String deleteCarQuery = "delete from cars where brand = ? and model = ? and year = ?";
        try {
            statement = databaseConnection.prepareStatement(deleteCarQuery);
            statement.setString(1, carToDelete.getBrand());
            statement.setString(2, carToDelete.getModel());
            statement.setString(3, carToDelete.getYear());
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted == 1) {
                System.out.println("Masina a fost stearsa cu succes din baza de date");
            } else {
                System.out.println("Masina nu a fost stearsa din baza de date");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //metoda de cautare/afisare
    public void selectCar(Car carToSelect) {
        String selectCarQuery = "select * from cars where brand = ? and model = ? and year = ?";
        try {
            statement = databaseConnection.prepareStatement(selectCarQuery);
            statement.setString(1, carToSelect.getBrand());
            statement.setString(2, carToSelect.getModel());
            statement.setString(3, carToSelect.getYear());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String color = resultSet.getString("color");
                String fuelType = resultSet.getString("fuel_type");
                System.out.println("Masinile cautate au culoarea: " + color + " si combustibilul " + fuelType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
