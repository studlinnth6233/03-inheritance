package de.thro.inf.prg3.a03.states;

import de.thro.inf.prg3.a03.Cat;

public class StateSleeping extends State
{
    /**
     * Constructor
     * Setting the duration of the State
     *
     * @param duration The duration of the State
     */
    public StateSleeping(int duration)
    {
        super(duration);
    }

    /**
     * Get the following state
     *
     * @param cat The cat to get the state for
     *
     * @return The following state
     */
    @Override
    public State successor(Cat cat)
    {
        logger.info("Yoan... getting hungry!");

        return new StateHungry(cat.getAwake());
    }
}