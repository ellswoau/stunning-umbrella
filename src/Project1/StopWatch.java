package Project1;

import java.io.*;
import java.util.Scanner;

/*****************************************************************
 ********
 *
 * A set of methods that create and manipulate a stopwatch that
 * keeps track of minutes, seconds, and milliseconds.
 *
 * @author Austin Ellsworth & Kit Bazner
 * @version 02/02/2021
 */

public class StopWatch  {


	/**Stores current minutes on stopwatch*/
	private int minutes;

	/**Stores current seconds on stopwatch*/
	private int seconds;

	/**Stores current milliseconds on stopwatch*/
	private int milliseconds;

	/** Stores whether the stopwatch is suspended or not*/
	private static boolean suspend = false;


	/*****************************************************************
	 * Default constructor that sets stopwatch object variables to zero.
	 *****************************************************************/
	public StopWatch() {
		this.minutes = 0;
		this.seconds = 0;
		this.milliseconds = 0;
	}

	/******************************************************************
	 *  A constructor that accepts a string as a parameter with the
	 *  following format: "1:21:300"� where 1 indicates minutes, 21
	 *  indicates seconds,  and 300 indicates milliseconds.  OR
	 *  the format "15:200"� where the 15 indicates seconds, and
	 *  200 indicates milliseconds, OR the format “300” where
	 *  300 indicates milliseconds.
	 *
	 * @param startTime is the input string the represents
	 * the starting time.
	 * @throws IllegalArgumentException when the input string
	 * does not match the proper format (see description above).
	 */

	public StopWatch(String startTime) {
		if (startTime == null)
			throw new IllegalArgumentException();
		int minutes = 0;
		int seconds = 0;
		int milliseconds = 0;

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

		if(minutes < 0 || seconds < 0 || seconds > 59  || milliseconds < 0 || milliseconds > 999) {
			throw new IllegalArgumentException();
		}
		this.minutes = minutes;
		this.seconds = seconds;
		this.milliseconds = milliseconds;
	}

	/*****************************************************************
	 * Constructor for stopwatch object using integer inputs for minutes
	 * seconds and milliseconds.
	 *
	 * @param minutes an integer representing the number of minutes the
	 * stopwatch will start with.
	 * @param seconds an integer representing the number of seconds the
	 * stopwatch will start with.
	 * @param milliseconds an integer representing the number of
	 * milliseconds the stopwatch will start with.
	 * @throws IllegalArgumentException throws when parameters are
	 * negative, seconds are above 59, or milliseconds are above 999.
	 *****************************************************************/
	public StopWatch(int minutes, int seconds, int milliseconds) {
		if (minutes < 0) {
			throw new IllegalArgumentException("constructor with 3 params");
		}
		if (seconds < 0 || seconds > 59) {
			throw new IllegalArgumentException();
		}
		if (milliseconds < 0 || milliseconds > 999) {
			throw new IllegalArgumentException();
		}
		this.minutes = minutes;
		this.seconds = seconds;
		this.milliseconds = milliseconds;


	}

	/*****************************************************************
	 * Constructor for stopwatch object using seconds and milliseconds.
	 *
	 * @param seconds an integer representing the number of seconds the
	 * stopwatch will start with.
	 * @param milliseconds an integer representing the number of
	 * milliseconds the stopwatch will start with.
	 * @throws IllegalArgumentException when seconds are not between 0
	 * and 59, or when milliseconds are not between 0 and 999.
	 *****************************************************************/
	public StopWatch(int seconds, int milliseconds) {
		this.minutes = 0;
		if (seconds < 0 || seconds > 59 || milliseconds < 0 || milliseconds > 999) {
			throw new IllegalArgumentException();
		}
		this.seconds = seconds;
		this.milliseconds = milliseconds;

	}


	/*****************************************************************
	 * Constructor for stopwatch object using only milliseconds.
	 *
	 * @param milliseconds an integer representing the number of milliseconds
	 * the stopwatch will start with.
	 * @throws IllegalArgumentException when value is not in valid range.
	 *****************************************************************/
	public StopWatch(int milliseconds) {
		this.minutes = 0;
		this.seconds = 0;

		if (milliseconds < 0 || milliseconds > 999) {
			throw new IllegalArgumentException();
		}
		this.milliseconds = milliseconds;
	}

	/******************************************************************
	 * Constructor for stopwatch object using another stopwatch object.
	 *
	 * @param stopWatch a stopwatch object to construct new stopwatch.
	 * @throws IllegalArgumentException thrown when given parameter is null.
	 ******************************************************************/
	public StopWatch(StopWatch stopWatch) {
		if (stopWatch == null) {
			throw new IllegalArgumentException();
		}
		this.minutes = stopWatch.minutes;
		this.seconds = stopWatch.seconds;
		this.milliseconds = stopWatch.milliseconds;
	}

	/*****************************************************************
	 * Equals method that compares stopwatches by calling getters.
	 *
	 * @param stopWatch1 a stopwatch object to be compared.
	 * @param stopWatch2 a second stopwatch object to be compared.
	 * @throws IllegalArgumentException thrown when parameters are null.
	 *****************************************************************/
	public static boolean equals(StopWatch stopWatch1, StopWatch stopWatch2) {
		if (stopWatch1 == null || stopWatch2 == null)
			throw new IllegalArgumentException();
		return (stopWatch1.getMilliseconds() == stopWatch2.getMilliseconds()) && (stopWatch1.getSeconds() == stopWatch2.getSeconds())
				&& (stopWatch1.getMinutes() == stopWatch2.getMinutes());
	}

	/*****************************************************************
	 * Method that compares stopwatch objects using instanceof.
	 *
	 * @param other an object that is to be compared with stopwatch.
	 * @throws IllegalArgumentException throws when other is null or
	 * not an instance of stopwatch.
	 *****************************************************************/
	public boolean equals(Object other) {
		if (other == null)
			throw new IllegalArgumentException();
		if (other instanceof StopWatch) {
			StopWatch s = (StopWatch) other;
			return (s.getMilliseconds() == this.milliseconds && s.getSeconds() == this.seconds && s.getMinutes() == this.minutes);
		}
		else
			throw new IllegalArgumentException();
	}


	/*****************************************************************
	 * A method that returns 1 if “this” StopWatch object is greater
	 * than the other StopWatch object;
	 * returns -1 if the “this” StopWatch object is less
	 * than the other StopWatch;
	 * returns 0 if the “this” StopWatch object is equal
	 * to the other StopWatch object.
	 *
	 * @param other a stopwatch to compare to current stopwatch.
	 * @throws IllegalArgumentException throws when other is null.
	 *****************************************************************/
	public int compareTo(StopWatch other) {
		if (other == null)
			throw new IllegalArgumentException();

		if (this.minutes > other.getMinutes())
			return 1;
		if (this.minutes < other.getMinutes())
			return -1;

		if (this.seconds > other.getSeconds())
			return 1;
		if (this.seconds < other.getSeconds())
			return -1;

		if (this.milliseconds > other.getMilliseconds())
			return 1;
		if (this.milliseconds < other.getMilliseconds())
			return -1;

		return 0;

	}

	/*****************************************************************
	 * Method that converts StopWatch object to milliseconds.
	 *
	 * @param stopWatch a stopwatch object to convert to milliseconds.
	 * @throws IllegalArgumentException throws when stopwatch is null.
	 *****************************************************************/
	private static int convertToMilli (StopWatch stopWatch) {
		if (stopWatch == null)
			throw new IllegalArgumentException();

		int tmpMilliseconds;
		tmpMilliseconds = stopWatch.milliseconds;
		tmpMilliseconds += (stopWatch.seconds * 1000);
		tmpMilliseconds += (stopWatch.minutes * 60000);
		return tmpMilliseconds;

	}

	/*****************************************************************
	 * Method uses for loop to run inc method n (milliseconds) number
	 * of times.
	 *
	 * @param milliseconds the number of milliseconds to be added.
	 * @throws IllegalArgumentException  throws when milliseconds are negative.
	 *****************************************************************/
	public void add(int milliseconds) {
		if (!isSuspended()) {
			if (milliseconds < 0)
				throw new IllegalArgumentException();
			if (!suspend) {
				for (int i = 0; i < milliseconds; i++) {
					this.inc();
				}
			}
		}
	}

	/*****************************************************************
	 * Method uses for loop to run dec method n (milliseconds) number
	 * of times.
	 *
	 * @param milliseconds the number of milliseconds to be subtracted.
	 * @throws IllegalArgumentException throws when milliseconds are negative.
	 *****************************************************************/
	public void sub(int milliseconds) {
		if (!isSuspended()) {
			if (milliseconds < 0)
				throw new IllegalArgumentException();
			for (int i = 0; i < milliseconds; i++) {
				this.dec();
			}
		}

	}


	/*****************************************************************
	 * Method to add two stopwatches together, converts second stopwatch
	 * object to milliseconds then loops the inc method.
	 *
	 * @param stopWatch a stopwatch object to add to.
	 * @throws IllegalArgumentException throws when stopwatch is null.
	 *****************************************************************/
	public void add(StopWatch stopWatch) {
		if (stopWatch == null)
			throw new IllegalArgumentException();
		if (!isSuspended()) {
			int tmpMilliseconds = convertToMilli(stopWatch);
			for (int i = 0; i < tmpMilliseconds; i++) {
				this.inc();
			}
		}

	}

	/*****************************************************************
	 * Method that subtracts stopwatch objects by converting the input
	 * stopwatch to milliseconds then loops the dec method.
	 *
	 * @param stopWatch is an input variable of a stopwatch object
	 * used to subtract from the parent stopwatch object.
	 * @throws IllegalArgumentException if the input variable object
	 * is null.
	 *****************************************************************/
	public void sub(StopWatch stopWatch) {
		if (stopWatch == null) {
			throw new IllegalArgumentException();
		}
		if (!isSuspended()) {
			int tmpMilliseconds = convertToMilli(stopWatch);
			for (int i = 0; i < tmpMilliseconds; i++) {
				this.dec();
			}

		}
	}

	/*****************************************************************
	 * Method that increases the StopWatch object by 1 millisecond.
	 * Calls the convertToMilli method, adds one, then updates object
	 * variables.
	 *****************************************************************/
	public void inc() {
		if (!isSuspended()) {
			int tmpMilliseconds = convertToMilli(this);
			tmpMilliseconds++;

			this.minutes = tmpMilliseconds / 60000;
			tmpMilliseconds %= 60000;
			this.seconds = tmpMilliseconds / 1000;
			tmpMilliseconds %= 1000;
			this.milliseconds = tmpMilliseconds;
		}
	}

	/*****************************************************************
	 * Method that decreases the StopWatch object by 1 millisecond.
	 * Calls the convertToMilli method, subtracts one, then updates
	 * object variables.
	 *
	 * @throws IllegalArgumentException if the milliseconds variable is
	 * invalid, ie less than zero.
	 *****************************************************************/
	public void dec() {
		if (!isSuspended()) {
			int tmpMilliseconds = convertToMilli(this);
			tmpMilliseconds--;

			if (tmpMilliseconds < 0)
				throw new IllegalArgumentException();

			minutes = tmpMilliseconds / 60000;
			tmpMilliseconds %= 60000;
			seconds = tmpMilliseconds / 1000;
			tmpMilliseconds %= 1000;
			milliseconds = tmpMilliseconds;
		}
	}

	/*****************************************************************
	 * Method concatenates minutes, seconds, milliseconds variables into
	 * temporary string variable and adds leading zeros based on the
	 * values of seconds and milliseconds. Returns a string.
	 *
	 * @returns a string in MIN:SEC:MILLI/0:00:00 format for the
	 * stopwatch object.
	 *****************************************************************/
	public String toString() {
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
		else{
			outputString += "" + milliseconds;
		}

		return outputString;

	}
	/*****************************************************************
	 * Method that saves the current object using "out" and printing
	 * each variable on a new line.
	 *
	 * @param filename used to set the name of the file that is saved
	 * by the print writer.
	 * @throws IllegalArgumentException if the name of the file is invalid
	 * or user does not have proper permissions to save.
	 *****************************************************************/
	public void save(String filename) {
		if (filename == null)
			throw new IllegalArgumentException();

		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));

			out.println(minutes);
			out.println(seconds);
			out.println(milliseconds);

			out.close();

		} catch (IOException e) {
			e.printStackTrace();
			throw new IllegalArgumentException();
		}

	}

	/*****************************************************************
	 * Method that loads a stopwatch object and reads each variable
	 * from the next line.
	 *
	 * @param filename is used to select the filename of the file loaded
	 * into the scanner.
	 * @throws IllegalArgumentException if the file cannot be found.
	 *****************************************************************/
	public void load(String filename)  {
		if (filename == null)
			throw new IllegalArgumentException();

		int minutes;
		int seconds;
		int milliseconds;

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(filename));
			minutes = scanner.nextInt();
			seconds = scanner.nextInt();
			milliseconds = scanner.nextInt();

		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException();
		}

		this.minutes = minutes;
		this.seconds = seconds;
		this.milliseconds = milliseconds;
	}

	/*****************************************************************
	 * Method that sets the stopwatch suspend status.
	 *
	 * @param tmpSuspend is the the boolean variable used to set the
	 * suspend state of the stopwatch object to true or false.
	 *****************************************************************/
	public static void setSuspend(boolean tmpSuspend) {
	if (tmpSuspend) {
		suspend = true;
		}
	if (!tmpSuspend) {
		suspend = false;
		}
	}

	/*****************************************************************
	 * Method to check if stopwatch is suspended.
	 *
	 * @returns a true/false boolean of the stopwatch's suspend state.
	 *****************************************************************/
	public static boolean isSuspended() {
		if (suspend) {
		return true;
		}
		else {
			return false;
		}
	}

	/*****************************************************************
	 * Getter method for minutes.
	 *
	 * @returns the minutes variable of the stopwatch object.
	 *****************************************************************/
	public int getMinutes() {
		return this.minutes;
	}

	/*****************************************************************
	 * Setter method for minutes.
	 *
	 * @param minutes is the variable used by the method to set the minutes
	 * of the stopwatch object.
	 * @throws IllegalArgumentException if the number of minutes is
	 * illegal, ie less than zero.
	 *****************************************************************/
	public void setMinutes(int minutes) {
		if (minutes < 0)
			throw new IllegalArgumentException();
		this.minutes = minutes;
	}

	/*****************************************************************
	 * Getter method for seconds.
	 *
	 * @returns the seconds variable of the stopwatch object.
	 *****************************************************************/
	public int getSeconds() {
		return this.seconds;
	}

	/*****************************************************************
	 * Setter method for seconds.
	 *
	 * @param seconds is the variable used by the method to set the
	 * seconds variable of the stopwatch object.
	 * @throws IllegalArgumentException if the seconds variable is
	 * in not in the valid range of 0-59.
	 *****************************************************************/
	public void setSeconds(int seconds) {
		if (seconds < 0 || seconds > 59)
			throw new IllegalArgumentException();
		this.seconds = seconds;
	}

	/*****************************************************************
	 * Getter method for milliseconds.
	 *
	 * @returns milliseconds of the stopwatch object.
	 *****************************************************************/
	public int getMilliseconds() {
		return this.milliseconds;
	}

	/*****************************************************************
	 * Setter method for milliseconds.
	 *
	 * @param milliseconds variable used by the method to set
	 * milli seconds on stopwatch.
	 * @throws IllegalArgumentException if variable passed to method is
	 * not in the valid range of 0-999.
	 *****************************************************************/
	public void setMilliseconds(int milliseconds) {
		if (milliseconds < 0 || milliseconds > 999)
			throw new IllegalArgumentException();
		this.milliseconds = milliseconds;
	}

}