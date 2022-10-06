package poo.trabalho1;
import poo.trabalho1.fun.*;
import poo.trabalho1.gui.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class App extends Application implements EventHandler<ActionEvent>{
    public static void main(String[] args) throws Exception {
        launch(args);
    }   

    @Override
    public void start(Stage primaryStage) throws Exception {
    FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("gui\\layout.fxml")); 
    Parent root = fxmlloader.load();
    Scene scene = new Scene(root);

    
    primaryStage.setTitle("Simulador de Veiculos");
    primaryStage.setScene(scene);
    primaryStage.show();
}

    @Override
    public void handle(ActionEvent event) {
        // TODO Auto-generated method stub
        
    }

    public class TelaInicial {

        @FXML
        private Button buttonInciar;
    
        @FXML
        private Button buttonSair;
    
        @FXML
        private MenuBar menuBar;
    
        @FXML
        void goToScene2(ActionEvent event) {
           TelaSecundaria telasecundaria = new TelaSecundaria();

           

             
        }
    
    }

}