import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class pruebaBotones extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage escenario) {
        //guarda un mensaje temporal
		Text mensaje= new Text("Saludo Vacio");

        //botones para cambiar texto
        Button  btnHola= new Button("Hola");
        Button  btnAdios= new Button("Adios");  

        btnHola.setOnAction (e -> mensaje.setText("hola"));
        btnAdios.setOnAction(e -> mensaje.setText("adios"));

        

        VBox raiz= new VBox();
        raiz.getChildren().addAll(mensaje, btnHola, btnAdios);                                                     

       

        Scene scn= new Scene(raiz, 300, 200);
        escenario.setScene(scn);
		escenario.setTitle("HolaFX , mi primerFX");
		escenario.show();

        
	}
	
}

