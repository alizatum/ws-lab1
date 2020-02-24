package lab1_ws_j2ee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQLDAO {
    Connection connection;

    public PostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from persons");

            while (rs.next()) {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");
                int phone = rs.getInt("phone");
                String gender = rs.getString("gender");

                Person person = new Person(name, surname, age, phone, gender);
                persons.add(person);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return persons;
    }

    public List<Person> getPersons(String name, String surname, Integer age, Integer phone, String gender ) {
        List<Person> persons = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select * from persons p " +
                            "where (" + getQuoted(name) + " is NULL or " + getQuoted(name) + " =p.name) AND " +
                            "(" + getQuoted(surname) + " is NULL or " + getQuoted(surname) + " =p.surname) AND " +
                            "(" + age + " is NULL or " + age + " =p.age) AND " +
                            "(" + phone + " is NULL or " + phone + " =p.phone) AND " +
                            "(" + getQuoted(gender) + " is NULL or " + getQuoted(gender) + " =p.gender)");

            while (rs.next()) {
                String resName = rs.getString("name");
                String resSurname = rs.getString("surname");
                Integer resAge = rs.getInt("age");
                Integer resPhone = rs.getInt("phone");
                String resGender = rs.getString("gender");

                Person person = new Person(resName, resSurname, resAge, resPhone, resGender);
                persons.add(person);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return persons;
    }

    private String getQuoted(String o) {
        return o == null ? o : ("'" + o + "'");
    }
}