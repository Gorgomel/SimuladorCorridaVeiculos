package poo.trabalho1;
import poo.trabalho1.fun.*;
import poo.trabalho1.gui.*;

import java.security.acl.Group;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;


public class App extends Application implements EventHandler<ActionEvent>{
    public static void main(String[] args) throws Exception {
        launch(args);
    }   



    @Override
    public void start(Stage primaryStage) throws Exception {

    primaryStage.setTitle("Simulador de Veiculos");
    Stage window = primaryStage;
    window.setResizable(false);

    window.setOnCloseRequest(e -> {
        e.consume();
        closeProgram(window);
    });

    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);//Posição Horizontal do botao na tela
    grid.setVgap(10);//Posição Vertical do botao na tela
    grid.setPadding(new Insets(25, 25, 25, 25));

    Label label1 = new Label("Simulador de Veiculos");
    label1.setLineSpacing(2);
    label1.setUnderline(true);
    grid.add(label1,0, 0);

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
            window.close();
            Stage second = new Stage();
            second.setTitle("Simulador de Veiculos");

            BorderPane border = new BorderPane();
            ListView list = new ListView();
            BorderPane.setAlignment(list, Pos.TOP_LEFT);
            BorderPane.setMargin(list, new Insets(15,100,12,10));
            border.setCenter(list);

            /*Image image = new Image("C:\\Users\\Brunn\\OneDrive\\Área de Trabalho\\2022-2\\POO\\RaceSimulator\\src\\poo\\trabalho1\\aaa.png");

            ImageView iv1 = new ImageView();
            iv1.setImage(image);
            iv1.setFitWidth(100);
            iv1.setPreserveRatio(true);
            iv1.setSmooth(true);
            iv1.setCache(true);
            border.setLeft(iv1);

            ImageView iv2 = new ImageView();
            iv2.setImage(image);
            iv2.setFitWidth(100);
            iv2.setPreserveRatio(true);
            iv2.setSmooth(true);
            iv2.setCache(true);

            ImageView iv3 = new ImageView();
            iv3.setImage(image);
            Rectangle2D viewportRect = new Rectangle2D(40,35,110,110);
            iv3.setViewport(viewportRect);
            iv3.setRotate(90); */
     
            Button inserir = new Button("Inserir");
            Button remover = new Button("Remover");
            Button abastecer = new Button("Abastecer");
            Button movimentarUm = new Button("Movimentar um veiculo");
            Button movimentarTodos = new Button("Movimentar todos os veiculos");
            Button calibrar = new Button("Calibrar");
            Button calibrarTodas = new Button("Calibrar todas as Rodas");

            VBox vbox = new VBox(13);
            vbox.setAlignment(Pos.BASELINE_RIGHT);
            vbox.setSpacing(5);
            vbox.getChildren().addAll(inserir, remover, abastecer, movimentarUm, movimentarTodos, calibrar, calibrarTodas);
            border.setRight(vbox);

            inserir.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {

                    TextInputDialog tex = new TextInputDialog();
                    tex.setResult("1230");
                    tex.setTitle("Definir ID");
		            tex.setHeaderText("ID");
		            tex.setContentText("Insira o ID");
		            tex.showAndWait();

                    int i = Integer.parseInt(tex.getResult());

                    if(i == 1230){
                        System.out.println("mas bag");
                    }

                    else
                    System.out.println("no bag");
                    
                }
            });

            Scene scene2 = new Scene (border, 1200, 700);
            second.setMaximized(true);
            second.setScene(scene2); 
            second.show();
        }

    });

    Scene scene = new Scene(grid, 300, 300, Color.BLACK);//Tamanho da tela 
    window.setScene(scene);
    window.show();
   
}

    private void closeProgram(Stage window) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Title here");
		alert.setHeaderText("headerText here");
		alert.setContentText("Sure you want to do that?");
		alert.showAndWait();
		
		if(alert.getResult() == ButtonType.OK) {
			System.out.println(alert.getResult().getText()  + " was pressed!");
			
			//System.out.println("File is saved!");
			window.close();
		}
    }
    

    @Override
    public void handle(ActionEvent event) {
        // TODO Auto-generated method stub
        
    }

    

}