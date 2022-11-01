package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {


        return duplicateCheck(forms);
    }

    public static List<String> duplicateCheck(List<List<String>> forms) {

        List<String> nickNames = new ArrayList<>();
        Set<String> duplicatedCrewEmail = new HashSet<>();

        for (List<String> form : forms) {
            nickNames.add(form.get(1));
        }


        for (int a = 0; a < nickNames.size() - 1; a++) {

            for (int i = 1; a < i && i < nickNames.size(); i++) {


                for (int k = 0; k <= nickNames.get(a).length() - 2; k++) {

                    for (int j = 0; j <= nickNames.get(i).length() - 2; j++) {

                        if (nickNames.get(a).substring(k, k + 2).equals(nickNames.get(i).substring(j, j + 2))) {

                            duplicatedCrewEmail.add(forms.get(a).get(0));
                            duplicatedCrewEmail.add(forms.get(i).get(0));

                        }
                    }
                }
            }
        }

        List<String> result = new ArrayList<>(duplicatedCrewEmail);
        Collections.sort(result);

        return result;
    }







}
