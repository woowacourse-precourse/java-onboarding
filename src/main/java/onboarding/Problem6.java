package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> nicknames = new ArrayList<>();
        List<String> emails = new ArrayList<>();
        List<String> nicknamesExceptThis;
        int index;
        String nickname;
        boolean exists;

        for (List<String> user : forms) {
            emails.add(user.get(0));
            nicknames.add(user.get(1));
        }

        for (int j = 0; j < nicknames.size(); j++) {
            nickname = nicknames.get(j);
            nicknamesExceptThis = new ArrayList<>(nicknames);
            nicknamesExceptThis.remove(j);
            exists = false;
            for (int k = 0; k < nickname.length(); k++) {
                index = (toString(nicknamesExceptThis)).indexOf(nickname.charAt(k));
                if ((index != -1) && (index + 1 < nicknamesExceptThis.size()) && (k + 1 < nickname.length())) {
                    if (toString(nicknamesExceptThis).charAt(index + 1) == nickname.charAt(k + 1)) {
                        exists = true;
                    }
                }
            }
            if (exists) {
                answer.add(emails.get(j));
            }
        }

        Collections.sort(answer);
        answer = new ArrayList<>(new LinkedHashSet<>(answer));
        return answer;
    }

    static String toString(List<String> arr) {
        StringBuilder str = new StringBuilder();
        for (String item : arr) {
            str.append(item);
            str.append(" ");
        }
        return str.toString();
    }
}
