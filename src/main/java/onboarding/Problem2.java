package onboarding;

import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {

        // if the cryptogram length is 0 or 1, return
        if(cryptogram.length() < 2){
            return cryptogram;
        }

        String[] stringArr = cryptogram.split("");

        // get index of overlapping(repeated) letters
        int[] repIndexArr = getRepIndexArr(stringArr);

        // define the length of new string
        int lossLen = calcLossLen(repIndexArr);


        // get new string
        String[] newStringArr = getNewStringArr(stringArr, repIndexArr, lossLen);
        String res = String.join("", newStringArr);

        if(lossLen == 0 || newStringArr.length < 2){
            return res;
        }

        // repeat
        return solution(res);
    }

    private static String[] getNewStringArr(String[] stringArr, int[] repIndexArr, int lossLen) {
        int newStringLen = stringArr.length - lossLen;
        String[] newStringArr = new String[newStringLen];
        int newStringIndex = 0;
        // get array that contains letters of new string
        for (int i = 0; i< repIndexArr.length; i++){
            if(repIndexArr[i] == 0){
                newStringArr[newStringIndex] = stringArr[i];
                newStringIndex += 1;
            }}
        return newStringArr;
    }

    private static int calcLossLen(int[] repIndexArr) {
        int lossLen = 0;
        for (int delIndex: repIndexArr){
            if(delIndex > 0){
                lossLen++;
            }
        }
        return lossLen;
    }

    private static int[] getRepIndexArr(String[] stringArr) {
        int[] repIndexArr = new int[stringArr.length];
        for (int i = 0; i < stringArr.length - 1; i++){
            if(stringArr[i].equals(stringArr[i+1])){
                repIndexArr[i] += 1;
                repIndexArr[i+1] += 1;
            }
        }
        return repIndexArr;
    }
}