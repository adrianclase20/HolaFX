package ud1;
// MicroHelpApp.java

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class prMicroHelpApp extends Application {
    private Text textodeayuda = new Text();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage escenario) {
        TextField nombre = new TextField();
        TextField apellido = new TextField();
        TextField salario = new TextField();
        Button BtnCerrar = new Button("Close");
        BtnCerrar.setOnAction(e -> Platform.exit());
        nombre.getProperties().put("microHelpText", "Introduce tu nombre");
        apellido.getProperties().put("microHelpText", "Introduce tu apellido");
        salario.getProperties().put("microHelpText", "Ingrese un salario mayor a $2000.00");
        // The help text node is unmanaged
        textodeayuda.setManaged(false);
        textodeayuda.setTextOrigin(VPos.TOP);
        textodeayuda.setFill(Color.RED);
        textodeayuda.setFont(Font.font(null, 9));
        textodeayuda.setMouseTransparent(true);
        // Add all nodes to a GridPane
        GridPane root = new GridPane();
        root.add(new Label("Nombre:"), 1, 1);
        root.add(nombre, 2, 1);
        root.add(new Label("Apellido:"), 1, 2);
        root.add(apellido, 2, 2);
        root.add(new Label("Salario:"), 1, 3);
        root.add(salario, 2, 3);
        root.add(BtnCerrar, 3, 3);
        root.add(textodeayuda, 4, 3);
        Scene escena = new Scene(root, 300, 100);
        // Add a change listener to the scene, so we know when
        // the focus owner changes and display the micro help
        escena.focusOwnerProperty().addListener((ObservableValue<? extends Node> value, Node oldNode, Node newNode) -> focusChanged(value, oldNode, newNode));
        escenario.setScene(escena);
        escenario.setTitle("Showing Micro Help");
        escenario.show();
    }

    public void focusChanged(ObservableValue<? extends Node> value, Node nodoViejo, Node nodoNuevo) {
        // Focus has changed to a new node
        String microHelpText = (String) nodoNuevo.getProperties().get("microHelpText");
        if (microHelpText != null && microHelpText.trim().length() > 0) {
            textodeayuda.setText(microHelpText);
            textodeayuda.setVisible(true);
            // Position the help text node
            double x = nodoNuevo.getLayoutX() + nodoNuevo.getLayoutBounds().getMinX() - textodeayuda.getLayoutBounds().getMinX();
            double y = nodoNuevo.getLayoutY() + nodoNuevo.getLayoutBounds().getMinY() + nodoNuevo.getLayoutBounds().getHeight() - textodeayuda.getLayoutBounds().getMinX();
            textodeayuda.setLayoutX(x);
            textodeayuda.setLayoutY(y);
            textodeayuda.setWrappingWidth(nodoNuevo.getLayoutBounds().getWidth());
        } else {
            textodeayuda.setVisible(false);
        }
    }
}