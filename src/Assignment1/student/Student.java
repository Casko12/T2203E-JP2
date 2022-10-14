package Assignment1.student;

public class Student {
    public Integer id;
    public String name;
    public String telephone;
    public String email;

    public Student() {
    }

    public Student(Integer id, String name, String telephone, String email) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
