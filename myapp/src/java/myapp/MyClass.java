package myapp;

public class MyClass {
    private int age;
    private String name;

    public MyClass(){
        this.age = 1;
        this.name = "";
    }
    public MyClass(int age, String name,String address){
        this.age = age;
        this.name = name;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

}
