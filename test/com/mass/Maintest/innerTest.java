package com.mass.Maintest;

import com.mass.InnerClassDemo;
import org.junit.Assert;
import org.junit.Test;

public class innerTest {

    private InnerClassDemo tes;
    @Test
    public void testOne (){

         tes = new InnerClassDemo();

        Assert.assertEquals("app", tes.runTwo());

    }
}
