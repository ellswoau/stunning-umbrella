package Project1;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestStopWatch {

/**
 *
 * The following are simple random JUnit test cases... After talking with your
 * instructor, create many, many more that shows that your code
 * is functioning correctly.
 *
 *
 * Prof says we are expected to have 80-100 unique test cases
 */

	// default constructor test
	@Test
	public void testDefaultConstructor() {
		StopWatch s = new StopWatch();
		assertEquals(0,s.getMinutes());
		assertEquals(0,s.getSeconds());
		assertEquals(0, s.getMilliseconds());
	}

	//3 Integer constructor tests
	@Test
	public void testConstructor3Parameters()
	{
		StopWatch s = new StopWatch(2,3,4);
		assertEquals(2,s.getMinutes());
		assertEquals(3, s.getSeconds());
		assertEquals(4, s.getMilliseconds());
	}

	@Test
	public void testConstructor3Parameters0() {
		StopWatch s = new StopWatch(0, 0, 0);
		assertEquals(0,s.getMinutes());
		assertEquals(0,s.getSeconds());
		assertEquals(0, s.getMilliseconds());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructor3ParametersXMinutes()
	{
		new StopWatch(-2, 3, 4);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructor3ParametersXSeconds()
	{
		new StopWatch(2, -3, 4);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructor3ParametersXMilliseconds()
	{
		new StopWatch(2, 3, -4);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructor3ParametersLMilliseconds(){
		new StopWatch(12, 3, 1000);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructor3ParametersLSeconds() {
		new StopWatch(12,60,14);
	}

	//2 Integer constructor tests
	@Test
	public void testConstructor2Parameters() {
		StopWatch s = new StopWatch(10, 300);
		assertEquals(0, s.getMinutes());
		assertEquals(10,s.getSeconds());
		assertEquals(300,s.getMilliseconds());
	}

	@Test
	public void testConstructor2Parameters0() {
		StopWatch s = new StopWatch(0,0);
		assertEquals(0,s.getMinutes());
		assertEquals(0,s.getSeconds());
		assertEquals(0, s.getMilliseconds());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructor2ParametersXSeconds(){
		new StopWatch(-1, 21);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructor2ParametersXMilliseconds() {
		new StopWatch(2, -1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructor2ParametersLSeconds(){
		new StopWatch (67, 12);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructor2ParametersLMilliseconds(){
		new StopWatch (5, 1000);
	}

	// 1 Integer constructor tests
	@Test
	public void testConstructor1Parameter(){
		StopWatch s = new StopWatch(30);
		assertEquals(0,s.getMinutes());
		assertEquals(0, s.getSeconds());
		assertEquals(30, s.getMilliseconds());
	}

	@Test
	public void testConstructor1Parameter0(){
		StopWatch s = new StopWatch(0);
		assertEquals(0,s.getMinutes());
		assertEquals(0,s.getSeconds());
		assertEquals(0, s.getMilliseconds());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructor1ParameterXMilliseconds() {
		new StopWatch(-1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructor1ParameterLMilliseconds(){
		new StopWatch(1000);
	}

	//String constructor tests
	@Test
	public void testStringConstructor3Input()
	{
		StopWatch s = new StopWatch("20:10:8");
		assertEquals(s.getMilliseconds(), 8);
		assertEquals(s.getSeconds(), 10);
		assertEquals(s.getMinutes(), 20);
	}

	@Test
	public void testStringConstructor2Input()
	{
		StopWatch s = new StopWatch("4:50");
		assertEquals(s.getMilliseconds(), 50);
		assertEquals(s.getSeconds(), 4);
		assertEquals(s.getMinutes(), 0);
	}

	@Test
	public void testStringConstructor1Input()
	{
		StopWatch s = new StopWatch("8");
		assertEquals(s.getMilliseconds(), 8);
		assertEquals(s.getSeconds(), 0);
		assertEquals(s.getMinutes(), 0);
	}

	@Test
	public void testStringConstructor0(){
		StopWatch s = new StopWatch ("0:0:0");
		assertEquals(s.getMinutes(), 0);
		assertEquals(s.getSeconds(), 0);
		assertEquals(s.getMilliseconds(), 0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testStringConstructorEmptyString() {
		new StopWatch("");
	}

	@Test (expected = IllegalArgumentException.class)
	public void testStringConstructorNullString(){
		String s = null;
		new StopWatch(s);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testNegDouble1Input() {
		new StopWatch("-59:23");

	}

	@Test (expected = IllegalArgumentException.class)
	public void testNegMinuteInput() {
		new StopWatch("-1:30:50");
	}


	@Test (expected = IllegalArgumentException.class)
	public void testNegDouble2aInput() {
		new StopWatch("2:-2");
	}

	@Test (expected = IllegalArgumentException.class)
	public void testLargeSecondInput() {
		new StopWatch("45:60:50");
	}

	@Test (expected = IllegalArgumentException.class)
	public void testLargeMillisecondInput(){
		new StopWatch("45:50:1000");
	}

	@Test (expected = IllegalArgumentException.class)
	public void testStringConstructorExtraColon(){
		new StopWatch("50:45:40:35");
	}

	@Test (expected = IllegalArgumentException.class)
	public void testAlphaInput() {
		new StopWatch("a");
	}

	//StopWatch Constructor Tests
	@Test
	public void testStopWatchConstructor(){
		StopWatch s = new StopWatch (4, 5, 6);
		StopWatch s1 = new StopWatch (s);
		assertEquals(4, s1.getMinutes());
		assertEquals(5, s1.getSeconds());
		assertEquals(6, s1.getMilliseconds());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testStopWatchConstructorNull(){
		StopWatch s = null;
		new StopWatch(s);
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
//	public void testToString() {
//		StopWatch s = new StopWatch(5,10,300);
//		assertEquals(s.toString(),"5:10:300");
//
//		s = new StopWatch("20:10:8");
//		assertEquals(s.toString(),"20:10:008");
//
//		s = new StopWatch("20:8");
//		assertEquals(s.toString(),"0:20:008");
//
//		s = new StopWatch("8");
//		assertEquals(s.toString(),"0:00:008");
//
//	}
//
//	@Test
//	public void testEqual () {
//		StopWatch s1 = new StopWatch(5,59,300);
//		StopWatch s2 = new StopWatch(6,01,200);
//		StopWatch s3 = new StopWatch(5,50,200);
//		StopWatch s4 = new StopWatch(5,59,300);
//
//		assertFalse(s1.equals(s2));
//		assertTrue (s1.equals(s4));
//
//		assertTrue (s2.compareTo(s1) > 0);
//		assertTrue (s3.compareTo(s1) < 0);
//		assertTrue (s1.compareTo(s4) == 0);
//
//	}
//	@Test
//	public void testCompareTo () {
//		StopWatch s1 = new StopWatch(5,59,300);
//		StopWatch s2 = new StopWatch(6,01,200);
//		StopWatch s3 = new StopWatch(5,50,200);
//		StopWatch s4 = new StopWatch(5,59,300);
//
//		assertFalse(s1.equals(s2));
//		assertTrue (s1.equals(s4));
//
//		assertTrue (s2.compareTo(s1) > 0);
//		assertTrue (s3.compareTo(s1) < 0);
//		assertTrue (s1.compareTo(s4) == 0);
//
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
//
//	@Test
//	public void equalsTest() {
//		StopWatch s1 = new StopWatch(5,59,300);
//		StopWatch s2 = new StopWatch(5,59,300);
//
//		assertEquals(s1, s2);
//	}
}
