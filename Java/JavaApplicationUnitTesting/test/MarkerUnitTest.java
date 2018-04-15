/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sami
 */
public class MarkerUnitTest {

    @Test
    public void constructorTest1() {
        Marker m = new Marker("blue");
        assertTrue(m.getColor().equals("blue"));
        assertTrue(m.getInkAmount() > 0);
    }

    @Test
    public void constructorTest2() {
        Marker m = new Marker();
        assertTrue(m.getColor().equals("black"));
        assertTrue(m.getInkAmount() > 0);
    }

    @Test
    public void drawTest1() {
        Marker m = new Marker("red");
        int before = m.getInkAmount();
        m.capOff();
        m.draw();
        assertTrue(m.getInkAmount() < before);
    }

    @Test
    public void drawTest2() {
        Marker m = new Marker("red");
        m.capOff();
        int count = 0;
        while(m.draw()) {
            count++;
        }
        assertTrue(m.getInkAmount() == 0);
        assertTrue(count == 20);
    }

    @Test
    public void drawTest3() {
        Marker m = new Marker("red");
        int before = m.getInkAmount();
        boolean didDraw = m.draw();
        assertTrue((before == m.getInkAmount()) && (!didDraw));
    }
}
