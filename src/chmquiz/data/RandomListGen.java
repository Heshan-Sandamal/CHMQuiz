/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chmquiz.data;

import java.util.Random;

/**
 *
 * @author Dimuth
 */
public class RandomListGen {
    
    public static void generateList(){
        final int[] ints = new Random().ints(0, 40).distinct().limit(4).toArray();
    int index;
    for (int i = 0; i < 4; i++) {
            System.out.println(ints[i]);
    }
        
    }
    
}