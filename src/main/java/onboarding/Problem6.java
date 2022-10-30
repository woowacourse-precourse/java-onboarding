package onboarding;

import java.util.*;

public class Problem6 {
    final static int EMAIL = 0;
    final static int NAME = 1;
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, Integer> twoNameCount = new HashMap<>();
        HashSet<String> duplicateEmails = new HashSet<>();

        for (List<String> form : forms) {
            HashSet<String> combinations = getCombinations(form.get(NAME));
            for (String combination : combinations) {
                twoNameCount.put(combination, twoNameCount.getOrDefault(combination, 0) + 1);
            }
        }

        for (String twoName : twoNameCount.keySet()) {
            if (twoNameCount.get(twoName)>1) {
                duplicateEmails.addAll(getDuplicateList(twoName, forms));
            }
        }

        ArrayList<String> answer = new ArrayList<>(duplicateEmails);
        Collections.sort(answer, new EmailCompare());
        return answer;
    }

    private static List<String> getDuplicateList(String twoName, List<List<String>> forms) {
        List<String> duplicateEmails = new ArrayList<>();
        for (List<String> form : forms) {
            if (form.get(NAME).contains(twoName)) {
                duplicateEmails.add(form.get(EMAIL));
            }
        }
        return duplicateEmails;
    }

    private static HashSet<String> getCombinations(String name) {
        HashSet<String> combinations = new HashSet<>();

        for (int i=0; i<name.length()-1; i++) {
            combinations.add(name.substring(i, i+2));
        }
        return combinations;
    }
}
class EmailCompare implements Comparator<String> {
    final int EMAIL_DOMAIN_LENGTH = 10;
    @Override
    public int compare(String email1, String email2) {
        String subEmail1 = email1.substring(0, email1.length()-EMAIL_DOMAIN_LENGTH);
        String subEmail2 = email2.substring(0, email2.length()-EMAIL_DOMAIN_LENGTH);
        return subEmail1.compareTo(subEmail2);
    }
}