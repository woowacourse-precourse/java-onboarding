package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        char beforeChar = ' ';
        String newCryptogram = "";

        for(int i=0; i<cryptogram.length(); i++){
            char curChar = cryptogram.charAt(i);

            if(curChar != beforeChar){
                newCryptogram += curChar;
            }
            beforeChar = curChar;
        }


        System.out.println("========================================");
        System.out.println(newCryptogram);



        return answer;
    }


    public static void main(String[] args) {
        solution("browoanoommnaon");
    }
}
