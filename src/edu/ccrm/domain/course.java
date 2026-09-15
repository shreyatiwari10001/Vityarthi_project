package edu.ccrm.domain;

public class Course {
    private String code;
    private String title;
    private int credits;
    private Teacher instructor;
    private Semester semester;  // enum we will create later
    private String department;

    public Course(String code, String title, int credits, Teacher instructor, Semester semester, String department) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.instructor = instructor;
        this.semester = semester;
        this.department = department;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Course{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", credits=" + credits +
                ", instructor=" + instructor.getName() +
                ", semester=" + semester +
                ", department='" + department + '\'' +
                '}';
    }
    public String getTitle() {
        return title;
    }
    public String getCode() {
        return code;
    }

    public int getCredits() {
        return credits;
    }

    public Teacher getInstructor() {
        return instructor;
    }

    public Semester getSemester() {
        return semester;
    }

    public String getDepartment() {
        return department;
    }

}
