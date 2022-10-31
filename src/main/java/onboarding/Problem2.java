package onboarding;

import java.util.ArrayList;
import java.util.Objects;

public class Problem2 {
    public static String solution(String cryptogram) {
        String[] letters = cryptogram.split("");
        ArrayList<String> stack = new ArrayList<>();
        stack.add(letters[0]);
        int cnt = 1;
        while(cnt > 0){
            cnt = 0;
            for(int i = 1; i < letters.length; i++){
                if(Objects.equals(stack.get(stack.size() - 1), letters[i])){
                    stack.remove(stack.size()-1);
                    cnt += 1;
                }
                else{
                    stack.add(letters[i]);
                }
            }

            if(stack.size() <= 1){
                return String.join("", stack);
            }
            letters = stack.toArray(new String[0]);
            stack = new ArrayList<>();
            stack.add(letters[0]);
        }
    return String.join("", letters);

    }
}
