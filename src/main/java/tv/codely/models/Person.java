package tv.codely.models;

import tv.codely.interfaces.Identifiable;

public class Person implements Identifiable {
    protected String id;
    protected String name;
    protected String address;
    protected String phoneNumber;

    public Person(String id, String name, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{id='" + id + '\'' + ", name='" + name + '\'' + ", address='" + address + '\'' + ", phoneNumber='" + phoneNumber + '\'' + '}';
    }

    public String toFileString() {
        return id + "," + name + "," + address + "," + phoneNumber;
    }

    public static Person fromFileString(String fileString) {
        String[] parts = fileString.split(",");
        return new Person(parts[0], parts[1], parts[2], parts[3]);
    }
}
