/* ============
 * Orson Charts
 * ============
 * 
 * (C)opyright 2013, 2014, by Object Refinery Limited.
 * 
 * http://www.object-refinery.com/orsoncharts/index.html
 * 
 * Redistribution of these source files is prohibited.
 * 
 */

package com.orsoncharts.graphics3d;

import java.io.Serializable;

/**
 * An offset <code>(dx, dy)</code> in two dimensional space.  Instances of 
 * this class are immutable.
 * <br><br>
 * NOTE: This class is serializable, but the serialization format is subject 
 * to change in future releases and should not be relied upon for persisting 
 * instances of this class. 
 */
@SuppressWarnings("serial")
public final class Offset2D implements Serializable {
    
    /** Zero offset. */
    public static final Offset2D ZERO_OFFSET = new Offset2D(0, 0);
    
    /** The x-offset. */
    private double dx;
    
    /** The y-offset. */
    private double dy;
    
    /**
     * Default constructor (<code>(0, 0)</code>).
     */
    public Offset2D() {
        this(0.0, 0.0);
    }
    
    /**
     * Creates a new instance.
     * 
     * @param dx  the x-offset.
     * @param dy  the y-offset.
     */
    public Offset2D(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    
    /**
     * Returns the x-offset.
     * 
     * @return The x-offset. 
     */
    public double getDX() {
        return this.dx;
    }
    
    /**
     * Returns the y-offset.
     * 
     * @return The y-offset. 
     */
    public double getDY() {
        return this.dy;
    }
    
    /**
     * Tests this instance for equality with an arbitrary object.
     * 
     * @param obj  the object (<code>null</code> permitted).
     * 
     * @return A boolean. 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Offset2D)) {
            return false;
        }
        Offset2D that = (Offset2D) obj;
        if (this.dx != that.dx) {
            return false;
        }
        if (this.dy != that.dy) {
            return false;
        }
        return true;
    }

    /**
     * Returns a hash code for this instance.
     * 
     * @return A hash code. 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.dx) 
                ^ (Double.doubleToLongBits(this.dx) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.dy) 
                ^ (Double.doubleToLongBits(this.dy) >>> 32));
        return hash;
    }
}
