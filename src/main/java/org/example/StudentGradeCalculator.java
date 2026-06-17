package org.example;

public class StudentGradeCalculator {

    public int calculateAverage(int... grades) {
        if (grades == null || grades.length == 0) {
            throw new IllegalArgumentException("Grades cannot be null");
        }

        int sum = 0;

        for (int grade : grades) {
            sum += grade;
        }

        return sum / grades.length;
    }

    public boolean isPassed(int averageGrade) {
        return averageGrade >= 60;
    }

    public String getECTSGrade(int averageGrade) {
        if (averageGrade >= 90) {
            return "A";
        }

        if (averageGrade >= 82) {
            return "B";
        }

        if (averageGrade >= 74) {
            return "C";
        }

        if (averageGrade >= 64) {
            return "D";
        }

        if (averageGrade >= 60) {
            return "E";
        }

        return "F";
    }

    public boolean hasScholarship(int averageGrade) {
        return averageGrade >= 85;
    }
}
