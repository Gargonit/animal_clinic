package Veterinary_Clinic;

import java.io.Serializable;

public class Animal implements Serializable {
    private static final long serialVersionUID=1L;
    private int id;
    private String name;
    private String type;
    private int age;
    private String owner;

    public Animal(int id, String name, int age) {
    }

    public Animal(String name, String type, int age, String owner) {
        this.name=name;
        this.type=type;
        this.age=age;
        this.owner=owner;
    }

    public Animal(int id, String name, String type, int age, String owner) {
        this.id=id;
        this.name=name;
        this.type=type;
        this.age=age;
        this.owner=owner;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type=type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age=age;
    }

    public String getOwner() { return owner;
    }
    public void setOwner(String owner) {
        this.owner=owner;
    }
}
//Здесь мы создали класс Animal, который представляет животное в ветеринарной клинике.
// Он имеет поля id, name, type, age и owner, которые отслеживают идентификатор, имя, тип,
// возраст и владельца животного соответственно. Мы также удалили поле getPrice,
// так как оно не имеет смысла в контексте ветеринарной клиники.