package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

class ConverterTest {

  static final double CELCIUS_TOLERANCE = 0.0005;
  static final double FAHRENHEIT_TOLERANCE = 0.0009;

  @DisplayName("Converter.convertC2F(double)")
  @ParameterizedTest(name = "[{index}] Asserting Converter.convertC2F({0}) == {1}")
  @CsvFileSource(resources = "converter.csv", numLinesToSkip = 1)
  void convertC2F(double inputCelsius, double expectedFahrenheit) {
    double actualFahrenheit = Converter.convertC2F(inputCelsius);
    assertEquals(expectedFahrenheit, actualFahrenheit, FAHRENHEIT_TOLERANCE);
  }

  @ParameterizedTest(name = "[{index}] Asserting Converter.convertF2C({1}) == {0}")
  @CsvFileSource(resources = "converter.csv", numLinesToSkip = 1)
  void convertF2C(double expectedCelsius, double inputFahrenheit) {
    double actualCelsius = Converter.convertF2C(inputFahrenheit);
    assertEquals(expectedCelsius, actualCelsius, CELCIUS_TOLERANCE);
  }
}
