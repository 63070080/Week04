package com.example.week04;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Route(value = "/index1")
public class MathView extends VerticalLayout {
   private TextField n1;
   private TextField n2;
   private TextField ans;
   private HorizontalLayout op;
   private Text t1;
   private Button p;
   private Button m;
   private Button d;
   private Button mt;
   private Button mod;
   private Button max;
   public MathView(){
       n1 = new TextField("Number1");
       n2 = new TextField("Number2");

       t1 = new Text("Operator");
       op = new HorizontalLayout();
       p = new Button("+");
       m = new Button("-");
       d = new Button("/");
       mt = new Button("X");
       mod = new Button("Mod");
       max = new Button("Max");
       op.add(p,m,mt,d,mod,max);

       ans = new TextField("Answer");
       add(n1,n2,t1,op,ans);

       p.addClickListener(event->{
          double num1 = Double.parseDouble(n1.getValue());
          double num2 = Double.parseDouble(n2.getValue());
          String out = WebClient.create().get().uri("http://localhost:8080/plus/"+num1+"/"+num2).retrieve().bodyToMono(String.class).block();
          ans.setValue(out);
       });
       m.addClickListener(event->{
           double num1 = Double.parseDouble(n1.getValue());
           double num2 = Double.parseDouble(n2.getValue());
           String out = WebClient.create().get().uri("http://localhost:8080/minus/"+num1+"/"+num2).retrieve().bodyToMono(String.class).block();
           ans.setValue(out);
       });
       mt.addClickListener(event->{
           double num1 = Double.parseDouble(n1.getValue());
           double num2 = Double.parseDouble(n2.getValue());
           String out = WebClient.create().get().uri("http://localhost:8080/multi/"+num1+"/"+num2).retrieve().bodyToMono(String.class).block();
           ans.setValue(out);
       });
       d.addClickListener(event->{
           double num1 = Double.parseDouble(n1.getValue());
           double num2 = Double.parseDouble(n2.getValue());
           String out = WebClient.create().get().uri("http://localhost:8080/divide/"+num1+"/"+num2).retrieve().bodyToMono(String.class).block();
           ans.setValue(out);
       });
       mod.addClickListener(event->{
           double num1 = Double.parseDouble(n1.getValue());
           double num2 = Double.parseDouble(n2.getValue());
           String out = WebClient.create().get().uri("http://localhost:8080/mod/"+num1+"/"+num2).retrieve().bodyToMono(String.class).block();
           ans.setValue(out);
       });
       mod.addClickListener(event->{
           double num1 = Double.parseDouble(n1.getValue());
           double num2 = Double.parseDouble(n2.getValue());
           String out = WebClient.create().get().uri("http://localhost:8080/mod/"+num1+"/"+num2).retrieve().bodyToMono(String.class).block();
           ans.setValue(out);
       });
       max.addClickListener(event->{
           ArrayList<Double> arr = new ArrayList<>();
           double num1 = Double.parseDouble(n1.getValue());
           double num2 = Double.parseDouble(n2.getValue());
           arr.add(num1);
           arr.add(num2);
           String out = WebClient.create().post().uri("http://localhost:8080/max").body(Mono.just(arr), ArrayList.class).retrieve().bodyToMono(String.class).block();
           ans.setValue(out);
       });
   }

}
