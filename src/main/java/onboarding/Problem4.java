package onboarding;

import java.util.ArrayList;

public class Problem4 {
    public static String solution(String word) {
        ArrayList<Character> lst = new ArrayList<>();
        char[] arr = word.toCharArray();
        for(char c : arr) lst.add(c);

        for(int i=0;i<lst.size();i++){
            int tmp = (int)lst.get(i);
            if(65 <= tmp && tmp <= 90) lst.set(i, (char)(155-tmp));
            else if(97 <= tmp && tmp <= 122) lst.set(i, (char)(219-tmp));
        }
        String answer= "";
        for(char c : lst){
            answer += c;
        }
        return answer;
    }
}
