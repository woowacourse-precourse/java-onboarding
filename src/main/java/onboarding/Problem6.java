package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = new ArrayList<>();
        List<String> wordlist = getWordList(forms);
        List<String> onlywordlist = getOnlyWordList(wordlist);

        for (String onlyword : onlywordlist) {
            for (int i = 0; i < forms.size(); i++) {
                String email = forms.get(i).get(0);
                String name = forms.get(i).get(1);

                if (name.contains(onlyword)) {
                    answer.add(email);
                }
            }
        }
        Collections.sort(answer);

        return answer;
    }

    public static List<String> getWordList(List<List<String>> forms) {
        ArrayList<String> wordlist = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            for (int j = 0; j < name.length() - 1; j++) {
                String word = "";
                String name0, name1;
                name0 = Character.toString(name.charAt(j));
                name1 = Character.toString(name.charAt(j + 1));
                word = name0 + name1;
                wordlist.add(word);
            }

        }
        return wordlist;
    }

    public static ArrayList<String> getOnlyWordList(List<String> wordlist) {
        ArrayList<String> onlywordlist = new ArrayList<>();

        for (int i = 0; i < wordlist.size(); i++) {
            String word = wordlist.get(i);
            for (int j = wordlist.size() - 1; j > i; j--) {
                String checkword = wordlist.get(j);
                if (Objects.equals(word, checkword)) {
                    if (!onlywordlist.contains(word)){
                        onlywordlist.add(word);
                    }
                }
            }
        }
        return onlywordlist;
    }
}
