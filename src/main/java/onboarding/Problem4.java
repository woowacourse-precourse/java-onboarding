package onboarding;

import java.util.*;

public class Problem4 {
    public static String solution(String word) {

        if(!checkAlpabet(word)) {
            String fail = "NotAlpabet";
            return fail;
        }

        String uppercaseReverse = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String lowercaseReverse = "zyxwvutsrqponmlkjihgfedcba";

        Map uppercaseMap = new HashMap();
        Map lowercaseMap = new HashMap();

        for(int i = 0, j = 0 ; i<uppercase.length();i++,j++){
            char a = uppercaseReverse.charAt(i);
            char b = uppercase.charAt(j);
            uppercaseMap.put(a,b);
        }

        for(int i = 0, j = 0 ; i<uppercase.length();i++,j++){
            char a = lowercaseReverse.charAt(i);
            char b = lowercase.charAt(j);
            lowercaseMap.put(a,b);
        }

        String[] seperatedWord = word.split(" ");

        List seperateWordList = new ArrayList();
        StringBuilder str = new StringBuilder();

        for(int i = 0; i<seperatedWord.length;i++) {
            String wordString = seperatedWord[i];
            seperateWordList.add(wordString);

            for(int j =0; j<wordString.length();j++) {
                char b = wordString.charAt(j);

                if(Character.isUpperCase(b)) {
                    str.append(uppercaseMap.get(b));
                }

                if(Character.isLowerCase(b)) {
                    str.append(lowercaseMap.get(b));
                }
            }
            if(i == seperatedWord.length-1){
                break;
            }
            str.append(" ");
        }
        String result = str.toString();

        return result;
    }
    }

    public static boolean checkAlpabet(String word) {

        //공백제거
        String onlyAlpabet = word.replaceAll(" ","");

        //알파벳 정규표현식
        String pattern = "^[a-zA-Z]*$";

        return onlyAlpabet.matches(pattern);
    }
}
