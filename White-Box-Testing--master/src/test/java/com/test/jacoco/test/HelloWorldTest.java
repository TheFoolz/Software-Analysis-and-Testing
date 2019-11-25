package com.test.jacoco.test;

import static org.junit.Assert.assertEquals;

/**
 * Created by superZh on 2019/10/1.
 */

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;
import com.test.jacoco.HelloWorld;

import java.text.ParseException;
import java.util.Date;

public class HelloWorldTest {
    @Test
    public void testMethod1() {
        HelloWorld hw = new HelloWorld();
        String a = hw.Method1();
        assertEquals("Hello World", a);
    }

    @Test
    public void testMethod2() {
        HelloWorld hw = new HelloWorld();
        int a = hw.Method2(2, 1);
        assertEquals(3, a);
    }
    
    @Test
    public void testMethod3() {
    	/**
    	 * TODO：finish the test function
    	 */
    	HelloWorld hw = new HelloWorld();

    	int a = hw.Method3(6, -1, 1);
        int b = hw.Method3(4, 1, -3);
        int c = hw.Method3(6, 1, 1);
        int d = hw.Method3(4, 1, -1);
        int e = hw.Method3(5, 1, -1);
    }

    /**
     * TODO: add the test function of other methods in HelloWorld.java
     */

    @Test
    public void testMethod4() {
        /**
         * TODO：finish the test function
         */
        HelloWorld hw = new HelloWorld();
        int a = hw.Method4(0,0,0,0,0);
        int b = hw.Method4(1,1,1,1,1);
        int c = hw.Method4(5,2,1,1,1);
        try {
            int d = hw.Method4(1,2,1,2,1);
        }catch (Exception e) {
            e.printStackTrace();
        }
        try {
            int e = hw.Method4(1,2,1,1,1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testBug() {
        /**
         * TODO：finish the test function
         */
        HelloWorld hw = new HelloWorld();

        Boolean flag1 = hw.bug(5);
        assertEquals(flag1,true);

        Boolean flag2 = hw.bug(3);
        assertEquals(flag2,false);
    }

    @Test
    public void testisTriangle() {
        /**
         * TODO：finish the test function
         */
        HelloWorld hw = new HelloWorld();

        Boolean a = hw.isTriangle(1,1,3);
        assertEquals(a,false);

        Boolean b = hw.isTriangle(3,1,1);
        assertEquals(b,false);

        Boolean c = hw.isTriangle(1,3,1);
        assertEquals(c,false);

        Boolean d = hw.isTriangle(1,1,1);
        assertEquals(d,true);

        Boolean e = hw.isTriangle(-1,1,1);
        assertEquals(e,false);

        Boolean f = hw.isTriangle(1,-1,1);
        assertEquals(e,false);

        Boolean g = hw.isTriangle(1,1,-1);
        assertEquals(e,false);
    }

    @Test
    public void testisBirthday() throws ParseException {
        /**
         * TODO：finish the test function
         */
        HelloWorld hw = new HelloWorld();

        Boolean a = hw.isBirthday(2000,15,31);
        assertEquals(a,false);

        Boolean b = hw.isBirthday(1910,2,3);
        assertEquals(b,false);

        Boolean c = hw.isBirthday(2052,1,13);
        assertEquals(c,false);

        Boolean d = hw.isBirthday(2015,7,27);
        assertEquals(d,true);
    }

    @Test
    public void testminiCalculator() {
        /**
         * TODO：finish the test function
         */
        HelloWorld hw = new HelloWorld();

        Double a = hw.miniCalculator(1,1,'+');
        assertEquals(a,2.0,0.0);


        Double b = hw.miniCalculator(1,1,'-');
        assertEquals(b,0.0,0.0);

        Double c = hw.miniCalculator(2,3,'*');
        assertEquals(c,6.0,0.0);

        Double d = hw.miniCalculator(6,2,'/');
        assertEquals(d,3.0,0.0);
    }
}
