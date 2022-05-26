package com.example.circlecatchergame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;


public class CircleCatcher extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // window screen values
        int windowWidth = 600;
        int windowHeight = 400;

        // one line to change amount of circles
        int changeAmt = 12;

        // store a random list of random circles
        ArrayList<RandomCircle> randomCircles = new ArrayList<RandomCircle>(changeAmt);

        for (int i = 0; i < changeAmt; i++){
            randomCircles.add(new RandomCircle(windowWidth, windowHeight, this));
        }

        // this pane is used to store the circles
        Pane pane = new Pane();

        for (int j = 0; j < changeAmt; j++){
            pane.getChildren().add(randomCircles.get(j));
        }


        System.out.println(pane.getChildren());

        // the pane above is implemented in scene
        Scene scene = new Scene(pane, windowWidth, windowHeight);
        stage.setTitle("Circle Catcher");
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:circle.png"));
        stage.show();

    }


    public static void main(String[] args) {
        launch();
    }
}