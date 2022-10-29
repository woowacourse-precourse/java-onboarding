package onboarding;

import java.util.LinkedList;
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        answer = "";
        final int LENGTH=cryptogram.length();
        LinkedList<String> list=new LinkedList<String>();

        String[] array=cryptogram.split("");

        for(int i=0;i<LENGTH;i++) list.add(array[i]);


        return answer;
    }
}