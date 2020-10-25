package com.company;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt(); sc.nextLine();
        System.out.printf("Test Cases: %d", t);
        System.out.println();
        for (int i = 0; i < t; i++) {
            int l = sc.nextInt(); sc.nextLine();
            System.out.println("No. of line: " + l);
            int x = process(l, 0, new Stack<>());
            System.out.println(x);
        }
    }

    public static int process(int l, int x, Stack<Integer> nStack) {
        if (l == 0) return x;

        String input = sc.nextLine();
        if (input.startsWith("add")) {
            return  process(--l, ++x, nStack);
        }
        else if (input.startsWith("for")) {
            int n = Integer.parseInt(input.substring(4));
            nStack.push(n);
            return  x + process(--l, 0, nStack);
        }
        else { // command == "end"
            return process(--l, x * nStack.pop(),  nStack);
        }
    }
}