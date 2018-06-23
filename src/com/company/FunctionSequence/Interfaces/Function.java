package com.company.FunctionSequence.Interfaces;

public interface Function {

    void dependsOn(Function dependency);

    boolean hasExecuted();

    boolean invokable();

    void invoke();
}
