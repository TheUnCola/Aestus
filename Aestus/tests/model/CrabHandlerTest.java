package model;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.ToolControl;
import model.CrabHandler;

/**
 * @author Steven Sell
 * @Test Tests all functions of CrabHandler
 */

public class CrabHandlerTest {

	static CrabHandler c;
	static ToolControl tc;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		c = new CrabHandler();
		tc = new ToolControl(10, 10);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		c = null;
	}
	
	/**
	 * @author Steven
	 * @Tests Adds a crab and tests the x/y coordinates of the crab.
	 */
	@Test
	public void addCrabTest() {
		c.addCrab(3, 2);
		assertEquals("Crab at first position should have an X of 3",c.getCrab(0).getX(),3);
		assertEquals("Crab at first position should have a Y of 2",c.getCrabs().get(0).getY(),2);
	}
	
	/**
	 * @author Steven
	 * @Tests Moves a crab's position at random to test the move method
	 */
	@Test
	public void moveCrabsTest() {
		c.addCrab(3, 2);
		c.moveCrabs();
	}
	
	/**
	 * @author Steven
	 * @Tests Adds a crab, deletes that crab, then verifies that it was actually deleted
	 */
	@Test
	public void deleteCrabTest() {
		c = new CrabHandler();
		c.addCrab(400, 10);
		c.deleteCrabs(tc);
		assertEquals("The size of the array should be 0",c.getCrabs().size(),0);

		//System.out.println(tc.getCrabTrap().getX()- tc.getCrabTrap().getSizeX()/2);
		//System.out.println(tc.getCrabTrap().getX() + tc.getCrabTrap().getSizeX()/4);
		//System.out.println(tc.getCrabTrap().getY()- tc.getCrabTrap().getSizeY()/2);
		//System.out.println(tc.getCrabTrap().getY() + tc.getCrabTrap().getSizeY()/4);
	}
	
	
	/**
	 * @author Steven
	 * @Tests Sets researched, then tests to make sure it was set properly
	 */
	@Test
	public void setResearchedTest() {
		c.setResearched(true);
		assertTrue("Researched should be true",c.getResearched());
	}
	
	/**
	 * @author Steven
	 * @Tests Checks that Removed is what is expected
	 */
	@Test
	public void getRemoved() {
		assertEquals("Removed should be 1", c.getRemoved(),1);
	}

}
