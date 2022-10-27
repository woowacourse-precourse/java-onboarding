package onboarding;

import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {
        String[] stringArr = cryptogram.split("");
        int[] delIndexArr = new int[cryptogram.length()];

        for (int i = 0; i < cryptogram.length() -1; i++){

            System.out.println(stringArr[i]);
            System.out.println(stringArr[i+1]);
            System.out.println(stringArr[i].equals(stringArr[i+1]));

            if(stringArr[i].equals(stringArr[i+1])){
//                remove index
                delIndexArr[i] += 1;
                delIndexArr[i+1] += 1;}}
        System.out.println(Arrays.toString(delIndexArr));
        String answer = "answer";
        return answer;
    }
}