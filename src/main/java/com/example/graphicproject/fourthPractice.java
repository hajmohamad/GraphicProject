package com.example.graphicproject;

import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class fourthPractice {
    public static void sceneMain(Stage stage) {
        AnchorPane ap = new AnchorPane();
        ap.setPrefSize(663.0, 470.0);
        Circle circle = new Circle(20);
        circle.setFill(Color.RED);
        circle.setLayoutX(100);
        circle.setLayoutY(100);
        Rectangle rectangle = new Rectangle(100, 100);
        rectangle.setFill(Color.BLUE);
        rectangle.setLayoutX(200);
        rectangle.setLayoutY(150);



        FadeTransition fade = new FadeTransition(Duration.seconds(1), circle);
        fade.setFromValue(1.0);
        fade.setToValue(0.0);
        fade.setCycleCount(3);

        TranslateTransition transition = new TranslateTransition();
        transition.setNode(circle);

        AnchorPane anchorPane = new AnchorPane();

        Scene scene = new Scene(anchorPane, 600, 400);
        stage.setScene(scene);
        stage.show();

        circle.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event1) {

                circle.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        circle.setTranslateX(event.getSceneX()-event1.getSceneX());
                        circle.setTranslateY(event.getSceneY()-event1.getSceneY());

                    }
                });
            }
        });


        circle.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(circle.getBoundsInParent().intersects(rectangle.getBoundsInParent())){
                    Alert a= new Alert(Alert.AlertType.ERROR);
                    a.setTitle("خطا");
                    a.setHeaderText(null);
                    a.setContentText("َشکل بر روی دیگریست" );
                    a.show();

                }else {
                transition.setByX(rectangle.getBoundsInParent().getCenterX() -circle.getBoundsInParent().getCenterX());
                transition.setByY(rectangle.getBoundsInParent().getCenterY() - circle.getBoundsInParent().getCenterY());
                transition.play();}

            }
        });
        transition.setOnFinished(e->{
            fade.setNode(circle);
            fade.play();

        });




        ap.getChildren().add(rectangle);
        ap.getChildren().add(circle);


        Button button = new Button("بازگشت");
        button.setStyle("-fx-font-size: 20px;");
        button.setPrefHeight(44.0);
        button.setPrefWidth(121.0);
        button.setOnMouseClicked(event -> {
            Main.sceneMain(stage);
        });
        AnchorPane.setBottomAnchor(button, 4.0);
        AnchorPane.setRightAnchor(button, 10.0);
        ap.getChildren().add(button);
        stage.setScene(new Scene(ap));
        stage.setTitle("میزکار سینمایی");


    }
}
