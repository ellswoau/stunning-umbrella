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


	// private variables to hold stopwatch time
	private int minutes;
	private int seconds;
	private int milliseconds;

	private StopWatch stopWatch, stopWatch1, stopWatch2;
	private Object other;

	private static boolean suspend = false;


	/*****************************************************************
	 * Default constructor that sets stopwatch object variables to zero
	 *****************************************************************/
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
	 *Constructor for stopwatch object using integer inputs for minutes
	 * seconds and milliseconds
	 *****************************************************************/
	public StopWatch(int minutes, int seconds, int milliseconds) {
		if (minutes < 0) {
			throw new IllegalArgumentException("constuctor with 3 params");
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
	 * Construct for stopwatch object usings seconds and milliseconds
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
	 * Constructor for stopwatch object using only milliseconds
	 *****************************************************************/
	public StopWatch(int milliseconds) {
		this.minutes = 0;
		this.seconds = 0;
		// changed milliseconds greater than from 59 to 999
		if (milliseconds < 0 || milliseconds > 999) {
			throw new IllegalArgumentException();
		}
		this.milliseconds = milliseconds;
	}

	public StopWatch(StopWatch stopWatch) {
		if (stopWatch == null) {
			throw new IllegalArgumentException();
		}
		this.minutes = stopWatch.minutes;
		this.seconds = stopWatch.seconds;
		this.milliseconds = stopWatch.milliseconds;
	}

	/*****************************************************************
	 * Equals method that compares stopwatches by calling getters
	 *****************************************************************/
	//needs testing
	public static boolean equals(StopWatch stopWatch1, StopWatch stopWatch2) {
		if (stopWatch1 == null || stopWatch2 == null)
			throw new IllegalArgumentException();
		return (stopWatch1.getMilliseconds() == stopWatch2.getMilliseconds()) && (stopWatch1.getSeconds() == stopWatch2.getSeconds())
			&& (stopWatch1.getMinutes() == stopWatch2.getMinutes());
	}

	/*****************************************************************
	 * Method that compares stopwatch objects using instanceof
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
	 * Method that compares this stopwatch with other stopwatch. Checks
	 * variables with greater amount first for efficiency and readability.
	 *****************************************************************/
	//needs testing
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
	 * Method that converts an integer input of milliseconds and converts
	 * it into a stopwatch.
	 *****************************************************************/
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
		for (int i = 0; i < milliseconds; i++) {
		this.dec();
		}

	}


	/*****************************************************************
	 * Method to add two stopwatches together, converts second stopwatch
	 * object to milliseconds then loops the inc method
	 *****************************************************************/
	public void add(StopWatch stopWatch) {
		int tmpMilliseconds = convertToMilli(stopWatch);
		for (int i = 0; i < tmpMilliseconds; i++){
			this.inc();
		}

	}

	/*****************************************************************
	 * Method that subtracts stopwatch objects by converting the input
	 * stopwatch to milliseconds then loops the dec method
	 *****************************************************************/
	public void sub(StopWatch stopWatch) {
		int tmpMilliseconds = convertToMilli(stopWatch);
		for (int i = 0; i < tmpMilliseconds; i++){
			this.dec();
		}

	}

	/*****************************************************************
	 * Method that increases the StopWatch object by 1 millisecond.
	 * Calls the convertToMilli method, adds one, then updates object
	 * variables.
	 *****************************************************************/
	public void inc() {
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
	/*****************************************************************
	 * Method that saves the current object using "out" and printing
	 * each variable on a new line.
	 *****************************************************************/
	public void save(String filename) {
		if (filename == null)
			throw new IllegalArgumentException();

		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));

			System.out.println(minutes);
			System.out.println(seconds);
			System.out.println(milliseconds);

			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/*****************************************************************
	 * Method that loads a stopwatch object and reads each variable
	 * from the next line.
	 *****************************************************************/
	public void load(String filename)  {
		if (filename == null)
			throw new IllegalArgumentException();

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(filename));
			minutes = scanner.next();
			seconds = scanner.next();
			milliseconds = scanner.next();

		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException();
		}

	}

	/*****************************************************************
	 *UNKNOWN
	 *****************************************************************/
	public static void setSuspend(boolean suspend) {
		//TO DO: finish logic
	}

	/*****************************************************************
	 *UNKOWN
	 *****************************************************************/
	public static boolean isSuspended() {
		//TO DO: finish logic
		return false; // place holder
	}

	/*****************************************************************
	 * Getting method for minutes
	 *****************************************************************/
	public int getMinutes() {
		return this.minutes;
	}

	/*****************************************************************
	 * Setter method for minutes
	 *****************************************************************/
	public void setMinutes(int minutes) {
		if (minutes < 0)
			throw new IllegalArgumentException();
		this.minutes = minutes;
	}

	/*****************************************************************
	 * Getter method for seconds
	 *****************************************************************/
	public int getSeconds() {
		return this.seconds;
	}

	/*****************************************************************
	 * Setter method for seconds
	 *****************************************************************/
	public void setSeconds(int seconds) {
		if (seconds < 0 || seconds > 59)
			throw new IllegalArgumentException();
		this.seconds = seconds;
	}

	/*****************************************************************
	 * Getter method for milliseconds
	 *****************************************************************/
	public int getMilliseconds() {
		return this.milliseconds;
	}

	/*****************************************************************
	 * Setter method for milliseconds
	 *****************************************************************/
	public void setMilliseconds(int milliseconds) {
		if (milliseconds < 0 || milliseconds > 999)
			throw new IllegalArgumentException();
		this.milliseconds = milliseconds;
	}

}