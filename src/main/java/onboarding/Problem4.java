package onboarding;

import org.assertj.core.util.Arrays;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        char[] originalDict = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        List<Object> originalDictList = Arrays.asList(originalDict);

        char[] reverseDict = {'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N', 'M', 'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'};
        List<Object> reverseDictList = Arrays.asList(reverseDict);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char originalChar = word.charAt(i); // 문자열에서 문자 하나만 추출
            int originalIndex = originalDictList.indexOf(originalChar); // 사전에서 문자의 인덱스를 알아냄

            if(originalIndex != -1){ // 사전에 해당 문자가 있다면
                char reverseChar = (char)reverseDictList.get(originalIndex); // 같은 인덱스를 사용해 청개구리 사전에서 바꿀 문자를 찾음
                sb.append(reverseChar); // 문장을 만듦
            }
            else
                sb.append(originalChar); // 원래 문자를 사용해 문장을 만듦
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        String word = "I LOVE YOU!";
        solution(word);
    }
}
