package com.mcmorrow.student.management.system;

import java.util.Scanner;

public class Student {
    private final String firstName;
    private final String lastName;
    private final int gradeYear;
    private final Scanner in = new Scanner(System.in);
    private String studentID;
    private String coursesEnrolled = "";
    private int tuitionBalance;
    private static final int costOfCourse = 600;
    private static int id = 100;

    //Constructor prompts student to enter name and year.

    public Student() {

        printText("Enter student First name: ");
        this.firstName = in.nextLine();

        printText("Enter student Last name: ");
        this.lastName = in.nextLine();

        printText("1 - Freshmen\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student class level: ");
        this.gradeYear = in.nextInt();

        setStudentID();
    }


    //Generate a Id for student
    private void setStudentID(){
        // Grade level + ID
        id++;
        this.studentID = conCat(gradeYear,id);
    }

    //enroll in courses
    public void enroll(){
        // Get inside a loop, user hits 0
        boolean pickingCourses = true;
        while (pickingCourses) {
            Scanner in = new Scanner(System.in);
            printText("Enter course to enroll, (Q to quit): ");
            String course = in.nextLine();
            if(!course.toUpperCase().equals("Q")){
                this.coursesEnrolled = conCat(coursesEnrolled,"\n  "+course);
                this.tuitionBalance += costOfCourse;
            }else{
                pickingCourses = false;
            }
        }
    }

    private void printText(String text) {
        System.out.println(text);
    }

    private String conCat(int firstWord, int secondWord) {
        return String.valueOf(firstWord)+ secondWord;
    }

    private String conCat(String firstWord, String secondWord) {
        return firstWord + secondWord;
    }

    //view balance
    public void viewBalance(){
        printText("Your balance is: €"+tuitionBalance);
    }

    // pay tuition
    public void payTuition(){
        viewBalance();
        printText("Enter your payment: €");
        int payment = in.nextInt();
        this.tuitionBalance = Math.max(tuitionBalance - payment,0);
        printText("Thank you for your payment of €"+payment);
        viewBalance();
    }

    // status
    @Override
    public String toString(){
        return "Name: "+ firstName + " "+lastName+
                "\nGrade Year: " + gradeYear +
                "\nStudent ID: " + studentID +
                "\nCourses Enrolled: " + coursesEnrolled +
                "\nBalance: €" + tuitionBalance;
    }
}
