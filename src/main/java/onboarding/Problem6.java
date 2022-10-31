package onboarding;

import java.util.*;

public class Problem6 {
    private static final Map<String, Integer> PIECE_OF_2_LETTER = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        clearHash();
        setTotalNicknamePieces(forms);
        answer = getSimilarUserList(forms);
        return answer;
    }

    public static void clearHash() {
        PIECE_OF_2_LETTER.clear();
    }

    public static void setTotalNicknamePieces(List<List<String>> forms) {
        for (List<String> user : forms) {
            setPiecesOfNickname(user.get(1));
        }
    }

    public static void setPiecesOfNickname(String nickname) {
        int len = nickname.length();
        for (int i = 0; i < len - 1; ++i) {
            String subStr = nickname.substring(i, i + 2);
            PIECE_OF_2_LETTER.put(subStr, PIECE_OF_2_LETTER.getOrDefault(subStr, 0) + 1);
        }
    }

    public static List<String> getSimilarUserList(List<List<String>> forms) {
        List<String> emailList = new ArrayList<>();
        for (List<String> user : forms) {
            addSimilarUserToEmailList(emailList, user);
        }
        emailList.sort(Comparator.naturalOrder());
        return emailList;
    }

    public static List<String> addSimilarUserToEmailList(List<String> emailList, List<String> user) {
        String emailOfSimilarUser = getEmailFromSimilarUser(user);
        if (emailOfSimilarUser != null) {
            emailList.add(emailOfSimilarUser);
        }
        return emailList;
    }

    public static String getEmailFromSimilarUser(List<String> user) {
        String nickname = user.get(1);
        int len = nickname.length();
        for (int i = 0; i < len - 1; ++i) {
            String subStr = nickname.substring(i, i + 2);
            if (PIECE_OF_2_LETTER.get(subStr) > 1)
                return user.get(0);
        }
        return null;
    }
}
