package lab1_client;

import lab1_client.generated.Person;
import lab1_client.generated.PersonService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class PersonWebService {


    public static void main(String[] args) throws MalformedURLException {

        String name=ConsoleInput.ReadStrValue("Name");
        String surname=ConsoleInput.ReadStrValue("Surname");
        Integer age=ConsoleInput.ReadIntValue("Age");
        Integer phone=ConsoleInput.ReadIntValue("Phone");
        String gender=ConsoleInput.ReadStrValue("Gender");

        URL url = new URL("http://localhost:8080/lab1_ws_j2ee_war_exploded/PersonService?wsdl");
//        URL url = new URL("http://localhost:8080/PersonService?wsdl");
        PersonService personService = new PersonService(url);
        List<Person> persons = personService.getPersonWebServicePort().getPersons(name, surname, age, phone, gender);
        for (Person person : persons) {
            System.out.println("name: " + person.getName() +
                    ", surname: " + person.getSurname() + ", age: " + person.getAge()+ ", phone: " + person.getPhone()+", gender: " + person.getGender());
        }
        System.out.println("Total persons: " + persons.size());
    }
}