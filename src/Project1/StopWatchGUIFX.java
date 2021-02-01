package Project1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**********************************
 *
 * https://www.youtube.com/watch?v=BHj6zbH3inI
 *
 * https://openjfx.io/openjfx-docs/  (look left side of screen and see JavaFX and IntelliJ)
 *
 *  in the run config type in VM: --module-path C:\Users\rf012\OfficeMachine\IntelliJProjects\javafx-sdk-11.0.2\lib --add-modules javafx.controls,javafx.fxml
 *
 *     add to project structure, libraries, +, C:\Users\rf012\OfficeMachine\IntelliJProjects\javafx-sdk-11.0.2\lib   (lib dir)
 *     change config to
 *
 */
public class StopWatchGUIFX extends Application {

    private Button susButton;

    @Override
    public void start(Stage primaryStage) throws Exception{

        String cssLayout = "-fx-border-color: Black;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 3;\n";

        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.getChildren().add (new StopWatchPanelFX());
        root.getChildren().add (new StopWatchPanelFX());
        root.getChildren().add (new StopWatchPanelFX());


        susButton = new Button("Suspend is OFF");
        root.getChildren().add (susButton);
        root.setSpacing(60);

        susButton.setOnAction(this::actionPerformed);
        root.setSpacing(10);

        root.setStyle(cssLayout);
        primaryStage.setTitle("StopWatch");
        primaryStage.setScene(new Scene(root, 1200, 300));
        primaryStage.show();
    }

    private void actionPerformed(javafx.event.ActionEvent actionEvent) {

    }
    public static void main(String[] args) {
        launch(args);
    }
}