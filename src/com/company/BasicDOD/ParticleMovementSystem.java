package com.company.BasicDOD;

import com.company.DemoCommon.Vector2;

public class ParticleMovementSystem {

    public void updateMutate(Vector2 position, Vector2 velocity) {
        // it is actually faster to mutate
        position.addMutate(velocity);
    }

    public ParticleData updateFunctional(Vector2 position, Vector2 velocity) {
        // the functional construction leads to a roughly 2x increase in deltaTime
        return new ParticleData(position.add(velocity), velocity);
    }

}
