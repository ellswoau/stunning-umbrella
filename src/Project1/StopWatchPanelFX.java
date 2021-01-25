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

    private Button startButton, stopButton;
    private TextField minField, secField;

    Label lblTime;

    public StopWatchPanelFX() {

        watch = new StopWatch();
        javaTimer = new Timer(8, new TimerListener());

        minField = new TextField("0");

        add(minField, 0, 0);
        add(new Label("Minutes:"), 1, 0);

        secField = new TextField("0");
        add(secField, 0, 1);
        add(new Label("Seconds:"), 1, 1);

        stopButton = new Button("Stop");
        add(stopButton, 0, 3);

        startButton = new Button("Start");
        add(startButton, 1, 3);

        add(new Label(" "), 1, 7);

        lblTime = new Label();
        lblTime.setText(watch.toString());
        add(lblTime, 0, 8);

        add(new Label("Time:"), 1, 8);

        // register the listeners
        stopButton.setOnAction(this::actionPerformed);
        startButton.setOnAction(this::actionPerformed);
    }

    public void actionPerformed(ActionEvent event) {

        int mins, sec, milli, p;

        if (event.getSource() == stopButton) {
            javaTimer.stop();
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

    private void errorMessageDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


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
    