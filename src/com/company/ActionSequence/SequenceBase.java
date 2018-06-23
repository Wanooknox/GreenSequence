package com.company.ActionSequence;

import com.company.ActionSequence.Interfaces.Action;
import com.company.ActionSequence.Interfaces.Sequence;

import java.util.ArrayDeque;
import java.util.Queue;

public abstract class SequenceBase implements Sequence {

    protected Queue<Action> actionQueue = new ArrayDeque<>();

    @Override
    public void run() {

//        Action currAction;
//        while ((currAction = actionQueue.poll()) != null) {

        while (actionQueue.peek() != null) {
        Action currAction = actionQueue.poll();
            if (currAction.invokable()) {
                currAction.invoke();
            } else {
                actionQueue.add(currAction);
            }
        }

    }
}