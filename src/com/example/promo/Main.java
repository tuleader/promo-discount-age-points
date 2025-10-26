package com.example.promo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PromotionService service = new PromotionService();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        System.out.print("Enter points: ");
        long points = sc.nextLong();

        double discount = service.calculateDiscount(age, points);
        System.out.printf("Discount (v1): %.2f%%%n", discount);
    }
}
