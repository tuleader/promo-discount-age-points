package com.example.promo;

public class PromotionService {

    /**
     * Computes discount percentage by age and points.
     * v1: additive rule with a simple cap at 25%.
     * @param age non-negative
     * @param points non-negative
     * @return discount in [0, 25]
     */
    public double calculateDiscount(int age, long points) {
        if (age < 0 || points < 0) {
            throw new IllegalArgumentException("Age and points must be non-negative.");
        }

        double base = baseByAge(age);
        double extra = Math.min((points / 1000) * 2.0, 10.0); // +2% per 1k points, max +10%
        double total = base + extra;
        return clamp(total, 0.0, 25.0);
    }

    private double baseByAge(int age) {
        if (age < 18) return 5.0;
        if (age <= 25) return 7.0;
        if (age <= 59) return 10.0;
        return 15.0; // >= 60
    }

    private double clamp(double v, double min, double max) {
        return Math.max(min, Math.min(max, v));
    }
}
