package onboarding;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.LinkedList;

public class Problem2 {
    public static String solution(String cryptogram) {
        List<String> characters = Stream.of(cryptogram.split("")).parallel()
                .collect(Collectors.toCollection(LinkedList::new));
        while (true) {
            boolean removed = false;
            for (int i = 0; i < characters.size(); ) {
                int j = i + 1;
                while (j < characters.size() && characters.get(j).compareTo(characters.get(j - 1)) == 0) {
                    j++;
                }
                if (j == i + 1) {
                    i = j;
                    continue;
                }
                removed = true;
                for (int k = i; k < j; k++) {
                    characters.remove(i);
                }
            }
            if (!removed) {
                break;
            }
        }
        String answer = String.join("", characters);
        return answer;
    }
}
