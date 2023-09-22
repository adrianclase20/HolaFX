package ud1;

// FlowPaneTest.java

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;



public class prFlowPaneTest extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage escenario) {
        double hgap = 5;
        double vgap = 10;
        
        // Creamos un nuevo FlowPane con espaciado horizontal (hgap) y vertical (vgap)
        FlowPane root = new FlowPane(hgap, vgap);
        
        // Agregamos diez botones al FlowPane
        for(int i = 1; i <= 10; i++) {
            root.getChildren().add(new Button("Botón " + i));
        }
        
        // Aplicamos un estilo al FlowPane utilizando CSS
        root.setStyle("-fx-padding: 10;" + 
                      "-fx-border-style: solid inside;" + 
                      "-fx-border-width: 2;" +
                      "-fx-border-insets: 5;" + 
                      "-fx-border-radius: 5;" + 
                      "-fx-border-color: blue;");
        
        // Creamos una escena y la configuramos en el escenario (stage)
        Scene scene = new Scene(root);
        escenario.setScene(scene);
        
        // Establecemos el título de la ventana
        escenario.setTitle("Un FlowPane Horizontal");
        
        // Mostramos la ventana
        escenario.show();
    }
}
