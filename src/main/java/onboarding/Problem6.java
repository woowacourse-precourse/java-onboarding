package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> getWords(String nick) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < nick.length() - 1; i++) {
            result.add(nick.substring(i, i + 2));
        }

        return result;
    }
    
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> dict = new HashMap<>();
        List<List<String>> wordOfNick = new ArrayList<>();

        for(int i = 0; i < forms.size(); i++){
            String nick = forms.get(i).get(1);
            List<String> words = getWords(nick);

            wordOfNick.add(words);

            for (String word : words) {
                if (dict.containsKey(word)) {
                    dict.put(word, dict.get(word) + 1);
                } else {
                    dict.put(word, 1);
                }
            }
        }

        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            List<String> words = wordOfNick.get(i);

            for (String word : words) {
                if (dict.get(word) > 1) {
                    answer.add(email);
                    break;
                }
            }
        }
        
        Collections.sort(answer);

        return answer;
    }
}
