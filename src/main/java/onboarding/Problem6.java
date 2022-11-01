package onboarding;

import ExceptionValidation.P6ExceptionValidation;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collection.*;
import static java.util.Collections.sort;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {


        for(List<String> form: forms){
            String email = form.get(0);
            String userName = form.get(1);
            if(!(P6ExceptionValidation.p6ExceptionValidation(email, userName))){
                return Collections.emptyList();
            }
        }

        List<String> duplicatedEmailList = findDuplicatedEmailList(forms);

        return duplicatedEmailList;
    }

    public static List<String> findDuplicatedEmailList(List<List<String>> forms) {

        HashSet<String> validationSet = new HashSet<>();
        HashSet<String> subSet = new HashSet<>();
        HashSet<String> duplicatedUserSet = new HashSet<>();

        String firstUserName = forms.get(0).get(1);

        for (int i = 0; i < firstUserName.length() - 1; i++) {
            subSet.add(firstUserName.substring(i, i + 2));
        }

        for (int i = 1; i < forms.size(); i++) {
            String userName = forms.get(i).get(1);

            for (int j = 0; j < userName.length() - 1; j++) {
                String duplicatedKey = userName.substring(j, j + 2);
                if (subSet.contains(duplicatedKey)) {
                    validationSet.add(duplicatedKey);
                }
                subSet.add(duplicatedKey);

            }
        }

        for (int i = 0; i < forms.size(); i++) {
            String userName = forms.get(i).get(1);
            for (int j = 0; j < userName.length() - 1; j++) {
                String candidatedUser = userName.substring(j, j + 2);
                if (validationSet.contains(candidatedUser)) {
                    String email = forms.get(i).get(0);
                    duplicatedUserSet.add(email);
                }
            }

        }

        return duplicatedUserSet.stream().sorted().collect(Collectors.toList());
    }
}

