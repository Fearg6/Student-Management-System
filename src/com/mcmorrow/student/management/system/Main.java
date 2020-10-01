package com.mcmorrow.student.management.system;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Ask how many new students that we need to add.
        System.out.println("Enter the number of new students to enroll: ");
        Scanner in = new Scanner(System.in);
        int numOfStudents = in.nextInt();
        ArrayList<Student> students = new ArrayList<>();

        // Create a number of new students.
        for(int i =0;i < numOfStudents;i++){
            students.add(new Student());
            students.get(i).enroll();
            students.get(i).payTuition();
        }

        for (Student student : students) {
            System.out.println(student.toString());
        }


    }
}
