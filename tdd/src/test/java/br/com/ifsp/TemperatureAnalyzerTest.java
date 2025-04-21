package br.com.ifsp;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TemperatureAnalyzerTest {

    @InjectMocks
    private TemperatureAnalyzer temperatureAnalyzer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnDaysAboveAverageForValidInputExample1() throws Exception {
        String input = "2 2 2 2 2 2 3";
        int expectedResult = 1;

        int result = (int) temperatureAnalyzer.calculateDaysAboveAverage(input);

        assertEquals(expectedResult, result);
    }

    @Test
    void shouldReturnDaysAboveAverageForValidInputExample2() throws Exception {
        String input = "21 10 13 34 30 21 34";
        int expectedResult = 3;

        int result = (int) temperatureAnalyzer.calculateDaysAboveAverage(input);

        assertEquals(expectedResult, result);
    }

    @Test
    void shouldReturnDaysAboveAverageForValidInputExample3() throws Exception {
        String input = "2 2 2 2 2 2 1";
        int expectedResult = 6;

        int result = (int) temperatureAnalyzer.calculateDaysAboveAverage(input);

        assertEquals(expectedResult, result);
    }

    @Test
    void shouldHandleNegativeTemperaturesCorrectly() throws Exception {
        String input = "-5 -10 0 5 10 15 20";
        int expectedResult = 3;

        int result = (int) temperatureAnalyzer.calculateDaysAboveAverage(input);

        assertEquals(expectedResult,result);
    }

    @Test
    void shouldReturnErrorForInvalidInputFormat(){
        String input = "2 2 2 2 2 2 abc";

        assertThatThrownBy(() -> temperatureAnalyzer.calculateDaysAboveAverage(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid input: contains non-numeric values");

    }

    @Test
    void shouldReturnErrorForInvalidInputFormatWhenInputIsEmpty(){
        String input = "     ";

        assertThatThrownBy(() -> temperatureAnalyzer.calculateDaysAboveAverage(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid input: null or empty");

    }

    @Test
    void shouldReturnIllegalArgumentExceptionForInvalidInputFormatWhenInputHasLess7Numbers(){
        String input = "2 2 2 2 2 2";

        assertThatThrownBy(() -> temperatureAnalyzer.calculateDaysAboveAverage(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid input: must contain exactly 7 values");

    }
}
