package com.example.airwar;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 * Esta clase representa el juego AirWar en JavaFX, que muestra una pantalla de inicio con opciones para jugar, ver un tutorial y ver información acerca del juego.
 */
public class AirWar extends Application {

    /**
     * El método principal que inicia la aplicación JavaFX.
     *
     * @param args los argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * El método de inicio de la aplicación JavaFX.
     *
     * @param primaryStage la ventana principal de la aplicación
     */
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        // Cargar la imagen desde el directorio de recursos
        Image imagen = new Image(getClass().getResource("/com/example/imagenes/AIRWAR.png").toExternalForm());

        ImageView imageView = new ImageView(imagen);
        root.getChildren().add(imageView);

        root.setPrefSize(978, 550);

        // Crear un botón circular para "Acerca de"
        Button circularButton = new Button("Acerca de");
        circularButton.setShape(new Circle(50)); // Establecer la forma del botón como un círculo
        circularButton.setPrefSize(100, 100); // Establecer el tamaño del botón
        circularButton.setLayoutX(100); // Establecer la posición X del botón
        circularButton.setLayoutY(400); // Establecer la posición Y del botón

        // Aplicar estilo CSS al botón
        circularButton.setStyle("-fx-background-color: linear-gradient(to bottom, #999999, #666666);" +
                "-fx-text-fill: black;" +
                "-fx-font-size: 14px;" +
                "-fx-border-color: black;" +
                "-fx-border-width: 2px;");

        root.getChildren().add(circularButton);

        // Crear un botón circular para "Jugar"
        Button circularButton1 = new Button("Jugar");
        circularButton1.setShape(new Circle(50));
        circularButton1.setPrefSize(100, 100);
        circularButton1.setLayoutX(425);
        circularButton1.setLayoutY(400);

        // Aplicar estilo CSS al botón
        circularButton1.setStyle("-fx-background-color: linear-gradient(to bottom, #999999, #666666);" +
                "-fx-text-fill: black;" +
                "-fx-font-size: 14px;" +
                "-fx-border-color: black;" +
                "-fx-border-width: 2px;");

        // Agregar evento al botón "Jugar"
        circularButton1.setOnAction(event -> {
            // Crear una instancia de MapaMundi y abrir la ventana
            MapaMundial mapaMundial = new MapaMundial();
            Stage mapaMundialStage = new Stage();
            mapaMundial.start(mapaMundialStage);
        });

        root.getChildren().add(circularButton1);

        // Crear un botón circular para "Tutorial"
        Button circularButton2 = new Button("Tutorial");
        circularButton2.setShape(new Circle(50)); // Establecer la forma del botón como un círculo
        circularButton2.setPrefSize(100, 100); // Establecer el tamaño del botón
        circularButton2.setLayoutX(750); // Establecer la posición X del botón
        circularButton2.setLayoutY(400); // Establecer la posición Y del botón

        // Aplicar estilo CSS al botón
        circularButton2.setStyle("-fx-background-color: linear-gradient(to bottom, #999999, #666666);" +
                "-fx-text-fill: black;" +
                "-fx-font-size: 14px;" +
                "-fx-border-color: black;" +
                "-fx-border-width: 2px;");

        // Agregar evento al botón "Tutorial"
        circularButton2.setOnAction(event -> {
            Tutorial tutorial = new Tutorial();
            Stage tutorialStage = new Stage();
            tutorial.start(tutorialStage);
        });

        root.getChildren().add(circularButton2);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("AirWar");
        primaryStage.show();

        // Evento para abrir la ventana "Acerca de"
        circularButton.setOnAction(event -> {
            Stage aboutStage = new Stage();
            StackPane aboutRoot = new StackPane();
            aboutRoot.setPrefSize(978, 550);

            // Cargar la imagen para la ventana "Acerca de"
            Image aboutImage = new Image(getClass().getResource("/com/example/imagenes/Acerca_de.png").toExternalForm());
            ImageView aboutImageView = new ImageView(aboutImage);
            aboutRoot.getChildren().add(aboutImageView);

            // Crear un botón circular
            Button circular3Button = new Button("Volver");
            circular3Button.setShape(new Circle(50)); // Establecer la forma del botón como un círculo
            circular3Button.setPrefSize(100, 100); // Establecer el tamaño del botón
            circular3Button.setStyle("-fx-background-color: linear-gradient(to bottom, #999999, #666666);" +
                    "-fx-text-fill: black;" +
                    "-fx-font-size: 14px;" +
                    "-fx-border-color: black;" +
                    "-fx-border-width: 2px;");

            HBox buttonContainer = new HBox(circular3Button);
            buttonContainer.setAlignment(Pos.BOTTOM_RIGHT);
            buttonContainer.setPadding(new Insets(10));

            aboutRoot.getChildren().add(buttonContainer);

            Scene aboutScene = new Scene(aboutRoot);
            aboutStage.setScene(aboutScene);
            aboutStage.setTitle("Acerca de");
            aboutStage.show();

            // Evento para cerrar la ventana "Acerca de" y volver a la ventana principal
            circular3Button.setOnAction(e -> {
                aboutStage.close(); // Cerrar la ventana "Acerca de"
                primaryStage.show(); // Mostrar la ventana principal
            });

            primaryStage.show(); // Mostrar la ventana principal
        });
    }
}
