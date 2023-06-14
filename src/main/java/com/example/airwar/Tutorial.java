package com.example.airwar;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Esta clase representa un tutorial en JavaFX que muestra una imagen y un botón circular para volver a la ventana principal.
 */
public class Tutorial extends Application {

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
        Image imagen = new Image(getClass().getResource("/com/example/imagenes/portada_AirWar.png").toExternalForm());

        ImageView imageView = new ImageView(imagen);
        root.getChildren().add(imageView);

        root.setPrefSize(978, 550);

        // Crear un botón circular
        Button circular4Button = new Button("Volver");
        circular4Button.setShape(new Circle(50)); // Establecer la forma del botón como un círculo
        circular4Button.setPrefSize(100, 100); // Establecer el tamaño del botón
        circular4Button.setLayoutX(100); // Establecer la posición X del botón
        circular4Button.setLayoutY(400); // Establecer la posición Y del botón

        // Aplicar estilo CSS al botón
        circular4Button.setStyle("-fx-background-color: linear-gradient(to bottom, #999999, #666666);" +
                "-fx-text-fill: black;" +
                "-fx-font-size: 14px;" +
                "-fx-border-color: black;" +
                "-fx-border-width: 2px;");

        root.getChildren().add(circular4Button);

        Scene scene = new Scene(root); // Crear la escena
        primaryStage.setScene(scene); // Establecer la escena en la ventana principal
        primaryStage.setTitle("Tutorial"); // Establecer el título de la ventana
        primaryStage.show(); // Mostrar la ventana

        // Evento para cerrar la ventana "Tutorial" y volver a la ventana principal
        circular4Button.setOnAction(e -> {
            primaryStage.close(); // Cerrar la ventana "Tutorial"
        });
    }
}
