package com.company.BasicOOP;

import java.util.List;

public class Simulator {

    private List<Simulatable> subjects;

    public Simulator(List<Simulatable> subjects) {
        this.subjects = subjects;
    }

    public void run() {
        long iterCount = 0;
        long time = getTime();
        long freshTime;
        while (true) {

            for (Simulatable subject : subjects) {
                subject.update();
            }

            freshTime = getTime();
            System.out.println(String.format("[ iteration: %s | deltaTime: %s  | totalTime: %s ]", iterCount, freshTime - time, time));
            time = freshTime;
            iterCount++;
        }

    }

    private long getTime() {
        return System.currentTimeMillis();
    }

}
