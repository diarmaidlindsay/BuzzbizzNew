package pulseanddecibels.jp.buzbiznew;

import junit.framework.Assert;

import org.junit.Test;

import pulseanddecibels.jp.buzbiznew.util.SampleDataUtil;

/**
 * Created by Diarmaid Lindsay on 2016/04/13.
 * Copyright Pulse and Decibels 2016
 */
public class SampleDataTest
{
    @Test
    public void testUniqueTelNumbers() {
        Assert.assertEquals(5, SampleDataUtil.getUniqueSampleNumbers(5, 0, 10).size());
        Assert.assertEquals(0, SampleDataUtil.getUniqueSampleNumbers(4, 0, 3).size());
    }
}
