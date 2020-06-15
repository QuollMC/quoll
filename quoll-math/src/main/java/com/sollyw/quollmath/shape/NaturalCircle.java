package com.sollyw.quollmath.shape;

import com.sollyw.quollmath.Vec2i;
import net.minecraft.util.math.Vec3i;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility for drawing imperfect circles that look much cleaner than perfect circles.
 */
public class NaturalCircle {
    /**
     * Draws a filled natural circle.
     * @param midpointX The X coordinate of the middle of the circle
     * @param midpointY The Y coordinate of the middle of the circle
     * @param radius The radius of the circle
     * @return An array of all points within the circle
     */
    public static Vec2i[] getFilled2D(int midpointX, int midpointY, int radius) {
        return getFilled2D(new Vec2i(midpointX, midpointY), radius);
    }

    /**
     * Draws a filled natural circle.
     * @param midpoint The middle of the circle
     * @param radius The radius of the circle
     * @return An array of all points within the circle
     */
    public static Vec2i[] getFilled2D(Vec2i midpoint, int radius) {
        List<Vec2i> points = new ArrayList<>();

        for (byte x = 0; x <= radius; x++) {
            for (byte y = 0; y <= radius; y++) {
                if (isWithinRadius(x, y, radius)) {
                    points.add(midpoint.add(x, y));
                    points.add(midpoint.add(x, -y));
                    points.add(midpoint.add(-x, y));
                    points.add(midpoint.add(-x, -y));
                }
            }
        }

        return points.toArray(new Vec2i[0]);
    }

    /**
     * Draws the outline of a natural circle.
     * @param midpointX The X coordinate of the middle of the circle
     * @param midpointY The Y coordinate of the middle of the circle
     * @param radius The radius of the circle
     * @return An array of all points on the perimeter of the circle
     */
    public static Vec2i[] getOutline2D(int midpointX, int midpointY, int radius) {
        return getOutline2D(new Vec2i(midpointX, midpointY), radius);
    }

    /**
     * Draws the outline of a natural circle.
     * @param midpoint The middle of the circle
     * @param radius The radius of the circle
     * @return An array of all points on the perimeter of the circle
     */
    public static Vec2i[] getOutline2D(Vec2i midpoint, int radius) {
        throw new UnsupportedOperationException();
    }

    /**
     * Draws a filled natural sphere.
     * @param midpointX The X coordinate of the middle of the sphere
     * @param midpointY The Y coordinate of the middle of the sphere
     * @param midpointZ The Z coordinate of the middle of the sphere
     * @param radius The radius of the sphere
     * @return An array of all points within the sphere
     */
    public static Vec3i[] getFilled3D(int midpointX, int midpointY, int midpointZ, int radius) {
        return getFilled3D(new Vec3i(midpointX, midpointY, midpointZ), radius);
    }

    /**
     * Draws a filled natural sphere.
     * @param midpoint The middle of the sphere
     * @param radius The radius of the sphere
     * @return An array of all points within the sphere
     */
    public static Vec3i[] getFilled3D(Vec3i midpoint, int radius) {
        throw new UnsupportedOperationException();
    }

    /**
     * Draws the outline of a natural sphere.
     * @param midpointX The X coordinate of the middle of the sphere
     * @param midpointY The Y coordinate of the middle of the sphere
     * @param midpointZ The Z coordinate of the middle of the sphere
     * @param radius The radius of the sphere
     * @return An array of all points on the perimeter of the sphere
     */
    public static Vec3i[] getOutline3D(int midpointX, int midpointY, int midpointZ, int radius) {
        return getOutline3D(new Vec3i(midpointX, midpointY, midpointZ), radius);
    }

    /**
     * Draws the outline of a natural sphere.
     * @param midpoint The middle of the sphere
     * @param radius The radius of the sphere
     * @return An array of all points on the perimeter of the sphere
     */
    public static Vec3i[] getOutline3D(Vec3i midpoint, int radius) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns true if the given point is within a circle with the given radius.
     */
    public static boolean isWithinRadius(Vec2i point, int radius) {
        return isWithinRadius(point.x, point.y, radius);
    }

    /**
     * Returns true if the given point is within a circle with the given radius.
     */
    public static boolean isWithinRadius(int x, int y, int radius) {
        return (Math.max(x, y) + (Math.min(x, y) >> 1)) <= radius;
    }

    /**
     * Returns true if the given point is on the perimeter of a circle with the given radius.
     */
    public static boolean isOnPerimeter(Vec2i point, int radius) {
        return isOnPerimeter(point.x, point.y, radius);
    }

    /**
     * Returns true if the given point is on the perimeter of a circle with the given radius.
     */
    public static boolean isOnPerimeter(int x, int y, int radius) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns true if the given point is within a sphere with the given radius.
     */
    public static boolean isWithinRadius(Vec3i point, int radius) {
        return isWithinRadius(point.getX(), point.getY(), point.getZ(), radius);
    }

    /**
     * Returns true if the given point is within a sphere with the given radius.
     */
    public static boolean isWithinRadius(int x, int y, int z, int radius) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns true if the given point is on the perimeter of a sphere with the given radius.
     */
    public static boolean isOnPerimeter(Vec3i point, int radius) {
        return isOnPerimeter(point.getX(), point.getY(), point.getZ(), radius);
    }

    /**
     * Returns true if the given point is on the perimeter of a sphere with the given radius.
     */
    public static boolean isOnPerimeter(int x, int y, int z, int radius) {
        throw new UnsupportedOperationException();
    }
}