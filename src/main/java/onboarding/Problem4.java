package onboarding;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem4 {
    public static String solution(String word) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        String str2 = str.toUpperCase();

        ArrayList<String> alphaList1 = new ArrayList<>(Arrays.asList(str.split("")));
        ArrayList<String> alphaList2 = new ArrayList<>(Arrays.asList(str2.split("")));

        StringBuilder answer = new StringBuilder();
        for (int i=0; i<word.length();i++){
            char[] c = {word.charAt(i)};   //i번째 문자를 찾고 리스트에 있는지 확인
            String letter = new String(c);
            if (alphaList1.contains(letter)){
                int index = 25 - alphaList1.indexOf(letter);
                answer.append(alphaList1.get(index));
            }
            else if(alphaList2.contains(letter)){
                int index = 25 - alphaList2.indexOf(letter);
                answer.append(alphaList2.get(index));
            }
            else {
                answer.append(" ");
            }
        }
        return answer.toString();    //String Buffer to string
    }
}
