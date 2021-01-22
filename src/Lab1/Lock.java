package Lab1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**********************************************************************
 *
 *    Here are my comments.
 *
 * @author Ferguson
 */
public class Lock   {
    /** used for user input */
    private String userEnteredCode;

    /** used to determine code to open lock */
    private String correctCode;

    private static String masterKey = "999";

    public Lock () {
        correctCode = "123";
        userEnteredCode = "";
    }

    public Lock (String code)  {

        if (code.length() == 0)
            throw new IllegalArgumentException();

        correctCode = code;
        userEnteredCode = "";
    }

    public void enterCode (String userEnteredCode) {
        this.userEnteredCode = userEnteredCode;
    }

    public boolean isUnlock() {
        if ((correctCode.equals(userEnteredCode)) ||
        (userEnteredCode.equals(masterKey)))
            return true;

        return false;
    }

    public boolean equals (Lock pLock) {
        if (pLock.correctCode.equals(this.correctCode))
            return true;
        else
            return false;
    }

    //    public boolean equals (Object other) {
//        if (other != null) {
//            if (other instanceof Lock) {
//                Lock temp = (Lock) other;
//                if (this.correctCode.equals(temp.correctCode))
//                    return true;
//                else
//                    return false;
//            }
//        }
//        throw new IllegalArgumentException();
//    }





    public static boolean equals(Lock lock1, Lock lock2) {
        if (lock1.correctCode.equals(lock2.correctCode))
            return true;
        else
            return false;

    }


    public void load(String fileName) {
        try{
            Scanner fileReader = new Scanner(new File(fileName));
            correctCode = fileReader.next();
            userEnteredCode = fileReader.next();

            System.out.println (correctCode);
            System.out.println (userEnteredCode);
        }

        // problem reading the file
        catch(Exception error){
            throw new RuntimeException();
            // System.out.println("Oops!  Something went wrong.");
        }

    }

    public void save(String fileName) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        out.println(correctCode);
        out.println(userEnteredCode);
        out.close();
    }

    public String getUserEnteredCode() {
        return userEnteredCode;
    }

    public void setUserEnteredCode(String userEnteredCode) {
        this.userEnteredCode = userEnteredCode;
    }

    public String getCorrectCode() {
        return correctCode;
    }

    public void setCorrectCode(String correctCode) {
        this.correctCode = correctCode;
    }

    public static String getMasterKey() {
        return masterKey;
    }

    public static void setMasterKey(String masterKey) {
        Lock.masterKey = masterKey;
    }
}