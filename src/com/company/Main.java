package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static final int maxValue = 65536;

    public static void main(String[] args) {

        ArrayList<Integer> data = new ArrayList<>();
        ArrayList<Integer> data2 = new ArrayList<>();
        ArrayList<Integer> data3 = new ArrayList<>();
        ArrayList<Integer> data4 = new ArrayList<>();
        ArrayList<Integer> data5 = new ArrayList<>();
        ArrayList<Integer> data6 = new ArrayList<>();
        ArrayList<Integer> data7 = new ArrayList<>();
        ArrayList<Integer> data8 = new ArrayList<>();
        ArrayList<Integer> data9 = new ArrayList<>();


        Collections.addAll(data, 10, 20, 31, 40, 55, 60, 65525); //111
        Collections.addAll(data2, 0, 20, 40); //111
        Collections.addAll(data3, 40, 20, 0); //fail
        Collections.addAll(data4, 0,20); //fail
        Collections.addAll(data5, 1,2,5); //fail
        Collections.addAll(data6, 0, 20, 30, 40, 50, 60, 101); //111 and 110
        Collections.addAll(data7, 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,39,40,50,59); //111
        Collections.addAll(data8, 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,39,40,50,62); //110
        Collections.addAll(data9,65515,65535,19,20,31,40,55); //overflow
//        Collections.addAll(data,65515,65525,9,20,31,40,55); //overflow

//        int out = binarySearch(data, 5);
//        System.out.println(out);

        System.out.println("Data: " + data);
        int dataOne = decode111(data);
        System.out.println("Decode 111 output index: " + dataOne);
        int dataOne2 = decode110(data);
        System.out.println("Decode 110 output index: " + dataOne2);
        int dataOne3 = modifyDecode111(data);
        System.out.println("Modified Decode 111 output index: " + dataOne3);
        System.out.println();

        System.out.println("Data Two: " + data2);
        int dataTwo = decode111(data2);
        System.out.println("Decode 111 output index: " + dataTwo);
        int dataTwo2 = decode110(data2);
        System.out.println("Decode 110 output index: " + dataTwo2);
        int dataTwo3 = modifyDecode111(data2);
        System.out.println("Modified Decode 111 output index: " + dataTwo3);
        System.out.println();

        System.out.println("Data Three: " + data3);
        int dataThree = decode111(data3);
        System.out.println("Decode 111 output index: " + dataThree);
        int dataThree2 = decode110(data3);
        System.out.println("Decode 110 output index: " + dataThree2);
        int dataThree3 = modifyDecode111(data3);
        System.out.println("Modified Decode 111 output index: " + dataThree3);
        System.out.println();

        System.out.println("Data Four: " + data4);
        int dataFour = decode111(data4);
        System.out.println("Decode 111 output index: " + dataFour);
        int dataFour2 = decode110(data4);
        System.out.println("Decode 110 output index: " + dataFour2);
        int dataFour3 = modifyDecode111(data4);
        System.out.println("Modified Decode 111 output index: " + dataFour3);
        System.out.println();

        System.out.println("Data Five: " + data5);
        int dataFive = decode111(data5);
        System.out.println("Decode 111 output index: " + dataFive);
        int dataFive2 = decode110(data5);
        System.out.println("Decode 110 output index: " + dataFive2);
        int dataFive3 = modifyDecode111(data5);
        System.out.println("Modified Decode 111 output index: " + dataFive3);
        System.out.println();

        System.out.println("Data Six: "  + data6);
        int dataSix = decode111(data6);
        System.out.println("Decode 111 output index: " + dataSix);
        int dataSix2 = decode110(data6);
        System.out.println("Decode 110 output index: " + dataSix2);
        int dataSix3 = modifyDecode111(data6);
        System.out.println("Modified Decode 111 output index: " + dataSix3);
        System.out.println();

        System.out.println("Data Seven: " + data7);
        int dataSeven = decode111(data6);
        System.out.println("Decode 111 output index: " + dataSeven);
        int dataSeven2 = decode110(data7);
        System.out.println("Decode 110 output index: " + dataSeven2);
        int dataSeven3 = modifyDecode111(data7);
        System.out.println("Modified Decode 111 output index: " + dataSeven3);
        System.out.println();

        System.out.println("Data Eight: "  + data8);
        int dataEight = decode111(data8);
        System.out.println("Decode 111 output index: " + dataEight);
        int dataEight2 = decode110(data8);
        System.out.println("Decode 110 output index: " + dataEight2);
        int dataEight3 = modifyDecode111(data8);
        System.out.println("Modified Decode 111 output index: " + dataEight3);
        System.out.println();

        System.out.println("Data Nine: " + data9);
        int dataNine = overflow(data9);
        System.out.println("Overflow output index: "  + dataNine);
    }

    public static int binarySearch(ArrayList<Integer> data, int target){
        int first = 0;
        int last = data.size() - 1;
        int mid;

        while( first <= last ){
            mid = (first + last)/2;
            if ( data.get(mid) == target ){
                return mid;
            }else if ( data.get(mid) < target ){
                first = mid + 1;
            }else{
                last = mid - 1;
            }
        }
        return -1;
    }

    /*
    Software Decode: Write a function that accepts an in-order array of unsigned short values.
    The function shall then scan the array for a specific pattern: Three values contained within the array equally spaced 20 units apart.
    The function shall return the index position within the original array where the pattern begins or -1 if not present.
    Given the input array: data[] = {10,20,31,40,55,60,65525}
    The function shall return: 1
     */
    public static boolean ascendingOrder(ArrayList<Integer> data){
        for (int i = 0; i < data.size() -1; i++){
            if(data.get(i) > data.get(i + 1)){
                return false;
            }
        }
        return true;
    }

    public static int decode111(ArrayList<Integer> data) {
        if(ascendingOrder(data)) {
            for (int i = 0; i <= data.size() - 1; i++) {
                if ((binarySearch(data, data.get(i) + 20) != -1 && (binarySearch(data, data.get(i) + 40)) != -1)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /*
    1-1-0 Detection: Modify Problem 3 such that it returns the index of
    the beginning of a sequence where the first two elements are 20 units
    apart and there is NO element 40 units away from the first.
    Two elements present, one absent.
     */
    public static int decode110(ArrayList<Integer> data){
        if(ascendingOrder(data)) {
            for (int i = 0; i <= data.size() - 1; i++) {
                int secondIndex = binarySearch(data, data.get(i) + 20);
                if (secondIndex != -1) {
                    if (binarySearch(data, data.get(i) + 40) == -1) {
                        if (secondIndex < (data.size() - 1)) {
                            return i;
                        }
                    }
                }
            }
        }
        return -1;
    }

    /*
    Modify Problem 3 to generalize the gap spacing.
    Instead of hardcoding the difference of 20 into the function, change the function signature to include it as a parameter.
     */
    public static int modifyDecode111(ArrayList<Integer> data){
        if(ascendingOrder(data)) {
            int space = 20;
            for (int i = 0; i <= data.size() - 1; i++) {
                if ((binarySearch(data, data.get(i) + space) != -1 && (binarySearch(data, data.get(i) + (2 * space))) != -1)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /*
    Modify Problem 3 such that the input array may wrap-around or overflow.
    Given the input array: data[] = {65515,65535,19,20,31,40,55}
    The function shall return: 0
     */
    public static int overflow(ArrayList<Integer> data){
        for (int i = 0; i < data.size(); i++) {
            if ((linearSearch(data, overflowCheck(data.get(i) + 20)) != -1 && (linearSearch(data, overflowCheck(data.get(i) + 40))) != -1)) {
                return i;
            }
//                if ((binarySearch(data, overflowCheck(data.get(i) + 20)) != -1 && (binarySearch(data, overflowCheck(data.get(i) + 40))) != -1)) {
//                    return i;
//                }
        }
        return -1;
    }

    public static int overflowCheck(int n){
        //return ((n % maxValue + maxValue) % maxValue);
        return (n % maxValue);
    }

    public static int linearSearch(ArrayList<Integer> data, int target){
        int n = data.size();
        for(int i = 0; i < n; i++)
        {
            if(data.get(i) == target)
                return i;
        }
        return -1;
    }
}

