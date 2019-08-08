package com.tavisca.test;

import com.tavisca.main.NoLineSegment;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NoLineSegmentTest {
    @Test
    public void testAcceptValue(){
        NoLineSegment noLineSegment = new NoLineSegment(new int[]{0, 0, 0, 0}, new int[]{0, 0, 0, 0});
        assertEquals(0,noLineSegment.x1);
        assertEquals(0,noLineSegment.y1);
        assertEquals(0,noLineSegment.x2);
        assertEquals(0,noLineSegment.y2);
        assertEquals(0,noLineSegment.x3);
        assertEquals(0,noLineSegment.y3);
        assertEquals(0,noLineSegment.x4);
        assertEquals(0,noLineSegment.y4);
    }

    @Test
    public void testAreParallel(){
        NoLineSegment segment = new NoLineSegment(new int[]{0, 0, 0, 1}, new int[]{0, 1, 0, 2});
        assertEquals("Yes",segment.isParallel());
    }

    @Test
    public void testArePerpendicular(){
        NoLineSegment segment = new NoLineSegment(new int[]{0, 0, 0, 1}, new int[]{0, 1, 0, 2});
        assertEquals("No",segment.isPerpendicular());
    }

    @Test
    public void testIfIntersectWithPerpendicular(){
        NoLineSegment segment = new NoLineSegment(new int[]{0, -1, 0, 1}, new int[]{-1, 0, 1, 0});
        assertEquals("Yes",segment.isIntersecting());
    }

    @Test
    public void testIfIntersectWithParallel(){
        NoLineSegment segment = new NoLineSegment(new int[]{0, 0, 0, 1}, new int[]{0, 1, 0, 2});
        assertEquals("Yes",segment.isIntersecting());
    }

    @Test
    public void testIfAPoint(){
        NoLineSegment segment = new NoLineSegment(new int[]{800, 1000, 800, 850}, new int[]{1000, 1000, -1000, 1000});
        assertEquals("Yes",segment.isIntersecting());
    }

    @Test
    public void testIfAPoint3(){
        NoLineSegment segment = new NoLineSegment(new int[]{0, 0, 0, 0}, new int[]{0, 0, 0, 0});
        assertEquals("Yes",segment.isIntersecting());
    }

    @Test
    public void testIfAPoint2(){
        NoLineSegment segment = new NoLineSegment(new int[]{50, 60, 100, 60}, new int[]{100, 1000, 100, -1000});
        assertEquals("Yes",segment.isIntersecting());
    }

    @Test
    public void testIfAPoint4(){
        NoLineSegment segment = new NoLineSegment(new int[]{1, 2, 1, 4}, new int[]{1, 2, 1, -2});
        assertEquals("Yes",segment.isIntersecting());
    }

    @Test
    public void testIfNotAPoint(){
        NoLineSegment segment = new NoLineSegment(new int[]{-788, -799, -600, -799}, new int[]{-788, -799, -600, -799});
        assertEquals("No",segment.isIntersecting());
    }

    @Test
    public void testNotSegment(){
        NoLineSegment segment = new NoLineSegment(new int[]{0, 0, 0, 1}, new int[]{0, 1, 0, 2});
        assertEquals("No",segment.isOverlapping());
    }

    @Test
    public void testIfSegment(){
        NoLineSegment segment = new NoLineSegment(new int[]{0, 0, 2, 0}, new int[]{1, 0, 10, 0});
        assertEquals("Yes",segment.isOverlapping());
    }

    @Test
    public void testIfSegment2(){
        NoLineSegment segment = new NoLineSegment(new int[]{10, 0, -10, 0}, new int[]{5, 0, -5, 0});
        assertEquals("Yes",segment.isOverlapping());
    }

    @Test
    public void testIfSegment3(){
        NoLineSegment segment = new NoLineSegment(new int[]{5, 4, 5, 9}, new int[]{5,5, 5, 8});
        assertEquals("Yes",segment.isOverlapping());
    }

    @Test
    public void testIfSegment4(){
        NoLineSegment segment = new NoLineSegment(new int[]{-778, -799, -600, -799}, new int[]{-778,-799, -600, -799});
        assertEquals("Yes",segment.isOverlapping());
    }

    @Test
    public void testIfNotSegmentAndNotAPoint(){
        NoLineSegment segment = new NoLineSegment(new int[]{5, 5, 5, 5}, new int[]{6, 6, 6, 6});
        assertEquals("No",segment.isOverlapping());
        assertEquals("No",segment.isIntersecting());
    }

    @Test
    public void testIfNotSegmentAndNotAPoint2(){
        NoLineSegment segment = new NoLineSegment(new int[]{19, -19, 20, -19}, new int[]{20, 99, 20, 1000});
        assertEquals("No",segment.isOverlapping());
        assertEquals("No",segment.isIntersecting());
    }

    @Test
    public void testIfNotSegmentAndNotAPoint3(){
        NoLineSegment segment = new NoLineSegment(new int[]{10, -5, 10, 78}, new int[]{10, -90, 10, -80});
        assertEquals("No",segment.isOverlapping());
        assertEquals("No",segment.isIntersecting());
    }
}
