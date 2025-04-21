package br.com.ifsp;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemperatureAnalyzerTest {

    @InjectMocks
    private TemperatureAnalyzer temperatureAnalyzer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnDaysAboveAverageForValidInputExample1(){
        String input = "2 2 2 2 2 2 3";
        int expectedResult = 1;

        int result = temperatureAnalyzer.calculateDaysAboveAverage(input);

        assertEquals(expectedResult, result);
    }

    @Test
    void shouldReturnDaysAboveAverageForValidInputExample2(){
        String input = "21 10 13 34 30 21 34";
        int expectedResult = 3;

        int result = temperatureAnalyzer.calculateDaysAboveAverage(input);

        assertEquals(expectedResult, result);
    }

    @Test
    void shouldReturnDaysAboveAverageForValidInputExample3(){
        String input = "2 2 2 2 2 2 1";
        int expectedResult = 6;

        int result = temperatureAnalyzer.calculateDaysAboveAverage(input);

        assertEquals(expectedResult, result);
    }
}
