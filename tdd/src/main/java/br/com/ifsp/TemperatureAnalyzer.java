package br.com.ifsp;

import java.util.Arrays;

public class TemperatureAnalyzer {
    public int calculateDaysAboveAverage(String input) {
        int[] temperature = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        double average = Arrays.stream(temperature).average().orElse(0);
        return (int) Arrays.stream(temperature).filter(temp -> temp > average).count();
    }
}