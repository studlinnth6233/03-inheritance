package de.thro.inf.prg3.a03.states;

import de.thro.inf.prg3.a03.Cat;

public class StateDeath extends State
{
    /**
     * Constructor
     * Setting the duration of the State
     *
     * @param duration The duration of the State
     */
    protected StateDeath(int duration)
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
        return new StateDeath(0);
    }
}