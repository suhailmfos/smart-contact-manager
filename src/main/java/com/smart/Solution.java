package com.smart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    @Override
    @SuppressWarnings("Deprecation")
    protected void finalize() throws Throwable{
        System.out.println("GC called...");
    }

    public static void main(String[] args) {
        // [1,2,3,7,5]
        //
        //target = 12
        /*

         */
        int[] nums = {1, 2, 3, 7, 5};
        int target = 12;

        System.gc();

        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "Suraj", 90840));
        list.add(new Employee(1, "Suraj", 40840));
        list.add(new Employee(1, "Suraj", 30840));
        list.add(new Employee(1, "Suraj", 20840));

        list.stream().filter(e->e.getSalary() < 40000)
                .map(e->{
                    e.setSalary(e.getSalary() + 5000);
                    return e;
                }).forEach(System.out::println);



    }
}

@AllArgsConstructor
@Data
@ToString
class Employee{
    private int id;
    private String name;
    private double salary;
}