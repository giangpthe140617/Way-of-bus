/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giang
 */
public class Manager {
    private Driver driver;
    private int totalTurn;
    private List<Pair<Way, Integer>> pairs;

    public Manager() {
        pairs = new ArrayList<>();
        totalTurn = 0;
    }

    public Manager(Driver driver, Pair pair) {
        this();
        this.driver = driver;
        this.totalTurn = totalTurn;
        this.pairs.add(pair);
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public int getTotalTurn() {
        this.totalTurn = 0;
        for (Pair<Way, Integer> pair : pairs) {
            this.totalTurn += pair.getTurn();
        }
        return totalTurn;
    }

    public void setTotalTurn(int totalTurn) {
        this.totalTurn = totalTurn;
    }

    public List<Pair<Way, Integer>> getPairs() {
        return pairs;
    }

    public void setPairs(Pair pair) {
        this.pairs.add(pair);
    }
    
    

    
}
