package com.company.PureAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ActionBase implements Action {

    private boolean executed = false;
    private List<Action> dependencies = new ArrayList<>();

    protected abstract boolean isDataReady();
    protected abstract void innerInvoke();

    public ActionBase(Action... dependencies) {
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
    public void invoke() {
        if (!isDataReady()) {
            throw new RuntimeException(String.format("Action %s is not DataReady", getClass().getCanonicalName()));
        }
        if (!isInvokable()) {
            throw new RuntimeException(String.format("Action %s is not Invokable", getClass().getCanonicalName()));
        }

        innerInvoke();
        executed = true;
    }
}
