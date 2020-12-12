/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Driver;
import Model.Manager;
import Model.Pair;
import Model.Way;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giang
 */
public class ControllerImp implements Controller {

    @Override
    public <T> void writeToFile(List<T> list, String fileName) {
        File file = new File(fileName);
        try {
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public <T> List<T> readDataFromFile(String fileName) {
        List<T> list = new ArrayList<>();
        File file = new File(fileName);
        if (file.length() > 0) {
            try {
                file.createNewFile();
                FileInputStream fos = new FileInputStream(file);
                ObjectInputStream oos = new ObjectInputStream(fos);
                Object o = oos.readObject();
                list = (List<T>) o;
                oos.close();
                fos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }

    public boolean isAccepted(List<Manager> managers, Driver driver, Pair<Way, Integer> pair) {
        for (Manager manager : managers) {
            if (manager.getDriver().getId() == driver.getId()) {
                return (manager.getTotalTurn() + pair.getTurn()) <= 15;
            }
        }
        return true;
    }

    public Manager getManager(List<Manager> managers, Driver driver) {
        for (Manager manager : managers) {
            if (manager.getDriver().getId() == driver.getId()) {
                return manager;
            }
        }
        return null;
    }

    public void addOrUpdate(List<Manager> managers, Driver driver, Pair<Way, Integer> pair) {
        Manager m = this.getManager(managers, driver);
        if (m == null) { //chua lai luot nao
            Manager man = new Manager(driver, pair);
            managers.add(man);
        } else { // cap nhat
            // 1. tuyen xe hien thoi chua dc lai
            // 2. da lai n luot tuyen xe trong pair
            boolean isExist = false;
            for (int i = 0; i < m.getPairs().size(); i++) {
                Pair<Way, Integer> p = m.getPairs().get(i);
                if (p.getWay().getId() == pair.getWay().getId()) {
                    isExist = true;
                    p.setTurn(p.getTurn() + pair.getTurn());
                    break;
                }
            }
            if (!isExist) {
                m.getPairs().add(pair);
            }
        }
    }

    @Override
    public <T> void sortByName(List<T> list) {
        list.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (o1 instanceof Manager) {
                    Manager m1 = (Manager) o1;
                    Manager m2 = (Manager) o2;
                    String fullname1 = m1.getDriver().getName().trim();
                    String fullname2 = m2.getDriver().getName().trim();
                    String name = fullname1.substring(fullname1.lastIndexOf(" "));
                    String name2 = fullname2.substring(fullname2.lastIndexOf(" "));
                    return name.compareTo(name2);
                }
                return 0;
            }
        });
    }

    @Override
    public <T> void sortByBuses(List<T> list) {
        list.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (o1 instanceof Manager) {
                    Manager m1 = (Manager) o1;
                    Manager m2 = (Manager) o2;
                    return m2.getPairs().size() - m1.getPairs().size();
                }
                return 0;
            }
        });
    }

    public float getTotalDistance(Manager m) {
        float distance = 0;
        for (Pair<Way, Integer> pair : m.getPairs()) {
            distance += pair.getWay().getDistance();
        }
        return distance;
    }

    @Override
    public <T> void sortByTotalDistance(List<T> list) {
        list.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (o1 instanceof Manager) {
                    Manager m1 = (Manager) o1;
                    Manager m2 = (Manager) o2;
                    float d1 = getTotalDistance(m1);
                    float d2 = getTotalDistance(m2); 
                    if(d1 < d2) {
                        return -1;
                    } else if(d1 > d2) {
                        return 1;
                    }
                }
                return 0;
            }
        });
    
    }
}