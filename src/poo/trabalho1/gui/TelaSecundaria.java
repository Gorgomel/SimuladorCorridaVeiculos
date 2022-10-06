package poo.trabalho1.gui;
import poo.trabalho1.fun.Principal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.HBox;

public class TelaSecundaria {
    Principal principal = new Principal();

    @FXML
    private Button abastecer;

    @FXML
    private Button calibrar;

    @FXML
    private Button calibrarTodos;

    @FXML
    private Button imprimir;

    @FXML
    private Button imprimirTodos;

    @FXML
    private Button incluir;

    @FXML
    private HBox menu;

    @FXML
    private Button mover;

    @FXML
    private Button remover;

    @FXML
    private Button sair;

    @FXML
    void abastecerVeiculo(ActionEvent event){
        principal.abastecerVeiculo();
    }

    @FXML
    void calibrar(ActionEvent event) {

    }

    @FXML
    void calibrarTodos(ActionEvent event) {

    }

    @FXML
    void imprimirDados(ActionEvent event) {

    }

    @FXML
    void imprimirTodosDados(ActionEvent event) {

    }

    @FXML
    void incluirVeiculo(ActionEvent event) {
        principal.incluirVeiculo();

    }

    @FXML
    void movimentarTodosVeiculos(ActionEvent event) {

    }

    @FXML
    void movimentarVeiculo(ActionEvent event) {

    }

    @FXML
    void removerVeiculo(ActionEvent event) {

    }

}


