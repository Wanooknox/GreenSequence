package com.company.BasicDOD;

public class ParticleMovementSystem {

    public void update(Vector2 position, Vector2 velocity) {
        position = position.add(velocity);
    }

}
