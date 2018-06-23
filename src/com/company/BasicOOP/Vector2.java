package com.company.BasicOOP;

public class Vector2 {
    public float x;
    public float y;

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2 add(Vector2 that) {
        return new Vector2(this.x + that.x, this.y + that.y);
    }
}
