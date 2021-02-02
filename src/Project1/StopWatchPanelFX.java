package Project1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.StageStyle;

import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.io.File;

public class StopWatchPanelFX extends GridPane {

    private StopWatch watch;
    private Timer javaTimer;

    private Button startButton, stopButton, loadButton, saveButton, addButton, subtractButton, newButton, continueButton;
    private TextField minField, secField, addField, subtractField, newField;



    Label lblTime;

    /*****************************************************************
     *  Constructor for each stopwatch panel, instantiates variables
     *  and listeners and element positions within the panel
     *****************************************************************/
    public StopWatchPanelFX() {

        watch = new StopWatch();
        javaTimer = new Timer(8, new TimerListener());

        minField = new TextField("0");
        add(new Label("Minutes:"), 0, 0);
        add(minField, 1, 0);

        secField = new TextField("0");
        add(new Label("Seconds:"), 0, 1);
        add(secField, 1, 1);

        addField = new TextField("0");
        add(addField, 1, 5);

        subtractField = new TextField("0");
        add(subtractField, 1, 6);

        newField = new TextField("0:00:00");
        add(newField, 1, 7);


        stopButton = new Button("Stop");
        add(stopButton, 0, 3);

        loadButton = new Button("Load");
        add(loadButton, 0, 4);

        addButton = new Button("Add");
        add(addButton, 0, 5);

        subtractButton = new Button("Subtract");
        add(subtractButton, 0, 6);

        newButton = new Button("New");
        add(newButton, 0, 7);

        continueButton = new Button("Continue");
        add(continueButton, 0, 7);

        startButton = new Button("Start");
        add(startButton, 1, 3);

        saveButton = new Button("Save");
        add(saveButton, 1, 4);

        add(new Label(" "), 1, 7);

        lblTime = new Label();
        lblTime.setText(watch.toString());
        add(lblTime, 0, 8);

        add(new Label("Time:"), 1, 8);

        // register the listeners
        stopButton.setOnAction(this::actionPerformed);
        startButton.setOnAction(this::actionPerformed);
        saveButton.setOnAction(this::actionPerformed);
        loadButton.setOnAction(this::actionPerformed);
        addButton.setOnAction(this::actionPerformed);
        subtractButton.setOnAction(this::actionPerformed);
        newButton.setOnAction(this::actionPerformed);
        continueButton.setOnAction(this::actionPerformed);
    }

    /*****************************************************************
     * Action method that executes different actions based on what
     * element is being interacted with.
     *****************************************************************/
    public void actionPerformed(ActionEvent event) {

        int mins, sec, milli, p;
        FileChooser fileChooser = new FileChooser();


        if (event.getSource() == stopButton) {
            javaTimer.stop();
        }

        if(event.getSource() == loadButton) {
        //uses file chooser for an open dialog and calls the load method
            try {
                File selectedFile = fileChooser.showOpenDialog(null);
                watch.load(selectedFile.getName());
            }
            catch (Exception e) {
                errorMessageDialog("File selection error");
            }
        }

        if(event.getSource() == saveButton) {
            //uses file chooser, sets default file name, and catches any exceptions
            //calls the save method
            try {
                fileChooser.setInitialFileName("stopwatch-default.txt");
                fileChooser.setTitle("Save StopWatch");
                File selectedFile = fileChooser.showSaveDialog(null);
                watch.save(selectedFile.getName());
            }
            catch (Exception e) {
                errorMessageDialog("File save error");
            }
        }

        //action performed when add button is clicked, adds the entered
        //num of milliseconds using the add() method
        if(event.getSource() == addButton) {
            try {
                milli = Integer.parseInt(addField.getText());
                watch.add(milli);
                javaTimer.start();
            } catch (NumberFormatException io) {
                errorMessageDialog("Number Format exception");
            } catch (IllegalArgumentException e) {
                errorMessageDialog("Number Format exception");
            }
        }

        //action performed when subtract button clicked, uses the
        // stopwatch sub() method
        if(event.getSource() == subtractButton) {

            try {
                milli = Integer.parseInt(subtractField.getText());
                watch.sub(milli);
                javaTimer.start();
            } catch (NumberFormatException io) {
                errorMessageDialog("Number Format exception");
            } catch (IllegalArgumentException e) {
                errorMessageDialog("Number Format exception");
            }
        }



        if(event.getSource() == newButton) {
            //place holder
        }

        if(event.getSource() == continueButton) {
            //Starts the timer back up without resetting it back to the
            //values provided in minutes and seconds fields above.
            try {
                javaTimer.start();
            }
            catch (Exception e) {
                errorMessageDialog("Timer already running");
            }

        }

        if (event.getSource() == startButton) {
            try {
                mins = Integer.parseInt(minField.getText());
                sec = Integer.parseInt(secField.getText());
                watch = new StopWatch(mins, sec, 0);
                javaTimer.start();
            } catch (NumberFormatException io) {
                errorMessageDialog("Number Format exception");
            } catch (IllegalArgumentException e) {
                errorMessageDialog("Number Format exception");

        }
        }



        lblTime.setText(watch.toString());
    }

    /*****************************************************************
     * Method that displays an error message dialog box and takes a
     * string input from the error message in the action performed
     * method
     *****************************************************************/
    private void errorMessageDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    /*****************************************************************
     * Timer listener
     *****************************************************************/
    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            watch.add(10);

            Platform.runLater(() -> lblTime.setText(watch.toString()));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    lblTime.setText(watch.toString());
                }
            });
            //
            // https://www.geeksforgeeks.org/java-util-timer-class-java/  (shows how to use util timer)
            //  shows how to use runLater method.
            // https://stackoverflow.com/questions/17124442/javafx2-illegalstateexception-with-label-settext

        }
    }
}
    