package application;

import model.Histogram;
import model.HistogramBuilder;
import model.Person;
import persistance.PersonReader;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Gabriel on 27/10/2015.
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");

        PersonReader personReader = new SQLiteDomainReader();
        List<Person> people = personReader.getPeople();

        HistogramBuilder<Person> builder = new HistogramBuilder<>(people);
        Histogram<String> domains = builder.build(person -> person.getMail().split("@")[1]);
        Histogram<String> genero = builder.build(Person::getGenero);
        Histogram<Float> peso = builder.build(Person::getPeso);

        new HistogramDisplay<>(domains).setVisible(true);
        new HistogramDisplay<>(genero).setVisible(true);
        new HistogramDisplay<>(peso).setVisible(true);

    }
}
