package view;

/**
 * @author Steven
 */

import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import static org.junit.Assert.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CordGrassViewTest {
	
	static CordGrassView cv;
	static Random rand;
	static BufferedImage cvi;
	static BufferedImage img;
	static Dimension screenSize;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cv = new CordGrassView();
		cvi = Helper.toBufferedImage(cv.getImage(0));
		rand = new Random();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		try { 
			img = ImageIO.read(new File("./img/Grass.png"));
        } catch (IOException ex) {
    	   System.out.println("Image read error");
        }
		img = Helper.toBufferedImage(img.getScaledInstance((int)screenSize.getWidth()/(38+12), -1,Image.SCALE_SMOOTH));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		cv = null;
		cvi = null;
		img = null;
	}

	@Test
	public void imageDimensionTest() {
		assertEquals("The height of each image should be equal",cvi.getHeight(null),img.getHeight(null));
		assertEquals("The width of each image should be equal",cvi.getWidth(null),img.getWidth(null));
	}
	
	@Test
	public void imagePixelComparisonTest() {
		int w = cvi.getHeight(null);
		int h = cvi.getWidth(null);
		for(int i=0;i<100;i++) {
			int rx = rand.nextInt(w);
			int ry = rand.nextInt(h);
			assertEquals("The integer pixels should be equal",img.getRGB(ry, rx),cvi.getRGB(ry, rx));
		}
	}
}
