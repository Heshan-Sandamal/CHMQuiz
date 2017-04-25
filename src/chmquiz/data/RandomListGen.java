/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chmquiz.data;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Dimuth
 */
public class RandomListGen {
    
    static ArrayList<Integer> indexList;
    
    
    
    public static ArrayList<Integer> generateList(){
        final int[] int1 = new Random().ints(0,30).distinct().limit(6).toArray();
        final int[] int2 = new Random().ints(31, 60).distinct().limit(4).toArray();
        final int[] int3 = new Random().ints(61, 100).distinct().limit(5).toArray();
       
        indexList = addToArray(new ArrayList<Integer>(),int1);
        indexList = addToArray(indexList,int2);
        indexList = addToArray(indexList,int3);
       
        return indexList;
    
    }
    
    private static ArrayList<Integer> addToArray(ArrayList<Integer> array, int[] indexes){
        ArrayList<Integer> newArray = array;
        
        for(int index: indexes){
            newArray.add(index);
        }
        return newArray;
    }
}