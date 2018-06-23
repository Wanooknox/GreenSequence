package com.company.FunctionJunktion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class FunctionBase implements Function {

    private boolean executed = false;
    private List<Function> dependencies = new ArrayList<>();

    protected abstract boolean isDataReady();
    protected abstract void innerInvoke();

    public FunctionBase(Function... dependencies) {
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
            for (Function dep : dependencies) {
                ready = ready && dep.hasExecuted();
            }
            return ready;
        }
        return false;
    }

    @Override
    public void invoke() {
        if (!isDataReady()) {
            throw new RuntimeException(String.format("Function %s is not DataReady", getClass().getCanonicalName()));
        }
        if (!isInvokable()) {
            throw new RuntimeException(String.format("Function %s is not Invokable", getClass().getCanonicalName()));
        }

        innerInvoke();
        executed = true;
    }
}
