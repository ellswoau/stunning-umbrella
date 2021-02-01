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
	@Test
	public void testAddInt0(){
		StopWatch s = new StopWatch (0,0,0);
		s.add(0);
		assertEquals(0, s.getMinutes());
		assertEquals(0, s.getSeconds());
		assertEquals(0, s.getMilliseconds());
	}

	@Test
	public void testAddInt1Milli(){
		StopWatch s = new StopWatch(0,0,0);
		s.add(1);
		assertEquals(0, s.getMinutes());
		assertEquals(0, s.getSeconds());
		assertEquals(1, s.getMilliseconds());
	}

	@Test
	public void testAddIntBigMilli(){
		StopWatch s = new StopWatch(0,0,0);
		s.add(999);
		assertEquals(0, s.getMinutes());
		assertEquals(0, s.getSeconds());
		assertEquals(999, s.getMilliseconds());
	}

	@Test
	public void testAddInt1Second(){
		StopWatch s = new StopWatch(0,0,0);
		s.add(1000);
		assertEquals(0, s.getMinutes());
		assertEquals(1, s.getSeconds());
		assertEquals(0, s.getMilliseconds());
	}

	@Test
	public void testAddIntBigSeconds(){
		StopWatch s = new StopWatch(0, 0, 0);
		s.add(59000);
		assertEquals(0, s.getMinutes());
		assertEquals(59, s.getSeconds());
		assertEquals(0, s.getMilliseconds());
	}

	@Test
	public void testAddInt1Minute(){
		StopWatch s = new StopWatch(0,0,0);
		s.add(60000);
		assertEquals(1, s.getMinutes());
		assertEquals(0, s.getSeconds());
		assertEquals(0, s.getMilliseconds());
	}

	@Test
	public void testAddIntMilliEvenRollover(){
		StopWatch s = new StopWatch(0, 1, 980);
		s.add(20);
		assertEquals(0, s.getMinutes());
		assertEquals(2, s.getSeconds());
		assertEquals(0, s.getMilliseconds());
	}

	@Test
	public void testAddIntMilliRemainsRollover(){
		StopWatch s = new StopWatch(0, 1, 989);
		s.add(20);
		assertEquals(0, s.getMinutes());
		assertEquals(2, s.getSeconds());
		assertEquals(9, s.getMilliseconds());
	}

	@Test
	public void testAddIntSecondEvenRollover(){
		StopWatch s = new StopWatch (1, 10, 30);
		s.add(50000);
		assertEquals(2, s.getMinutes());
		assertEquals(0, s.getSeconds());
		assertEquals(30, s.getMilliseconds());
	}

	@Test
	public void testAddIntSecondRemainsRollover(){
		StopWatch s = new StopWatch(1,13, 10);
		s.add(50000);
		assertEquals(2, s.getMinutes());
		assertEquals(3, s.getSeconds());
		assertEquals(10, s.getMilliseconds());
	}

	@Test
	public void testAddIntCascadeRollover(){
		StopWatch s = new StopWatch(5,59,950);
		s.add(1055);
		assertEquals(6, s.getMinutes());
		assertEquals(1, s.getSeconds());
		assertEquals(5, s.getMilliseconds());
	}

	@Test
	public void testAddIntSuspended(){
		StopWatch.setSuspend(true);
		StopWatch s = new StopWatch(0,0,0);
		s.add(300);
		StopWatch.setSuspend(false);

		assertEquals(0, s.getMinutes());
		assertEquals(0, s.getSeconds());
		assertEquals(0, s.getMilliseconds());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testAddIntNegInput(){
		StopWatch s = new StopWatch(2,3,4);
		s.add(-5);
	}

	//Add Stopwatch tests
	@Test
	public void testAddStopWatch0(){
		StopWatch s1 = new StopWatch(0,0,0);
		StopWatch s2 = new StopWatch(0,0,0);
		s1.add(s2);
		assertEquals(0, s1.getMinutes());
		assertEquals(0,s1.getSeconds());
		assertEquals(0, s1.getMilliseconds());
	}

	@Test
	public void testAddStopWatch1Milli(){
		StopWatch s1 = new StopWatch(0,0,0);
		StopWatch s2 = new StopWatch(0,0,1);
		s1.add(s2);
		assertEquals(0, s1.getMinutes());
		assertEquals(0, s1.getSeconds());
		assertEquals(1, s1.getMilliseconds());
	}

	@Test
	public void testAddStopWatchBigMilli(){
		StopWatch s1 = new StopWatch(0,0,0);
		StopWatch s2 = new StopWatch(0,0,999);
		s1.add(s2);
		assertEquals(0,s1.getMinutes());
		assertEquals(0, s1.getSeconds());
		assertEquals(999, s1.getMilliseconds());
	}

	@Test
	public void testAddStopWatch1Second(){
		StopWatch s1 = new StopWatch(0,0,0);
		StopWatch s2 = new StopWatch(0, 1, 0);
		s1.add(s2);
		assertEquals(0, s1.getMinutes());
		assertEquals(1, s1.getSeconds());
		assertEquals(0, s1.getMilliseconds());
	}

	@Test
	public void testAddStopWatchBigSecond(){
		StopWatch s1 = new StopWatch (0,0,0);
		StopWatch s2 = new StopWatch(0, 59, 0);
		s1.add(s2);
		assertEquals(0, s1.getMinutes());
		assertEquals(59, s1.getSeconds());
		assertEquals(0, s1.getMilliseconds());
	}

	@Test
	public void testAddStopWatch1Minute(){
		StopWatch s1 = new StopWatch(0,0,0);
		StopWatch s2 = new StopWatch (1, 0, 0);
		s1.add(s2);
		assertEquals(1, s1.getMinutes());
		assertEquals(0, s1.getSeconds());
		assertEquals(0, s1.getMilliseconds());
	}

	@Test
	public void testAddStopWatchMilliEvenRollover(){
		StopWatch s1 = new StopWatch(3,2,500);
		StopWatch s2 = new StopWatch(0,0,500);
		s1.add(s2);
		assertEquals(3, s1.getMinutes());
		assertEquals(3, s1.getSeconds());
		assertEquals(0, s1.getMilliseconds());
	}

	@Test
	public void testAddStopWatchMilliRemainsRollover(){
		StopWatch s1 = new StopWatch(3,2,550);
		StopWatch s2 = new StopWatch(0,0,500);
		s1.add(s2);
		assertEquals(3, s1.getMinutes());
		assertEquals(3, s1.getSeconds());
		assertEquals(50, s1.getMilliseconds());
	}

	@Test
	public void testAddStopWatchSecondEvenRollover(){
		StopWatch s1 = new StopWatch(3, 50, 100);
		StopWatch s2 = new StopWatch(0, 10, 0);
		s1.add(s2);
		assertEquals(4, s1.getMinutes());
		assertEquals(0, s1.getSeconds());
		assertEquals(100, s1.getMilliseconds());
	}

	@Test
	public void testAddStopWatchSecondRemainsRollover(){
		StopWatch s1 = new StopWatch(3, 55, 100);
		StopWatch s2 = new StopWatch(0, 10, 0);
		s1.add(s2);
		assertEquals(4, s1.getMinutes());
		assertEquals(5, s1.getSeconds());
		assertEquals(100, s1.getMilliseconds());
	}

	@Test
	public void testAddStopWatchAllChange(){
		StopWatch s1 = new StopWatch(3, 55, 950);
		StopWatch s2 = new StopWatch(2, 11, 100);
		s1.add(s2);
		assertEquals(6, s1.getMinutes());
		assertEquals(7, s1.getSeconds());
		assertEquals(50, s1.getMilliseconds());
	}

	@Test
	public void testAddStopWatchSuspended(){
		StopWatch s1 = new StopWatch (0,0,0);
		StopWatch s2 = new StopWatch(4,5,6);
		StopWatch.setSuspend(true);
		s1.add(s2);
		StopWatch.setSuspend(false);
		assertEquals(0, s1.getMinutes());
		assertEquals(0, s1.getSeconds());
		assertEquals(0, s1.getMilliseconds());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testAddStopWatchNullInput(){
		StopWatch s1 = new StopWatch(5, 3, 5);
		StopWatch s2 = null;
		s1.add(s2);
	}

	// Sub Int tests
	@Test
	public void testSubInt0(){
		StopWatch s = new StopWatch(2,4,5);
		s.sub(0);
		assertEquals(2, s.getMinutes());
		assertEquals(4, s.getSeconds());
		assertEquals(5, s.getMilliseconds());
	}

	@Test
	public void testSubInt1Milli(){
		StopWatch s = new StopWatch(2,5,1);
		s.sub(1);
		assertEquals(2, s.getMinutes());
		assertEquals(5, s.getSeconds());
		assertEquals(0, s.getMilliseconds());
	}

	@Test
	public void testSubInt1Second(){
		StopWatch s = new StopWatch(2, 1, 4);
		s.sub(1000);
		assertEquals(2, s.getMinutes());
		assertEquals(0, s.getSeconds());
		assertEquals(4, s.getMilliseconds());
	}

	@Test
	public void testSubInt1Minute(){
		StopWatch s = new StopWatch(1,5,4);
		s.sub(60000);
		assertEquals(0,s.getMinutes());
		assertEquals(5, s.getSeconds());
		assertEquals(4, s.getMilliseconds());
	}

	@Test
	public void testSubIntMilliRollover(){
		StopWatch s = new StopWatch(3, 3, 50);
		s.sub(51);
		assertEquals(3, s.getMinutes());
		assertEquals(2, s.getSeconds());
		assertEquals(999, s.getMilliseconds());
	}

	@Test
	public void testSubIntSecondRollover(){
		StopWatch s = new StopWatch(3, 1, 50);
		s.sub(2000);
		assertEquals(2, s.getMinutes());
		assertEquals(59, s.getSeconds());
		assertEquals(50, s.getMilliseconds());
	}

	@Test
	public void testSubIntDoubleRollover(){
		StopWatch s = new StopWatch(3, 2, 50);
		s.sub(2051);
		assertEquals(2, s.getMinutes());
		assertEquals(59, s.getSeconds());
		assertEquals(999, s.getMilliseconds());
	}

	@Test
	public void testSubIntSuspended(){
		StopWatch s = new StopWatch(0,0,1);
		StopWatch.setSuspend(true);
		s.sub(1);
		StopWatch.setSuspend(false);
		assertEquals(0, s.getMinutes());
		assertEquals(0, s.getSeconds());
		assertEquals(1,s.getMilliseconds());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSubIntNegInput(){
		StopWatch s = new StopWatch(5,3,5);
		s.sub(-5);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSubIntNegResult(){
		StopWatch s = new StopWatch (0,4,50);
		s.sub(4051);
	}

	//sub StopWatch tests
	@Test
	public void testSubStopWatch0(){
		StopWatch s1 = new StopWatch(0,0,0);
		StopWatch s2 = new StopWatch(0,0,0);
		s1.sub(s2);
		assertEquals(0, s1.getMinutes());
		assertEquals(0, s1.getSeconds());
		assertEquals(0, s1.getMilliseconds());
	}

	@Test
	public void testSubStopWatch1Milli(){
		StopWatch s1 = new StopWatch(5,4,3);
		StopWatch s2 = new StopWatch(0,0,1);
		s1.sub(s2);
		assertEquals(5, s1.getMinutes());
		assertEquals(4, s1.getSeconds());
		assertEquals(2, s1.getMilliseconds());
	}

	@Test
	public void testSubStopWatch1Second(){
		StopWatch s1 = new StopWatch(5,4,2);
		StopWatch s2 = new StopWatch(0,1,0);
		s1.sub(s2);
		assertEquals(5, s1.getMinutes());
		assertEquals(3, s1.getSeconds());
		assertEquals(2, s1.getMilliseconds());
	}

	@Test
	public void testSubStopWatch1Minute(){
		StopWatch s1 = new StopWatch(6, 4, 3);
		StopWatch s2 = new StopWatch(1, 0,0);
		s1.sub(s2);
		assertEquals(5, s1.getMinutes());
		assertEquals(4, s1.getSeconds());
		assertEquals(3, s1.getMilliseconds());
	}

	@Test
	public void testSubStopWatchMilliRollover(){
		StopWatch s1 = new StopWatch(5,5,300);
		StopWatch s2 = new StopWatch(0, 0,301);
		s1.sub(s2);
		assertEquals(5, s1.getMinutes());
		assertEquals(4, s1.getSeconds());
		assertEquals(999, s1.getMilliseconds());
	}

	@Test
	public void testSubStopWatchSecondRollover(){
		StopWatch s1 = new StopWatch(5, 5, 300);
		StopWatch s2 = new StopWatch(0, 6, 0);
		s1.sub(s2);
		assertEquals(4, s1.getMinutes());
		assertEquals(59, s1.getSeconds());
		assertEquals(300, s1.getMilliseconds());
	}

	@Test
	public void testSubStopWatchDoubleRollover(){
		StopWatch s1 = new StopWatch(4, 50, 300);
		StopWatch s2 = new StopWatch(0, 50, 301);
		s1.sub(s2);
		assertEquals(3, s1.getMinutes());
		assertEquals(59, s1.getSeconds());
		assertEquals(999, s1.getMilliseconds());
	}

	@Test
	public void testSubStopWatchSuspended(){
		StopWatch s1 = new StopWatch(4,5,6);
		StopWatch s2 = new StopWatch(0,0,1);
		StopWatch.setSuspend(true);
		s1.sub(s2);
		StopWatch.setSuspend(false);
		assertEquals(4, s1.getMinutes());
		assertEquals(5, s1.getSeconds());
		assertEquals(6, s1.getMilliseconds());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSubStopWatchNullInput(){
		StopWatch s1 = new StopWatch(3, 2, 1);
		StopWatch s2 = null;
		s1.sub(s2);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSubStopWatchBiggerInput(){
		StopWatch s1 = new StopWatch(3,2,1);
		StopWatch s2 = new StopWatch(3,2,2);
		s1.sub(s2);
	}

	//Inc Tests
	@Test
	public void testInc(){
		StopWatch s = new StopWatch(0,0,0);
		s.inc();
		assertEquals(0,s.getMinutes());
		assertEquals(0, s.getSeconds());
		assertEquals(1, s.getMilliseconds());
	}

	@Test
	public void testIncMilliRollover(){
		StopWatch s = new StopWatch(0,0,999);
		s.inc();
		assertEquals(0, s.getMinutes());
		assertEquals(1, s.getSeconds());
		assertEquals(0, s.getMilliseconds());
	}

	@Test
	public void testIncDoubleRollover(){
		StopWatch s = new StopWatch(0, 59, 999);
		s.inc();
		assertEquals(1, s.getMinutes());
		assertEquals(0, s.getSeconds());
		assertEquals(0, s.getMilliseconds());
	}

	@Test
	public void testIncSuspended(){
		StopWatch s = new StopWatch(0,0,0);
		StopWatch.setSuspend(true);
		s.inc();
		StopWatch.setSuspend(false);
		assertEquals(0, s.getMinutes());
		assertEquals(0, s.getSeconds());
		assertEquals(0, s.getMilliseconds());
	}

	//Dec Tests
	@Test
	public void testDec(){
		StopWatch s = new StopWatch(6,5,4);
		s.dec();
		assertEquals(6, s.getMinutes());
		assertEquals(5, s.getSeconds());
		assertEquals(3, s.getMilliseconds());
	}

	@Test
	public void testDecSecondRollover(){
		StopWatch s = new StopWatch(1,5,0);
		s.dec();
		assertEquals(1, s.getMinutes());
		assertEquals(4, s.getSeconds());
		assertEquals(999, s.getMilliseconds());
	}

	@Test
	public void testDecDoubleRollover(){
		StopWatch s = new StopWatch(5,0,0);
		s.dec();
		assertEquals(4, s.getMinutes());
		assertEquals(59, s.getSeconds());
		assertEquals(999, s.getMilliseconds());
	}

	@Test
	public void testDecSuspended(){
		StopWatch s = new StopWatch(0,0,2);
		StopWatch.setSuspend(true);
		s.dec();
		StopWatch.setSuspend(false);
		assertEquals(0, s.getMinutes());
		assertEquals(0, s.getSeconds());
		assertEquals(2, s.getMilliseconds());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testDecNegResult(){
		StopWatch s = new StopWatch(0,0,0);
		s.dec();
	}

	//set Minutes tests
	@Test
	public void testSetMinutes0(){
		StopWatch s = new StopWatch(1,1,1);
		s.setMinutes(0);
		assertEquals(0,s.getMinutes());
		assertEquals(1, s.getSeconds());
		assertEquals(1, s.getMilliseconds());
	}

	@Test
	public void testSetMinutesBig(){
		StopWatch s = new StopWatch(0,0,0);
		s.setMinutes(999999);
		assertEquals(999999, s.getMinutes());
		assertEquals(0, s.getSeconds());
		assertEquals(0, s.getMilliseconds());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSetMinutesNegInput(){
		StopWatch s = new StopWatch(0,0,0);
		s.setMinutes(-1);
	}

	//set Seconds tests
	@Test
	public void testSetSeconds0(){
		StopWatch s = new StopWatch(1,1,1);
		s.setSeconds(0);
		assertEquals(1,s.getMinutes());
		assertEquals(0, s.getSeconds());
		assertEquals(1,s.getMilliseconds());
	}

	@Test
	public void testSetSeconds(){
		StopWatch s = new StopWatch(0,0,0);
		s.setSeconds(59);
		assertEquals(0,s.getMinutes());
		assertEquals(59, s.getSeconds());
		assertEquals(0, s.getMilliseconds());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSetSecondsNegInput(){
		StopWatch s = new StopWatch(0,0,0);
		s.setSeconds(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetSecondLargeInput(){
		StopWatch s = new StopWatch(0,0,0);
		s.setSeconds(60);
	}

	//Set Milliseconds Test
	@Test
	public void testSetMilliseconds(){
		StopWatch s = new StopWatch(0,0,0);
		s.setMilliseconds(999);
		assertEquals(0, s.getMinutes());
		assertEquals(0, s.getSeconds());
		assertEquals(999, s.getMilliseconds());
	}

	@Test
	public void testSetMilliseconds0(){
		StopWatch s = new StopWatch(1,1,1);
		s.setMilliseconds(0);
		assertEquals(1,s.getMinutes());
		assertEquals(1,s.getSeconds());
		assertEquals(0, s.getMilliseconds());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSetMillisecondsBig(){
		StopWatch s = new StopWatch(0,0,0);
		s.setMilliseconds(1000);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetMillisecondsNegInput(){
		StopWatch s = new StopWatch(0,0,0);
		s.setMilliseconds(-1);
	}

	//Load/save tests
	@Test
	public void testLoadSave () {
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(3,4,5);
		s2.save("testLoadFile.txt");
		s1.load("testLoadFile.txt");
		assertEquals(3, s1.getMinutes());
		assertEquals(4, s1.getSeconds());
		assertEquals(5, s1.getMilliseconds());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testNullSaveFile(){
		StopWatch s = new StopWatch(0,0,0);
		String str = null;
		s.save(str);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmptyStringSaveFile(){
		StopWatch s = new StopWatch();
		s.save("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmptyStringLoadFile(){
		StopWatch s = new StopWatch();
		s.load("");
	}
	@Test(expected = IllegalArgumentException.class)
	public void testNullLoadFile(){
		StopWatch s = new StopWatch(0,0,0);
		String str = null;
		s.load(str);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWrongLoadFile(){
		StopWatch s = new StopWatch(0,0,0);
		s.load("test.txt");
	}
}
