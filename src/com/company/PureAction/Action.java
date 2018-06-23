package com.company.PureAction;

public interface Action<T> {

    boolean hasExecuted();

    boolean isInvokable();

    T invoke();
}
