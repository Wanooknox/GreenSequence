package com.company;

import com.company.FunctionSequence.ConkSequence;
import com.company.PureAction.ConsolePrintAction;
import com.company.PureAction.SubtractAction;

public class Main {

    public static void main(String[] args) {
//        testSequence();
        testActions();
    }

    private static void testActions() {
        Double result = new SubtractAction().setValues(5.0, 2.0).invoke();
        new ConsolePrintAction().message("print me!: " + result).invoke();
    }

    private static void testSequence() {
        ConkSequence conkSequence = new ConkSequence();

        conkSequence.run();
    }
}
