package onboarding;

import java.util.*;

public class Problem6 {

    static HashMap<String, Set<String>> emailAndNicknameMap;

    public static List<String> solution(List<List<String>> forms) {

        emailAndNicknameMap = new HashMap<>();

        for (List<String> form : forms) {

            String email = form.get(0);
            String nickname = form.get(1);

            for (int i = 0; i < nickname.length() - 1; i++) {
                addNicknameSubstring(i, email, nickname, "");
            }
        }

        ArrayList<String> result = getResultFromHashMap();

        Collections.sort(result);

        return result;

    }

    static void addNicknameSubstring(int index, String email, String nickname, String substring) {

        if (substring.length() >= 2) {
            Set<String> set = emailAndNicknameMap.getOrDefault(substring, new HashSet<>());
            set.add(email);
            emailAndNicknameMap.put(substring, set);
        }

        if(index >= nickname.length())
            return;

        addNicknameSubstring(index + 1, email, nickname, substring + nickname.charAt(index));


    }

    static ArrayList<String> getResultFromHashMap() {

        ArrayList<String> result = new ArrayList<>();

        for (String nicknameSubstring : emailAndNicknameMap.keySet()) {

            Set<String> emailList = emailAndNicknameMap.get(nicknameSubstring);

            if (emailList.size() > 1) {
                addEmailToResult(result, emailList);
            }
        }

        return result;
    }

    static void addEmailToResult(ArrayList<String> result, Set<String> emailList) {

        for (String email : emailList) {
            result.add(email);
        }
    }
}
