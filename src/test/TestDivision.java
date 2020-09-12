package test;
import logic.BasicCalculations;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestDivision {
	
	@Test
	public void testDivision() {
		BasicCalculations b = new BasicCalculations();
		double output = b.perfectDivision(12, 10);
		assertEquals((double) 1, output, 2);
		
	}

}
