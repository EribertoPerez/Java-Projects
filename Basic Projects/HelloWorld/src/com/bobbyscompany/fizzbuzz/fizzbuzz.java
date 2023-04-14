package com.bobbyscompany.fizzbuzz;

import java.util.Scanner;

public class fizzbuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fizzBuzz = scanner.nextInt();
        if (fizzBuzz % 5 == 0 && fizzBuzz % 3 == 0)
            System.out.println("FizzBuzz");
        else if (fizzBuzz % 5 == 0)
            System.out.println("Fizz");
        else if (fizzBuzz % 3 == 0)
            System.out.println("Buzz");
        else System.out.println(fizzBuzz);
    }
}
