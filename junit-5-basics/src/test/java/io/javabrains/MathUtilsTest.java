package io.javabrains;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
//import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS) //has only one instance running for the entire execution
@DisplayName("When running MathUtils")
class MathUtilsTest {
	
	MathUtils mathutils;
	TestInfo testInfo;
	TestReporter testReporter;
	
//	@BeforeAll
//	 void beforeAllInit() {
//	System.out.println("First method to run..BeforeAll");	
//	}
     
	
	@BeforeEach
	void init(TestInfo testInfo,TestReporter testReporter) {
		mathutils = new MathUtils();
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tag name " + testInfo.getTags());
	}
	
//	@AfterEach
//     void cleanup() {
//		System.out.println("Cleaning up..");
//	}
	
	@Nested
	@DisplayName("The add method")
	@Tag("Math")
	class AddTest{
		@Test
		@DisplayName("when adding 2 +ve numbers")
		void testAddPositive() {
			int expected = 2;
	        int actual = mathutils.add(1, 1);
			assertEquals(expected,actual,() -> "should return " + expected + " but retuned " + actual );
		}
		
		@Test
		@DisplayName("when adding 2 -ve numbers")
		void testAddNegative() {	
			int expected = -2;
			int actual = mathutils.add(-1, -1);
			assertEquals(expected,actual,() -> "should return " + expected + " but retuned " + actual );
		}	
	}

	@Test
	@DisplayName("the multiply method")
	@Tag("Math")
	void multiplyTest() {
	  assertAll(
			    () -> assertEquals(2,mathutils.multiply(2, 1)),
			    () -> assertEquals(0,mathutils.multiply(2, 0)),
			    () -> assertEquals(-2,mathutils.multiply(2, -1))
			  );	
	}
	
	 @Test
	 @DisplayName("the divide method")
	 @Tag("Math")
	 void testDivide() {
		
		 assertThrows(ArithmeticException.class,() -> mathutils.divide(1, 0),"Divide by Zero(Arithmetic) Exception should be  thrown..");
	 }
	 
	//@RepeatedTest(3)
	 @Test
	 @DisplayName("Testing Circle Area")
	 @Tag("Circle")
	//RepetitionInfo repInfo
	void computeCircleRadius() {
		
		assertEquals(314.1592653589793,mathutils.computeCircleArea(10),"gives us the circle area..");
	}
	
//	@Test
//	@DisplayName("This should not run")
//	void disabledTest() {
//		fail("This should be disabled..");
//	}
}
