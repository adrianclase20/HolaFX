package ud1;

// WindowEventApp.java

import javafx.application.Application;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import static javafx.stage.WindowEvent.WINDOW_CLOSE_REQUEST;

public class prWindowEventApp extends Application {
    private CheckBox checkBoxCerrar;

    // Método principal para iniciar la aplicación
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    // Método start, que configura la interfaz de usuario
    public void start(Stage stage) {
        checkBoxCerrar = new CheckBox("Puede cerrar la ventana");
        Button closeBtn = new Button("Cerrar");
         // Cierra la ventana principal
        closeBtn.setOnAction(e -> stage.close()); 
        Button btnOcultar = new Button("Ocultar");
        btnOcultar.setOnAction(e -> {
            // Muestra una ventana emergente
            showDialog(stage);  
            // Oculta la ventana principal
            stage.hide();  
        });

        // Configura el diseño de la interfaz de usuario usando un HBox
        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(checkBoxCerrar, closeBtn, btnOcultar);

        // Agrega manejadores de eventos de ventana a la ventana principal
         // Cuando la ventana se está mostrando
        stage.setOnShowing(e -> handle(e)); 
        // Después de que la ventana se muestra
        stage.setOnShown(e -> handle(e));    
        // Cuando la ventana se está ocultando
        stage.setOnHiding(e -> handle(e));  
        // Después de que la ventana se oculta
        stage.setOnHidden(e -> handle(e));    
        // Cuando se solicita cerrar la ventana
        stage.setOnCloseRequest(e -> handle(e));  

        // Configura la escena y muestra la ventana principal
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Eventos de Ventana");
        stage.show();
    }

    // Manejador de eventos de ventana
    public void handle(WindowEvent e) {
        // Consume el evento si la casilla de verificación no está seleccionada
        // para evitar que el usuario cierre la ventana
        EventType<WindowEvent> type = e.getEventType();
        if (type == WINDOW_CLOSE_REQUEST && !checkBoxCerrar.isSelected()) {
            e.consume();
        }
        System.out.println(type + ": Consumido=" + e.isConsumed());
    }

    // Método para mostrar una ventana emergente
    public void showDialog(Stage mainWindow) {
        Stage popup = new Stage();
        Button closeBtn = new Button("Haga clic para mostrar la ventana principal");
        closeBtn.setOnAction(e -> {
            popup.close();
            // Muestra la ventana principal nuevamente
            mainWindow.show();  
        });

        // Configura la interfaz de usuario de la ventana emergente
        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(closeBtn);
        Scene scene = new Scene(root);
        popup.setScene(scene);
        popup.setTitle("Ventana Emergente");
        popup.show();
    }
}
