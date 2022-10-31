package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = getResult(forms);
        return answer;
    }

    static List<String> getResult(List<List<String>> forms) {
        HashMap<String,String> words = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (int i=0;i<forms.size();i++) {
            for (String twoWord : getWordList(forms.get(i).get(1))) {
                String email = forms.get(i).get(0);
                if (words.get(twoWord) == null) {
                    words.put(twoWord, email);
                    continue;
                }
                if (result.contains(email)) continue;
                if (!result.contains(words.get(twoWord)))
                    result.add(words.get(twoWord));
                result.add(email);
            }
        }

        Collections.sort(result);
        return result;
    }

    static List<String> getWordList(String name) {
        List<String> wordList = new ArrayList<>();
        if (name.length() == 1) return wordList;
        for (int i=1;i<name.length();i++)
            wordList.add(name.substring(i-1, i+1));
        return wordList;
    }
}
