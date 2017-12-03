package ui;/*
 *Liz Mahoney
 *12/2/17
 *Control.java
 */

import javafx.event.Event;
import javafx.event.EventHandler;

import java.util.EventListener;


/**
 * @author Liz Mahoney
 * @version 1.0
 */
public class Control implements EventHandler<Event>{

    private DoodlePadUI doodlePadUI;

    public Control(DoodlePadUI doodlePadUI){
        this.doodlePadUI = doodlePadUI;
    }

    @Override
    public void handle(final Event event){

    }
}
