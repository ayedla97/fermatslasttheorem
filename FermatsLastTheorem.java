/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fermatslasttheorem;

import java.util.Scanner;

/**
 * Fermat's Last Theorem Calculator
 * 
 * Program File: FermatsLastTheorem.java
 * 
 * External Files Required:
 *   - None
 * 
 * External Files Created:
 *   - None
 * 
 * Programmers:
 *   - [1. Shashank Meesa
 *      2. Arunoday Yedla
 * ]
 * 
 * Contact Email:
 *   - [1. shashankmeesa1@gmail.com
 *      2. arunodayyedla@lewisu.edu
 * ]
 * 
 * Course Information:
 *   - Course Number: FA23-CPSC-60500-001
 *   - Section Number: Assignment 1
 * 
 * Date Completed and Submitted:
 *   - [25-09-2023]
 * 
 * Description:
 *   This Java program calculates the nearest miss for Fermat's Last Theorem, which states
 *   that there are no three positive integers a, b, and c that satisfy the equation
 *   an + bn = cn for any integer value of n greater than 2.
 * 
 *   The program takes input values for a, b, z, and n from the user, and then calculates
 *   the nearest miss for the equation an + bn != zn, for all n > 2.
 * 
 * Resources Used:
 *   - [List any resources or references used in developing the program, such as websites, books, or tutorials.]
 * 1. https://www.w3schools.com/java/
 * 2. https://www.tutorialspoint.com/java/
 */ 

public class FermatsLastTheorem {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Fermat's Last Theorem: an + bn != zn, for all(n>2)");
        int a, b, z, n;
        double nearest_miss;
        System.out.print("Enter value for a:");
        a = s.nextInt();
        System.out.print("Enter value for b:");
        b = s.nextInt();
        System.out.print("Enter value for z:");
        z = s.nextInt();
        
        while (true) {
            System.out.print("Enter value for n or exponent:");
            n = s.nextInt();
            
            // Check if n is less than or equal to 2, and prompt the user to enter a greater value.
            if (n <= 2) {
                System.out.println("Enter a value greater than 2");
            } else {
                // Calculate the sum of a^n and b^n
                int pow_sum = (int) (Math.pow(a, n) + Math.pow(b, n)); // pow_sum has the value an + bn.
                
                // Calculate the nth root of pow_sum
                double zValue = Math.pow(pow_sum, 1.0 / n);
                
                // Calculate z^n and (z+1)^n
                int z_pow = (int) Math.pow((int) zValue, n); // z_pow has the value zn.
                int z_ext_pow = (int) Math.pow((int) (zValue + 1), n); // z_ext_pow has the value (z+1)n and an + bn.
                
                // Calculate the differences between an + bn and zn, and between (z+1)n and an + bn.
                int diff_pow_sum_z_pow = pow_sum - z_pow; // Variable for difference between an + bn and zn.
                int diff_z_ext_pow_sum = z_ext_pow - pow_sum; // Variable for difference between (z+1)n and an + bn.
                
                // Determine the nearest miss
                if (diff_pow_sum_z_pow > diff_z_ext_pow_sum) { // Comparison to find the nearest miss.
                    nearest_miss = diff_pow_sum_z_pow;
                } else {
                    nearest_miss = diff_z_ext_pow_sum;
                }
                
                // Display the nearest miss value
                System.out.println("Nearest Miss=" + nearest_miss);
            }
        }
    }
}
