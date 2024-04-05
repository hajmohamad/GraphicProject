package com.example.graphicproject;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }
    public static void sceneMain(Stage stage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefHeight(400.0);
        anchorPane.setPrefWidth(600.0);
        anchorPane.setStyle(     "-fx-border-color: green; \n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 3;\n" );

        VBox vBox1 = new VBox();
        vBox1.setStyle("-fx-border-color: blue;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 3;\n" );

        vBox1.setLayoutX(150);
        vBox1.setLayoutY(70);



        VBox vbox = new VBox();
        String cssLayout = "-fx-border-color: red;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 3;\n" ;
        vbox.setStyle(cssLayout);

        Label label = new Label("میزکار");
        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label.setPrefHeight(54.0);
        label.setPrefWidth(100.0);
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setFont(new Font(33.0));



        vbox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vbox.setPrefHeight(250);
        vbox.setPrefWidth(300);
        vbox.setSpacing(15.0);



        Button button1 = new Button("میزکار عکاسی");
        button1.setOnMouseClicked(event -> {
            firstPractice.sceneMain(stage);
        });
        Button button2 = new Button("میزکار ادبی");
        button2.setOnMouseClicked(event -> {
            secondPractice.sceneMain(stage);

        });
        Button button3 = new Button("میزکار هنری");
        button3.setOnMouseClicked(event -> {
            thirdPractice.sceneMain(stage);

        });
        Button button4 = new Button("میزکار سینمایی");
        button4.setOnMouseClicked(event -> {
            fourthPractice.sceneMain(stage);
        });

        vbox.getChildren().addAll( button1,new Separator(Orientation.HORIZONTAL), button2,new Separator(Orientation.HORIZONTAL), button3,new Separator(Orientation.HORIZONTAL), button4);
        vBox1.getChildren().add(label) ;
        vBox1.getChildren().add(vbox);
        anchorPane.getChildren().add(vBox1);
        Scene scene = new Scene(anchorPane, 601,400 );
        stage.setTitle("میز کار");
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void start(Stage stage) throws Exception {
        Main.sceneMain(stage);

    }
}
