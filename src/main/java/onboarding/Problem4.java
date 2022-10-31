package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        HashMap<Character, Character> hashMap = new HashMap<>();
        for(int i=0;i<26;i++){
            char lowerLeft = (char)(i + 'a');
            char lowerRight = (char)((25-i) + 'a');
            hashMap.put(lowerLeft,lowerRight);

            char higherLeft = (char)(i + 'A');
            char higherRight = (char)((25-i) + 'A');
            hashMap.put(higherLeft,higherRight);
        }
        StringBuilder sb = new StringBuilder();
        for(char a : word.toCharArray()){
            if(hashMap.containsKey(a)){
                sb.append(hashMap.get(a));
            }else{
                sb.append(a);
            }
        }
        answer = sb.toString();

        return answer;
    }
}
