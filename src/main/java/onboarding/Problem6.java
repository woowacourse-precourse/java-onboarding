package onboarding;

import java.util.*;

class Craw {
    private final String email;
    private final String name;

    public Craw(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}

public class Problem6 {
    private static final int EMPTY_LIST = 1;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Craw[] craws = new Craw[forms.size()];
        for (int i = 0; i < forms.size(); i++) {
            List<String> form = forms.get(i);
            craws[i] = new Craw(form.get(0), form.get(1));
        }
        Set<Craw> sets = getDuplicatedCraws(craws);
        for (Craw set : sets) {
            answer.add(set.getEmail());
        }
        Collections.sort(answer);
        return answer;
    }

    private static Set<Craw> getDuplicatedCraws(Craw[] craws) {
        Set<Craw> sets = new HashSet<>(craws.length);
        for (Craw craw : craws) {
            String crawName = craw.getName();
            addDuplicatedCraws(craws, sets, craw, crawName);
        }
        return sets;
    }

    private static void addDuplicatedCraws(Craw[] craws, Set<Craw> sets, Craw craw, String crawName) {
        if (crawName.length() == 1) {
            return;
        }
        for (int j = 1; j < crawName.toCharArray().length; j++) {
            String subString;
            subString = String.valueOf(crawName.charAt(j - 1)) + crawName.charAt(j);
            List<Craw> duplicatedCraws = findDuplicatedCrawsBySubString(craws, subString);
            if (duplicatedCraws.size() == EMPTY_LIST) {
                continue;
            }
            sets.addAll(duplicatedCraws);
        }
    }

    private static List<Craw> findDuplicatedCrawsBySubString(Craw[] craws, String subString) {
        List<Craw> duplicatedCraws = new LinkedList<>();
        for (Craw cmpCraw : craws) {
            if (!cmpCraw.getName().contains(subString)) {
                continue;
            }
            duplicatedCraws.add(cmpCraw);
        }
        return duplicatedCraws;
    }
}
