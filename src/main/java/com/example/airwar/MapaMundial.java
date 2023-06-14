package com.example.airwar;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
/**
 * Esta clase representa un mapa mundial con aeropuertos y rutas de avión.
 */
public class MapaMundial extends Application {

    /**
     * El radio del círculo que representa un punto en el mapa.
     */
    public static final double CIRCLE_RADIUS = 5;

    /**
     * El color del círculo que representa un aeropuerto.
     */
    public static final Color CIRCLE_COLOR_AEREOPUERTO = Color.PURPLE;

    /**
     * El color del círculo que representa un portaaviones.
     */
    public static final Color CIRCLE_COLOR_PORTAAVIONES = Color.GREENYELLOW;

    /**
     * El color de la ruta de avión.
     */
    public static final Color ROUTE_COLOR = Color.RED;

    /**
     * El tamaño del logotipo de un aeropuerto.
     */
    public static final double LOGO_SIZE = 20;

    /**
     * Esta clase representa un punto con coordenadas (x, y).
     */
    public static class Point {
        public double x;
        public double y;

        /**
         * Crea un nuevo punto con las coordenadas especificadas.
         *
         * @param x la coordenada x del punto.
         * @param y la coordenada y del punto.
         */
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        // Carga la imagen del mapa mundial
        Image mapaImage = new Image(getClass().getResourceAsStream("/com/example/imagenes/mapa mundi (1).jpg"));
        ImageView mapaImageView = new ImageView(mapaImage);
        root.getChildren().add(mapaImageView);

        // Coordenadas de los aeropuertos
        Point punto1 = new Point(160, 180); // Coordenada del aeropuerto de Canadá
        Point punto2 = new Point(319, 415); // Coordenada del aeropuerto de Argentina
        Point punto3 = new Point(220, 255); // Coordenada del aeropuerto de Estados Unidos
        Point punto4 = new Point(349, 375); // Coordenada del aeropuerto de Brasil
        Point punto5 = new Point(220, 295); // Coordenada del aeropuerto de Mexico
        Point punto6 = new Point(549, 195); // Coordenada del aeropuerto de Rusia
        Point punto7 = new Point(349, 125); // Coordenada del aeropuerto de Groenlandia
        Point punto8 = new Point(720, 255); // Coordenada del aeropuerto de China
        Point punto9 = new Point(790, 415); // Coordenada del aeropuerto de Australia
        Point punto10 = new Point(493, 280); // Coordenada del aeropuerto de Libia

        // Rutas de avión
        Line route1 = createLine(punto1, punto2); // Ruta entre Canadá y Argentina
        route1.setStroke(ROUTE_COLOR);
        root.getChildren().add(route1);
        // ...

        // Crea círculos que representan los aeropuertos y agrega la imagen a cada punto
        // Crea círculos que representan los aeropuertos y agrega la imagen a cada punto
        Circle circleT1 = createCircle(punto1, CIRCLE_COLOR_AEREOPUERTO);
        root.getChildren().add(circleT1); // Agregar el círculo al Group
        ImageView imageT1 = createImage("/com/example/imagenes/Logo_AereoPuerto.png", punto1.x, punto1.y);
        root.getChildren().addAll(imageT1);

        Circle circleT2 = createCircle(punto2, CIRCLE_COLOR_AEREOPUERTO);
        root.getChildren().add(circleT2); // Agregar el círculo al Group
        ImageView imageT2 = createImage("/com/example/imagenes/Logo_AereoPuerto.png", punto2.x, punto2.y);
        root.getChildren().addAll( imageT2);

        Circle circleT3 = createCircle(punto3, CIRCLE_COLOR_AEREOPUERTO);
        ImageView imageT3 = createImage("/com/example/imagenes/Logo_AereoPuerto.png", punto3.x, punto3.y);
        root.getChildren().addAll(circleT3, imageT3);

        Circle circleT4 = createCircle(punto4, CIRCLE_COLOR_AEREOPUERTO);
        ImageView imageT4 = createImage("/com/example/imagenes/Logo_AereoPuerto.png", punto4.x, punto4.y);
        root.getChildren().addAll(circleT4, imageT4);

        Circle circleT5 = createCircle(punto5, CIRCLE_COLOR_AEREOPUERTO);
        ImageView imageT5 = createImage("/com/example/imagenes/Logo_AereoPuerto.png", punto5.x, punto5.y);
        root.getChildren().addAll(circleT5, imageT5);

        Circle circleT6 = createCircle(punto6, CIRCLE_COLOR_AEREOPUERTO);
        ImageView imageT6 = createImage("/com/example/imagenes/Logo_AereoPuerto.png", punto6.x, punto6.y);
        root.getChildren().addAll(circleT6, imageT6);

        Circle circleT7 = createCircle(punto7, CIRCLE_COLOR_AEREOPUERTO);
        ImageView imageT7 = createImage("/com/example/imagenes/Logo_AereoPuerto.png", punto7.x, punto7.y);
        root.getChildren().addAll(circleT7, imageT7);

        Circle circleT8 = createCircle(punto8, CIRCLE_COLOR_AEREOPUERTO);
        ImageView imageT8 = createImage("/com/example/imagenes/Logo_AereoPuerto.png", punto8.x, punto8.y);
        root.getChildren().addAll(circleT8, imageT8);

        Circle circleT9 = createCircle(punto9, CIRCLE_COLOR_AEREOPUERTO);
        ImageView imageT9 = createImage("/com/example/imagenes/Logo_AereoPuerto.png", punto9.x, punto9.y);
        root.getChildren().addAll(circleT9, imageT9);

        Circle circleT10 = createCircle(punto10, CIRCLE_COLOR_AEREOPUERTO);
        ImageView imageT10 = createImage("/com/example/imagenes/Logo_AereoPuerto.png", punto10.x, punto10.y);
        root.getChildren().addAll(circleT10, imageT10);

        // Establece un evento de clic en la imagenT1
        imageT1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String texto = "Aeropuerto internacional de Canadá\nAviones disponibles:\nGalones de Combustibles disponibles:";
                mostrarVentanaEmergente("Aeropuerto de Canadá", texto);

                // Crea un objeto Text con el texto deseado
                Text textoObjeto = new Text(texto);

                // Establece la posición del texto debajo del mapa
                textoObjeto.setX(10); // Ajusta la posición horizontal según sea necesario
                textoObjeto.setY(300); // Ajusta la posición vertical según sea necesario

                // Agrega el objeto Text al Group principal
                root.getChildren().add(textoObjeto);
            }
        });


        // Establece un evento de clic en la imagenT2
        imageT2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Llama a la función mostrarVentanaEmergente con los datos del aeropuerto de Argentina
                String texto2 = "Aeropuerto internacional de Argentina\nAviones disponibles:\nGalones de Combustibles disponibles:";

                mostrarVentanaEmergente2("Aeropuerto de Argentina", texto2);
                // Crea un objeto Text con el texto deseado
                Text textoObjeto = new Text(texto2);

                // Establece la posición del texto debajo del mapa
                textoObjeto.setX(10); // Ajusta la posición horizontal según sea necesario
                textoObjeto.setY(300); // Ajusta la posición vertical según sea necesario

                // Agrega el objeto Text al Group principal
                root.getChildren().add(textoObjeto);
            }
        });

        // Establece un evento de clic en la imagenT3
        imageT3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Llama a la función mostrarVentanaEmergente con los datos del aeropuerto de USA
                String texto3 = "Aeropuerto internacional de USA\nAviones disponibles:\nGalones de Combustibles disponibles:";
                mostrarVentanaEmergente3("Aeropuerto de USA", texto3);
                // Crea un objeto Text con el texto deseado
                Text textoObjeto = new Text(texto3);

                // Establece la posición del texto debajo del mapa
                textoObjeto.setX(10); // Ajusta la posición horizontal según sea necesario
                textoObjeto.setY(300); // Ajusta la posición vertical según sea necesario

                // Agrega el objeto Text al Group principal
                root.getChildren().add(textoObjeto);
            }
        });

        // Establece un evento de clic en la imagenT4
        imageT4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Llama a la función mostrarVentanaEmergente con los datos del aeropuerto de Brasil
                String texto4 = "Aeropuerto internacional de Brasil\nAviones disponibles:\nGalones de Combustibles disponibles:";

                mostrarVentanaEmergente4("Aeropuerto de Brasil", texto4);
                // Crea un objeto Text con el texto deseado
                Text textoObjeto = new Text(texto4);

                // Establece la posición del texto debajo del mapa
                textoObjeto.setX(10); // Ajusta la posición horizontal según sea necesario
                textoObjeto.setY(300); // Ajusta la posición vertical según sea necesario

                // Agrega el objeto Text al Group principal
                root.getChildren().add(textoObjeto);
            }
        });

        // Establece un evento de clic en la imagenT5
        imageT5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Llama a la función mostrarVentanaEmergente con los datos del aeropuerto de mexico
                String texto5 = "Aeropuerto internacional de Mexico\nAviones disponibles:\nGalones de Combustibles disponibles:";
                mostrarVentanaEmergente5("Aeropuerto de mexico", texto5);
                // Crea un objeto Text con el texto deseado
                Text textoObjeto = new Text(texto5);

                // Establece la posición del texto debajo del mapa
                textoObjeto.setX(10); // Ajusta la posición horizontal según sea necesario
                textoObjeto.setY(300); // Ajusta la posición vertical según sea necesario

                // Agrega el objeto Text al Group principal
                root.getChildren().add(textoObjeto);
            }
        });

        // Establece un evento de clic en la imagenT6
        imageT6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Llama a la función mostrarVentanaEmergente con los datos del aeropuerto de rusia
                String texto6 = "Aeropuerto internacional de Rusia\nAviones disponibles:\nGalones de Combustibles disponibles:";
                mostrarVentanaEmergente6("Aeropuerto de rusia", texto6);
                // Crea un objeto Text con el texto deseado
                Text textoObjeto = new Text(texto6);

                // Establece la posición del texto debajo del mapa
                textoObjeto.setX(10); // Ajusta la posición horizontal según sea necesario
                textoObjeto.setY(300); // Ajusta la posición vertical según sea necesario

                // Agrega el objeto Text al Group principal
                root.getChildren().add(textoObjeto);
            }
        });

        // Establece un evento de clic en la imagenT7
        imageT7.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Llama a la función mostrarVentanaEmergente con los datos del aeropuerto de groenlandia
                String texto7 = "Aeropuerto internacional de Groenlandia\nAviones disponibles:\nGalones de Combustibles disponibles:";
                mostrarVentanaEmergente7("Aeropuerto de groenlandia", texto7);
                // Crea un objeto Text con el texto deseado
                Text textoObjeto = new Text(texto7);

                // Establece la posición del texto debajo del mapa
                textoObjeto.setX(10); // Ajusta la posición horizontal según sea necesario
                textoObjeto.setY(300); // Ajusta la posición vertical según sea necesario

                // Agrega el objeto Text al Group principal
                root.getChildren().add(textoObjeto);
            }
        });

        // Establece un evento de clic en la imagenT8
        imageT8.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Llama a la función mostrarVentanaEmergente con los datos del aeropuerto de china
                String texto8 = "Aeropuerto internacional de China\nAviones disponibles:\nGalones de Combustibles disponibles:";
                mostrarVentanaEmergente8("Aeropuerto de china", texto8 );
                // Crea un objeto Text con el texto deseado
                Text textoObjeto = new Text(texto8);

                // Establece la posición del texto debajo del mapa
                textoObjeto.setX(10); // Ajusta la posición horizontal según sea necesario
                textoObjeto.setY(300); // Ajusta la posición vertical según sea necesario

                // Agrega el objeto Text al Group principal
                root.getChildren().add(textoObjeto);
            }
        });

        // Establece un evento de clic en la imagenT9
        imageT9.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Llama a la función mostrarVentanaEmergente con los datos del aeropuerto de australia
                String texto9 = "Aeropuerto internacional de Australia\nAviones disponibles:\nGalones de Combustibles disponibles:";
                mostrarVentanaEmergente9("Aeropuerto de australia", texto9);
                // Crea un objeto Text con el texto deseado
                Text textoObjeto = new Text(texto9);

                // Establece la posición del texto debajo del mapa
                textoObjeto.setX(10); // Ajusta la posición horizontal según sea necesario
                textoObjeto.setY(300); // Ajusta la posición vertical según sea necesario

                // Agrega el objeto Text al Group principal
                root.getChildren().add(textoObjeto);
            }
        });

        // Establece un evento de clic en la imagenT10
        imageT10.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Llama a la función mostrarVentanaEmergente con los datos del aeropuerto de libia
                String texto10 = "Aeropuerto internacional de Libia\nAviones disponibles:\nGalones de Combustibles disponibles:";
                mostrarVentanaEmergente10("Aeropuerto de libia", "Información sobre el aeropuerto de libia ");
                // Crea un objeto Text con el texto deseado
                Text textoObjeto = new Text(texto10);

                // Establece la posición del texto debajo del mapa
                textoObjeto.setX(10); // Ajusta la posición horizontal según sea necesario
                textoObjeto.setY(300); // Ajusta la posición vertical según sea necesario

                // Agrega el objeto Text al Group principal
                root.getChildren().add(textoObjeto);
            }
        });

        // Coordenadas de los portaaviones
        Point punto11 = new Point(419, 415); // Coordenada del portaaviones del Atlántico (caribe)Sur
        Point punto12 = new Point(358, 265); // Coordenada del portaaviones del Atlántico (caribe)Norte
        Point punto13 = new Point(158, 465); // Coordenada del portaaviones del Pacífico Sur
        Point punto14 = new Point(120, 265); // Coordenada del portaaviones del Pacífico norte
        Point punto15 = new Point(619, 415); // Coordenada del portaaviones del indico
        Point punto16 = new Point(858, 265); // Coordenada del portaaviones del pacifico Norte

        // Crea círculos que representan los portaaviones y agrega la imagen a cada punto
        Circle circleT11 = createCircle(punto11, CIRCLE_COLOR_PORTAAVIONES);
        ImageView imageT11 = createImage("/com/example/imagenes/Logo_PortaAviones.png", punto11.x, punto11.y);
        root.getChildren().addAll(circleT11, imageT11);

        Circle circleT12 = createCircle(punto12, CIRCLE_COLOR_PORTAAVIONES);
        ImageView imageT12 = createImage("/com/example/imagenes/Logo_PortaAviones.png", punto12.x, punto12.y);
        root.getChildren().addAll(circleT12, imageT12);

        Circle circleT13 = createCircle(punto13, CIRCLE_COLOR_PORTAAVIONES);
        ImageView imageT13 = createImage("/com/example/imagenes/Logo_PortaAviones.png", punto13.x, punto13.y);
        root.getChildren().addAll(circleT13, imageT13);

        Circle circleT14 = createCircle(punto14, CIRCLE_COLOR_PORTAAVIONES);
        ImageView imageT14 = createImage("/com/example/imagenes/Logo_PortaAviones.png", punto14.x, punto14.y);
        root.getChildren().addAll(circleT14, imageT14);

        Circle circleT15 = createCircle(punto15, CIRCLE_COLOR_PORTAAVIONES);
        ImageView imageT15 = createImage("/com/example/imagenes/Logo_PortaAviones.png", punto15.x, punto15.y);
        root.getChildren().addAll(circleT15, imageT15);

        Circle circleT16 = createCircle(punto16, CIRCLE_COLOR_PORTAAVIONES);
        ImageView imageT16 = createImage("/com/example/imagenes/Logo_PortaAviones.png", punto16.x, punto16.y);
        root.getChildren().addAll(circleT16, imageT16);

        // Establece un evento de clic en la imagenT11
        imageT11.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Llama a la función mostrarVentanaEmergente con los datos del porta aviones del atlantico sur
                String texto11 = "portaaviones del atlantico sur \nAviones disponibles:\nGalones de Combustibles disponibles:";
                mostrarVentanaEmergente11("Portaaviones", texto11);
                // Crea un objeto Text con el texto deseado
                Text textoObjeto = new Text(texto11 );

                // Establece la posición del texto debajo del mapa
                textoObjeto.setX(10); // Ajusta la posición horizontal según sea necesario
                textoObjeto.setY(300); // Ajusta la posición vertical según sea necesario

                // Agrega el objeto Text al Group principal
                root.getChildren().add(textoObjeto);

            }
        });

        // Establece un evento de clic en la imagenT12
        imageT12.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Llama a la función mostrarVentanaEmergente con los datos del porta aviones del atlantico norte
                mostrarVentanaEmergente12("Portaaviones", "Información sobre el Portaaviones del atlantico norte ");

            }
        });

        // Establece un evento de clic en la imagenT13
        imageT13.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Llama a la función mostrarVentanaEmergente con los datos del porta aviones del pacifico sur
                mostrarVentanaEmergente13("Portaaviones", "Información sobre el Portaaviones del pacifico sur");

            }
        });

        // Establece un evento de clic en la imagenT14
        imageT14.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Llama a la función mostrarVentanaEmergente con los datos del porta aviones del pacifico norte
                mostrarVentanaEmergente14("Portaaviones", "Información sobre el Portaaviones del pacifico ");

            }
        });

        // Establece un evento de clic en la imagenT15
        imageT15.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Llama a la función mostrarVentanaEmergente con los datos del porta aviones del indico
                mostrarVentanaEmergente15("Portaaviones", "Información sobre el Portaaviones del oceano indico ");

            }
        });

        // Establece un evento de clic en la imagenT16
        imageT16.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Llama a la función mostrarVentanaEmergente con los datos del  segundo porta aviones del pacifico note
                mostrarVentanaEmergente16("Portaaviones", "Información sobre el segundo  Portaaviones del pacifico norte  ");

            }
        });

        // Repite para los demás puntos de portaaviones

        Scene scene = new Scene(root, mapaImage.getWidth(), mapaImage.getHeight());
        primaryStage.setTitle("Mapa Mundial");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Circle createCircle(Point point, Color color) {
        return new Circle(point.x, point.y, CIRCLE_RADIUS);
    }

    private Line createLine(Point startPoint, Point endPoint) {
        return new Line(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    }

    private ImageView createImage(String imageUrl, double x, double y) {
        URL imageURL = getClass().getResource(imageUrl);
        if (imageURL != null) {
            Image image = new Image(imageURL.toExternalForm());
            ImageView imageView = new ImageView(image);
            imageView.setX(x - LOGO_SIZE / 2);
            imageView.setY(y - LOGO_SIZE / 2);
            imageView.setFitWidth(LOGO_SIZE);
            imageView.setFitHeight(LOGO_SIZE);
            return imageView;
        } else {
            // Manejar el caso en el que no se encuentre la imagen
            System.out.println("No se pudo encontrar la imagen: " + imageUrl);
            return null;
        }
    }

    // Método para mostrar una ventana emergente con el título y el contenido de datos

    private void mostrarVentanaEmergente(String titulo, String contenido) {
        Stage ventanaEmergente = new Stage();
        ventanaEmergente.setTitle(titulo);

        BorderPane contenedorPrincipal = new BorderPane();
        contenedorPrincipal.setStyle("-fx-background-color: black;"); // Fondo negro

        StackPane contenedorImagen = new StackPane();
        contenedorImagen.setAlignment(Pos.TOP_LEFT);

        //imagen del pais en donde esta el aereopuerto
        Image imagen = new Image(getClass().getResource("/com/example/imagenes/Canada-sin-fondo.png").toExternalForm());
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        contenedorImagen.getChildren().add(imageView);

        contenedorPrincipal.setTop(contenedorImagen);

        VBox contenidoVentana = new VBox();
        contenidoVentana.setAlignment(Pos.CENTER);
        contenidoVentana.setSpacing(10);

        Label etiquetaContenido = new Label(contenido);
        etiquetaContenido.setStyle("-fx-text-fill: blue;"); // color del  texto de la ventana
        contenidoVentana.getChildren().add(etiquetaContenido);

        contenedorPrincipal.setCenter(contenidoVentana);

        Scene escena = new Scene(contenedorPrincipal, 500, 500); // tamaño de la ventana

        ventanaEmergente.setScene(escena);
        ventanaEmergente.show();
    }
    // Método para mostrar una ventana emergente con el título y el contenido de datos
    private void mostrarVentanaEmergente2(String titulo, String contenido) {
        Stage ventanaEmergente2 = new Stage();
        ventanaEmergente2.setTitle(titulo);

        BorderPane contenedorPrincipal = new BorderPane();
        contenedorPrincipal.setStyle("-fx-background-color: black;"); // Fondo negro

        StackPane contenedorImagen = new StackPane();
        contenedorImagen.setAlignment(Pos.TOP_LEFT);

        //imagen del pais donde esta ubicado el aereopuerto
        Image imagen = new Image(getClass().getResource("/com/example/imagenes/Argentina-sin-fondo.png").toExternalForm());
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        contenedorImagen.getChildren().add(imageView);

        contenedorPrincipal.setTop(contenedorImagen);

        VBox contenidoVentana = new VBox();
        contenidoVentana.setAlignment(Pos.CENTER);
        contenidoVentana.setSpacing(10);

        Label etiquetaContenido = new Label(contenido);
        etiquetaContenido.setStyle("-fx-text-fill: blue;");// color del texto  de la ventana
        contenidoVentana.getChildren().add(etiquetaContenido);

        contenedorPrincipal.setCenter(contenidoVentana);

        Scene escena2 = new Scene(contenedorPrincipal, 500, 500);// tamaño de la ventana

        ventanaEmergente2.setScene(escena2);
        ventanaEmergente2.show();
    }

    // Método para mostrar una ventana emergente con el título y el contenido de datos
    private void mostrarVentanaEmergente3(String titulo, String contenido) {
        Stage ventanaEmergente3 = new Stage();
        ventanaEmergente3.setTitle(titulo);

        BorderPane contenedorPrincipal = new BorderPane();
        contenedorPrincipal.setStyle("-fx-background-color: black;"); // Fondo negro

        StackPane contenedorImagen = new StackPane();
        contenedorImagen.setAlignment(Pos.TOP_LEFT);

        //imagen del pais en donde esta ubicado el aereopuerto
        Image imagen = new Image(getClass().getResource("/com/example/imagenes/USA-sin-fondo.png").toExternalForm());
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        contenedorImagen.getChildren().add(imageView);

        contenedorPrincipal.setTop(contenedorImagen);

        VBox contenidoVentana = new VBox();
        contenidoVentana.setAlignment(Pos.CENTER);
        contenidoVentana.setSpacing(10);

        Label etiquetaContenido = new Label(contenido);
        etiquetaContenido.setStyle("-fx-text-fill: blue;");// borde de la ventana
        contenidoVentana.getChildren().add(etiquetaContenido);

        contenedorPrincipal.setCenter(contenidoVentana);

        Scene escena3 = new Scene(contenedorPrincipal, 500, 500);//tamaño de la ventana

        ventanaEmergente3.setScene(escena3);
        ventanaEmergente3.show();
    }

    // Método para mostrar una ventana emergente con el título y el contenido  de datos
    private void mostrarVentanaEmergente4(String titulo, String contenido) {
        Stage ventanaEmergente4 = new Stage();
        ventanaEmergente4.setTitle(titulo);

        BorderPane contenedorPrincipal = new BorderPane();
        contenedorPrincipal.setStyle("-fx-background-color: black;"); // Fondo negro

        StackPane contenedorImagen = new StackPane();
        contenedorImagen.setAlignment(Pos.TOP_LEFT);

        // imagen del pais donde esta ubicado el aereo puerto
        Image imagen = new Image(getClass().getResource("/com/example/imagenes/brasil-sin-fondo.png").toExternalForm());
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        contenedorImagen.getChildren().add(imageView);

        contenedorPrincipal.setTop(contenedorImagen);

        VBox contenidoVentana = new VBox();
        contenidoVentana.setAlignment(Pos.CENTER);
        contenidoVentana.setSpacing(10);

        Label etiquetaContenido = new Label(contenido);
        etiquetaContenido.setStyle("-fx-text-fill: blue;"); // color del texto de la ventana
        contenidoVentana.getChildren().add(etiquetaContenido);

        contenedorPrincipal.setCenter(contenidoVentana);

        Scene escena4 = new Scene(contenedorPrincipal, 500, 500);// tamaño de la ventana

        ventanaEmergente4.setScene(escena4);
        ventanaEmergente4.show();
    }
    // Método para mostrar una ventana emergente con el título y el contenido de datos
    private void mostrarVentanaEmergente5(String titulo, String contenido) {
        Stage ventanaEmergente5 = new Stage();
        ventanaEmergente5.setTitle(titulo);

        BorderPane contenedorPrincipal = new BorderPane();
        contenedorPrincipal.setStyle("-fx-background-color: black;"); // Fondo negro

        StackPane contenedorImagen = new StackPane();
        contenedorImagen.setAlignment(Pos.TOP_LEFT);
// imagen del pais donde esta  aereo puerto
        Image imagen = new Image(getClass().getResource("/com/example/imagenes/mexico-sin-fondo.png").toExternalForm());
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        contenedorImagen.getChildren().add(imageView);

        contenedorPrincipal.setTop(contenedorImagen);

        VBox contenidoVentana = new VBox();
        contenidoVentana.setAlignment(Pos.CENTER);
        contenidoVentana.setSpacing(10);

        Label etiquetaContenido = new Label(contenido);
        etiquetaContenido.setStyle("-fx-text-fill: blue;");
        contenidoVentana.getChildren().add(etiquetaContenido);

        contenedorPrincipal.setCenter(contenidoVentana);

        Scene escena5 = new Scene(contenedorPrincipal, 500, 500);

        ventanaEmergente5.setScene(escena5);
        ventanaEmergente5.show();
    }
    private void mostrarVentanaEmergente6(String titulo, String contenido) {
        Stage ventanaEmergente6 = new Stage();
        ventanaEmergente6.setTitle(titulo);

        BorderPane contenedorPrincipal = new BorderPane();
        contenedorPrincipal.setStyle("-fx-background-color: black;"); // Fondo negro

        StackPane contenedorImagen = new StackPane();
        contenedorImagen.setAlignment(Pos.TOP_LEFT);

        Image imagen = new Image(getClass().getResource("/com/example/imagenes/rusia-sin-fondo.png").toExternalForm());
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        contenedorImagen.getChildren().add(imageView);

        contenedorPrincipal.setTop(contenedorImagen);

        VBox contenidoVentana = new VBox();
        contenidoVentana.setAlignment(Pos.CENTER);
        contenidoVentana.setSpacing(10);

        Label etiquetaContenido = new Label(contenido);
        etiquetaContenido.setStyle("-fx-text-fill: blue;");
        contenidoVentana.getChildren().add(etiquetaContenido);

        contenedorPrincipal.setCenter(contenidoVentana);

        Scene escena6 = new Scene(contenedorPrincipal, 500, 500);

        ventanaEmergente6.setScene(escena6);
        ventanaEmergente6.show();
    }
    private void mostrarVentanaEmergente7(String titulo, String contenido) {
        Stage ventanaEmergente7 = new Stage();
        ventanaEmergente7.setTitle(titulo);

        BorderPane contenedorPrincipal = new BorderPane();
        contenedorPrincipal.setStyle("-fx-background-color: black;"); // Fondo negro

        StackPane contenedorImagen = new StackPane();
        contenedorImagen.setAlignment(Pos.TOP_LEFT);

        Image imagen = new Image(getClass().getResource("/com/example/imagenes/groenlandia-sin-fondo.png").toExternalForm());
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        contenedorImagen.getChildren().add(imageView);

        contenedorPrincipal.setTop(contenedorImagen);

        VBox contenidoVentana = new VBox();
        contenidoVentana.setAlignment(Pos.CENTER);
        contenidoVentana.setSpacing(10);

        Label etiquetaContenido = new Label(contenido);
        etiquetaContenido.setStyle("-fx-text-fill: blue;");
        contenidoVentana.getChildren().add(etiquetaContenido);

        contenedorPrincipal.setCenter(contenidoVentana);

        Scene escena7 = new Scene(contenedorPrincipal, 500, 500);

        ventanaEmergente7.setScene(escena7);
        ventanaEmergente7.show();
    }
    private void mostrarVentanaEmergente8(String titulo, String contenido) {
        Stage ventanaEmergente8 = new Stage();
        ventanaEmergente8.setTitle(titulo);

        BorderPane contenedorPrincipal = new BorderPane();
        contenedorPrincipal.setStyle("-fx-background-color: black;"); // Fondo negro

        StackPane contenedorImagen = new StackPane();
        contenedorImagen.setAlignment(Pos.TOP_LEFT);

        Image imagen = new Image(getClass().getResource("/com/example/imagenes/china-sin-fondo.png").toExternalForm());
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        contenedorImagen.getChildren().add(imageView);

        contenedorPrincipal.setTop(contenedorImagen);

        VBox contenidoVentana = new VBox();
        contenidoVentana.setAlignment(Pos.CENTER);
        contenidoVentana.setSpacing(10);

        Label etiquetaContenido = new Label(contenido);
        etiquetaContenido.setStyle("-fx-text-fill: blue;");
        contenidoVentana.getChildren().add(etiquetaContenido);

        contenedorPrincipal.setCenter(contenidoVentana);

        Scene escena8 = new Scene(contenedorPrincipal, 500, 500);

        ventanaEmergente8.setScene(escena8);
        ventanaEmergente8.show();
    }
    private void mostrarVentanaEmergente9(String titulo, String contenido) {
        Stage ventanaEmergente9 = new Stage();
        ventanaEmergente9.setTitle(titulo);

        BorderPane contenedorPrincipal = new BorderPane();
        contenedorPrincipal.setStyle("-fx-background-color: black;"); // Fondo negro

        StackPane contenedorImagen = new StackPane();
        contenedorImagen.setAlignment(Pos.TOP_LEFT);

        Image imagen = new Image(getClass().getResource("/com/example/imagenes/australia-sin-fondo.png").toExternalForm());
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        contenedorImagen.getChildren().add(imageView);

        contenedorPrincipal.setTop(contenedorImagen);

        VBox contenidoVentana = new VBox();
        contenidoVentana.setAlignment(Pos.CENTER);
        contenidoVentana.setSpacing(10);

        Label etiquetaContenido = new Label(contenido);
        etiquetaContenido.setStyle("-fx-text-fill: blue;");
        contenidoVentana.getChildren().add(etiquetaContenido);

        contenedorPrincipal.setCenter(contenidoVentana);

        Scene escena9 = new Scene(contenedorPrincipal, 500, 500);

        ventanaEmergente9.setScene(escena9);
        ventanaEmergente9.show();
    }
    private void mostrarVentanaEmergente10(String titulo, String contenido) {
        Stage ventanaEmergente10 = new Stage();
        ventanaEmergente10.setTitle(titulo);

        BorderPane contenedorPrincipal = new BorderPane();
        contenedorPrincipal.setStyle("-fx-background-color: black;"); // Fondo negro

        StackPane contenedorImagen = new StackPane();
        contenedorImagen.setAlignment(Pos.TOP_LEFT);

        Image imagen = new Image(getClass().getResource("/com/example/imagenes/libia-sin-fondo.png").toExternalForm());
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        contenedorImagen.getChildren().add(imageView);

        contenedorPrincipal.setTop(contenedorImagen);

        VBox contenidoVentana = new VBox();
        contenidoVentana.setAlignment(Pos.CENTER);
        contenidoVentana.setSpacing(10);

        Label etiquetaContenido = new Label(contenido);
        etiquetaContenido.setStyle("-fx-text-fill: blue;");
        contenidoVentana.getChildren().add(etiquetaContenido);

        contenedorPrincipal.setCenter(contenidoVentana);

        Scene escena10 = new Scene(contenedorPrincipal, 500, 500);

        ventanaEmergente10.setScene(escena10);
        ventanaEmergente10.show();
    }
    private void mostrarVentanaEmergente11(String titulo, String contenido) {
        Stage ventanaEmergente11 = new Stage();
        ventanaEmergente11.setTitle(titulo);

        BorderPane contenedorPrincipal = new BorderPane();
        contenedorPrincipal.setStyle("-fx-background-color: black;"); // Fondo negro

        StackPane contenedorImagen = new StackPane();
        contenedorImagen.setAlignment(Pos.TOP_LEFT);

        Image imagen = new Image(getClass().getResource("/com/example/imagenes/porta_aviones-sin-fondo.png").toExternalForm());
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        contenedorImagen.getChildren().add(imageView);

        contenedorPrincipal.setTop(contenedorImagen);

        VBox contenidoVentana = new VBox();
        contenidoVentana.setAlignment(Pos.CENTER);
        contenidoVentana.setSpacing(10);

        Label etiquetaContenido = new Label(contenido);
        etiquetaContenido.setStyle("-fx-text-fill: blue;");
        contenidoVentana.getChildren().add(etiquetaContenido);

        contenedorPrincipal.setCenter(contenidoVentana);

        Scene escena11 = new Scene(contenedorPrincipal, 500, 500);

        ventanaEmergente11.setScene(escena11);
        ventanaEmergente11.show();
    }
    private void mostrarVentanaEmergente12(String titulo, String contenido) {
        Stage ventanaEmergente12 = new Stage();
        ventanaEmergente12.setTitle(titulo);

        BorderPane contenedorPrincipal = new BorderPane();
        contenedorPrincipal.setStyle("-fx-background-color: black;"); // Fondo negro

        StackPane contenedorImagen = new StackPane();
        contenedorImagen.setAlignment(Pos.TOP_LEFT);

        Image imagen = new Image(getClass().getResource("/com/example/imagenes/porta_aviones-sin-fondo.png").toExternalForm());
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        contenedorImagen.getChildren().add(imageView);

        contenedorPrincipal.setTop(contenedorImagen);

        VBox contenidoVentana = new VBox();
        contenidoVentana.setAlignment(Pos.CENTER);
        contenidoVentana.setSpacing(10);

        Label etiquetaContenido = new Label(contenido);
        etiquetaContenido.setStyle("-fx-text-fill: blue;");
        contenidoVentana.getChildren().add(etiquetaContenido);

        contenedorPrincipal.setCenter(contenidoVentana);

        Scene escena12 = new Scene(contenedorPrincipal, 500, 500);

        ventanaEmergente12.setScene(escena12);
        ventanaEmergente12.show();
    }
    private void mostrarVentanaEmergente13(String titulo, String contenido) {
        Stage ventanaEmergente13 = new Stage();
        ventanaEmergente13.setTitle(titulo);

        BorderPane contenedorPrincipal = new BorderPane();
        contenedorPrincipal.setStyle("-fx-background-color: black;"); // Fondo negro

        StackPane contenedorImagen = new StackPane();
        contenedorImagen.setAlignment(Pos.TOP_LEFT);

        Image imagen = new Image(getClass().getResource("/com/example/imagenes/porta_aviones-sin-fondo.png").toExternalForm());
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        contenedorImagen.getChildren().add(imageView);

        contenedorPrincipal.setTop(contenedorImagen);

        VBox contenidoVentana = new VBox();
        contenidoVentana.setAlignment(Pos.CENTER);
        contenidoVentana.setSpacing(10);

        Label etiquetaContenido = new Label(contenido);
        etiquetaContenido.setStyle("-fx-text-fill: blue;");
        contenidoVentana.getChildren().add(etiquetaContenido);

        contenedorPrincipal.setCenter(contenidoVentana);

        Scene escena13 = new Scene(contenedorPrincipal, 500, 500);

        ventanaEmergente13.setScene(escena13);
        ventanaEmergente13.show();
    }
    private void mostrarVentanaEmergente14(String titulo, String contenido) {
        Stage ventanaEmergente14 = new Stage();
        ventanaEmergente14.setTitle(titulo);

        BorderPane contenedorPrincipal = new BorderPane();
        contenedorPrincipal.setStyle("-fx-background-color: black;"); // Fondo negro

        StackPane contenedorImagen = new StackPane();
        contenedorImagen.setAlignment(Pos.TOP_LEFT);

        Image imagen = new Image(getClass().getResource("/com/example/imagenes/porta_aviones-sin-fondo.png").toExternalForm());
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        contenedorImagen.getChildren().add(imageView);

        contenedorPrincipal.setTop(contenedorImagen);

        VBox contenidoVentana = new VBox();
        contenidoVentana.setAlignment(Pos.CENTER);
        contenidoVentana.setSpacing(10);

        Label etiquetaContenido = new Label(contenido);
        etiquetaContenido.setStyle("-fx-text-fill: blue;");
        contenidoVentana.getChildren().add(etiquetaContenido);

        contenedorPrincipal.setCenter(contenidoVentana);

        Scene escena14 = new Scene(contenedorPrincipal, 500, 500);

        ventanaEmergente14.setScene(escena14);
        ventanaEmergente14.show();
    }
    private void mostrarVentanaEmergente15(String titulo, String contenido) {
        Stage ventanaEmergente15 = new Stage();
        ventanaEmergente15.setTitle(titulo);

        BorderPane contenedorPrincipal = new BorderPane();
        contenedorPrincipal.setStyle("-fx-background-color: black;"); // Fondo negro

        StackPane contenedorImagen = new StackPane();
        contenedorImagen.setAlignment(Pos.TOP_LEFT);

        Image imagen = new Image(getClass().getResource("/com/example/imagenes/porta_aviones-sin-fondo.png").toExternalForm());
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        contenedorImagen.getChildren().add(imageView);

        contenedorPrincipal.setTop(contenedorImagen);

        VBox contenidoVentana = new VBox();
        contenidoVentana.setAlignment(Pos.CENTER);
        contenidoVentana.setSpacing(10);

        Label etiquetaContenido = new Label(contenido);
        etiquetaContenido.setStyle("-fx-text-fill: blue;");
        contenidoVentana.getChildren().add(etiquetaContenido);

        contenedorPrincipal.setCenter(contenidoVentana);

        Scene escena15 = new Scene(contenedorPrincipal, 500, 500);

        ventanaEmergente15.setScene(escena15);
        ventanaEmergente15.show();
    }
    private void mostrarVentanaEmergente16(String titulo, String contenido) {
        Stage ventanaEmergente16 = new Stage();
        ventanaEmergente16.setTitle(titulo);

        BorderPane contenedorPrincipal = new BorderPane();
        contenedorPrincipal.setStyle("-fx-background-color: black;"); // Fondo negro

        StackPane contenedorImagen = new StackPane();
        contenedorImagen.setAlignment(Pos.TOP_LEFT);

        Image imagen = new Image(getClass().getResource("/com/example/imagenes/porta_aviones-sin-fondo.png").toExternalForm());
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        contenedorImagen.getChildren().add(imageView);

        contenedorPrincipal.setTop(contenedorImagen);

        VBox contenidoVentana = new VBox();
        contenidoVentana.setAlignment(Pos.CENTER);
        contenidoVentana.setSpacing(10);

        Label etiquetaContenido = new Label(contenido);
        etiquetaContenido.setStyle("-fx-text-fill: blue;");
        contenidoVentana.getChildren().add(etiquetaContenido);

        contenedorPrincipal.setCenter(contenidoVentana);

        Scene escena16 = new Scene(contenedorPrincipal, 500, 500);

        ventanaEmergente16.setScene(escena16);
        ventanaEmergente16.show();
    }





    public static void main(String[] args) {
        launch(args);

    }
}
