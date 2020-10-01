package com.mcmorrow.student.management.system;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Ask how many new students that we need to add.
        System.out.println("Enter the number of new students to enroll: ");
        Scanner in = new Scanner(System.in);
        int numOfStudents = in.nextInt();
        Student[] students = new Student[numOfStudents];

        // Create a number of new students.
        for(int i =0;i < students.length;i++){
            students[i] = new Student();
            students[i].enroll();
            students[i].payTuition();
        }

        for (Student student : students) {
            System.out.println(student.toString());
        }


    }
}
