package onboarding;

import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {

        if(cryptogram.length() < 2){
            return cryptogram;
        }

        String[] stringArr = cryptogram.split("");

        // get index of overlapping(repeated) letters
        int[] repIndexArr = new int[stringArr.length];
        for (int i = 0; i < stringArr.length - 1; i++){
            if(stringArr[i].equals(stringArr[i+1])){
                repIndexArr[i] += 1;
                repIndexArr[i+1] += 1;
            }
        }

        // define the length of new string
        int lossLen = 0;
        for (int delIndex: repIndexArr){
            if(delIndex > 0){
                lossLen += 1;
            }
        }


        // get new string
        int newStringLen = stringArr.length - lossLen;
        String[] newStringArr = new String[newStringLen];
        int newStringIndex = 0;
        for (int i = 0; i<repIndexArr.length;i++){
            if(repIndexArr[i] == 0){
                newStringArr[newStringIndex] = stringArr[i];
                newStringIndex += 1;
            }}
        String res = String.join("", newStringArr);

        if(lossLen == 0 || newStringArr.length < 2){
            return res;
        }

        return solution(res);
    }
}