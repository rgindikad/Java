/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
import java.util.ArrayList;

public class Recipe {
    private int time;
    private String name;
    private ArrayList<String> ingrediants;
    
    public Recipe(String name) {
        ingrediants = new ArrayList<>();
        this.name = name;
        this.time = 0;
    }
    
    public void seTime(int time) {
        this.time = time;
    }
    
    public void addIngredian(String name) {
        ingrediants.add(name);
    }
    
    public String toString() {
        return (name + ", cooking time: " + time);
    }
    
    public String getName() {
        return name;
    }
    
    public int getTime() {
        return time;
    }
    
    public boolean containIngredient(String str) {
        return ingrediants.contains(str);
    }
}
