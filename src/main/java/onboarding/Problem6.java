package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = List.of("answer");

        List<List<String>> saveInList = new ArrayList<>();

        for(int i = 0; i < forms.size(); i++){

            String nowString = forms.get(i).get(1);
            saveInList.add(getAllWordList(nowString));
        }

        return answer;
    }

    public static List<String> getAllWordList(String string) {

        List<String> wordList = new ArrayList<>();

        for (int j = 0; j < string.length() - 1; j++) {

            for (int k = j + 2; k < string.length() + 1; k++) {

                wordList.add(string.substring(j, k));

            }
        }
        return wordList;
    }
}
