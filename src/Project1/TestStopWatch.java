package Project1;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestStopWatch {

	/**
	 * The following are simple random JUnit test cases... After talking with your
	 * instructor, create many, many more that shows that your code
	 * is functioning correctly.
	 * <p>
	 * <p>
	 * Prof says we are expected to have 80-100 unique test cases
	 */

	// default constructor test
	@Test
	public void testDefaultConstructor() {
		StopWatch s = new StopWatch();
		assertEquals(0, s.getMinutes());
		assertEquals(0, s.getSeconds());
		assertEquals(0, s.getMilliseconds());
	}

	//3 Integer constructor tests
	@Test
	public void testConstructor3Parameters() {
		StopWatch s = new StopWatch(2, 3, 4);
		assertEquals(2, s.getMinutes());
		assertEquals(3, s.getSeconds());
		assertEquals(4, s.getMilliseconds());
	}

	@Test
	public void testConstructor3Parameters0() {
		StopWatch s = new StopWatch(0, 0, 0);
		assertEquals(0, s.getMinutes());
		assertEquals(0, s.getSeconds());
		assertEquals(0, s.getMilliseconds());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor3ParametersXMinutes() {
		new StopWatch(-2, 3, 4);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor3ParametersXSeconds() {
		new StopWatch(2, -3, 4);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor3ParametersXMilli() {
		new StopWatch(2, 3, -4);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor3ParametersLMilli() {
		new StopWatch(12, 3, 1000);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor3ParametersLSeconds() {
		new StopWatch(12, 60, 14);
	}

	//2 Integer constructor tests
	@Test
	public void testConstructor2Parameters() {
		StopWatch s = new StopWatch(10, 300);
		assertEquals(0, s.getMinutes());
		assertEquals(10, s.getSeconds());
		assertEquals(300, s.getMilliseconds());
	}

	@Test
	public void testConstructor2Parameters0() {
		StopWatch s = new StopWatch(0, 0);
		assertEquals(0, s.getMinutes());
		assertEquals(0, s.getSeconds());
		assertEquals(0, s.getMilliseconds());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor2ParametersXSeconds() {
		new StopWatch(-1, 21);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor2ParametersXMilli() {
		new StopWatch(2, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor2ParametersLSeconds() {
		new StopWatch(67, 12);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor2ParametersLMilli() {
		new StopWatch(5, 1000);
	}

	// 1 Integer constructor tests
	@Test
	public void testConstructor1Parameter() {
		StopWatch s = new StopWatch(30);
		assertEquals(0, s.getMinutes());
		assertEquals(0, s.getSeconds());
		assertEquals(30, s.getMilliseconds());
	}

	@Test
	public void testConstructor1Parameter0() {
		StopWatch s = new StopWatch(0);
		assertEquals(0, s.getMinutes());
		assertEquals(0, s.getSeconds());
		assertEquals(0, s.getMilliseconds());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor1ParameterXMilli() {
		new StopWatch(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor1ParameterLMilli() {
		new StopWatch(1000);
	}

	//String constructor tests
	@Test
	public void testStringConstructor3Input() {
		StopWatch s = new StopWatch("20:10:8");
		assertEquals(s.getMilliseconds(), 8);
		assertEquals(s.getSeconds(), 10);
		assertEquals(s.getMinutes(), 20);
	}

	@Test
	public void testStringConstructor2Input() {
		StopWatch s = new StopWatch("4:50");
		assertEquals(s.getMilliseconds(), 50);
		assertEquals(s.getSeconds(), 4);
		assertEquals(s.getMinutes(), 0);
	}

	@Test
	public void testStringConstructor1Input() {
		StopWatch s = new StopWatch("8");
		assertEquals(s.getMilliseconds(), 8);
		assertEquals(s.getSeconds(), 0);
		assertEquals(s.getMinutes(), 0);
	}

	@Test
	public void testStringConstructor0() {
		StopWatch s = new StopWatch("0:0:0");
		assertEquals(s.getMinutes(), 0);
		assertEquals(s.getSeconds(), 0);
		assertEquals(s.getMilliseconds(), 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testStringConstructorEmptyString() {
		new StopWatch("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testStringConstructorNullString() {
		String s = null;
		new StopWatch(s);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegDouble1Input() {
		new StopWatch("-59:23");

	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegMinuteInput() {
		new StopWatch("-1:30:50");
	}


	@Test(expected = IllegalArgumentException.class)
	public void testNegDouble2aInput() {
		new StopWatch("2:-2");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLargeSecondInput() {
		new StopWatch("45:60:50");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLargeMilliInput() {
		new StopWatch("45:50:1000");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testStringConstructorExtraColon() {
		new StopWatch("50:45:40:35");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAlphaInput() {
		new StopWatch("a");
	}

	//StopWatch Constructor Tests
	@Test
	public void testStopWatchConstructor() {
		StopWatch s = new StopWatch(4, 5, 6);
		StopWatch s1 = new StopWatch(s);
		assertEquals(4, s1.getMinutes());
		assertEquals(5, s1.getSeconds());
		assertEquals(6, s1.getMilliseconds());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testStopWatchConstructorNull() {
		StopWatch s = null;
		new StopWatch(s);
	}

	//Equals StopWatch Tests
	@Test
	public void testEqualsStopWatchTrue() {
		StopWatch s1 = new StopWatch(12, 31, 52);
		StopWatch s2 = new StopWatch(12, 31, 52);
		assertTrue(StopWatch.equals(s1, s2));
	}

	@Test
	public void testEqualsStopWatchFalseSeconds() {
		StopWatch s1 = new StopWatch(6, 21, 999);
		StopWatch s2 = new StopWatch(6, 23, 999);
		assertFalse(StopWatch.equals(s1, s2));
	}

	@Test
	public void testEqualsStopWatchFalseMinutes() {
		StopWatch s1 = new StopWatch(3, 14, 200);
		StopWatch s2 = new StopWatch(2, 14, 200);
		assertFalse(StopWatch.equals(s1, s2));
	}

	@Test
	public void testEqualsStopWatchFalseMilli() {
		StopWatch s1 = new StopWatch(40, 30, 223);
		StopWatch s2 = new StopWatch(40, 30, 222);
		assertFalse(StopWatch.equals(s1, s2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEqualsStopWatchFirstNull() {
		StopWatch s1 = null;
		StopWatch s2 = new StopWatch(2, 31, 555);
		StopWatch.equals(s1, s2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEqualsStopWatchSecondNull() {
		StopWatch s1 = new StopWatch(15, 32, 544);
		StopWatch s2 = null;
		StopWatch.equals(s1, s2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEqualsStopWatchAllNull() {
		StopWatch s1 = null;
		StopWatch s2 = null;
		StopWatch.equals(s1, s2);
	}

	//Equals Object Tests
	@Test
	public void testEqualsObjectTrue() {
		StopWatch s1 = new StopWatch(5, 59, 300);
		StopWatch s2 = new StopWatch(5, 59, 300);
		assertTrue(s1.equals(s2));
	}

	@Test
	public void testEqualsObjectFalseMilli() {
		StopWatch s1 = new StopWatch(8, 22, 2);
		StopWatch s2 = new StopWatch(8, 22, 3);
		assertFalse(s1.equals(s2));
	}

	@Test
	public void testEqualsObjectFalseSeconds() {
		StopWatch s1 = new StopWatch(9, 1, 72);
		StopWatch s2 = new StopWatch(9, 2, 72);
		assertFalse(s1.equals(s2));
	}

	@Test
	public void testEqualsObjectFalseMinutes() {
		StopWatch s1 = new StopWatch(10, 11, 72);
		StopWatch s2 = new StopWatch(11, 11, 72);
		assertFalse(s1.equals(s2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEqualsObjectNull() {
		StopWatch s1 = new StopWatch(1, 31, 21);
		StopWatch s2 = null;
		s1.equals(s2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEqualsObjectNotStopWatch() {
		StopWatch s = new StopWatch(3, 1, 500);
		Object o = new Object();
		s.equals(o);
	}

	//Compare to Tests
	@Test
	public void testCompareToEquals() {
		StopWatch s1 = new StopWatch (9, 1, 300);
		StopWatch s2 = new StopWatch (9, 1, 300);
		assertEquals(0, s1.compareTo(s2));
	}

	@Test
	public void testCompareToBiggerMinutes(){
		StopWatch s1 = new StopWatch(3, 26, 208);
		StopWatch s2 = new StopWatch (2, 26, 208);
		assertEquals(1, s1.compareTo(s2));
	}

	@Test
	public void testCompareToBiggerSeconds(){
		StopWatch s1 = new StopWatch(6, 21, 999);
		StopWatch s2 = new StopWatch(6,20,999);
		assertEquals(1, s1.compareTo(s2));
	}

	@Test
	public void testCompareToBiggerMilli(){
		StopWatch s1 = new StopWatch(5, 5, 5);
		StopWatch s2 = new StopWatch(5,5,4);
		assertEquals(1,s1.compareTo(s2));
	}

	@Test
	public void testCompareToSmallerMinutes(){
		StopWatch s1 = new StopWatch(9, 11, 1);
		StopWatch s2 = new StopWatch(10, 11, 1);
		assertEquals(-1, s1.compareTo(s2));
	}

	@Test
	public void testCompareToSmallerSeconds(){
		StopWatch s1 = new StopWatch(1,27,67);
		StopWatch s2 = new StopWatch(1,28, 67);
		assertEquals(-1, s1.compareTo(s2));
	}

	@Test
	public void testCompareToSmallerMilli(){
		StopWatch s1 = new StopWatch(2,35, 255);
		StopWatch s2 = new StopWatch(2,35,256);
		assertEquals(-1, s1.compareTo(s2));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testCompareToNullStopWatch(){
		StopWatch s1 = new StopWatch(4, 5, 6);
		StopWatch s2 = null;
		s1.compareTo(s2);
	}

	//toString tests
	@Test
	public void testToString0(){
		StopWatch s = new StopWatch(0,0,0);
		assertEquals("0:00:000", s.toString());
	}

	@Test
	public void testToStringMinutes() {
		StopWatch s = new StopWatch(999999999, 0,0);
		assertEquals("999999999:00:000", s.toString());
	}

	@Test
	public void testToString2DigitBigSeconds(){
		StopWatch s = new StopWatch(59, 0);
		assertEquals("0:59:000", s.toString());
	}

	@Test
	public void testToString1DigitBigSeconds(){
		StopWatch s = new StopWatch (9, 0);
		assertEquals("0:09:000", s.toString());
	}

	@Test
	public void testToString2DigitSmallSeconds(){
		StopWatch s = new StopWatch(10, 0);
		assertEquals("0:10:000", s.toString());
	}

	@Test
	public void testToString3DigitBigMilli(){
		StopWatch s = new StopWatch(999);
		assertEquals("0:00:999", s.toString());
	}

	@Test
	public void testToString3DigitSmallMilli(){
		StopWatch s = new StopWatch(100);
		assertEquals("0:00:100", s.toString());
	}

	@Test
	public void testToString2DigitBigMilli(){
		StopWatch s = new StopWatch (99);
		assertEquals("0:00:099", s.toString());
	}

	@Test
	public void testToString2DigitSmallMilli(){
		StopWatch s = new StopWatch(10);
		assertEquals("0:00:010", s.toString());
	}

	@Test
	public void testToString1DigitBigMilli(){
		StopWatch s = new StopWatch(9);
		assertEquals("0:00:009", s.toString());
	}

	//Add milliseconds Tests
	//TO DO: MAKE SUSPEND CHECKERS!!*******************************************************************************
	@Test
	public void testAdd0(){
		StopWatch s = new StopWatch (0,0,0);
		s.add(0);
		assertEquals(0, s.getMinutes());
		assertEquals(0, s.getSeconds());
		assertEquals(0, s.getMilliseconds());
	}

	@Test
	public void testAdd1Milli(){
		StopWatch s = new StopWatch(0,0,0);
		s.add(1);
		assertEquals(0, s.getMinutes());
		assertEquals(0, s.getSeconds());
		assertEquals(1, s.getMilliseconds());
	}

	@Test
	public void testAddBigMilli(){
		StopWatch s = new StopWatch(0,0,0);
		s.add(999);
		assertEquals(0, s.getMinutes());
		assertEquals(0, s.getSeconds());
		assertEquals(999, s.getMilliseconds());
	}

	@Test
	public void testAdd1Second(){
		StopWatch s = new StopWatch(0,0,0);
		s.add(1000);
		assertEquals(0, s.getMinutes());
		assertEquals(1, s.getSeconds());
		assertEquals(0, s.getMilliseconds());
	}

	@Test
	public void testAddBigSeconds(){
		StopWatch s = new StopWatch(0, 0, 0);
		s.add(59000);
		assertEquals(0, s.getMinutes());
		assertEquals(59, s.getSeconds());
		assertEquals(0, s.getMilliseconds());
	}

	@Test
	public void testAdd1Minute(){
		StopWatch s = new StopWatch(0,0,0);
		s.add(60000);
		assertEquals(1, s.getMinutes());
		assertEquals(0, s.getSeconds());
		assertEquals(0, s.getMilliseconds());
	}

	@Test
	public void testAddMilliEvenRollover(){
		StopWatch s = new StopWatch(0, 1, 980);
		s.add(20);
		assertEquals(0, s.getMinutes());
		assertEquals(2, s.getSeconds());
		assertEquals(0, s.getMilliseconds());
	}

	@Test
	public void testAddMilliRemainsRollover(){
		StopWatch s = new StopWatch(0, 1, 989);
		s.add(20);
		assertEquals(0, s.getMinutes());
		assertEquals(2, s.getSeconds());
		assertEquals(9, s.getMilliseconds());
	}

	@Test
	public void testAddSecondEvenRollover(){
		StopWatch s = new StopWatch (1, 10, 30);
		s.add(50000);
		assertEquals(2, s.getMinutes());
		assertEquals(0, s.getSeconds());
		assertEquals(30, s.getMilliseconds());
	}

	@Test
	public void testAddSecondRemainsRollover(){
		StopWatch s = new StopWatch(1,13, 10);
		s.add(50000);
		assertEquals(2, s.getMinutes());
		assertEquals(3, s.getSeconds());
		assertEquals(10, s.getMilliseconds());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testAddNegInput(){
		StopWatch s = new StopWatch(2,3,4);
		s.add(-5);
	}

//	@Test
//	public void testAddMethod () {
//		StopWatch s1 = new StopWatch(5,59,300);
//		s1.add(2000);
//		assertEquals (s1.toString(),"6:01:300");
//
//		s1 = new StopWatch(5,59,300);
//		StopWatch s2 = new StopWatch(2,2,300);
//		s1.add(s2);
//		System.out.println (s1);
//		assertEquals (s1.toString(),"8:01:600");
//
//		for (int i = 0; i < 15000; i++)
//			s1.inc();
//		System.out.println (s1);
//		assertEquals (s1.toString(),"8:16:600");
//	}
//
//	@Test
//	public void testLoadSave () {
//		StopWatch s1 = new StopWatch(5,59,300);
//		StopWatch s2 = new StopWatch(5,59,300);
//
//		s1.save("file1");
//		s1 = new StopWatch();  // resets to zero
//
//		s1.load("file1");
//		assertTrue (s1.equals(s2));
//	}
//
//	@Test
//	public void testMutate () {
//		StopWatch s1 = new StopWatch(5,59,300);
//		StopWatch s2 = new StopWatch(5,59,300);
//
//		StopWatch.setSuspend(true);
//		s1.add(1000);
//		assertTrue (s1.equals(s2));
//		StopWatch.setSuspend(false);
//		}
}
