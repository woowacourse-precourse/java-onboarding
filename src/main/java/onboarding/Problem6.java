package onboarding;

import java.util.*;

class CrewInfo {
    String email;
    String nickname;

    public CrewInfo(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }
}
public class Problem6 {
    public static List<String> searchNickname(List<String> answer, List<List<String>> forms) {
        List<CrewInfo> crews = new ArrayList<>();
        for (List<String> data:forms) {
            crews.add(new CrewInfo(data.get(0), data.get(1)));
        }

        HashSet<String> duplicatedEmail = findDuplicateNickname(crews);
        return new ArrayList<>();
    }

    public static HashSet<String> findDuplicateNickname(List<CrewInfo> crews) {
        HashSet<String> duplicateEmail = new HashSet<>();
        for (int i = 0; i < crews.size()-1; i++) {
            for (int j = i; j < crews.size(); j++) {
                if(containsWord(crews.get(i).nickname, crews.get(j).nickname)){
                    duplicateEmail.add(crews.get(i).email);
                    duplicateEmail.add(crews.get(j).email);
                }
            }
        }

        return duplicateEmail;
    }

    public static boolean containsWord(String nickname1, String nickname2) {
        for (int i = 2; i < nickname1.length(); i++) {
            String word = nickname1.substring(0, i);
            if(nickname2.contains(word)) {
                return true;
            }
        }

        return false;
    }

    public static List<String> solution(List<List<String>> forms) {
        Problem6 problem6 = new Problem6();
        List<String> answer = new ArrayList<>();

        answer = searchNickname(answer, forms);

        return answer;
    }
}
