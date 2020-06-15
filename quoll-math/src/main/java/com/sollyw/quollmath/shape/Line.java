package com.sollyw.quollmath.shape;

import com.sollyw.quollmath.Vec2i;
import net.minecraft.util.math.Vec3i;

/**
 * Utility for drawing straight lines between points using Bresenham's line algorithm.
 */
public class Line {
    /**
     * Draws a straight 2D line between two points.
     * @return an array of all points on the line
     */
    public static Vec2i[] get2D(Vec2i from, Vec2i to) {
        return get2D(from.x, from.y, to.x, to.y);
    }

    /**
     * Draws a straight 2D line between two points.
     * @return an array of all points on the line
     */
    public static Vec2i[] get2D(int x1, int y1, int x2, int y2) {
        final int dx = Math.abs(x2 - x1);
        final int dy = Math.abs(y2 - y1);
        final int sx = (x2 > x1) ? 1 : -1;
        final int sy = (y2 > y1) ? 1 : -1;
        final int l = Math.max(dx, dy);
        int ex = l >> 1;
        int ey = ex;
        Vec2i[] points = new Vec2i[l + 1];
        points[0] = new Vec2i(x1, y1);

        for (int p = 1; p <= l; p++) {
            ex -= dx;
            ey -= dy;

            if (ex < 0) {
                ex += l;
                x1 += sx;
            }

            if (ey < 0) {
                ey += l;
                y1 += sy;
            }

            points[p] = new Vec2i(x1, y1);
        }

        return points;
    }

    /**
     * Draws a straight 3D line between two points.
     * @return an array of all points on the line
     */
    public static Vec3i[] get3D(Vec3i from, Vec3i to) {
        return get3D(from.getX(), from.getY(), from.getZ(), to.getX(), to.getY(), to.getZ());
    }

    /**
     * Draws a straight 3D line between two points.
     * @return an array of all points on the line
     */
    public static Vec3i[] get3D(int x1, int y1, int z1, int x2, int y2, int z2) {
        final int dx = Math.abs(x2 - x1);
        final int dy = Math.abs(y2 - y1);
        final int dz = Math.abs(z2 - z1);
        final int sx = (x2 > x1) ? 1 : -1;
        final int sy = (y2 > y1) ? 1 : -1;
        final int sz = (z2 > z1) ? 1 : -1;
        final int l = Math.max(Math.max(dx, dy), dz);
        int ex = l >> 1;
        int ey = ex;
        int ez = ex;
        Vec3i[] points = new Vec3i[l + 1];
        points[0] = new Vec3i(x1, y1, z1);

        for (int p = 1; p <= l; p++) {
            ex -= dx;
            ey -= dy;
            ez -= dz;

            if (ex < 0) {
                ex += l;
                x1 += sx;
            }

            if (ey < 0) {
                ey += l;
                y1 += sy;
            }

            if (ez < 0) {
                ez += l;
                z1 += sz;
            }

            points[p] = new Vec3i(x1, y1, z1);
        }

        return points;
    }
}
