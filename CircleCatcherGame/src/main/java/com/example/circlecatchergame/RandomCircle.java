package com.example.circlecatchergame;


import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import java.util.Random;

public class RandomCircle extends Circle {

    private static Random random = new Random();
    private static Random randomFinal = new Random();
    private static Color[] listOfColors = {Color.RED, Color.BLUE, Color.AQUA, Color.DARKCYAN,
    Color.GOLD, Color.GREEN, Color.YELLOW, Color.YELLOW, Color.DARKGRAY, Color.DARKMAGENTA,
    Color.DARKKHAKI, Color.DARKSALMON, Color.DARKORANGE, Color.DARKVIOLET, Color.LAVENDER};

    private int randomXLocation;
    private int randomYLocation;
    private int finalXLocation;
    private int finalYLocation;

    private int windowWidth;
    private int windowHeight;

    private CircleCatcher circleCatcher;
    private PathTransition p;

    public RandomCircle(int windowWidth, int windowHeight, CircleCatcher catchMe) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        /*The plus 25 is used to bound the random values
        so, location x is random is 0 will be added therefore
        bounds of x is [25, maxWidthScreen] worst case*/
        this.randomXLocation = (random.nextInt(windowWidth - 50)) + 25;
        this.randomYLocation = (random.nextInt(windowHeight - 50)) + 25;
        int randomRadius = (random.nextInt(15)) + 15;
        int randomColor = random.nextInt(listOfColors.length);
        this.finalXLocation = randomFinal.nextInt(windowWidth - 50) + 25;
        this.finalYLocation = randomFinal.nextInt(windowHeight - 50) + 25;
        setRadius(randomRadius);
        setFill(listOfColors[randomColor]);
        this.circleCatcher = catchMe;

        runAnimation();

        this.setOnMousePressed( event -> {
            //stop circle
            p.stop();
            // reset
            p.setPath(new Path(new MoveTo(0, 0)));
        });
    }

    public void runAnimation(){
        p = new PathTransition();
        p.setDuration(new Duration(random.nextInt(19000) + 5));
        p.setNode(this);
        p.setAutoReverse(true);
        p.setCycleCount(Timeline.INDEFINITE);
        Path goTo = new Path();
        goTo.getElements().add(new MoveTo(this.randomXLocation, this.randomYLocation));
        goTo.getElements().add(new LineTo(this.finalXLocation, this.finalYLocation));
        p.setPath(goTo);
        p.play();
    }

    public int getRandomXLocation(){
        return randomXLocation;
    }

    public int getRandomYLocation(){
        return randomYLocation;
    }

}
