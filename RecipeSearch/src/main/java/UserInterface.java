/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;

public class UserInterface {

    private Scanner scanner;
    private ArrayList<Recipe> recipes;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        recipes = new ArrayList<>();
    }

    public void start() {
        System.out.println("File to read: ");
        String file = scanner.nextLine();
        processFile(file);

        while (true) {
            System.out.println("Enter command: ");
            String cmd = scanner.nextLine();

            if (cmd.equals("stop")) {
                break;
            }
            System.out.println(cmd);

            if (cmd.equals("list")) {
                printRecipes();
            } else if (cmd.equals("find name")) {
                System.out.println("Searched word: ");
                String find = scanner.nextLine();
                findRecipebyName(find);
            } else if(cmd.equals("find cooking time")) {
                System.out.println("Max cooking time: ");
                findRecipebyTime(Integer.valueOf(scanner.nextLine()));
                
            } else if(cmd.equals("find ingredient")) {
                System.out.println("Ingredient: ");
                containIngridient(scanner.nextLine());                
            }
        }

    }

    private void processFile(String file) {
        try ( Scanner scan = new Scanner(Paths.get(file))) {
            int pos = 0;
            
            while (scan.hasNextLine()) {
                String str = scan.nextLine();
                Recipe recipe = new Recipe(str);
                recipe.seTime(Integer.valueOf(scan.nextLine()));
                
                while (scan.hasNextLine()) {
                    str = scan.nextLine();
                    if (str.equals("")) {
                        break;
                    }
                    
                    recipe.addIngredian(str);
                }               
                recipes.add(recipe);               
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void printRecipes() {
        System.out.println("Recipes:");
        
        for (Recipe re : recipes) {
            System.out.println(re);
        }
    }

    public void findRecipebyName(String name) {
        System.out.println("Recipes:");
        for (Recipe re : recipes) {
            if (re.getName().contains(name)) {
                System.out.println(re);
            }
        }

    }
    
    public void findRecipebyTime(int time) {
        System.out.println("Recipes:");
        for (Recipe re : recipes) {
            if (re.getTime() <= time) {
                System.out.println(re);
            }
        }
    }
    
    public void containIngridient(String name) {
        System.out.println("Recipes:");
        for (Recipe re : recipes) {
            if (re.containIngredient(name)) {
                System.out.println(re);
            }
        }
    }

}
