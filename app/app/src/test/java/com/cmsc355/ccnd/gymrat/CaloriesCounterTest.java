package com.cmsc355.ccnd.gymrat;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Davis on 11/16/17.
 */
public class CaloriesCounterTest {
    CaloriesCounter mCalories = new CaloriesCounter();

    @Test
    public void deleteFood() throws Exception {
        List<String> list = new ArrayList<String>();
        List<String> spyList = Mockito.spy(list);

        spyList.add("pizza");
        spyList.add("cookie");
        Mockito.verify(spyList).add("pizza");
        Mockito.verify(spyList).add("cookie");
        spyList.remove("pizza");

        assertEquals(spyList.get(0), "cookie");

    }

    @Test
    public void addFood() throws Exception {
        List<String> list = new ArrayList<String>();
        List<String> spyList = Mockito.spy(list);

        spyList.add("pizza");
        Mockito.verify(spyList).add("pizza");

        assertEquals(1, spyList.size());
        assertEquals(spyList.get(0), "pizza");
    }

    @Test
    public void deleteAllFood() throws Exception {
        List<String> list = new ArrayList<String>();
        List<String> spyList = Mockito.spy(list);

        spyList.add("hamburger");
        spyList.add("ice cream");
        Mockito.verify(spyList).add("hamburger");
        Mockito.verify(spyList).add("ice cream");
        spyList.removeAll(spyList);

        assertEquals(0, spyList.size());
    }

}