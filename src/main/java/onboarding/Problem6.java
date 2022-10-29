package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {

    private static Set<String> duplicateList = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {

        for (List<String> form : forms) {
            String name = form.get(1);
            for (int i = 0; i < name.length() - 1; i++) {
                checkDuplicate(forms, name.substring(i, i + 2), form);
            }
        }

        return new ArrayList<>(duplicateList);
    }

    public static void checkDuplicate(List<List<String>> forms, String checkName, List<String> originForm) {
        String originEmail = originForm.get(0);
        String originName = originForm.get(1);
        boolean isDuplicate = false;

        for (List<String> form : forms) {
            String email = form.get(0);
            String name = form.get(1);

            if (name.contains(checkName) && !originEmail.equals(email) && !originName.equals(name)) {
                duplicateList.add(email);
                isDuplicate = true;
            }
        }

        if (isDuplicate) {
            duplicateList.add(originEmail);
        }
    }
}
