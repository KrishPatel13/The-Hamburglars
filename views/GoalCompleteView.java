package views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import observer.EventObserver;
import observer.Goal;

import static views.CalendarView.colour;

/**
 * A window that notifies the user when they have completed one of their goals.
 */
public class GoalCompleteView {

    private Label completeLabel = new Label(""); // Message that tells the user which goal has been completed
    private Button okButton = new Button("OK"); // Button to close this window

    /**
     * Constructor
     *
     * @param o the goal which has been completed
     */
    public GoalCompleteView(Goal o) {
        final Stage dialog = new Stage();
        VBox dialogVbox = new VBox(20);
        dialogVbox.setPadding(new Insets(20, 20, 20, 20));
        dialogVbox.setBackground(new Background(new BackgroundFill(colour,null,null)));
        completeLabel.setText("Congratulations! You completed your goal: " + o.getName());
        Font f = new Font(16);
        completeLabel.setFont(f);
        completeLabel.setTextFill(CalendarView.colour_font);
        okButton.setFont(f);
        okButton.setTextFill(CalendarView.colour_font);


        okButton.setOnAction(e -> {
            dialog.close();
        });

        VBox vbox = new VBox(10, completeLabel, okButton);
        dialogVbox.getChildren().add(vbox);
        Scene scene = new Scene(dialogVbox, 400, 100);
        dialog.setScene(scene);
        dialog.show();
        dialog.setAlwaysOnTop(true);
    }


}