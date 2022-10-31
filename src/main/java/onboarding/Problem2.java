package onboarding;

import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder();
        List<Character> charList = convertListFrom(cryptogram);

        while(findDuplication(charList)!=-1) {
            int index = findDuplication(charList);
            charList.remove(index);
            charList.remove(index);
        }

        for (char c: charList) {
            answer.append(c);
        }
        return answer.toString();
    }

    private static List<Character> convertListFrom(String s) {
        return s.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.toList());
    }

    private static int findDuplication(List<Character> charList) {
        for (int i=0; i< charList.size()-1; i++) {
            char currentItem = charList.get(i);
            char nextItem = charList.get(i+1);

            if (currentItem == nextItem) {
                return i;
            }
        }
        return -1;
    }
}
