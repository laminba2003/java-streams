package com.training.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamCreation {

    public static void main(String[] args) {
        Employee[] employees = {
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000.0)
        };
        System.out.println("Printing all the employees");
        System.out.println("----------------------------------------");
        Stream.of(employees).forEach(System.out::println);

        System.out.println("Printing all the employees with salary > 150000.0");
        System.out.println("----------------------------------------");
        Arrays.asList(employees).stream()
                .filter(e -> e.getSalary() >= 150000.0)
                .forEach(System.out::println);

        System.out.println("Printing all the employees with name contains Jeff");
        System.out.println("----------------------------------------");
        Stream.Builder<Employee> builder = Stream.builder();
        builder.accept(employees[0]);
        builder.accept(employees[1]);
        builder.accept(employees[2]);
        builder.build()
                .filter(e -> e.getName().contains("Jeff"))
                .peek(e -> e.setSalary(8000000.0))
                .forEach(System.out::println);
    }
}