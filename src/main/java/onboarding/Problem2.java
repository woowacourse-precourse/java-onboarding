package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        ArrayList <Character> list = new ArrayList<>();
        for(char c : cryptogram.toCharArray()) list.add(c);
        int pre_size = -1;

        while(list.size() != pre_size){
            pre_size = list.size();
            for(int i = 0; i < list.size() - 1; i++){
                if(list.get(i) == list.get(i+1)){
                    list.remove(i);
                    list.remove(i);
                    break;
                }
            }
        }
        String answer = "";
        for(char c : list)  answer  += c;
        return answer;
    }
}
