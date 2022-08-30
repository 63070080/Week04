package com.example.week04;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

@Route(value = "/index2")
public class CashierView extends VerticalLayout {
    private TextField t1;
    private TextField t2;
    private TextField t3;
    private TextField t4;
    private TextField t5;
    private TextField t6;
    private TextField t7;
    private TextField t8;
    private Button b1;

    public CashierView(){
        b1 = new Button("คำนวณเงินทอน");

        t1 = new TextField("เงินทอน");
        t2 = new TextField();
        t3 = new TextField();
        t4 = new TextField();
        t5 = new TextField();
        t6 = new TextField();
        t7 = new TextField();
        t8 = new TextField();

        t1.setPrefixComponent(new Span("$"));
        t2.setPrefixComponent(new Span("$1000: "));
        t3.setPrefixComponent(new Span("$500: "));
        t4.setPrefixComponent(new Span("$100: "));
        t5.setPrefixComponent(new Span("$20: "));
        t6.setPrefixComponent(new Span("$10: "));
        t7.setPrefixComponent(new Span("$5: "));
        t8.setPrefixComponent(new Span("$1: "));

        add(t1,b1,t2,t3,t4,t5,t6,t7,t8);

        b1.addClickListener(event->{
            int money = Integer.parseInt(t1.getValue());
            Change out = WebClient.create().get().uri("http://localhost:8080/getChange/"+money).retrieve().bodyToMono(Change.class).block();
            t2.setValue(String.valueOf(out.getB1000()));
            t3.setValue(String.valueOf(out.getB500()));
            t4.setValue(String.valueOf(out.getB100()));
            t5.setValue(String.valueOf(out.getB20()));
            t6.setValue(String.valueOf(out.getB10()));
            t7.setValue(String.valueOf(out.getB5()));
            t8.setValue(String.valueOf(out.getB1()));
        });
    }


}
