package practice.lesson4;

public class Employee {
    private int id;
    private String phoneNum;
    private String name;
    private int seniority; // стаж

    public int getId() {
        return id;
    }

    public Employee(int id, String phoneNum, String name, int seniority) {
        this.id = id;
        this.phoneNum = phoneNum;
        this.name = name;
        this.seniority = seniority;
    }

    public String getPhoneNum() {
        return phoneNum;
    }


    public String getName() {
        return name;
    }


    public int getSeniority() {
        return seniority;
    }

    @Override
    public String toString() {
        return "id: " + id + "| phone: " + phoneNum + "| name: " + name + "| seniority: " + seniority;
    }
}
