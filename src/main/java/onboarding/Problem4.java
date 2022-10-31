package onboarding;

import org.assertj.core.util.Arrays;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char charValue = word.charAt(i); // 문자열에서 문자 하나만 추출

            if(Character.isLowerCase(charValue)){ // 문자가 소문자이면
                char upperChar = Character.toUpperCase(charValue); // 대문자로 변환
                char newLowerChar = Character.toLowerCase(find(upperChar)); // 다시 소문자로 변환
                sb.append(newLowerChar);
            }
            else{ // 문자가 대문자이면
                char newUpperChar = find(charValue);
                sb.append(newUpperChar);
            }
        }

//        System.out.println(sb.toString());
        return sb.toString();
    }

    private static char find(char charValue){
        char[] originalDict = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        List<Object> originalDictList = Arrays.asList(originalDict);

        char[] reverseDict = {'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N', 'M', 'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'};
        List<Object> reverseDictList = Arrays.asList(reverseDict);

        int originalIndex = originalDictList.indexOf(charValue); // 사전에서 문자의 인덱스를 알아냄

        if(originalIndex != -1){ // 사전에 해당 문자가 있다면
            return (char)reverseDictList.get(originalIndex); // 같은 인덱스를 사용해 청개구리 사전에서 바꿀 문자를 찾아서 반환
        }
        else
            return charValue; // 없으면 원래 문자를 반환
    }
}
