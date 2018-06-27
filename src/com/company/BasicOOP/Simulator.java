package com.company.BasicOOP;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulator {

    private static final Random rand = new Random();

    private List<Particle> particles = new ArrayList<>();

    Simulator(int particleCount) {
        addParticles(particleCount);
    }

    public void run() {
        long iterCount = 0;
        long time = getTime();
        long freshTime;
        while (true) {

            for (Particle particle : particles) {
                particle.update();
            }

            freshTime = getTime();
            System.out.println(String.format("[ iteration: %s | deltaTime: %s  | totalTime: %s ]", iterCount, freshTime - time, time));
            time = freshTime;
            iterCount++;
        }

    }

    //region Misc Supporting code
    private long getTime() {
        return System.currentTimeMillis();
    }

    private void addParticles(int count) {
        for (int i = 0; i < count; i++) {
            Vector2 position = getRandomVector(1f);
            Vector2 velocity = getRandomVector(rand.nextInt(5));

            particles.add(new Particle(position, velocity));
        }
    }

    private Vector2 getRandomVector(float scalar) {
        return new Vector2(rand.nextFloat() * scalar, rand.nextFloat() * scalar);
    }
    //endregion
}
