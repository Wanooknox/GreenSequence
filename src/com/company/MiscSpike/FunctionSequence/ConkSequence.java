package com.company.MiscSpike.FunctionSequence;

public class ConkSequence extends SequenceBase {

    public ConkSequence() {

        ConkFunction act1 = new ConkFunction();
        ConkFunction2 act2 = new ConkFunction2();
        act2.dependsOn(act1);

        functionQueue.add(act2);
        functionQueue.add(act1);
    }
}
