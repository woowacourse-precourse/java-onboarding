package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static boolean isOverLap(char a, char b) {
        if(a == b) {
            return true;
        } else {
            return false;
        }
    }

    public static String solution(String cryptogram) {
        int overlapNum = 0;

        List<Character> characterList = new ArrayList<>();

        for(char ch: cryptogram.toCharArray()){
            characterList.add(ch);
        }

        char tmp1, tmp2;

        int i=0;
        while(characterList.size() != 0 && i+1 < characterList.size()) {
            tmp1 = characterList.get(i);
            tmp2 = characterList.get(i+1);
            if(isOverLap(tmp1, tmp2)){
                characterList.remove(i);
                characterList.remove(i);
                i = 0;
            }
            else {
                i++;
            }
        }
        String answer = "";
        for(char chr: characterList){
            answer += chr;
        }
        return answer;
    }
}
