package com.sollyw.quollmath;

import net.minecraft.util.math.MathHelper;

public class Vec2i {
    public static final Vec2i ZERO = new Vec2i(0, 0);
    public final int x;
    public final int y;

    public Vec2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vec2i(double x, double y) {
        this(MathHelper.floor(x), MathHelper.floor(y));
    }

    public boolean equals(Vec2i other) {
        return this.x == other.x && this.y == other.y;
    }

    public Vec2i add(Vec2i v) {
        return new Vec2i(this.x + v.x, this.y + v.y);
    }

    public Vec2i add(int x, int y) {
        return new Vec2i(this.x + x, this.y + y);
    }

    public Vec2i subtract(Vec2i v) {
        return new Vec2i(this.x - v.x, this.y - v.y);
    }

    public Vec2i subtract(int x, int y) {
        return new Vec2i(this.x - x, this.y - y);
    }
}
