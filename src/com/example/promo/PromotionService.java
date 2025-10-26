package com.example.promo;

public class PromotionService {

    /**
     * Computes discount percentage by age and points.
     * v2: combined rule with age multipliers amplifying points bonus.
     * Cap at 30%.
     * @param age non-negative
     * @param points non-negative
     * @return discount in [0, 30]
     */
    public double calculateDiscount(int age, long points) {
        if (age < 0 || points < 0) {
            throw new IllegalArgumentException("Age and points must be non-negative.");
        }

        double base = baseByAge(age);
        double multiplier = multiplierByAge(age);
        double bonus = bonusByPoints(points);
        double total = base + bonus * multiplier;

        return clamp(total, 0.0, 30.0);
    }

    private double baseByAge(int age) {
        if (age < 18) return 6.0;
        if (age <= 30) return 8.0;
        if (age <= 59) return 11.0;
        return 16.0; // >= 60
    }

    private double multiplierByAge(int age) {
        if (age < 18) return 1.0;
        if (age <= 30) return 1.0;
        if (age <= 59) return 1.1;
        return 1.2; // >= 60
    }

    private double bonusByPoints(long points) {
        if (points < 1000) return 0.0;
        if (points < 5000) return 3.0;
        if (points < 10000) return 6.0;
        return 10.0; // >= 10000
    }

    private double clamp(double v, double min, double max) {
        return Math.max(min, Math.min(max, v));
    }
}
