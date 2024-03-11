package fx;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SceneSwitcher extends Application {

    private Stage primaryStage;
    private Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Scene Switching Example");

        // Create scenes
        createScene1();
        createScene2();

        // Set the initial scene
        primaryStage.setScene(scene1);

        // Show the stage
        primaryStage.show();
    }

    private void createScene1() {
        // Create the button
        Button switchButton = new Button("Switch to Scene 2");
        switchButton.setOnAction(e -> primaryStage.setScene(scene2));

        // Set up the layout
        StackPane layout = new StackPane();
        layout.getChildren().add(switchButton);

        // Create the scene
        scene1 = new Scene(layout, 300, 200);
    }

    private void createScene2() {
        // Create the button
        Button switchButton = new Button("Switch to Scene 1");
        switchButton.setOnAction(e -> primaryStage.setScene(scene1));

        // Set up the layout
        StackPane layout = new StackPane();
        layout.getChildren().add(switchButton);

        // Create the scene
        scene2 = new Scene(layout, 300, 200);
    }

    // Other methods or classes can go here

}
