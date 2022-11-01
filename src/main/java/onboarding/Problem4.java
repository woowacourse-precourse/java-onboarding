package onboarding;

import java.util.ArrayList;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        ArrayList<Character> frog = new ArrayList<>();
        char[] arr = word.toCharArray();
        for(char c : arr) frog.add(c);

        for(int i=0;i<frog.size();i++){
            int temp = (int)frog.get(i);

            if(temp >=65 && temp < 91 ) answer += Character.toString((char)90 - (temp-65));
            else if(temp >= 97  && temp <= 122)  answer += Character.toString((char)122 - (temp-97));
            else answer += Character.toString((char)temp);
        }

        return answer;
    }
}
