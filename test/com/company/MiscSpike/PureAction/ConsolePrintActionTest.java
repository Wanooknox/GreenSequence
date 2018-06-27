package com.company.MiscSpike.PureAction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConsolePrintActionTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void invoke_shouldThrowDataReadyException_whenNoMessageProvided() {
        // Arrange
        ConsolePrintAction consolePrintAction = new ConsolePrintAction();

        // Act
        RuntimeException exception = assertThrows(RuntimeException.class, consolePrintAction::invoke);

        // Assert
        assertEquals("Action ConsolePrintAction is not DataReady", exception.getMessage());
    }

    @Test
    void invoke_shouldPrintToConsole_whenGivenStringData() {
        // Arrange
        String expectedMsg = "this is a test";
        ConsolePrintAction consolePrintAction = new ConsolePrintAction().message(expectedMsg);

        // Act
        consolePrintAction.invoke();

        // Assert
        assertEquals(expectedMsg, outContent.toString().trim());
    }

}