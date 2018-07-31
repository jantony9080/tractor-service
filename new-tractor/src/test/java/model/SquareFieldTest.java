package model;

import org.junit.Assert;
import org.junit.Test;

public class SquareFieldTest {

    @Test(expected = IllegalArgumentException.class)
    public void cteateFieldWithNegXTest(){
        new SquareField(-1,7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cteateFieldWithNegYTest(){
        new SquareField(1,-7);
    }


    @Test
    public void zeroLenTest(){
        Field underTest=new SquareField(0,0);
        Assert.assertTrue(underTest.isOnTheField(new Position(0,0)));
        Assert.assertFalse(underTest.isOnTheField(new Position(1,0)));
        Assert.assertFalse(underTest.isOnTheField(new Position(0,1)));
        Assert.assertFalse(underTest.isOnTheField(new Position(1,1)));
    }

    @Test
    public void nonZeroLenTest(){
        Field underTest=new SquareField(2,2);
        Assert.assertTrue(underTest.isOnTheField(new Position(0,0)));
        Assert.assertTrue(underTest.isOnTheField(new Position(1,0)));
        Assert.assertTrue(underTest.isOnTheField(new Position(0,1)));
        Assert.assertFalse(underTest.isOnTheField(new Position(0,5)));
        Assert.assertFalse(underTest.isOnTheField(new Position(5,0)));
        Assert.assertFalse(underTest.isOnTheField(new Position(5,5)));
    }
}
