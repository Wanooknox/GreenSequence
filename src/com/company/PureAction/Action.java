package com.company.PureAction;

public interface Action {

    boolean hasExecuted();

    boolean isInvokable();

    void invoke();
}
