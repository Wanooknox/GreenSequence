package com.company.MiscSpike.PureAction;

public interface Action<T> {

    boolean hasExecuted();

    boolean isInvokable();

    T invoke();
}
