package com.company.ActionSequence;

import com.company.ActionSequence.Interfaces.Action;

import java.util.ArrayList;
import java.util.List;

public abstract class ActionBase implements Action {

    private boolean executed = false;
    private List<Action> dependencies = new ArrayList<>();

    protected abstract void innerInvoke();

    @Override
    public void dependsOn(Action dependency) {
        dependencies.add(dependency);
    }

    @Override
    public boolean hasExecuted() {
        return executed;
    }

    @Override
    public boolean invokable() {
        boolean ready = true;
        for (Action dep : dependencies) {
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
