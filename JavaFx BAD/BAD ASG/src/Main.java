import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Scene scene;
    Stage window;
    BorderPane bp;
    GridPane gp;
    Label EnterlBl, KeylBl;
    TextField keyField;
    Button Colorkey1, Colorkey2, Colorkey3, Colorkey4, Colorkey5;
    Button Btn0, Btn1, Btn2, Btn3, Btn4, Btn5, Btn6, Btn7, Btn8, Btn9;
    Button Reset;

    public static void main(String[] args) {
        launch(args);
    }

    public void initialize() {
        bp = new BorderPane();
        gp = new GridPane();
        scene = new Scene(bp, 400, 200);
        Colorkey1 = new Button("FFA500");
        Colorkey1.setStyle("-fx-background-color: #FFA500; ");
        Colorkey2 = new Button("FFE4B5");
        Colorkey2.setStyle("-fx-background-color: #FFE4B5; ");
        Colorkey3 = new Button("7FFFD4");
        Colorkey3.setStyle("-fx-background-color: #7FFFD4; ");
        Colorkey4 = new Button("FF00FF");
        Colorkey4.setStyle("-fx-background-color: #FF00FF; ");
        Colorkey5 = new Button("ADD8E6");
        Colorkey5.setStyle("-fx-background-color: #ADD8E6; ");
        EnterlBl = new Label("Enter last 5 digit key: ");
        KeylBl = new Label("Key Number");
        keyField = new TextField();
        Btn0 = new Button("0");
        Btn1 = new Button("1");
        Btn2 = new Button("2");
        Btn3 = new Button("3");
        Btn4 = new Button("4");
        Btn5 = new Button("5");
        Btn6 = new Button("6");
        Btn7 = new Button("7");
        Btn8 = new Button("8");
        Btn9 = new Button("9");
        Reset = new Button("RESET");

        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(10));

        bp.setPadding(new Insets(20));
    }

    public void addComponent() {
        bp.setTop(ColorkeyButtons());

        gp.addRow(1, Btn0, Btn1, Btn2, Btn3, Btn4, Btn5, Btn6, Btn7, Btn8, Btn9);
        gp.setAlignment(Pos.TOP_LEFT);

        VBox vbox = new VBox(gp);
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);
        bp.setCenter(vbox);

        HBox hbox = new HBox(KeylBl, keyField, Reset);
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);
        bp.setBottom(hbox);
    }

    public HBox ColorkeyButtons() {
        HBox hbox = new HBox(10, Colorkey1, Colorkey2, Colorkey3, Colorkey4, Colorkey5);
        hbox.setAlignment(Pos.CENTER);
        return hbox;
    }

    @Override
    public void start(Stage window) {
        initialize();
        addComponent();
        buttonPressed();

        Reset.setOnMouseClicked(event -> {
            System.out.println("Old Value: " + keyField.getText());
            keyField.clear();
        });

        window.show();
        window.setTitle("Color Key - NIM: 2502042656");
        window.setScene(scene);
    }

    public void buttonPressed() {
        Button[] buttons = {Btn0, Btn1, Btn2, Btn3, Btn4, Btn5, Btn6, Btn7, Btn8, Btn9};
        for (int i = 0; i < buttons.length; i++) {
            final int digit = i;
            buttons[i].setOnMouseClicked(event -> {
                System.out.println("Numpad #" + digit + " Pressed");
                keyField.appendText(Integer.toString(digit));
            });
        }
    }
}
