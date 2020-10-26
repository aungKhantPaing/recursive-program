package com.company;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < t; i++) {
            int l = sc.nextInt(); sc.nextLine();
            int x = p(l).x;
            System.out.println(x);
        }
    }

    public static R p (int l) {
        if (l == 0) return new R(0, 0);

        String input = sc.nextLine();
        if (input.startsWith("add")) {
            R r = p(--l);
            return new R(r.x + 1, r.l);
        }
        else if (input.startsWith("for")) {
            int n = Integer.parseInt(input.substring(4));
            R r = p(--l);
            r.x *= n;

            R r2 = p(r.l);
            return new R(r.x + r2.x, r2.l);
        }
        else {
            return new R(0, --l);
        }
    }

}

class R {
    public int x;
    public int l;

    public R(int x, int l ) {
        this.x = x;
        this.l = l;
    }
}