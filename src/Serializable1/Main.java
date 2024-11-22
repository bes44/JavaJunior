package Serializable1;

// Создайте класс Person с полями name и age. Реализуйте сериализацию и десериализацию этого класса в файл.

import java.io.*;

public class Main{
    public static void main(String[] args) {
        Person person = new Person("John", 30);

        // Сериализация
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            oos.writeObject(person);
            System.out.println("Сериализация выполнена успешно!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Десериализация
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
            Person deserializedPerson = (Person) ois.readObject();
            System.out.println("Де сериализация выполнена успешно!");
            System.out.println("Десериализованный объект: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
