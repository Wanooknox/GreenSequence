package com.company.FunctionJunktion;

import java.util.ArrayList;
import java.util.List;

public abstract class FunctionBase implements Function {

    private boolean executed = false;
    private List<Function> dependencies = new ArrayList<>();

    protected abstract void gimmedata();
    protected abstract void innerInvoke();

    @Override
    public boolean hasExecuted() {
        return executed;
    }

    @Override
    public boolean invokable() {
        boolean ready = true;
        for (Function dep : dependencies) {
            ready = ready && dep.hasExecuted();
        }
        return ready;
    }

    @Override
    public void invoke() {
        innerInvoke();
        executed = true;
    }
}
