package application;

import model.Person;
import persistance.PersonReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by usuario on 10/11/2015.
 */
public class SQLiteDomainReader implements PersonReader {

    private final Connection connection;

    public SQLiteDomainReader() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:KATA.sDB");
    }

    @Override
    public List<Person> getPeople() {
        try {
            List<Person> people = new LinkedList<>();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM PEOPLE");
            while (resultSet.next()) {
                people.add(new Person(resultSet.getInt(1), resultSet.getString(6), resultSet.getString(3), resultSet.getFloat(5)));
            }
            connection.close();
            return people;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
