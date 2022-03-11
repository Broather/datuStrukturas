package dataStr.SEMINARS_1.models;

public class Student {
    private static int idCounter = 10000;

    private int id;
    private String name;
    private String surname;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setId() {
        this.id = idCounter++;
    }

    public void setName(String name) {
        // regex priekš "Jānis" vai "Jānis Pēteris"
        if (name != null && name.matches("([A-ZĒŪĪĀŠĢĶĻŅČŽ]{1}[a-zēūīļķģšāžčņ]+\\s?){1,2}")) {

            this.name = name;
        } else {
            this.name = "notknown";
        }
    }

    public void setSurname(String surname) {
        // regex priekš "Ozoliņš"
        if (surname != null && surname.matches("([A-ZĒŪĪĀŠĢĶĻŅČŽ]{1}[a-zēūīļķģšāžčņ]+\\s?){1,2}")) {
            this.surname = surname;

        } else {
            this.surname = "notknown";
        }
    }

    public Student() {
        setId();
        setName("notknown");
        setSurname("notknown");
    }

    public Student(String name, String surname) {
        setId();
        setName(name);
        setSurname(surname);
    }

    public String toString() {
        return id + " " + name + " " + surname;
    }
}
