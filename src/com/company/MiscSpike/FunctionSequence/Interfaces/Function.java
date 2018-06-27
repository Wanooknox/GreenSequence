package com.company.MiscSpike.FunctionSequence.Interfaces;

public interface Function {

    void dependsOn(Function dependency);

    boolean hasExecuted();

    boolean invokable();

    void invoke();
}
