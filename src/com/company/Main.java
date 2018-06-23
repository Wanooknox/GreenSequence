package com.company;

import com.company.FunctionSequence.ConkSequence;
import com.company.PureAction.ConsolePrintAction;

public class Main {

    public static void main(String[] args) {
//        testSequence();
        testActions();
    }

    private static void testActions() {
        new ConsolePrintAction().message("print me!").invoke();
    }

    private static void testSequence() {
        ConkSequence conkSequence = new ConkSequence();

        conkSequence.run();
    }
}
