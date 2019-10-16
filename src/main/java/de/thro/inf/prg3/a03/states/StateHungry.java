package de.thro.inf.prg3.a03.states;

import de.thro.inf.prg3.a03.Cat;

public class StateHungry extends State
{
    /**
     * Constructor
     * Setting the duration of the State
     *
     * @param duration The duration of the State
     */
    protected StateHungry(int duration)
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
        logger.info("I've starved for a too long time...good bye...");

        return new StateDeath(0);
    }

    /**
     * Feed the cat
     *
     * @param cat The cat to feed
     *
     * @return The following state
     */
    State feed(Cat cat)
    {
        if (!cat.isHungry())
            throw new IllegalStateException("Can't stuff a cat...");

        logger.info("You feed the cat...");

        return new StateDigesting(cat.getDigest());
    }
}