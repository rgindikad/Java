
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class UserInterface {

    private Scanner scan;
    private Statistics stat;

    public UserInterface(Scanner scan) {
        this.scan = scan;
        stat = new Statistics();
    }

    public void start() {
        System.out.println("Enter point totals, -1 stops:");
        while (true) {
            int val = Integer.valueOf(scan.nextLine());

            if (val == -1) {
                break;
            }
            stat.addGrade(val);
        }
        System.out.println("Point average (all): " + stat.average());
        if (stat.passAvg() == 0.0) {
            System.out.println("Point average (passing): -");
        } else {
            System.out.println("Point average (passing): " + stat.passAvg());
        }
        System.out.println("Pass percentage: " + stat.passPercentage());
        
        int[] out = stat.getGradeDist();
        for (int i = out.length - 1; i >= 0 ; i--) {
            System.out.print(i + ": ");
            printStars(out[i]);
            System.out.println();
        }
            
    }
    
    private void printStars(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
    }
}

