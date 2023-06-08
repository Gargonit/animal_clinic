package Veterinary_Clinic;

import java.sql.*;
import java.util.ArrayList;
public class AnimalDB {
    private static String url="jdbc:mysql://localhost:3306/animals";
    private static String username="root";
    private static String password="54535251x";

    public static ArrayList<Animal> select() {

        ArrayList<Animal> animals=new ArrayList<Animal> ( );
        try {
            Class.forName ( "com.mysql.cj.jdbc.Driver" ).getDeclaredConstructor ( ).newInstance ( );
            try (Connection conn=DriverManager.getConnection ( url, username, password )) {

                Statement statement=conn.createStatement ( );
                ResultSet resultSet=statement.executeQuery ( "SELECT * FROM animals" );
                while (resultSet.next ( )) {

                    int id=resultSet.getInt ( 1 );
                    String name=resultSet.getString ( 2 );
                    String type=resultSet.getString ( 3 );
                    int age=resultSet.getInt ( 4 );
                    String owner=resultSet.getString ( 5 );
                    Animal animal=new Animal ( id, name, type, age, owner );
                    animals.add ( animal );
                }
            }
        } catch (Exception ex) {
            System.out.println ( ex );
        }
        return animals;
    }

    public static Animal selectOne(int id) {

        Animal animal=null;
        try {
            Class.forName ( "com.mysql.cj.jdbc.Driver" ).getDeclaredConstructor ( ).newInstance ( );
            try (Connection conn=DriverManager.getConnection ( url, username, password )) {
                String sql="SELECT * FROM animals WHERE id = ?";
                try (PreparedStatement preparedStatement=conn.prepareStatement ( sql )) {
                    preparedStatement.setInt ( 1, id );
                    ResultSet resultSet=preparedStatement.executeQuery ( );
                    if (resultSet.next ( )) {

                        int animalId=resultSet.getInt ( 1 );
                        String name=resultSet.getString ( 2 );
                        String type=resultSet.getString ( 3 );
                        int age=resultSet.getInt ( 4 );
                        String owner=resultSet.getString ( 5 );
                        animal=new Animal ( animalId, name, type, age, owner );
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println ( ex );
        }
        return animal;
    }

    public static int insert (Animal animal) {
        try {
            Class.forName ( "com.mysql.cj.jdbc.Driver" ).getDeclaredConstructor ( ).newInstance ( );
            try (Connection conn=DriverManager.getConnection ( url, username, password )) {
                String sql="INSERT INTO animals (name, type, age, owner) VALUES (?, ?, ?, ?)";

                try (PreparedStatement preparedStatement=conn.prepareStatement ( sql )) {
                    preparedStatement.setString ( 1, animal.getName ( ) );
                    preparedStatement.setString ( 2, animal.getType ( ) );
                    preparedStatement.setInt ( 3, animal.getAge ( ) );
                    preparedStatement.setString ( 4, animal.getOwner ( ) );

                    return preparedStatement.executeUpdate ( );
                }
            }
        } catch (Exception ex) {
            System.out.println ( ex );
        }
        return 0;
    }

    public static int update(Animal animal) {

        try {
            Class.forName ( "com.mysql.cj.jdbc.Driver" ).getDeclaredConstructor ( ).newInstance ( );
            try (Connection conn=DriverManager.getConnection ( url, username, password )) {

                String sql = "UPDATE animals SET name = ?, type = ?, age = ?, owner = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement ( sql )) {
                    preparedStatement.setString (1,animal.getName ());
                    preparedStatement.setString ( 2,animal.getType ());
                    preparedStatement.setInt ( 3,animal.getAge ());
                    preparedStatement.setString ( 4,animal.getOwner ());
                    preparedStatement.setInt ( 5,animal.getId ());

                    return  preparedStatement.executeUpdate ();
                }
            }
        }
        catch (Exception ex) {
            System.out.println ( ex );
        }
        return 0;
    }

    public static int delete(int id)  {
        try {
            Class.forName ( "com.mysql.cj.jdbc.Driver" ).getDeclaredConstructor ( ).newInstance ( );
            try (Connection conn=DriverManager.getConnection ( url, username, password )) {

                String sql = "DELETE FROM animals WHERE id = ?";
                try (PreparedStatement preparedStatement = conn.prepareStatement ( sql )) {
                    preparedStatement.setInt ( 1, id );

                    return preparedStatement.executeUpdate ();
                }
            }
        }
        catch (Exception ex) {
            System.out.println ( ex );
        }
        return 0;
    }
}

    //Здесь мы заменили объект Product на Animal, чтобы отразить, что это ветеринарная клиника,
// а не зоомагазин. Мы также изменили названия таблицы и полей в соответствии с новыми требованиями.