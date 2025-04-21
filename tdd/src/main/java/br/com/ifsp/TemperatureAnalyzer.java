package br.com.ifsp;

import java.util.Arrays;

public class TemperatureAnalyzer {
    public Object calculateDaysAboveAverage(String input) throws Exception {
        try{
            if (input == null || input.trim().isEmpty()){
                throw new IllegalArgumentException("Invalid input: null or empty");
            }

            String[] itens = input.trim().split("\\s+");
            if (itens.length!=7){
                throw new IllegalArgumentException("Invalid input: must contain exactly 7 values");
            }

            int[] temperature = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            double average = Arrays.stream(temperature).average().orElse(0);
            return (int) Arrays.stream(temperature).filter(temp -> temp > average).count();

        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Invalid input: contains non-numeric values", e);
        }

    }
}