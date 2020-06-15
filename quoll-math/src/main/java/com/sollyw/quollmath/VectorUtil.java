package com.sollyw.quollmath;

import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

/**
 * Utility methods that belong in vanilla vector classes
 */
public class VectorUtil {
    /**
     * Creates a vector3 from a vector2 and an angle.
     * Uses one sin() call and one cos() call.
     * @param vec the vector2, should have a magnitude of 1
     * @param angle the angle, in radians
     * @return a vector3 with a magnitude of 1
     */
    public static Vec3d vec2AngleToVec3(Vec2d vec, double angle) {
        final double sa = Math.sin(angle);
        return new Vec3d(vec.x * sa, Math.cos(angle), vec.y * sa);
    }

    /**
     * Creates a vector3 from two angles.
     * Uses two sin() calls and two cos() calls.
     * @param yaw the horizontal rotation
     * @param pitch the vertical rotation
     * @return the vector3 equivalent of the two angles, with a magnitude of 1
     */
    public static Vec3d yawPitchToVec3(double yaw, double pitch) {
        return vec2AngleToVec3(Vec2d.fromAngle(yaw), pitch);
    }

    /**
     * Multiplies the X, Y, and Z components of one Vec3i with the X, Y, and Z components of another.
     */
    public static Vec3i multiply(Vec3i a, Vec3i b) {
        return new Vec3i(a.getX() * b.getX(), a.getY() * b.getY(), a.getZ() * b.getZ());
    }

    /**
     * Multiplies the X, Y, and Z components of a Vec3i with a number,
     */
    public static Vec3i multiply(Vec3i a, int b) {
        return new Vec3i(a.getX() * b, a.getY() * b, a.getZ() * b);
    }
}