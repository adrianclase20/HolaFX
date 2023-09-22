package ud1;

// FlowPaneAlignment.java
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class prFlowPaneAlignment extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage escenario) {
        // Creamos FlowPanes con diferentes alineaciones
        FlowPane fp1 = createFlowPane(Pos.BOTTOM_RIGHT);
        FlowPane fp2 = createFlowPane(Pos.BOTTOM_LEFT);
        FlowPane fp3 = createFlowPane(Pos.CENTER);
        FlowPane fp4 = createFlowPane(Pos.TOP_CENTER);
        FlowPane fp5 = createFlowPane(Pos.TOP_LEFT);
        FlowPane fp6 = createFlowPane(Pos.TOP_RIGHT);

        // Colocamos los FlowPanes en un HBox para mostrarlos horizontalmente
        HBox root = new HBox(fp1, fp2, fp3, fp4, fp5, fp6);
        Scene escena = new Scene(root);

        // Configuramos la escena en el escenario (stage)
        escenario.setScene(escena);

        // Establecemos el título de la ventana
        escenario.setTitle("Alineación de FlowPane");

        // Mostramos la ventana
        escenario.show();
    }

    // Método para crear un FlowPane con una alineación específica
    private FlowPane createFlowPane(Pos alineados) {
        FlowPane fp = new FlowPane(5, 5);
        fp.setPrefSize(200, 100);
        fp.setAlignment(alineados);

        // Agregamos elementos al FlowPane, incluyendo un Text para mostrar la alineación
        fp.getChildren().addAll(new Text(alineados.toString()), 
                                new Button("Botón 1"), 
                                new Button("Botón 2"),
                                new Button("Botón 3"));

        // Aplicamos un estilo con borde azul al FlowPane
        fp.setStyle("-fx-padding: 10;" +
                    "-fx-border-style: solid inside;" + 
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 5;" + 
                    "-fx-border-radius: 5;" + 
                    "-fx-border-color: blue;");
        return fp;
    }
}
