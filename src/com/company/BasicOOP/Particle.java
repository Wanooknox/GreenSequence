package com.company.BasicOOP;

public class Particle extends Simulatable {

    private Vector2 position;
    private Vector2 velocity;

//    private SaturatedFat fattener = new SaturatedFat();

    public Particle(Vector2 position, Vector2 velocity) {
        this.position = position;
        this.velocity = velocity;
    }

    @Override
    public void update() {
        Move();
    }

    private void Move() {
        position = position.add(velocity);
    }
}
