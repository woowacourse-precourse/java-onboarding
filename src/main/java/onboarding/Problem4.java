package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String convertedWord = "";
        for(int i = 0 ; i< word.length(); i++){
            char slicedWord = word.charAt(i);
            if(slicedWord >= 65 && slicedWord <= 90){
                slicedWord = (char)(155 - (int)(slicedWord));
            }
            else if(slicedWord >= 97 && slicedWord <= 122){
                slicedWord = (char)(219 - (int)(slicedWord));
            }
            convertedWord += slicedWord;
        }
        return convertedWord;
    }
    public static void main(String args[]){
        String word = "I love you";
        System.out.println(solution((word)));
    }


}
