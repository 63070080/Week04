package com.example.week04;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Change implements Serializable {
    private int b1000;
    private int b500;
    private int b100;
    private int b20;
    private int b10;
    private int b5;
    private int b1;

    public Change(){
        this(0);
    }
    public Change(int money){
        while (money >= 1000){
            money -= 1000;
            this.b1000 += 1;
        }
        while (money >= 500){
            money -= 500;
            this.b500 += 1;
        }
        while (money >= 100){
            money -= 100;
            this.b100 += 1;
        }
        while (money >= 20){
            money -= 20;
            this.b20 += 1;
        }
        while (money >= 10){
            money -= 10;
            this.b10 += 1;
        }
        while (money >= 5){
            money -= 5;
            this.b5 += 1;
        }
        while (money >= 1){
            money -= 1;
            this.b1 += 1;
        }
    }

    public int getB1000() {
        return b1000;
    }

    public void setB1000(int b1000) {
        this.b1000 = b1000;
    }

    public int getB500() {
        return b500;
    }

    public void setB500(int b500) {
        this.b500 = b500;
    }

    public int getB100() {
        return b100;
    }

    public void setB100(int b100) {
        this.b100 = b100;
    }

    public int getB20() {
        return b20;
    }

    public void setB20(int b20) {
        this.b20 = b20;
    }

    public int getB10() {
        return b10;
    }

    public void setB10(int b10) {
        this.b10 = b10;
    }

    public int getB5() {
        return b5;
    }

    public void setB5(int b5) {
        this.b5 = b5;
    }

    public int getB1() {
        return b1;
    }

    public void setB1(int b1) {
        this.b1 = b1;
    }
}
