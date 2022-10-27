package onboarding;

import java.util.*;
import java.util.stream.*;

class Problem1 {
    private static boolean testPage(List<Integer> list){
        if(list.get(1) - list.get(0) == 1)  return true;
        return false;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!testPage(pobi) || !testPage(crong)) return -1;

        List <Integer> listA = pobi.stream().map(num -> Integer.toString(num).toCharArray())
                .map(arr -> {
                    int A, B;
                    A = 0;  B = 1;
                    for(int i = 0; i < arr.length; i++){
                        A += arr[i] - '0';
                        B *= arr[i] - '0';
                    }
                    return Math.max(A, B);
                }).collect(Collectors.toList());

        List <Integer> listB = crong.stream().map(num -> Integer.toString(num).toCharArray())
                .map(arr -> {
                    int A, B;
                    A = 0;  B = 1;
                    for(int i = 0; i < arr.length; i++){
                        A += arr[i] - '0';
                        B *= arr[i] - '0';
                    }
                    return Math.max(A, B);
                }).collect(Collectors.toList());

        int A = Collections.max(listA);
        int B = Collections.max(listB);

        if( A > B)  return 1;
        else if( A < B) return 2;
        return 0;
    }
}