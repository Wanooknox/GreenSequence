package com.company.FunctionSequence;

import com.company.FunctionSequence.Interfaces.Function;
import com.company.FunctionSequence.Interfaces.Sequence;

import java.util.ArrayDeque;
import java.util.Queue;

public abstract class SequenceBase implements Sequence {

    protected Queue<Function> functionQueue = new ArrayDeque<>();

    @Override
    public void run() {

//        Function currAction;
//        while ((currAction = functionQueue.poll()) != null) {

        while (functionQueue.peek() != null) {
        Function currFunction = functionQueue.poll();
            if (currFunction.invokable()) {
                currFunction.invoke();
            } else {
                functionQueue.add(currFunction);
            }
        }

    }
}
