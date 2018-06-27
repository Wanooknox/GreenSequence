package com.company.BasicOOP;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicOOPDemo {

    private static final int count = 2 * 1000000;

    private static final Random rand = new Random();

    public static void main(String[] args) {

        List<Simulatable> subjects = new ArrayList<>();

        addParticles(subjects, count);

        new Simulator(subjects).run();
    }

    private static void addParticles(List<Simulatable> subjects, int count) {
        for (int i = 0; i < count; i++) {
            Vector2 position = getRandomVector();
            Vector2 velocity = getRandomVector(rand.nextInt(5));

            subjects.add(new Particle(position, velocity));
        }
    }

    private static Vector2 getRandomVector() {
        return getRandomVector(1f);
    }

    private static Vector2 getRandomVector(float scalar) {
        return new Vector2(rand.nextFloat() * scalar, rand.nextFloat() * scalar);
    }

}
