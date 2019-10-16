package de.thro.inf.prg3.a03;

import de.thro.inf.prg3.a03.states.*;

public class Cat
{
    private final String name;

    private final int sleep;
    private final int awake;
    private final int digest;

    private State state;

    /**
     * Constructor
     * Set the attributes and initialize the starting state
     *
     * @param name   The name of the cat
     * @param sleep  The sleeping time of the cat
     * @param awake  The awake time of the cat
     * @param digest The digesting time of the cat
     */
    public Cat(String name, int sleep, int awake, int digest)
    {
        this.name = name;

        this.sleep  = sleep;
        this.awake  = awake;
        this.digest = digest;

        this.state = new StateSleeping(this.sleep);
    }

    /**
     * Gets called every tick
     * Calls the tick method on the current active state
     */
    public void tick()
    {
        this.state = this.state.tick(this);
    }

    /**
     * This would be a user interaction: feed the cat to change its state!
     */
    public void feed()
    {
        if (!isHungry())
            throw new IllegalStateException("Can't stuff a cat...");

        this.state = ((StateHungry) this.state).feed(this);
    }

    /**
     * Check if the cat is currently asleep
     *
     * @return True / False whether cat is in sleeping state
     */
    public boolean isAsleep()
    {
        return this.state instanceof StateSleeping;
    }

    /**
     * Check if the cat is currently playful
     *
     * @return True / False whether cat is in playful state
     */
    public boolean isPlayful()
    {
        return this.state instanceof StatePlayful;
    }

    /**
     * Check if the cat is currently hungry
     *
     * @return True / False whether cat is in hungry state
     */
    public boolean isHungry()
    {
        return this.state instanceof StateHungry;
    }

    /**
     * Check if the cat is currently digesting
     *
     * @return True / False whether cat is in digesting state
     */
    public boolean isDigesting()
    {
        return this.state instanceof StateDigesting;
    }

    /**
     * Check if the cat is dead
     *
     * @return True / False whether cat is in death state
     */
    public boolean isDead()
    {
        return this.state instanceof StateDeath;
    }

    /**
     * Get the sleeping time of the cat
     *
     * @return The sleeping time of the cat
     */
    public int getSleep()
    {
        return this.sleep;
    }

    /**
     * Get the digesting time of the cat
     *
     * @return The digesting time of the cat
     */
    public int getDigest()
    {
        return this.digest;
    }

    /**
     * Get the awake time of the cat
     *
     * @return The awake time of the cat
     */
    public int getAwake()
    {
        return this.awake;
    }

    /**
     * Translate the cat into a readable String ( name )
     *
     * @return Readable string representation of the cat
     */
    @Override
    public String toString()
    {
        return name;
    }
}