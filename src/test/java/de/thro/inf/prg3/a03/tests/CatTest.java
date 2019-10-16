package de.thro.inf.prg3.a03.tests;

import de.thro.inf.prg3.a03.Cat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Peter Kurfer
 * Created on 10/7/17.
 */
public class CatTest
{
    private static final int Sleep  = 10;
    private static final int Awake  = 15;
    private static final int Digest = 10;

    private Cat cat;

    @BeforeEach
    void setUp()
    {
        cat = new Cat("Horst", Sleep, Awake, Digest);
    }

    @Test
    void testFeedHungryAnimal()
    {
        IntStream.range(0, Sleep).forEach(i -> cat.tick());
        assertTrue(cat.isHungry());
        cat.feed();
        assertTrue(cat.isDigesting());
    }

    @Test
    void testFeedNotHungryAnimal()
    {
        assertFalse(cat.isHungry());
        assertThrows(IllegalStateException.class, () -> cat.feed());
    }

    @Test
    void testAnimalGettingPlayful()
    {
        IntStream.range(0, Sleep).forEach(i -> cat.tick());
        cat.feed();
        IntStream.range(0, Digest).forEach(i -> cat.tick());
        assertTrue(cat.isPlayful());
    }

    @Test
    void testAnimalDying()
    {
        IntStream.range(0, Sleep + Awake).forEach(i -> cat.tick());
        assertTrue(cat.isDead());
    }

    @Test
    void testAnimalIsGoingToSleepAgain()
    {
        IntStream.range(0, Sleep).forEach(i -> cat.tick());
        cat.feed();
        IntStream.range(0, Awake).forEach(i -> cat.tick());
        assertTrue(cat.isAsleep());
    }
}