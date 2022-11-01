package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> emails = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            for(int j = 0; j < forms.size(); j++) {
                if ( isDuplicated(forms.get(i).get(1), forms.get(j).get(1))) {
                    if (!emails.contains(forms.get(i).get(0))) {
                        emails.add(forms.get(i).get(0));
                    }
                    if (!emails.contains(forms.get(j).get(0))) {
                        emails.add(forms.get(j).get(0));
                    }
                }
            }
        }

        List<String> answer = new ArrayList<>(emails);

        Collections.sort(answer);

        return answer;
    }

    private static boolean isDuplicated(String email1, String email2) {
        for (int i = 0; i < email1.length() -1 ; i++) {
            for (int j = 0; j < email2.length() -1 ; j++) {
                if (email1.substring( i, i+2 ).equals(email2.substring( j, j+2 ))) {
                    return true;
                }
            }
        }
        return false;
    }
}
