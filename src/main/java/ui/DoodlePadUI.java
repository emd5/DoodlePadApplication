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


import adapters.CircleAdapter;
import drawing.IShape;
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

import javafx.stage.Stage;
import shapes.Circle;
import shapes.Shape;


import java.io.File;


public class DoodlePadUI extends Application{

    private static final int LAYOUT_SPACING = 10;
    private static final int WINDOW_WIDTH = 775;
    private static final int WINDOW_HEIGHT = 475;
    private static final int CANVAS_WIDTH = 750;
    private static final int CANVAS_HEIGHT = 400;

    private static final String[] SHAPE_FILE_NAME ={"oval", "rectangle",
            "triangle", "line", "polygon"};
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
    private static ToggleButton[] toggleButtons;
    private static GraphicsContext graphicsContext;
    private static ToggleGroup toggleGroup;
    private static Slider slider;
    private static double x;
    private static double y;


    public static SavedShapes savedShapes;

    public static Control control;
    public static Shape shape;

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

                 x = event.getX();
                 y = event.getY();

                selectedToggleShape();

                graphicsContext = canvas.getGraphicsContext2D();



                IShape circle = new CircleAdapter(new Circle(20,x,y,thickness, colorPicker
                        .getValue(),fillCheckBox.isSelected()));
                System.out.println(circle.toString());
                savedShapes.add(circle);
                savedShapes.drawShapes(graphicsContext);





            }
        });
        canvasVbox.setId("canvasVbox");
        canvasVbox.getChildren().addAll(canvas);
        window.getChildren().addAll(flowPane, canvasVbox);
        window.getStylesheets().addAll("css/doodlepad.css");

        return new Scene(window, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    private void selectedToggleShape(){

        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            @Override
            public void changed(final ObservableValue<? extends Toggle> observable,
                                final Toggle oldValue, final Toggle newValue){
                switch(newValue.getUserData().toString()){
                    case "oval":
                        IShape circle = new CircleAdapter(new Circle(20,x,y,thickness,
                                colorPicker.getValue(),fillCheckBox.isSelected()));
                        savedShapes.add(circle);


                }



            }
        });
    }

    private FlowPane toolBarSettings(){

        final FlowPane flowPane = new FlowPane();
        flowPane.setId("flowPane");
        flowPane.setHgap(TOOLBAR_HORIZONTAL_SPACING);

        ToggleButton[] buttonShapes = shapeToggleButtons();

        for(int i = 0; i< SHAPE_FILE_NAME.length; i++){
            final ToggleButton button = buttonShapes[i];
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

    private Slider sliderThickSetting(TextField thicknessTextField){
        slider = new Slider(0, MAX_THICKNESS, INITIAL_SLIDER_VALUE);
        slider.setId("slider");

        slider.valueProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(final ObservableValue<? extends Number>
                observable, final Number oldValue, final Number newValue){
                thicknessTextField.setText(String.valueOf
                        (Math.round(newValue.intValue())));

            }

        });

        System.out.println("slider" + slider.getValue());


        return slider;

    }

    private ToggleButton[] shapeToggleButtons(){

        final ToggleButton[] toggleButtons = new ToggleButton[SHAPE_FILE_NAME.length];
        toggleGroup = new ToggleGroup();

        for(int i = 0; i< SHAPE_FILE_NAME.length; i++){

            Image[] image = new Image[SHAPE_FILE_NAME.length];
            image[i] = new Image(String.valueOf(new File("images/"+ SHAPE_FILE_NAME[i]+".png")),
                    IMAGE_WIDTH, IMAGE_HEIGHT,false,true);

            toggleButtons[i] = new ToggleButton("", new ImageView(image[i]));
            toggleButtons[i].setUserData(SHAPE_FILE_NAME[i]);
            toggleButtons[i].setPrefSize(LAYOUT_SPACING, LAYOUT_SPACING);
            toggleButtons[i].setToggleGroup(toggleGroup);
        }

        selectedToggleShape();

        return toggleButtons;
    }

    private ColorPicker colorButtonSelector(){

        ColorPicker colorPicker = new ColorPicker();
        colorPicker.getStyleClass().add("split-button");
        colorPicker.setId("colorpicker-button");

        colorPicker.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(final ActionEvent event){
                System.out.println(colorPicker.getValue());
                colorPicker.getValue();
            }
        });

        colorPicker.getValue();
        System.out.println("2 " +colorPicker.getValue());

        return colorPicker;
    }

    private CheckBox filledCheckBox(){

        fillCheckBox = new CheckBox("Fill");
        fillCheckBox.setPadding(new Insets(0, CHECKBOX_PADDING_RIGHT,0,0));
        fillCheckBox.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(final ActionEvent event){
                if(!filledCheckBox().isIndeterminate()){
                    fillCheckBox.isSelected();
                }
                else{
                    fillCheckBox.isIndeterminate();
                }
            }
        });
        return fillCheckBox;
    }
}
