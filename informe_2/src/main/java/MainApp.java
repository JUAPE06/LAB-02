package com.laboratorio.proyectoucv;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        TabPane root = new TabPane();

        // --- PESTAÑA 1: LLAMADAS ---
        Tab tabLlamadas = new Tab("Registro de Llamadas");
        tabLlamadas.setClosable(false);
        GridPane grid1 = crearGridBase();

        ComboBox<String> cbTipoLlamada = new ComboBox<>();
        cbTipoLlamada.getItems().addAll("Fijo", "Celular");
        TextField txtMinutos = new TextField();
        ComboBox<String> cbHorario = new ComboBox<>();
        cbHorario.getItems().addAll("Mañana-Tarde", "Noche-Madrugada");
        Button btnCalc1 = new Button("Calcular Costos");
        TextArea output1 = new TextArea();
        output1.setEditable(false);

        grid1.addRow(0, new Label("Tipo de Llamada:"), cbTipoLlamada);
        grid1.addRow(1, new Label("Minutos:"), txtMinutos);
        grid1.addRow(2, new Label("Horario:"), cbHorario);
        grid1.addRow(3, btnCalc1);
        grid1.add(output1, 0, 4, 2, 1);

        btnCalc1.setOnAction(e -> {
            try {
                Llamada ll = new Llamada(cbTipoLlamada.getValue(), Double.parseDouble(txtMinutos.getText()), cbHorario.getValue());
                output1.setText("Costo/Min: S/ " + ll.calcularCostoPorMinuto() + "\nTotal: S/ " + String.format("%.2f", ll.calcularCostoTotal()));
            } catch (Exception ex) { output1.setText("Error en los datos."); }
        });
        tabLlamadas.setContent(grid1);

        // --- PESTAÑA 2: EMBARQUE ---
        Tab tabEmbarque = new Tab("Gestión de Embarques");
        tabEmbarque.setClosable(false);
        GridPane grid2 = crearGridBase();

        TextField txtCodigo = new TextField();
        TextField txtDistribuidor = new TextField();
        ComboBox<String> cbLadrillo = new ComboBox<>();
        cbLadrillo.getItems().addAll("King Kong", "Pandereta");
        ComboBox<String> cbCamion = new ComboBox<>();
        cbCamion.getItems().addAll("Paletizados", "Con Guinche");
        TextField txtCantidad = new TextField();
        Button btnCalc2 = new Button("Procesar Embarque");
        TextArea output2 = new TextArea();

        grid2.addRow(0, new Label("Código:"), txtCodigo);
        grid2.addRow(1, new Label("Distribuidor:"), txtDistribuidor);
        grid2.addRow(2, new Label("Ladrillo:"), cbLadrillo);
        grid2.addRow(3, new Label("Camión:"), cbCamion);
        grid2.addRow(4, new Label("Cantidad:"), txtCantidad);
        grid2.addRow(5, btnCalc2);
        grid2.add(output2, 0, 6, 2, 1);

        btnCalc2.setOnAction(e -> {
            try {
                Embarque emb = new Embarque(txtCodigo.getText(), txtDistribuidor.getText(), cbLadrillo.getValue(), cbCamion.getValue(), Integer.parseInt(txtCantidad.getText()));
                output2.setText("Resumen para: " + txtDistribuidor.getText() + "\nGastos Envio: S/ " + emb.calcularGastosEnvio() + "\nCosto Total (Inc. IGV): S/ " + String.format("%.2f", emb.calcularCostoTotalEmbarque()));
            } catch (Exception ex) { output2.setText("Error en los datos."); }
        });
        tabEmbarque.setContent(grid2);

        root.getTabs().addAll(tabLlamadas, tabEmbarque);
        Scene scene = new Scene(root, 450, 550);

        // Carga del CSS para el Dark Mode
        String css = getClass().getResource("/style.css").toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.setTitle("Laboratorio 02 - POO");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane crearGridBase() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(15);
        return grid;
    }

    public static void main(String[] args) {
        launch(args);
    }
}