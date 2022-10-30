package onboarding;

import java.util.*;

public class Problem6 {

    static Map<String, String> formHash = new HashMap<>();
    static Set<String> answerSet = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        for (int i = 0; i < forms.size(); i++) {
            List<String> form = forms.get(i);
            if (hashForm(splitName(form.get(1)), form.get(0))) {
                answerSet.add(form.get(0));
                continue;
            }
        }
        answerSet.stream().sorted().forEach(email -> answer.add(email));
        return answer;
    }

    private static List<String> splitName(String name) {
        List<String> namePiece = new ArrayList<String>();
        for (int i = 0; i < name.length() - 1; i++) {
            namePiece.add(name.substring(i, i + 2));
        }
        return namePiece;
    }

    private static boolean hashForm(List<String> namePiece, String email) {
        for (int i = 0; i < namePiece.size(); i++) {
            if (formHash.containsKey(namePiece.get(i))) {
                answerSet.add(formHash.get(namePiece.get(i)));
                return true; // Collision
            }
            formHash.put(namePiece.get(i), email);
        }
        return false;
    }

}
