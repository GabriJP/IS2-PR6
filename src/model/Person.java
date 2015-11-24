package model;

/**
 * Created by Gabriel on 24/11/2015.
 */
public class Person {
    private final Integer id;
    private final String mail;
    private final String genero;
    private final float peso;

    public Person(Integer id, String email, String genero, float peso) {
        this.id = id;
        this.mail = email;
        this.genero = genero;
        this.peso = peso;
    }

    public Integer getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public String getGenero() {
        return genero;
    }

    public float getPeso() {
        return peso;
    }
}
