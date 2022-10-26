package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        ArrayList<Character> characters = new ArrayList<>();
        for(int i=0; i<cryptogram.length(); i++)
            characters.add(cryptogram.charAt(i));

        boolean flag = true;
        int count;
        while(flag) {
            count = 0;

            for(int i=0; i<characters.size()-1; i++) {
                if(characters.get(i) == characters.get(i+1)) {
                    characters.remove(i+1);
                    characters.remove(i);
                    count++;
                }
            }

            if(count == 0)
                flag = false;
        }
        String answer ="";
        for(Character c : characters)
            answer += c;
        return answer;
    }
}
