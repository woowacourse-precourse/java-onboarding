package onboarding;

import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {
        String[] stringArr = cryptogram.split("");

        int[] delIndexArr = new int[stringArr.length];
        for (int i = 0; i < stringArr.length -1; i++){
            if(stringArr[i].equals(stringArr[i+1])){
                delIndexArr[i] += 1;
                delIndexArr[i+1] += 1;}}
        System.out.println(Arrays.toString(delIndexArr));

        // define the length of new string
        int lossLen = 0;
        for (int i =0; i<delIndexArr.length;i++){
            if(delIndexArr[i]>0){
                lossLen += 1;
            }
        }
        System.out.println(lossLen); // 4

        int newStringLen = stringArr.length - lossLen;
        String[] newStringArr = new String[newStringLen];
        int newStringIndex = 0;
        for (int i =0; i<delIndexArr.length;i++){
            if(delIndexArr[i]==0){
                newStringArr[newStringIndex] = stringArr[i];
                newStringIndex = newStringIndex + 1;
            }}
        System.out.println(Arrays.toString(newStringArr));
        String res = String.join("", newStringArr);

        if(lossLen == 0 || newStringArr.length < 2){
            return res;
        }

        return solution(res);
    }
}