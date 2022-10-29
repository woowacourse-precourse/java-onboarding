package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        return answer;
    }

    private static void getEachListInForms(List<List<String>> forms) {
        for (List<String> nameAndEmailList : forms) {
            checkNameDuplication(nameAndEmailList);
        }
    }

    private static void checkNameDuplication(List<String> nameAndEmail) {
        HashMap<String, String> hashMap = new HashMap<>();
        HashSet<String> emails = new HashSet<>();

        String name = nameAndEmail.get(1);
        String email = nameAndEmail.get(0);

        for (int i = 0; i < name.length() - 1; i++) {
            name = name.substring(i, i + 2);
            //해당키가 이미 있다면
            if (hashMap.containsKey(name)) {
                String duplicateEmail = hashMap.get(name);
                emails.add(email);
                emails.add(duplicateEmail);
            } else {
                hashMap.put(name, email);
            }
        }
    }

}
