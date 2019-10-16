package de.thro.inf.prg3.a03.states;

import de.thro.inf.prg3.a03.Cat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class State
{
    // Instance of logger
    protected final Logger logger = LogManager.getLogger();

    protected int time = 0;
    protected final int duration;

    /**
     * Constructor
     * Setting the duration of the State
     *
     * @param duration The duration of the State
     */
    protected State(int duration)
    {
        this.duration = duration;
    }

    /**
     * Get the following state
     *
     * @param cat The cat to get the state for
     *
     * @return The following state
     */
    public abstract State successor(Cat cat);

    /**
     * Get's called every tick
     * Increase the internal timer and return the following state based on it
     *
     * @param cat The cat to tick
     *
     * @return The following state
     */
    public final State tick(Cat cat)
    {
        logger.info("tick()");

        this.time ++;

        return this.time < this.duration ? this : this.successor(cat);
    }
}