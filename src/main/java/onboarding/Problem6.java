package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
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
