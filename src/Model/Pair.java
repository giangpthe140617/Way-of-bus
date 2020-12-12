/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author giang
 */
public class Pair<K, T> implements Serializable {
    private K way;
    private T turn;

    public Pair() {
    }

    public Pair(K way, T turn) {
        this.way = way;
        this.turn = turn;
    }

    public K getWay() {
        return way;
    }

    public void setWay(K way) {
        this.way = way;
    }

    public T getTurn() {
        return turn;
    }

    public void setTurn(T turn) {
        this.turn = turn;
    }
    
    
}
