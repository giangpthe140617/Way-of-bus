
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
public class Way implements Serializable {

    private int id;
    private float distance;
    private int station;
    private static int sId = 1000000;

    public Way() {
        this.id = sId++;
    }

    public Way(float distance, int station) {
        this.id = sId++;
        this.distance = distance;
        this.station = station;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getStation() {
        return station;
    }

    public void setStation(int station) {
        this.station = station;
    }

    public static int getsId() {
        return sId;
    }

    public static void setsId(int sId) {
        Way.sId = sId;
    }

}
