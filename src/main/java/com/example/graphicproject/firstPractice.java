package com.example.graphicproject;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class firstPractice {

    public static void sceneMain(Stage stage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefHeight(464.0);
        anchorPane.setPrefWidth(622.0);
        anchorPane.setStyle("-fx-border-color: green; -fx-border-insets: 5; -fx-border-width: 3;");

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setPrefHeight(400.0);
        scrollPane.setPrefWidth(619.0);

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        //gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        gridPane.setMinHeight(530.0);
        gridPane.setMinWidth(602.0);
        gridPane.setPrefHeight(530.0);
        gridPane.addRow(5);
        gridPane.addColumn(2);
        gridPane.setHgap(3);
        gridPane.setVgap(3);


        for (int i = 0; i < 6; i++) {
            for (int j = 0; j <= 2; j++) {
            Image image = new Image("I:\\ramezon\\ap\\javafx\\GraphicProject\\src\\main\\resources\\com\\example\\graphicproject\\tree.jpg");
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(200);
            imageView.setFitHeight(150);
            imageView.setOnMouseClicked(event -> {
                ImageView Image = new ImageView(image);
                Image.setFitHeight(400);
                Image.setFitWidth(400);
                Stage stage2 = new Stage();
                Scene scene = new Scene(new AnchorPane(Image), 400, 400);
                stage2.setScene(scene);
                stage2.initOwner(stage);
                stage2.initModality(javafx.stage.Modality.APPLICATION_MODAL);
                stage2.show();
            });
            gridPane.add(imageView, j , i);
        }}


        scrollPane.setContent(gridPane);
        AnchorPane.setTopAnchor(scrollPane, 0.0);
        AnchorPane.setRightAnchor(scrollPane, 0.0);
        AnchorPane.setBottomAnchor(scrollPane, 54.0);
        AnchorPane.setLeftAnchor(scrollPane, 0.0);
        scrollPane.setStyle("-fx-border-color: blue; -fx-border-insets: 5; -fx-border-width: 3;");


        Button button = new Button("بازگشت");
        button.setStyle("-fx-font-size: 20px;");
        button.setPrefHeight(44.0);
        button.setPrefWidth(121.0);
        button.setOnMouseClicked(event -> {
            Main.sceneMain(stage);
        });
        AnchorPane.setBottomAnchor(button, 4.0);
        AnchorPane.setRightAnchor(button, 10.0);

        anchorPane.getChildren().addAll(scrollPane, button);


        Scene scene = new Scene(anchorPane);
        stage.setTitle("میزکار عکاسی");
        stage.setScene(scene);


    }
}
