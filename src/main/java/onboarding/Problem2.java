package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static void main(String[] args) {
        System.out.println(solution("browoanoommnaon"));
    }

    public static String solution(String cryptogram) {
        String answer = "a";

        if(cryptogram.length() == 1){
            return cryptogram;
        }

        answer = removeDupulication(cryptogram);

        return answer;
    }

    private static String removeDupulication(String cryptogram) {
        List<String> stack = new ArrayList<>();
        List<String> cryptogramList = new ArrayList<>(List.of(cryptogram.split("")));

        for(int i = 0; i < cryptogramList.size(); i++){
            if(!stack.isEmpty()){
                if(cryptogramList.get(i).equals(stack.get(stack.size()-1))){
                    stack.remove(stack.size()-1);
                    continue;
                }
            }
            stack.add(cryptogramList.get(i));
        }

        return String.join("",  stack);
    }
}
