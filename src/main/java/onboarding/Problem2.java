package onboarding;

import java.util.Queue;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decodingString(cryptogram);
    }

    public static String decodingString(String cryptogram){
        String plainText = deleteDuplicatedChar(cryptogram);
        String preText = cryptogram;
        while(!(plainText.equals(preText))){
            preText = plainText;
            plainText = deleteDuplicatedChar(plainText);
        }
        return  plainText;
    }

    public static String deleteDuplicatedChar(String str){
        int len = str.length();
        if(len < 2)
            return str;

        int deletedChar = Character.MAX_VALUE;
        StringBuilder resultText = new StringBuilder();
        for(int i=0; i<len-1; i++){
            if((deletedChar == str.charAt(i)) || (str.charAt(i) == str.charAt(i+1)))
                deletedChar = str.charAt(i);
            else {
                resultText.append(str.charAt(i));
                deletedChar = Character.MAX_VALUE;
            }
        }

        if(str.charAt(len - 2) != str.charAt(len - 1)){
            resultText.append(str.charAt(len - 1));
        }

        return resultText.toString();
    }


}
