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

        boolean isDeleted = false;
        StringBuilder resultText = new StringBuilder();
        for(int i=0; i<len-1; i++){
            if(str.charAt(i) == str.charAt(i+1))
                isDeleted = true;

            if(!isDeleted)
                resultText.append(str.charAt(i));

            if(str.charAt(i) != str.charAt(i+1))
                isDeleted = false;
        }

        if(str.charAt(len - 2) != str.charAt(len - 1)){
            resultText.append(str.charAt(len - 1));
        }

        return resultText.toString();
    }


}
