package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> duplicatedWord = findDuplicatedWord(forms);
        List<String> duplicatedCrew = getDuplicatedCrew(duplicatedWord, forms);
        return duplicatedCrew;
    }

    static void checkForm(List<String> form) {
        boolean isError = false;
        String email = form.get(0);
        String name = form.get(1);

        if (nameError(name))
            isError = true;
        if (emailError(email))
            isError = true;

        try {
            if (isError == true) throw new Exception();
        } catch (Exception e) {
            System.out.println("Incorrect name and email. Check your form");
            System.out.println("your form = " + form);
        }
    }

    static List<String> findDuplicatedWord(List<List<String>> forms) {
        Map<String, Integer> map = new HashMap<>();
        List<String> duplicatedWord = new ArrayList<>();

        for (List<String> form : forms) {
            checkForm(form);
            String crewName = form.get(1);
            for (int j = 0; j < crewName.length() - 1; j++) {
                String subName = crewName.substring(j, j + 2);
                map.put(subName, map.getOrDefault(subName, 0) + 1);
            }
        }

        for (String s : map.keySet()) {
            if (map.get(s) > 1)
                duplicatedWord.add(s);
        }
        return duplicatedWord;
    }

    static List<String> getDuplicatedCrew(List<String> duplicatedWord, List<List<String>> forms) {
        Set<String> emailList = new HashSet<>();

        for (String s : duplicatedWord) {
            for (int i = 0; i < forms.size(); i++) {
                if (forms.get(i).get(1).contains(s))
                    emailList.add(forms.get(i).get(0));
            }
        }
        Collections.sort(new ArrayList<String>(emailList));

        return new ArrayList<>(emailList);
    }

    private static boolean emailError(String email) {
        return !(email.matches("^[a-zA-Z0-9]+@email.com$") && (email.length() > 10 && email.length() < 20));
    }

    private static boolean nameError(String name) {
        return !(name.matches("^[가-힣]*$") && (name.length() > 0 && name.length() < 20));
    }
}
