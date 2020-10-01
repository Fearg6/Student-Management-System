package com.mcmorrow.student.management.system;

import java.util.Scanner;

public class Student {
    private final String firstName;
    private final String lastName;
    private final int gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance;
    private static final int costOfCourse = 600;
    private static int id = 100;

    //Constructor prompts student to enter name and year.

    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter student First name: ");
        this.firstName = in.nextLine();

        System.out.println("Enter student Last name: ");
        this.lastName = in.nextLine();

        System.out.println("1 - Freshmen\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student class level: ");
        this.gradeYear = in.nextInt();

        setStudentID();
    }


    //Generate a Id for student
    private void setStudentID(){
        // Grade level + ID
        id++;
        this.studentID = gradeYear+""+id;
    }

    //enroll in courses
    public void enroll(){
        // Get inside a loop, user hits 0
        boolean pickingCourses = true;
        while (pickingCourses) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter course to enroll, (Q to quit): ");
            String course = in.nextLine();
            if(!course.toUpperCase().equals("Q")){
                this.courses = conCat(courses,"\n  "+course);
                this.tuitionBalance += costOfCourse;
            }else{
                pickingCourses = false;
            }
        }
    }

    private String conCat(String courses, String addedCourse) {
        return courses + addedCourse;
    }

    //view balance
    public void viewBalance(){
        System.out.println("Your balance is: €"+tuitionBalance);
    }

    // pay tuition
    public void payTuition(){
        viewBalance();
        System.out.print("Enter your payment: €");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        this.tuitionBalance -= payment;
        System.out.println("Thank you for your payment of €"+payment);
        viewBalance();
    }

    // status
    @Override
    public String toString(){
        return "Name: "+ firstName + " "+lastName+
                "\nGrade level: " + gradeYear +
                "\nStudent ID: " + studentID +
                "\nCourses Enrolled: " + courses +
                "\nBalance: €" + tuitionBalance;
    }
}
