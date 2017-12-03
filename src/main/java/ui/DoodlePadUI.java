/*
 *Liz Mahoney
 *12/1/17
 *Canvas.java
 */
package ui;

/**
 * @author Liz Mahoney
 * @version 1.0
 */

import drawing.SavedShapes;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;
import javafx.stage.Stage;
import shapes.Shape;


import java.io.File;


public class DoodlePadUI extends Application{

    private static final int LAYOUT_SPACING = 10;
    private static final int WINDOW_WIDTH = 775;
    private static final int WINDOW_HEIGHT = 475;
    private static final int CANVAS_WIDTH = 750;
    private static final int CANVAS_HEIGHT = 400;

    private static final String[] FILE_NAME ={"images/oval.png", "images/rectangle" +
            ".png",
            "images/triangle.png", "images/line.png", "images/polygon.png"};
    private static final int IMAGE_WIDTH = 30;
    private static final int IMAGE_HEIGHT = 30;
    private static final int MAX_THICKNESS = 10;
    private static final int INITIAL_SLIDER_VALUE = 2;
    private static final int TEXTFIELD_WIDTH = 40;
    private static final int TOOLBAR_HORIZONTAL_SPACING = 5;
    private static final int CHECKBOX_PADDING_RIGHT = 40;
    private static double thickness;
    private static ColorPicker colorPicker;
    private static CheckBox fillCheckBox;


    public static SavedShapes savedShapes = new SavedShapes();
    public static Control control;

    @Override
    public void start(Stage stage){
        stage.setTitle("Doodle Pad");
        stage.setScene(getScene());
        stage.show();
    }

    private Scene getScene(){

        final VBox window = new VBox(LAYOUT_SPACING);
        window.setId("window");

        final FlowPane flowPane = toolBarSettings();
        flowPane.setId("flowpane");

        final VBox canvasVbox = new VBox();

        Canvas canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);

        canvas.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(final MouseEvent event){
                GraphicsContext graphicsContext
                        = canvas.getGraphicsContext2D();


                savedShapes.drawShapes(graphicsContext);

                double x = event.getX();
                double y = event.getY();

//                Shape shape = new Shape(x,y, thickness, colorPicker.getValue
//                        (), fillCheckBox);

            }
        });

        canvasVbox.setId("canvasVbox");
        canvas.setId("canvas");

        canvasVbox.getChildren().addAll(canvas);

        window.getChildren().addAll(flowPane, canvasVbox);

        window.getStylesheets().addAll("css/doodlepad.css");

        return new Scene(window, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    private FlowPane toolBarSettings(){

        final FlowPane flowPane = new FlowPane();
        flowPane.setId("flowPane");
        flowPane.setHgap(TOOLBAR_HORIZONTAL_SPACING);

        ToggleButton[] buttonShapes = shapeToggleButtons();

        for(int i = 0; i< FILE_NAME.length; i++){
            final ToggleButton button = buttonShapes[i];

            button.setPrefSize(LAYOUT_SPACING,LAYOUT_SPACING);

            flowPane.getChildren().add(button);
        }

        final TextField thicknessTextField = new TextField();
        thicknessTextField.setPrefWidth(TEXTFIELD_WIDTH);

        final Slider sliderThickSetting = sliderThickSetting(thicknessTextField);

        thickness = sliderThickSetting.getValue();

        flowPane.getChildren().addAll(colorButtonSelector(), filledCheckBox(),
                new Label("Thickness"),
                thicknessTextField, sliderThickSetting);

        return flowPane;
    }
//    private FlowPane toolBarSettings(){
//
//        final FlowPane flowPane = new FlowPane();
//        flowPane.setId("flowPane");
//        flowPane.setHgap(TOOLBAR_HORIZONTAL_SPACING);
//
//        ToggleButton[] buttonShapes = shapeToggleButtons();
//
//        for(int i = 0; i< FILE_NAME.length; i++){
//            final ToggleButton button = buttonShapes[i];
//
//            button.setPrefSize(LAYOUT_SPACING,LAYOUT_SPACING);
//
//            flowPane.getChildren().add(button);
//        }
//
//        final ColorPicker colorSelector = colorButtonSelector();
//
//        final CheckBox colorFill = filledCheckBox();
//
//        final Label thicknessLabel= new Label("Thickness");
//
//        final TextField thicknessTextField = new TextField();
//        thicknessTextField.setPrefWidth(TEXTFIELD_WIDTH);
//        final Slider sliderThickSetting = sliderThickSetting(thicknessTextField);
//
//        double thickValue = sliderThickSetting.getValue();
//
//       // Shape shape = new Shape(thickValue, c);
//
//       flowPane.getChildren().addAll(colorSelector, colorFill, thicknessLabel,
//                thicknessTextField, sliderThickSetting);
//
//        return flowPane;
//    }

    private Slider sliderThickSetting(TextField thicknessTextField){
        final Slider slider = new Slider(0, MAX_THICKNESS, INITIAL_SLIDER_VALUE);
        slider.setId("slider");

        slider.valueProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(final ObservableValue<? extends Number>
                observable, final Number oldValue, final Number newValue){
                thicknessTextField.setText(String.valueOf
                        (Math.round(newValue.intValue())));
            }
        });

        return slider;

    }

    private ToggleButton[] shapeToggleButtons(){

        final ToggleGroup shapeToggleGroup = new ToggleGroup();

        final ToggleButton[] toggleButtons = new ToggleButton[FILE_NAME.length];

        for(int i = 0; i< FILE_NAME.length; i++){

            final ToggleButton toggleButton = toggleButtons[i];

            Image[] image = new Image[FILE_NAME.length];
            image[i] = new Image(String.valueOf(new File(FILE_NAME[i])),
                    IMAGE_WIDTH, IMAGE_HEIGHT,false,true);

            toggleButtons[i] = new ToggleButton("", new ImageView(image[i]));
            toggleButtons[i].setToggleGroup(shapeToggleGroup);

            toggleButtons[i].setOnAction(new EventHandler<ActionEvent>(){
                @Override
                //oval = 0 ,rectangle = 1,triangle =2 , line = 3, polygon =4
                public void handle(final ActionEvent event){
                    //oval = 0 ,rectangle = 1,triangle =2 , line = 3, polygon =4
                    if(toggleButton.isSelected()){



                    }
                }
            });

        }
        return toggleButtons;
    }

    private ColorPicker colorButtonSelector(){

        colorPicker = new ColorPicker();
        colorPicker.getStyleClass().add("split-button");
        colorPicker.setId("colorpicker-button");

        colorPicker.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(final ActionEvent event){
                colorPicker.getValue();

                //do something
            }
        });

        return colorPicker;
    }

    private CheckBox filledCheckBox(){

        fillCheckBox = new CheckBox("Fill");
        fillCheckBox.setPadding(new Insets(0, CHECKBOX_PADDING_RIGHT,0,0));
        fillCheckBox.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(final ActionEvent event){

                fillCheckBox.isSelected();
            }
        });
        return fillCheckBox;

    }

}
