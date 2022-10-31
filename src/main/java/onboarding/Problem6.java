package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        forms = new ArrayList<>(forms);
        ArrayList<String> separateName = new ArrayList<String>();

        for (List<String> strings : forms) {
            for (int k = 0; strings.size() - 1 > k; k++) {
                separateName.add(String.valueOf(strings.get(1).charAt(k)) + (strings.get(1).charAt(k + 1)));
            }
        }

        ArrayList<String> checkDuplicateName = new ArrayList<String>();

        for  (int s = 0; separateName.size() > s; s++){
            for (int k = 0; separateName.size() > k; k++){
                if (s != k && Objects.equals(separateName.get(s), separateName.get(k))){
                    checkDuplicateName.add(separateName.get(s));
                }
            }
        }

        HashSet<String> hashSet = new HashSet<>(checkDuplicateName);
        ArrayList<String> duplicateName = new ArrayList<String>(hashSet);
        ArrayList<String> getEmail = new ArrayList<String>();

        for (List<String> form : forms) {
            for (String s : duplicateName) {
                if (form.get(1).contains(s)) {
                    getEmail.add(form.get(0));
                }
            }
        }

        HashSet<String> hashSet2 = new HashSet<>(getEmail);
        ArrayList<String> getDupUserEmail = new ArrayList<String>(hashSet2);
        Collections.sort(getDupUserEmail);

        List<String> answer = getDupUserEmail;
        return answer;
    }
}
