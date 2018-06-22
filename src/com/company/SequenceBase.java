package com.company;

import com.company.Interfaces.Action;
import com.company.Interfaces.Sequence;

import java.util.ArrayDeque;
import java.util.Queue;

public abstract class SequenceBase implements Sequence {

    protected Queue<Action> actionQueue = new ArrayDeque<>();

    @Override
    public void run() {

//        while (actionQueue.peek() != null) {
//        Action currAction = actionQueue.poll();

        Action currAction;
        while ((currAction = actionQueue.poll()) != null) {

            if (currAction.invokable()) {
                currAction.invoke();
            } else {
                actionQueue.add(currAction);
            }
        }

    }
}
