package com.company.MiscSpike.PureAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ActionBase<T> implements Action {

    private boolean executed = false;
    private List<Action> dependencies = new ArrayList<>();

    protected abstract boolean isDataReady();
    protected abstract T innerInvoke();

    ActionBase(Action... dependencies) {
        this.dependencies.addAll(Arrays.asList(dependencies));
    }

    @Override
    public boolean hasExecuted() {
        return executed;
    }

    @Override
    public boolean isInvokable() {
        if (isDataReady()) {
            boolean ready = true;
            for (Action dep : dependencies) {
                ready = ready && dep.hasExecuted();
            }
            return ready;
        }
        return false;
    }

    @Override
    public T invoke() {
        if (!isDataReady()) {
            throw new RuntimeException(String.format("Action %s is not DataReady", getClass().getSimpleName()));
        }
        if (!isInvokable()) {
            throw new RuntimeException(String.format("Action %s is not Invokable", getClass().getSimpleName()));
        }

        T result = innerInvoke();
        executed = true;
        return result;
    }
}
