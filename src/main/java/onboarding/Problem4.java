package onboarding;

import java.util.ArrayList;

public class Problem4 {
    public static ArrayList<Character> frog(String word) {

        char[] charArr = word.toCharArray();
        ArrayList<Character> result = new ArrayList<Character>();
        for (int i = 0; i < charArr.length; i++) {
            if (Character.isUpperCase(charArr[i])) {
                char after = (char) Math.abs(155 - (int) (charArr[i]));
                result.add(after);
            } else if (Character.isLowerCase(charArr[i])) {
                char after = (char) Math.abs(219 - (int) (charArr[i]));
                result.add(after);
            } else if ((charArr[i]) == ((char) (32))) {
                result.add((charArr[i]));
            }
            else continue;
        }
        return result;
    }
    public static String solution(String word) {
        ArrayList<Character> result = frog(word);
        String answer = "";
        for(int i = 0;i< result.size();i++){
            answer += String.valueOf(result.get(i));
        }
        return answer;
    }
}
