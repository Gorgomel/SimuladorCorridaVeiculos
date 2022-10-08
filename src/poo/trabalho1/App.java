package poo.trabalho1;
import poo.trabalho1.fun.*;
import poo.trabalho1.gui.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class App extends Application implements EventHandler<ActionEvent>{
    public static void main(String[] args) throws Exception {
        launch(args);
    }   

    @Override
    public void start(Stage primaryStage) throws Exception {
    //FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("gui\\layout.fxml")); 
    //Parent root = fxmlloader.load();

    primaryStage.setTitle("Simulador de Veiculos");
    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);//Posição Horizontal do botao na tela
    grid.setVgap(10);//Posição Vertical do botao na tela
    grid.setPadding(new Insets(25, 25, 25, 25));

    
    Button bIniciar = new Button("Iniciar");
    HBox hbIniciar = new HBox(20);
    hbIniciar.setAlignment(Pos.BOTTOM_RIGHT);
    hbIniciar.getChildren().add(bIniciar);
    grid.add(hbIniciar, 1, 4);//Tambem altera a posiçao do botao

    final Text actiontarget = new Text();
    grid.add(actiontarget, 1, 6);

    bIniciar.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent e){
            actiontarget.setFill(Color.FIREBRICK);
            actiontarget.setText("testa isso aiii");

        }

    });

    Scene scene = new Scene(grid, 300, 275);
    primaryStage.setScene(scene);
    primaryStage.show();
}

    @Override
    public void handle(ActionEvent event) {
        // TODO Auto-generated method stub
        
    }

    

}