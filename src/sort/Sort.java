/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.*;
public class Sort {

    public static void BucketSort(int[] a,int max,int min){
        int bucketCount =10;
        int size = (max-min)/10+1;
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();//Integer[bucketCount][length];
        for(int i=0;i<bucketCount;i++)
        bucket.add(new ArrayList<>());
        for (int i=0; i<a.length; i++){
            int x = (a[i]-min)/size; 
           bucket.get(x).add(a[i]);
        }
        System.out.println("");
        
        String listOutput = "";
        
        for (int i=0;i<bucketCount;i++){
           Collections.sort(bucket.get(i));
           for(int j=0;j<bucket.get(i).size();j++){
               listOutput += ((bucket.get(i).get(j))+" ");
//System.out.print((bucket.get(i).get(j))+" ");
           }
        }
        System.out.println(listOutput);
        
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number,max= Integer.MIN_VALUE,min= Integer.MAX_VALUE;
        System.out.println("Please enter the number of array");
        number = input.nextInt();
        int[] num = new int[number];
        int inputNumber,x;
        
        for(int i=0;i<number;i++){
            inputNumber = input.nextInt();
            if(inputNumber>max){
                max = inputNumber;
            }if(inputNumber<min){
                min = inputNumber;
            }
            num[i]=inputNumber;
        }
        
        
        
        for(int i=0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
        BucketSort(num,max,min);
    }
    
}