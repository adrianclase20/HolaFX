package ud1;
// EventRegistration.java
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class prEventRegistration extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage escenario) {
        // Crear un círculo con centro en (100, 100) y radio de 50
        Circle circle = new Circle(100, 100, 50);
        circle.setFill(Color.CYAN); // Establecer el color de relleno del círculo
    
        // Crear un controlador de eventos de mouse utilizando una expresión lambda
        EventHandler<MouseEvent> mouseEventHandler = e -> System.out.println("Se ha llamado al controlador de eventos del mouse.");
    
        // Agregar el controlador de eventos al círculo para el evento MOUSE_CLICKED
        circle.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
    
        // Crear un contenedor horizontal (HBox) y agregar el círculo a él
        HBox root = new HBox();
        root.getChildren().add(circle);
    
        // Crear una escena con el contenedor
        Scene escena = new Scene(root);
    
        // Establecer la escena en el escenario y configurar detalles del escenario
        escenario.setScene(escena);
        escenario.setTitle("Registrando Controladores de Eventos");
        escenario.show();
        escenario.sizeToScene(); // Ajustar el tamaño del escenario según el contenido
    }
    
}