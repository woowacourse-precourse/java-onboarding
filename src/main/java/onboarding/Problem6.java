package onboarding;

import java.util.*;

public class Problem6 {

    static HashMap<String, ArrayList<String>> emailAndNicknameMap;

    public static List<String> solution(List<List<String>> forms) {

        emailAndNicknameMap = new HashMap<>();

        for (List<String> form : forms) {

            String email = form.get(0);
            String nickname = form.get(1);

            addNicknameSubstring(email, nickname);

        }

        ArrayList<String> result = new ArrayList<>(getResultFromHashMap());

        Collections.sort(result);

        return result;
    }

    static void addNicknameSubstring(String email, String nickname) {

        Set<String> nicknameSubstringSet = new HashSet();

        for (int i = 0; i < nickname.length() - 1; i++) {
            nicknameSubstringSet.add(nickname.substring(i, i + 2));
        }

        Iterator<String> iterator = nicknameSubstringSet.iterator();

        while(iterator.hasNext()) {

            String nicknameSubstring = iterator.next();

            ArrayList<String> emailList = emailAndNicknameMap.getOrDefault(nicknameSubstring, new ArrayList<>());
            emailList.add(email);
            emailAndNicknameMap.put(nicknameSubstring, emailList);
        }


    }

    static Set<String> getResultFromHashMap() {

        Set<String> result = new HashSet<>();

        for (String nicknameSubstring : emailAndNicknameMap.keySet()) {

            ArrayList<String> emailList = emailAndNicknameMap.get(nicknameSubstring);

            if (emailList.size() > 1) {
                addEmailToResult(result, emailList);
            }
        }

        return result;
    }

    static void addEmailToResult(Set<String> result, ArrayList<String> emailList) {

        for (String email : emailList) {
            result.add(email);
        }
    }
}
