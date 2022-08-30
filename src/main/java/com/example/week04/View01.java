package com.example.week04;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;


@Route(value = "/cal")
public class View01 extends HorizontalLayout {
    private Button btn;
    public View01(){
        btn = new Button();
        add(btn);
    }
}
