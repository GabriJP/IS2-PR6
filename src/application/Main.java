package application;

import model.Histogram;
import model.HistogramBuilder;
import model.Person;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Gabriel on 27/10/2015.
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");

        List<Person> people = new SQLiteDomainReader().getPeople();

        HistogramBuilder<Person> builder = new HistogramBuilder<>(people);
        Histogram<String> domains = builder.build(person -> person.getMail().split("@")[1]);
        Histogram<String> genero = builder.build(Person::getGenero);
        Histogram<Float> peso = builder.build(Person::getPeso);

        new HistogramDisplay<>(domains, "Domains").setVisible(true);
        new HistogramDisplay<>(genero, "Género").setVisible(true);
        new HistogramDisplay<>(peso, "Peso").setVisible(true);

    }
}
