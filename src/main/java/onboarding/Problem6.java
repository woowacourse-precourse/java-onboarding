package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        return findAllEmailsWithSimilarName(forms);
    }

    private static List<String> findAllEmailsWithSimilarName(List<List<String>> forms) {
        List<String> output = new ArrayList<>();
        List<String> emailsWithSimilarName;
        for(int i = 0; i < forms.size(); i++) {
            String curEmail = forms.get(i).get(0);
            String curName = forms.get(i).get(1);
            List<List<String>> followingForms = forms.subList(i + 1, forms.size());

            emailsWithSimilarName = findEmailsWithSimilarName(curName, followingForms);
            if(emailsWithSimilarName.size() != 0) {
                output.add(curEmail);
            }

            output.addAll(emailsWithSimilarName);
        }

        output = sortAndDistinctList(output);
        return output;
    }

    private static List<String> findEmailsWithSimilarName(String name, List<List<String>> forms) {
        List<String> output = new ArrayList<>();
        for (List<String> form : forms) {
            if (isSimilarName(name, form.get(1))) {
                output.add(form.get(0));
            }
        }
        return output;
    }

    private static boolean isSimilarName(String name1, String name2) {
        for(int i = 0; i < name1.length() - 1; i++) {
            for(int j = 0; j < name2.length() - 1; j++) {
                if(name1.charAt(i) == name2.charAt(j) && name1.charAt(i+1) == name2.charAt(j+1))
                    return true;
            }
        }
        return false;
    }

    private static List<String> sortAndDistinctList(List<String> list) {
        list.sort(new EmailComparator());
        return list.stream().distinct().collect(Collectors.toList());
    }

    private static class EmailComparator implements Comparator<String> {
        @Override
        public int compare(String email1, String email2) {
            email1 = email1.substring(0, email1.length() - 10);
            email2 = email2.substring(0, email2.length() - 10);

            return email1.compareTo(email2);
        }
    }
}
