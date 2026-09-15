package edu.ccrm.domain;

public class Teacher extends Person {
    private String department;
    private int experience;

    @Override
    public void showProfile() {
        System.out.println(this);
    }

    public Teacher(int id, String name, String email, String role, String department, int experience) {
        super(id, name, email, role);
        this.department = department;
        this.experience = experience;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return super.toString() + ", Teacher{" +
                "department='" + department + '\'' +
                ", experience=" + experience +
                '}';
    }
}
