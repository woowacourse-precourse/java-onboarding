package onboarding;

import java.util.*;

public class Problem6 {
    static HashMap<String, String> twoWords = new HashMap<>(10000);
    static Set<String> emailSet = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {
        for (List<String> crew : forms) {
            dontname(crew);
        }
        return new ArrayList<>(emailSet);
    }

    private static void dontname(List<String> crew) {
        String email = crew.get(0);
        String nickname = crew.get(1);
        HashMap<String, String> prevWords = twoWords;
        String vmail;
        for (int i = 0; i < nickname.length() - 1; i++) {
            String twoLetter = nickname.substring(i, i +2);
            if ((vmail = prevWords.get(twoLetter)) != null){
                emailSet.add(vmail);
                emailSet.add(email);
            } else {
                twoWords.put(twoLetter, email);
            }
        }
    }
}
