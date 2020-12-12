/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.List;

/**
 *
 * @author giang
 */
public interface Controller {
    <T> void writeToFile(List<T> list, String fileName);
    
    <T> List<T> readDataFromFile(String fileName);
    
    <T> void sortByName(List<T> list);
    
    <T> void sortByBuses(List<T> list);
    
    <T> void sortByTotalDistance(List<T> list);
     
}
