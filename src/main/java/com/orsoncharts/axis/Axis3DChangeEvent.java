/* ============
 * Orson Charts
 * ============
 * 
 * (C)opyright 2013, 2014, by Object Refinery Limited.
 * 
 * http://www.object-refinery.com/orsoncharts/index.html
 * 
 * Redistribution of this source file is prohibited.
 * 
 */

package com.orsoncharts.axis;

import java.util.EventObject;

import com.orsoncharts.util.ArgChecks;

/**
 * An event associated with a change to an {@link Axis3D}.  These change 
 * events will be generated by an axis and broadcast to the plot that owns the
 * axis (in the standard setup, the plot will then trigger its own change event
 * to notify the chart that a subcomponent of the plot has changed). 
 * <br><br>
 * NOTE: This class is serializable, but the serialization format is subject 
 * to change in future releases and should not be relied upon for persisting 
 * instances of this class. 
 */
@SuppressWarnings("serial")
public class Axis3DChangeEvent extends EventObject {
  
    /** The axis associated with this event. */
    private Axis3D axis;
  
    /** 
     * A flag indicating whether or not the change requires the 3D world to 
     * be updated.
     */
    private boolean requiresWorldUpdate;
    
    /**
     * Creates a new event.
     * 
     * @param axis  the axis (<code>null</code> not permitted).
     * @param requiresWorldUpdate  a flag indicating whether or not this change
     *     requires the 3D world to be updated.
     */
    public Axis3DChangeEvent(Axis3D axis, boolean requiresWorldUpdate) {
        this(axis, axis, requiresWorldUpdate);
    }
    
    /**
     * Creates a new event.
     * 
     * @param source  the event source.
     * @param axis  the axis (<code>null</code> not permitted).
     * @param requiresWorldUpdate  a flag indicating whether or not this change
     *     requires the 3D world to be updated.
     */
    public Axis3DChangeEvent(Object source, Axis3D axis, 
            boolean requiresWorldUpdate) {
        super(source);
        ArgChecks.nullNotPermitted(axis, "axis");
        this.axis = axis;
        this.requiresWorldUpdate = requiresWorldUpdate;
    }
  
    /**
     * Returns the axis associated with this event.
     * 
     * @return The axis (never <code>null</code>). 
     */
    public Axis3D getAxis() {
        return this.axis;
    }

    /**
     * Returns the flag that indicates whether or not this change will require
     * the 3D world to be updated.
     * 
     * @return A boolean.
     * 
     * @since 1.2
     */
    public boolean requiresWorldUpdate() {
        return this.requiresWorldUpdate;
    }
}
