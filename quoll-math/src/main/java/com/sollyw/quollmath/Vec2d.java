package com.sollyw.quollmath;

public class Vec2d {
    public static final Vec2d ZERO = new Vec2d(0, 0);
    public final double x;
    public final double y;

    public Vec2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Vec2d other) {
        return this.x == other.x && this.y == other.y;
    }

    public Vec2d add(Vec2d v) {
        return new Vec2d(this.x + v.x, this.y + v.y);
    }

    public Vec2d add(double x, double y) {
        return new Vec2d(this.x + x, this.y + y);
    }

    public Vec2d subtract(Vec2d v) {
        return new Vec2d(this.x - v.x, this.y - v.y);
    }

    public Vec2d subtract(double x, double y) {
        return new Vec2d(this.x - x, this.y - y);
    }

    /**
     * Creates a vector2 from an angle.
     * Uses one sin() call and one cos() call.
     * @param angle the angle, in radians
     * @return the vector2 equivalent of the angle, with a magnitude of 1
     */
    public static Vec2d fromAngle(double angle) {
        return new Vec2d(Math.sin(angle), Math.cos(angle));
    }

}
