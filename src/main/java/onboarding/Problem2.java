package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        List<Character> charList = new ArrayList<>();
        for (char character : cryptogram.toCharArray()) {
            charList.add(character);
        }

        if (cryptogram.length() < 1 || 1000 < cryptogram.length()){
            return ("문자의 길이를 1 이상 1000 이하로 입력해 주세요!");
        }

        for(int index = 0; index < cryptogram.length(); index++){
            if(Character.isUpperCase(charList.get(index))){
                return ("문자를 소문자만 입력해 주세요!");
            }
        }

        int index = 0;
        while (index < charList.size() - 1){
            if(charList.get(index) == charList.get(index+1)) {
                charList.remove(index);
                charList.remove(index);
                index = 0;
            } else {
                index = index + 1;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Character ch : charList) {
            sb.append(ch);
        }

        String answer = sb.toString();
        return answer;
    }
}
