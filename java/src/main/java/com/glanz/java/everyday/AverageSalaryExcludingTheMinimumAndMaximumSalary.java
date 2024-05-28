package com.glanz.java.everyday;

public class AverageSalaryExcludingTheMinimumAndMaximumSalary {
    public static void main(String[] args) {

    }

    public double average(int[] salary) {
        double max = salary[0];
        double min = salary[0];
        double sum = 0;
        for (int i = 0; i < salary.length; i++) {
            max = Math.max(max, salary[i]);
            min = Math.min(min, salary[i]);
            sum += salary[i];
        }

        return  (sum - max - min)/(salary.length-2);
    }
}
