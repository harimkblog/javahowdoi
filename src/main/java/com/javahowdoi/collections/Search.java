package com.javahowdoi.collections;

import java.util.*;

/**
 * Created by Hari on 11/9/2019.
 */
public class Search {

    public static void main(String[] args ) {
        int[] arr = {0,1,2,3,10,20,31,62};
        int idx  = Arrays.binarySearch(arr, 10);
        assert(idx == 4 );



        List<Integer> al = (ArrayList<Integer>) Arrays.asList( 0,1,2,3,10,20,31,62);
        //al.set(1,1);

        Integer[] arr1 = (Integer[]) al.toArray();
        Arrays.asList(arr1);

        idx  = Collections.binarySearch(al, 10);
        assert(idx == 4 );

        HashSet<String> s = new HashSet<>();
        switch(idx) {
            case 0:
            case 1:
            default:
                break;
        }
    }
}

class Rectangle {
    private double length;
    private double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public double getLength() {
        return length;
    }

    public double getBreadth() {
        return breadth;
    }

    public double area() {
        return length * breadth;
    }

}

/** class Employee {

    private int empId;
    private String empFirstName;
    private String empSecondName;


    private double empSalary;

    //Write your code here
    public  Employee(int empId, String empFirstName, String empSecondName, double empSalary) {
        super();
        this.empId = empId;
        this.empFirstName = empFirstName;
        this.empSecondName = empSecondName;
        this.empSalary = empSalary;
    }
    public int getEmpId() {
        return empId;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public String getEmpSecondName() {
        return empSecondName;
    }

    public double getEmpSalary() {
        return empSalary;
    }

}**/

