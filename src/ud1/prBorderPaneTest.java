package ud1;

// BorderPaneTest.java
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class prBorderPaneTest extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage escenario) {
        // Establecemos los nodos superiores e izquierdos como nulos
        Node top = null;
        Node left = null;
        
        // Construimos los nodos de contenido para la región central
        VBox center = getCenter();
        
        // Creamos el nodo hijo derecho
        Button btnAceptar = new Button("Aceptar");
        Button btnCancelar = new Button("Cancelar");
        
        // Hacemos que los botones "Aceptar" y "Cancelar" tengan el mismo tamaño
        btnAceptar.setMaxWidth(Double.MAX_VALUE);
        VBox right = new VBox(btnAceptar, btnCancelar);
        right.setStyle("-fx-padding: 10;");
        
        // Creamos el nodo hijo inferior
        Label statusLbl = new Label("Estado: Listo");
        HBox bottom = new HBox(statusLbl);
        BorderPane.setMargin(bottom, new Insets(10, 0, 0, 0));
        bottom.setStyle("-fx-background-color: lavender;" +
                        "-fx-font-size: 7pt;" +
                        "-fx-padding: 10 0 0 0;");
        
        // Creamos un BorderPane y configuramos sus nodos hijos
        BorderPane root = new BorderPane(center, top, right, bottom, left);
        root.setStyle("-fx-background-color: lightgray;");
        
        // Creamos una escena y la configuramos en el escenario (stage)
        Scene escena = new Scene(root);
        escenario.setScene(escena);
        
        // Establecemos el título de la ventana
        escenario.setTitle("Usando un BorderPane");
        
        // Mostramos la ventana
        escenario.show();
    }

    private VBox getCenter() {
        // Un Label y un TextField en un HBox
        Label lblNombre = new Label("Nombre:");
        TextField fldTexto = new TextField();
        HBox.setHgrow(fldTexto, Priority.ALWAYS);
        HBox nameFields = new HBox(lblNombre, fldTexto);
        
        // Un Label y un TextArea
        Label lblDesc = new Label("Descripción:");
        TextArea descText = new TextArea();
        descText.setPrefColumnCount(20);
        descText.setPrefRowCount(5);
        VBox.setVgrow(descText, Priority.ALWAYS);
        
        // Agrupamos todos los controles en un VBox
        VBox center = new VBox(nameFields, lblDesc, descText);
        return center;
    }
}
