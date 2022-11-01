package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = deduplicateAndSort(forms);
        return answer;
    }

    public static List createNameList(List<List<String>> forms) {
        List<String> nameList = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            nameList.add(name);
        }
        return nameList;
    }

    public static List deduplicateName(List<List<String>> forms) {
        List<String> nameList = createNameList(forms);
        List<String> emailList = new ArrayList<>();

        for (int i = 0; i < nameList.size(); i++) {
            String name = nameList.get(i);
            int nameSize = name.length();
            String substringName;

            for (int j = 0; j < nameSize - 1; j++) {
                substringName = name.substring(j, j + 2);

                for (int k = i + 1; k < nameList.size(); k++) {
                    String email = forms.get(k).get(0);
                    String standardEmail = forms.get(i).get(0);
                    if (nameList.get(k).contains(substringName)) {
                        if (!emailList.contains(standardEmail)) {
                            emailList.add(standardEmail);
                        }
                        emailList.add(email);
                    }
                }
            }
        }
        return emailList;
    }

    public static List deduplicateAndSort(List<List<String>> forms) {
        List<String> emailList = deduplicateName(forms);
        emailList = emailList.stream().distinct().collect(Collectors.toList());
        Collections.sort(emailList);
        return emailList;
    }
}