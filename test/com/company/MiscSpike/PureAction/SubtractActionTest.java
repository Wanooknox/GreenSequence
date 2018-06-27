package com.company.MiscSpike.PureAction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtractActionTest {

    @Test
    void invoke_shouldThrowDataReadyException_whenNoDataProvided() {
        // Arrange
        SubtractAction subtractAction = new SubtractAction();

        // Act
        RuntimeException exception = assertThrows(RuntimeException.class, subtractAction::invoke);

        // Assert
        assertEquals("Action SubtractAction is not DataReady", exception.getMessage());
    }

    @Test
    void invoke_shouldSubtractTwoValues() {
        // Arrange
        double expected = 3.0;
        SubtractAction subtractAction = new SubtractAction().setValues(5.0, 2.0);

        // Act
        Double actual = subtractAction.invoke();

        // Assert
        assertEquals(expected, actual.doubleValue());
    }

}