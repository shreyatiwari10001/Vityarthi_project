package edu.ccrm.domain;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;



public class Student extends Person {
    private String course;
    private double gpa;

    private Map<Course, Grade> courseGrades;


    public Student(int id, String name, String email, String role, String course, double gpa) {
        super(id, name, email, role); // Call Person constructor
        this.course = course;
        this.gpa = gpa;
        this.enrolledCourses = new ArrayList<>();
        this.courseGrades = new HashMap<>();

    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString() + ", Student{" +
                "course='" + course + '\'' +
                ", gpa=" + gpa +
                '}';
    }
    private List<Course> enrolledCourses;  // new field

    // --- Enroll in a course ---
    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
    }

    // --- Unenroll from a course ---
    public void unenrollCourse(Course course) {
        enrolledCourses.remove(course);
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    // Override showProfile for abstraction
    @Override
    public void showProfile() {
        System.out.println(this);
        if (!enrolledCourses.isEmpty()) {
            System.out.println("Enrolled Courses:");
            for (Course c : enrolledCourses) {
                System.out.println(" - " + c.getTitle());
            }
        }
    }
    // Record grade for a course
    public void recordGrade(Course course, Grade grade) {
        if(enrolledCourses.contains(course)) {
            courseGrades.put(course, grade);
            computeGpa();  // recalculate GPA whenever a grade is added
        } else {
            System.out.println("Student not enrolled in this course!");
        }
    }

    // Compute GPA
    private void computeGpa() {
        if(courseGrades.isEmpty()) {
            this.gpa = 0;
            return;
        }

        double totalPoints = 0;
        int totalCredits = 0;

        for(Map.Entry<Course, Grade> entry : courseGrades.entrySet()) {
            Course course = entry.getKey();
            Grade grade = entry.getValue();
            totalPoints += grade.getPoints() * course.getCredits();
            totalCredits += course.getCredits();
        }

        this.gpa = totalPoints / totalCredits;
    }

    // Get grade for a course
    public Grade getGrade(Course course) {
        return courseGrades.get(course);
    }
    public void printTranscript() {
        System.out.println("=== Transcript for " + getName() + " ===");
        System.out.println("Email: " + getEmail());
        System.out.println("Student ID: " + getId());

        if(enrolledCourses.isEmpty()) {
            System.out.println("No courses enrolled.");
        } else {
            System.out.println("Courses & Grades:");
            for(Course c : enrolledCourses) {
                Grade grade = courseGrades.get(c);
                String gradeStr = (grade != null) ? grade.name() : "Not graded";
                System.out.println(" - " + c.getTitle() + " (" + c.getCode() + "): " + gradeStr);
            }
        }

        System.out.println("GPA: " + getGpa());
        System.out.println("====================\n");
    }

}
