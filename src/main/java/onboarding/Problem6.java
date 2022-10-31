package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem6 {

    public static List<String> getSepNames(List<List<String>> forms) {
        List<String> sepNames = new ArrayList<>();
        for (List<String> form : forms) {
            String name = form.get(1);
            for(int i = 0; i < name.length() - 1; i++) {
                sepNames.add(name.substring(i, i + 2));
            }
        }
        return sepNames;
    }


    public static String getDupName(List<String> sepNames) {
        for (String sepName : sepNames) {
            if(Collections.frequency(sepNames, sepName) != 1) {
                return sepName;
            }
        }
        return "";
    }

    public static List<String> getDupEmails(List<List<String>> forms, String dupName) {
        List<String> dupEmails = new ArrayList<>();
        for (List<String> form : forms) {
            if (form.get(1).contains(dupName)) {
                dupEmails.add(form.get(0));
            }
        }
        return dupEmails;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> sepNames = getSepNames(forms);
        String dupName = getDupName(sepNames);
        List<String> answer = getDupEmails(forms, dupName);
        Collections.sort(answer);
        return answer;
    }




}
