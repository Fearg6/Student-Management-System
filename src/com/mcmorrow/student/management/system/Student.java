package com.mcmorrow.student.management.system;

import java.util.Scanner;

public class Student {
    private final String firstName;
    private final String lastName;
    private int gradeYear;
    private final Scanner in = new Scanner(System.in);
    private final String studentID;
    private String coursesEnrolled = "";
    private int tuitionBalance;
    private static final int costOfCourse = 600;
    private static int id = 100;

    //Constructor prompts student to enter name and year.

    public Student() {

        printText("Enter student's First name: ");
        this.firstName = in.nextLine();

        printText("Enter student's Last name: ");
        this.lastName = in.nextLine();

        do {
            printText("1 - Freshmen\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student class level: ");
            this.gradeYear = in.nextInt();
            if(this.gradeYear!=1 && this.gradeYear!=2 && this.gradeYear!=3 && this.gradeYear!=4){
                printText("please enter a number 1-4");
            }
        } while (this.gradeYear!=1 && this.gradeYear!=2 && this.gradeYear!=3 && this.gradeYear!=4);

        //Generate a Id for student
        id++;
        this.studentID = conCat(String.valueOf(gradeYear),String.valueOf(id));
    }

    public Student(String firstName, String lastName, int gradeYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gradeYear = gradeYear;

        //Generate a Id for student
        id++;
        this.studentID = conCat(String.valueOf(gradeYear),String.valueOf(id));
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




    private String conCat(String firstWord, String secondWord) {
        return firstWord + secondWord;
    }

    //view balance
    private void viewBalance(){
        printText("Your balance is: €"+ tuitionBalance);
    }

    // pay tuition
    public void payTuition(){
        viewBalance();
        int payment;
        do {
            printText("Enter your payment: €");
            payment = in.nextInt();
            if(payment<0||payment>this.tuitionBalance){
                printText("Please enter an amount between 0 and balance");
            }
        } while (payment<0||payment>this.tuitionBalance);
        this.tuitionBalance = Math.max(tuitionBalance - payment,0);
        printText("Thank you for your payment of €"+payment);
        viewBalance();
    }

    private void printText(String text) {
        System.out.println(text);
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
