package com.example.graphicproject;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class thirdPractice {

    public static void sceneMain(Stage stage) {
        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-border-color: green; -fx-border-insets: 5; -fx-border-width: 3;");
        root.setPrefSize(600, 400);

        VBox vbox = new VBox();
        vbox.setStyle("-fx-border-color: blue; -fx-border-insets: 5; -fx-border-width: 3;");
        vbox.setLayoutX(14);
        vbox.setLayoutY(14);
        vbox.setPrefSize(570, 371);
        vbox.setSpacing(10);

        AnchorPane drawinganchorPane = new AnchorPane();
        drawinganchorPane.setStyle("-fx-border-color: GRAY; -fx-border-insets: 5; -fx-border-width: 3;");
        drawinganchorPane.setPrefSize(570, 300);


        HBox hbox = new HBox();
        hbox.setStyle("-fx-border-color: red; -fx-border-insets: 5; -fx-border-width: 3;");
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setPrefSize(579, 66);

        MenuButton menuButton = new MenuButton("اشکال");
        MenuItem circleItem = new MenuItem("دایره");
        MenuItem lineItem = new MenuItem("خط");
        MenuItem rectangleItem = new MenuItem("مستطیل");
        MenuItem squareItem = new MenuItem("مربع");
        menuButton.getItems().addAll(circleItem, lineItem, rectangleItem, squareItem);

        AnchorPane innerAnchorPane = new AnchorPane();
        innerAnchorPane.setStyle("-fx-border-color: yellow; -fx-border-insets: 5; -fx-border-width: 3;");
        innerAnchorPane.setPrefSize(473, 66);

        TextField textField1 = new TextField();
        textField1.setLayoutX(8);
        textField1.setLayoutY(21);
        textField1.setPrefSize(37, 25);
        textField1.setPromptText("x");

        TextField textField2 = new TextField();
        textField2.setLayoutX(52);
        textField2.setLayoutY(21);
        textField2.setPrefSize(43, 25);
        textField2.setPromptText("y");

        TextField textField3 = new TextField();
        textField3.setLayoutX(107);
        textField3.setLayoutY(21);
        textField3.setPrefSize(43, 25);
        textField3.setPromptText("x");

        TextField textField4 = new TextField();
        textField4.setLayoutX(164);
        textField4.setLayoutY(21);
        textField4.setPrefSize(43, 25);
        textField4.setPromptText("y");

        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setLayoutX(287);
        colorPicker.setLayoutY(21);
        colorPicker.setPrefSize(91, 25);

        Button drawButton = new Button("رسم");
        drawButton.setLayoutX(395);
        drawButton.setLayoutY(21);

        innerAnchorPane.getChildren().addAll(textField1, textField2, textField3, textField4, colorPicker, drawButton);

        hbox.getChildren().addAll(menuButton, innerAnchorPane);

        vbox.getChildren().addAll(hbox, drawinganchorPane);
        root.getChildren().add(vbox);
        Button button = new Button("بازگشت");
        button.setStyle("-fx-font-size: 10px;");
        button.setPrefHeight(30.0);
        button.setPrefWidth(100.0);
        button.setOnMouseClicked(event -> {
            Main.sceneMain(stage);
        });
        textField1.setVisible(false);
        textField2.setVisible(false);
        textField3.setVisible(false);
        textField4.setVisible(false);
        colorPicker.setVisible(false);
        drawButton.setVisible(false);
        innerAnchorPane.setVisible(false);

        circleItem.setOnAction(event -> {
            textField1.setVisible(true);
            textField1.setPromptText("x");
            textField2.setVisible(true);
            textField2.setPromptText("y");
            textField3.setVisible(true);
            textField3.setPromptText("شعاع");
            textField4.setVisible(false);
            innerAnchorPane.setVisible(true);
            drawButton.setVisible(true);
            colorPicker.setVisible(true);
            drawButton.setOnMouseClicked(event1 -> {
                if(Double.parseDouble(textField1.getText())>=570||Double.parseDouble(textField2.getText())>=400){

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("خطا");
                    alert.setHeaderText(null);
                    alert.setContentText("مقادیر وارد شده بیشتر از حد مجاز است");
                    alert.showAndWait();
                }else{

                Circle circle = new Circle(Double.parseDouble(textField3.getText()));
                circle.setLayoutX(Double.parseDouble(textField1.getText()));
                circle.setLayoutY(Double.parseDouble(textField2.getText()));
                circle.setFill(colorPicker.getValue());
                drawinganchorPane.getChildren().add(circle);}
            });

        });
        rectangleItem.setOnAction(event -> {
            textField1.setVisible(true);
            textField1.setPromptText("x");
            textField2.setVisible(true);
            textField2.setPromptText("y");
            textField3.setVisible(true);
            textField4.setVisible(true);
            textField3.setPromptText("طول");
            textField4.setPromptText("عرض");
            innerAnchorPane.setVisible(true);
            drawButton.setVisible(true);
            colorPicker.setVisible(true);
            drawButton.setOnMouseClicked(event1 -> {
                if(Double.parseDouble(textField1.getText())>=570||Double.parseDouble(textField2.getText())>=400){

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("خطا");
                    alert.setHeaderText(null);
                    alert.setContentText("مقادیر وارد شده بیشتر از حد مجاز است");
                    alert.showAndWait();
                }else{
                Rectangle rectangle = new Rectangle(Double.parseDouble(textField3.getText()), Double.parseDouble(textField4.getText()));
                rectangle.setLayoutX(Double.parseDouble(textField1.getText()));
                rectangle.setLayoutY(Double.parseDouble(textField2.getText()));
                rectangle.setFill(colorPicker.getValue());
                drawinganchorPane.getChildren().add(rectangle);}
            });
        });
        squareItem.setOnAction(event -> {
            textField1.setVisible(true);
            textField1.setPromptText("x");
            textField2.setVisible(true);
            textField2.setPromptText("y");
            textField3.setVisible(true);
            textField3.setPromptText("ظلع");
            textField4.setVisible(false);
            innerAnchorPane.setVisible(true);
            drawButton.setVisible(true);
            colorPicker.setVisible(true);
            drawButton.setOnMouseClicked(event1 -> {
                if(Double.parseDouble(textField1.getText())>=570||Double.parseDouble(textField2.getText())>=400){

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("خطا");
                    alert.setHeaderText(null);
                    alert.setContentText("مقادیر وارد شده بیشتر از حد مجاز است");
                    alert.showAndWait();
                }else{
                Rectangle rectangle = new Rectangle(Double.parseDouble(textField3.getText()), Double.parseDouble(textField3.getText()));
                rectangle.setLayoutX(Double.parseDouble(textField1.getText()));
                rectangle.setLayoutY(Double.parseDouble(textField2.getText()));
                rectangle.setFill(colorPicker.getValue());
                drawinganchorPane.getChildren().add(rectangle);}


            });

        });
        lineItem.setOnAction(event -> {
            textField1.setVisible(true);
            textField1.setPromptText("شروع x");
            textField2.setVisible(true);
            textField2.setPromptText("شروع y");
            textField3.setVisible(true);
            textField3.setPromptText("پایان x");
            textField4.setVisible(true);
            textField4.setPromptText("پایان y");
            innerAnchorPane.setVisible(true);
            drawButton.setVisible(true);
            colorPicker.setVisible(true);
            drawButton.setOnAction(e -> {
                if(Double.parseDouble(textField1.getText())>=570||Double.parseDouble(textField2.getText())>=400){

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("خطا");
                    alert.setHeaderText(null);
                    alert.setContentText("مقادیر وارد شده بیشتر از حد مجاز است");
                    alert.showAndWait();
                }else{
                double startX = Double.parseDouble(textField1.getText());
                double startY = Double.parseDouble(textField2.getText());
                double endX = Double.parseDouble(textField3.getText());
                double endY = Double.parseDouble(textField4.getText());

                Line line = new Line(startX, startY, endX, endY);
                line.setStroke(colorPicker.getValue());
                    drawinganchorPane.getChildren().add(line);}
            });
        });


        AnchorPane.setBottomAnchor(button, 4.0);
        AnchorPane.setRightAnchor(button, 10.0);
        root.getChildren().add(button);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("میزکار هنری");

        stage.show();
    }
}
