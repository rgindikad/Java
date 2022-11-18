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

public class Statistics {

    private ArrayList<Integer> grades;

    public Statistics() {
        grades = new ArrayList<>();
    }

    public void addGrade(int val) {
        if (val > 100 || val < 0) {
            return;
        }
        grades.add(val);
    }

    public double average() {
        if (grades.size() == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int val : grades) {
            sum += val;
        }
        return (1.0 * sum / grades.size());
    }

    public double passAvg() {
        if (grades.size() == 0) {
            return 0.0;
        }
        int sum = 0;
        int count = 0;
        for (int val : grades) {
            if (val >= 50) {
                sum += val;
                count++;
            }
        }
        return (1.0 * sum / count);
    }
    
    public int paticipants() {
        return grades.size();
    }
    
    public double passPercentage() {
        if (grades.size() == 0) {
            return 0;
        }
        int count = 0;
        for (int val : grades) {
            if (val >= 50) {                
                count++;
            }
        }
        return 100.00 * count /grades.size();
    }
    
    public int[] getGradeDist() {
        int[] disri = new int[]{0,0,0,0,0,0};
        for (int val : grades) {           
            if (val < 50) {                
                disri[0]++;
            } else if (val < 60) {
                disri[1]++;
            } else if (val < 70) {
                disri[2]++;
            } else if (val < 80) {
                disri[3]++;
            } else if (val < 90) {
                disri[4]++;
            } else {
                disri[5]++;
            }
        }
        
        return disri;
    }
}
