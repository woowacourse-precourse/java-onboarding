package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = new ArrayList<>();

        TreeSet<String> nameDictionary = new TreeSet<>();

        nameDictionary = makeNameDictionary(forms);

        for (int i = 0; i < forms.size(); i++) {
            if (checkNameDictionary(forms.get(i), nameDictionary)) {
                answer.add(forms.get(i).get(0));
            }
        }
        Collections.sort(answer);
        return answer;
    }

    public static TreeSet<String> makeNameDictionary(List<List<String>> forms) {
        List<String> nameDictionaryDuplicates = new ArrayList<>();
        TreeSet<String> nameDictionary = new TreeSet<>();

        for (int i = 0; i < forms.size(); i++) {
            for (int j = 0; j < forms.get(i).get(1).length() - 1; j++) {
                nameDictionaryDuplicates.add(forms.get(i).get(1).substring(j, j + 2));
            }
        }

        for (String name : nameDictionaryDuplicates) {
            if (nameDictionaryDuplicates.indexOf(name)
                    != nameDictionaryDuplicates.lastIndexOf(name)) {
                nameDictionary.add(name);
            }
        }

        return nameDictionary;
    }

    public static boolean checkNameDictionary(List<String> forms, TreeSet<String> nameDictionary) {
        for (int j = 0; j < forms.get(1).length() - 1; j++) {
            if (nameDictionary.contains(forms.get(1).substring(j, j + 2))) {
                return true;
            }
        }
        return false;
    }
}
