package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    static List<String> nameList;
    static List<String> emailList;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = deduplicateAndSort(forms);
        return answer;
    }

    public static void createNameList(List<List<String>> forms) {
        nameList = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            nameList.add(forms.get(i).get(1));
        }
    }

    public static List deduplicateName(List<List<String>> forms) {
        createNameList(forms);
        String name;
        emailList = new ArrayList<>();

        for (int i = 0; i < nameList.size(); i++) {
            name = nameList.get(i);

            int nameSize = name.length();
            String substringName;
            for (int j = 0; j < nameSize - 1; j++) {
                substringName = name.substring(j, j + 2);

                for (int k = i + 1; k < nameList.size(); k++) {
                    if (nameList.get(k).contains(substringName)) {
                        if (!emailList.contains(forms.get(i).get(0))) {
                            emailList.add(forms.get(i).get(0));
                        }
                        emailList.add(forms.get(k).get(0));
                    }
                }
            }
        }
        return emailList;
    }

    public static List deduplicateAndSort(List<List<String>> forms) {
        deduplicateName(forms);
        List<String> deduplicatedEmails = emailList.stream().distinct().collect(Collectors.toList());
        Collections.sort(deduplicatedEmails);
        return deduplicatedEmails;
    }
}
