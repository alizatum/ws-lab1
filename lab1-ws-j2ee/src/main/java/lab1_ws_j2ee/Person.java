package lab1_ws_j2ee;

public class Person {
    private String name;
    private String surname;
    private Integer age;
    private Integer phone;
    private String gender;

    public Person() {
    }
    public Person(String name, String surname, Integer age, Integer phone, String gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public Integer getAge() {
        return age;
    }

    public String getGender() {

        return gender;
    }

    public Integer getPhone() {

        return phone;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(Integer phone) {

        this.phone = phone;
    }



    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", surname=" + surname + ", age=" + age +", phone=" + phone + ", gender=" + gender + '}';
    }
}