package com.levelUP;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class exampleTest {


    @Test
    public void sum() {
        Example example = new Example();
        int result = example.sum(2,2);
assertEquals(4,result);
    }

}