package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    static HashMap<String, List<Integer>> wordDict = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        makeDict(forms);

        List<Integer> user = getUser(forms.size());

        List<String> emailList = getEmail(forms, user);
        Collections.sort(emailList);

        return emailList;
    }

    /**
     * 로직 함수
     */
    private static void makeDict(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            String nickname = forms.get(i).get(1);

            for (int j = 0; j < nickname.length() - 1; j++) {
                String word = nickname.substring(j, j + 2);
                List<Integer> idxList = wordDict.get(word);

                if (idxList == null) {
                    idxList = new ArrayList<>();
                    idxList.add(i);
                    wordDict.put(word, idxList);
                } else {
                    idxList.add(i);
                }
            }
        }
    }

    private static List<Integer> getUser(int n) {
        List<Integer> users = new ArrayList<>(Collections.nCopies(n, 0));

        for (String word : wordDict.keySet()) {
            List<Integer> idx = wordDict.get(word);

            if (idx.size() != 1) {
                for (int i = 0; i < idx.size(); i++) {
                    users.set(idx.get(i), 1);
                }
            }
        }

        return users;
    }

    private static List<String> getEmail(List<List<String>>forms, List<Integer> users) {
        List<String> emailList = new ArrayList<>();

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) == 1) {
                emailList.add(forms.get(i).get(0));
            }
        }

        return emailList;
    }
}
