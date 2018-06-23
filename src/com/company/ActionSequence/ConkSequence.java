package com.company.ActionSequence;

public class ConkSequence extends SequenceBase {

    public ConkSequence() {

        ConkAction act1 = new ConkAction();
        ConkAction2 act2 = new ConkAction2();
        act2.dependsOn(act1);

        actionQueue.add(act2);
        actionQueue.add(act1);
    }
}
