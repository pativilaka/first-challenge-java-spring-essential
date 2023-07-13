package com.vilaka.firstchallenge.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {

    private Integer code;
    private double basic;
    private double discount;

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido código " + getCode());
        return sb.toString();
    }
}
