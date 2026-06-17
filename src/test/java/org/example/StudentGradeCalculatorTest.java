package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentGradeCalculatorTest {

    private StudentGradeCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StudentGradeCalculator();
    }

    @Test
    @Tag("grade")
    void calculateAverageTest() {
        int result = calculator.calculateAverage(90, 80, 100);

        assertEquals(90, result);
    }

    @ParameterizedTest
    @Tag("grade")
    @ValueSource(ints = {60, 70, 80, 90})
    void isPassedTest(int grade) {
        assertTrue(calculator.isPassed(grade));
    }

    @ParameterizedTest
    @Tag("grade")
    @CsvSource({
            "95, A",
            "85, B",
            "75, C",
            "65, D",
            "60, E",
            "40, F"
    })
    void ectsGradeTest(int grade, String expected) {
        assertEquals(expected, calculator.getECTSGrade(grade));
    }

    @TestFactory
    @Tag("scholarship")
    Collection<DynamicTest> scholarshipTests() {
        return List.of(
                DynamicTest.dynamicTest(
                        "Average 90 should have scholarship",
                        () -> assertTrue(calculator.hasScholarship(90))
                ),

                DynamicTest.dynamicTest(
                        "Average 80 should not have scholarship",
                        () -> assertFalse(calculator.hasScholarship(80))
                )
        );
    }

    @Test
    @Tag("scholarship")
    void scholarshipAssumptionTest() {

        int averageGrade = 90;
        boolean passedSession = calculator.isPassed(averageGrade);

        Assumptions.assumeTrue(
                passedSession,
                "Scholarship is checked only for students who passed the session"
        );

        assertTrue(calculator.hasScholarship(averageGrade));
    }
}
