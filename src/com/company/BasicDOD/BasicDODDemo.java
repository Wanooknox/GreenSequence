package com.company.BasicDOD;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicDODDemo {

    private static final int count = 3 * 1000000;

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

            //TODO: build collection of particle datas and operate on them with the system
//            subjects.add(new ParticleData(position, velocity));
        }
    }

    private static Vector2 getRandomVector() {
        return getRandomVector(1f);
    }

    private static Vector2 getRandomVector(float scalar) {
        return new Vector2(rand.nextFloat() * scalar, rand.nextFloat() * scalar);
    }

}
