/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.*;
public class Sort {

    public static void BucketSort(int[] a,int max,int min){
        int bucketCount =(max-min)/10+1;
        int length = max-min+1;
        Integer[][] bucket = new Integer[bucketCount][length];  
        for (int i=0; i<a.length; i++){
            int x = (a[i]-min)/10; 
            for (int j=0; j<length; j++){
                if (bucket[x][j]==null){
                    bucket[x][j]=a[i]-min;
                    break;
                }
            }
        }
        System.out.println("");
        for (int i=0;i<bucketCount;i++){
            
            
            for (int j=1; j<length; j++){
                if(bucket[i][j]==null){
                    break;
                }
                int value = bucket[i][j];
                int index=j;
                while (index>0 && bucket[i][index-1]>value){
                    bucket[i][index] = bucket[i][index-1];
                    index--;
                }
                bucket[i][index] = value;
            }
            
            
            for(int j=0;j<length;j++){
                if(bucket[i][j]==null){
                    break;
                }
                    System.out.print(bucket[i][j]+min+" ");
            }
        }
        
        
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
            }else if(inputNumber<min){
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