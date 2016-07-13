/**
 * 
 */
package com.alexiesracca.sandbox;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author alexies racca
 * @dateCreated Dec 14, 2015 
 */
public class LambdaTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] s =  new String[]{"c","d","b","a"};
        List<String> list = Arrays.asList(s);
        
        list.stream().filter((l) -> !l.equals("c")).sorted().forEach(System.out::print);
        
        int[] intSample = new int[]{1,3,4,5,6,7,8};
        List<int[]> intList =  Arrays.asList(intSample);
        IntStream.rangeClosed(0, 100).filter((i)-> i%2 == 0).forEach(System.out::println);
     //   DoubleStream.generate(2)
        

    }

}
