package com.example.graphicproject;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class secondPractice {
    public static void sceneMain(Stage stage) {
        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-border-color: green; -fx-border-insets: 5; -fx-border-width: 3;");
        root.setPrefSize(663.0, 470.0);

        TabPane tabPane = new TabPane();
        tabPane.setPrefSize(622.0, 469.0);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tab1 = new Tab("لیست خاطرات");
        AnchorPane tab1Content = new AnchorPane();
        tab1Content.setStyle("-fx-border-color: blue; -fx-border-insets: 5; -fx-border-width: 3;");
        tab1Content.setPrefSize(600.0, 450.0);

        VBox tab1VBox = new VBox();
        tab1VBox.setSpacing(10.0);
        tab1VBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        tab1VBox.setStyle("-fx-border-color: red; -fx-border-insets: 5; -fx-border-width: 3;");
        tab1VBox.setPrefSize(580.0, 350.0);
        AnchorPane.setTopAnchor(tab1VBox, 10.0);
        AnchorPane.setLeftAnchor(tab1VBox, 10.0);

        Label tab1Label = new Label("");
        tab1Label.setPrefSize(600.0, 38.0);
        ListView tab1ListView = new ListView();

        tab1ListView.setOnMouseClicked(event -> {

            tab1Label.setText(tab1ListView.getSelectionModel().getSelectedItem().toString());
        });


        tab1ListView.setPrefSize(400.0, 330.0);
        tab1VBox.getChildren().addAll(tab1Label,new Separator(Orientation.HORIZONTAL), tab1ListView,new Separator(Orientation.HORIZONTAL));
        tab1Content.getChildren().add(tab1VBox);
        tab1.setContent(tab1Content);

        Button backButton = new Button("بازگشت");
        backButton.setStyle("-fx-font-size: 20px;");
        backButton.setPrefHeight(44.0);
        backButton.setPrefWidth(121.0);
        backButton.setOnMouseClicked(event -> {
            Main.sceneMain(stage);
        });
        AnchorPane.setBottomAnchor(backButton, 10.0);
        AnchorPane.setRightAnchor(backButton, 10.0);
        tab1Content.getChildren().add(backButton);



        Tab tab2 = new Tab("اضافه کردن");
        AnchorPane tab2Content = new AnchorPane();
        tab2Content.setPrefSize(200.0, 180.0);
        TextField textField = new TextField();
        textField.setLayoutX(151.0);
        textField.setLayoutY(51.0);
        textField.setPrefSize(300.0, 25.0);
        textField.setPromptText("موضوع خاطره");
        TextArea textArea = new TextArea();
        textArea.setLayoutX(149.0);
        textArea.setLayoutY(118.0);
        textArea.setPrefSize(305.0, 200.0);
        textArea.setPromptText("یک خاطره بنویسید");
        DatePicker datePicker = new DatePicker();
        datePicker.setLayoutX(151.0);
        datePicker.setLayoutY(86.0);
        datePicker.setPrefSize(301.0, 25.0);
        Button button = new Button("افزودن خاطره");
        button.setLayoutX(371.0);
        button.setLayoutY(345.0);
        button.setMnemonicParsing(false);
        button.setOnMouseClicked(event -> {
            tab1ListView.getItems().add(textField.getText() + " : " + textArea.getText() + " : " + datePicker.getValue());
        });
        tab2Content.getChildren().addAll(textField, textArea, datePicker, button);
        tab2.setContent(tab2Content);


        tabPane.getTabs().addAll(tab1, tab2);
        root.getChildren().add(tabPane);
        Scene scene = new Scene(root, 622.0, 464.0);
        stage.setTitle("میزکار ادبی");

        stage.setScene(scene);


    }
}
