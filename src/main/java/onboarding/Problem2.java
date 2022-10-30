package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        List<Character> chars = new ArrayList<>();

        for(char c: cryptogram.toCharArray()){
            chars.add(c);
        }
        remove(chars);

        StringBuilder sb = new StringBuilder();
        for(Character c: chars){
            sb.append(c);
        }
        String answer = sb.toString();
        return answer;
    }

    public static void remove(List<Character> charArr){
        boolean hasDuplicate = false;
        int index = 0;

        try{
            while(true){
                if(index+1==charArr.size()) break;
                while((charArr.get(index).equals(charArr.get(index+1)))) {
                    charArr.remove(index+1);
                    hasDuplicate = true;
                    if(charArr.size()==index+1) break;
                }
                if(hasDuplicate){
                    charArr.remove(index);
                    index = 0;
                } else{
                    index++;
                }
                hasDuplicate = false;
            }
        } catch(IndexOutOfBoundsException e){
            return;
        }
    }
}
