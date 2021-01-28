package Project1;

import java.io.*;
import java.util.Scanner;

/*****************************************************************
 ********   class description...
 *
 * THIS IS JUST STARTING CODE, MUCH HAS TO BE CHANGED.
 *
 * @author Austin Ellsworth & Kit Bazner
 * @version 01/25/2021
 */

public class StopWatch  {


	/**
	 * This holds minutes for our stopwatch
	 */
	private int minutes;


	private int seconds;
	private int milliseconds;

	private static boolean suspend = false;


	/**
	 * default constructor that sets the StopWatch to zero
	 */
	public StopWatch() {
		//setting default stopwatch to zero
		this.minutes = 0;
		this.seconds = 0;
		this.milliseconds = 0;
	}

	/******************************************************************
	 *
	 *  A constructor that accepts a string as a parameter with the
	 *  following format: "1:21:300"� where 1 indicates minutes, 21
	 *  indicates seconds,  and 300 indicates milliseconds.  OR
	 *  the format "15:200"� where the 15 indicates seconds, and
	 *  200 indicates milliseconds, OR the format “300” where
	 *  300 indicates milliseconds
	 *
	 * @param startTime is the input string the represents
	 * the starting time
	 * @throws IllegalArgumentException when the input string
	 * does not match the proper format (see description above)
	 */

	public StopWatch(String startTime) {
		if (startTime == null)
			throw new IllegalArgumentException();
		minutes = 0;
		seconds = 0;
		milliseconds = 0;

		String[] s = startTime.split(":");

		if (s.length == 3) {
			minutes = Integer.parseInt(s[0]);
			seconds = Integer.parseInt(s[1]);
			milliseconds = Integer.parseInt(s[2]);
		}
		else if (s.length == 2) {
			seconds = Integer.parseInt(s[0]);
			milliseconds = Integer.parseInt(s[1]);
		}
		else if (s.length == 1) {
			milliseconds = Integer.parseInt(s[0]);
		}
		else
			throw new IllegalArgumentException();

		if(minutes < 0 || seconds < 0 || seconds > 59  || milliseconds < 0 || milliseconds > 999)
			throw new IllegalArgumentException();
		//TO DO: finish code
	}

	public StopWatch(int minutes, int seconds, int milliseconds) {
		if (minutes < 0)
			throw new IllegalArgumentException("constuctor with 3 params");

		if (seconds < 0 || seconds > 59)
			throw new IllegalArgumentException();

		//TO DO: finish code - check milliseconds
		if (milliseconds < 0 || milliseconds > 999)
			throw new IllegalArgumentException();
		//TO DO: assign input parameters to instance variables
		this.minutes = minutes;
		this.seconds = seconds;
		this.milliseconds = milliseconds;


	}

	public StopWatch(StopWatch stopWatch) {
		if (stopWatch == null)
			throw new IllegalArgumentException();

		this.minutes = stopWatch.minutes;
		this.seconds = stopWatch.seconds;
		this.milliseconds = stopWatch.milliseconds;
	}

	public StopWatch(int seconds, int milliseconds) {
		//TO DO:
		this.minutes = 0;
		if (seconds < 0 || seconds > 59 || milliseconds < 0 || milliseconds > 999)
			throw new IllegalArgumentException();
		this.seconds = seconds;
		this.milliseconds = milliseconds;

	}


	public StopWatch(int milliseconds) {
		// TO DO:
		this.minutes = 0;
		this.seconds = 0;
		if (milliseconds < 0 || milliseconds > 59)
			throw new IllegalArgumentException();
		this.milliseconds = milliseconds;
	}

	public static boolean equals(StopWatch stopWatch1, StopWatch stopWatch2) {
		//TO DO:
		return false; // place holder
	}

	public boolean equals(Object object) {
		//TO DO:
		return false; // place holder

	}

	public int compareTo(StopWatch other) {
		if (other == null)
			throw new IllegalArgumentException();

		//TO DO: finish logic
		return 0; // place holder

	}

	/*****************************************************************
	 * Method that converts StopWatch object to milliseconds.
	 *****************************************************************/
	private static int convertToMilli (StopWatch stopWatch) {
		if (stopWatch == null)
			throw new IllegalArgumentException();

		//TO DO: convert the stopWatch passed as input
		//TO DO: parameter into milliseconds
		int tmpMilliseconds;
		tmpMilliseconds = stopWatch.milliseconds;
		tmpMilliseconds += (stopWatch.seconds * 1000);
		tmpMilliseconds += (stopWatch.minutes * 60000);
		return tmpMilliseconds;

	}

	private void convertToStopWatch (int tempMilliseconds) {
		minutes = tempMilliseconds / 60000;
		tempMilliseconds %= 60000;

		seconds = tempMilliseconds / 1000;
		tempMilliseconds %= 1000;
		milliseconds = tempMilliseconds;
	}

	/*****************************************************************
	 * Method uses for loop to run inc method n (milliseconds) number
	 * of times.
	 *****************************************************************/
	public void add(int milliseconds) {
		if (!suspend) {
			//TO DO: finish logic
			for (int i = 0; i < milliseconds; i++) {
				this.inc();
			}
		}
	}
	/*****************************************************************
	 * Method uses for loop to run dec method n (milliseconds) number
	 * of times.
	 *****************************************************************/
	public void sub(int milliseconds) {
		//TO DO: finish logic
		for (int i = 0; i < milliseconds; i++) {
		this.dec();
		}

	}

	public void add(StopWatch stopWatch) {
		//TO DO: finish logic

	}

	public void sub(StopWatch stopWatch) {
		//TO DO: finish logic

	}

	/*****************************************************************
	 * Method that increases the StopWatch object by 1 millisecond.
	 * Calls the convertToMilli method, adds one, then updates object
	 * variables.
	 *****************************************************************/
	public void inc() {
		//TO DO: finish logic
		int tmpMilliseconds = convertToMilli(this);
		tmpMilliseconds++;

		this.minutes = tmpMilliseconds / 60000;
		tmpMilliseconds %= 60000;
		this.seconds = tmpMilliseconds / 1000;
		tmpMilliseconds %= 1000;
		this.milliseconds = tmpMilliseconds;
	}

	/*****************************************************************
	 * Method that decreases the StopWatch object by 1 millisecond.
	 * Calls the convertToMilli method, subtracts one, then updates
	 * object variables.
	 *****************************************************************/
	public void dec() {
		//TO DO: finish logic
		int tmpMilliseconds = convertToMilli(this);
		tmpMilliseconds--;

		minutes = tmpMilliseconds / 60000;
		tmpMilliseconds %= 60000;
		seconds = tmpMilliseconds / 1000;
		tmpMilliseconds %= 1000;
		milliseconds = tmpMilliseconds;
	}

	/*****************************************************************
	 * Method concats minutes, seconds, milliseconds variables into
	 * temporary string variable and adds leading zeros based on the
	 * values of seconds and milliseconds. Returns a string.
	 *****************************************************************/
	public String toString() {
		//TO DO: finish logic
		String outputString = "";

		outputString += "" + minutes + ":";

		if (seconds < 10) {
			outputString += "0" + seconds + ":";
		}
		else {
			outputString += "" + seconds + ":";
		}

		if (milliseconds < 10) {
			outputString += "00" + milliseconds;
		}
		else if (milliseconds < 100 ) {
			outputString += "0" + milliseconds;
		}
		else if (milliseconds >= 1000) {
			outputString = "" + milliseconds;
		}

		return outputString;

	}

	public void save(String filename) {
		if (filename == null)
			throw new IllegalArgumentException();

		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));

			//TO DO: finish - write fields to file

			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public void load(String filename)  {
		if (filename == null)
			throw new IllegalArgumentException();

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(filename));

			//TO DO: read fields into instance variables

		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException();
		}

	}

	public static void setSuspend(boolean suspend) {
		//TO DO: finish logic
	}

	public static boolean isSuspended() {
		//TO DO: finish logic
		return false; // place holder
	}

	public int getMinutes() {
		//TO DO: finish logic
		return this.minutes;

		//return 0; // place holder

	}

	public void setMinutes(int minutes) {
		//TO DO: finish logic
		if (minutes < 0)
			throw new IllegalArgumentException();
		this.minutes = minutes;
	}

	/*****************************************************************
	 * Method multiplies minutes by 60, adds to seconds, and returns
	 * the temp variable for total number of seconds.
	 *
	 * !!!Ask professor if these should return only the seconds variable
	 * or the TOTAL number of seconds???
	 *****************************************************************/
	public int getSeconds() {
		//TO DO: finish logic
		int tmpSeconds = 0;
		tmpSeconds += seconds;
		tmpSeconds += (minutes * 60);
		return tmpSeconds;

		//return 0; // place holder

	}

	public void setSeconds(int seconds) {
		//TO DO: finish logic
		if (seconds < 0 || seconds > 59)
			throw new IllegalArgumentException();
		this.seconds = seconds;
	}

	public int getMilliseconds() {
		//TO DO: finish logic
		return this.milliseconds;

		//return 0; // place holder

	}

	public void setMilliseconds(int milliseconds) {
		//TO DO: finish logic
		if (milliseconds < 0 || milliseconds > 999)
			throw new IllegalArgumentException();
		this.milliseconds = milliseconds;
	}

}