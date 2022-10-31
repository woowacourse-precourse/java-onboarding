package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    private static List<List<String>> candidates = new ArrayList<List<String>>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();


        for(List<String> person : forms) {
            List<String> words = collectTwoCharacters(person.get(0));


            candidates.add(words);
        }

        return answer;
    }

    /**
     * 입력받은 이름을 2글자가 되도록 쪼개서 모은다 (ex: 제이슨 -> 제이,이슨)
     */

    private static List<String> collectTwoCharacters(String name) {
        ArrayList<String> words = new ArrayList<>();
        for(int i=0; i<name.length()-1; i++) {
            String twoCharacter = String.valueOf(name.charAt(i) + name.charAt(i+1));
            words.add(twoCharacter);
        }

        return words;
    }

}
