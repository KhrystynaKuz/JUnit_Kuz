package org.example;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses(StudentGradeCalculatorTest.class)
@IncludeTags("scholarship")
public class ScholarshipSuite {
}
