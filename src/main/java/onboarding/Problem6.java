package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    private static Map<String, String> sequenceNamesMap = new HashMap<>();
    private static Set<String> reportEmailsSet = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {

        for (int i = 0; i < forms.size(); i++) {
            List<String> crew = forms.get(i);
            addSequenceName(crew);
        }

        List<String> answer = getSortList();
        return answer;
    }

    private static void addSequenceName(List<String> crew) {

        String email = crew.get(0);
        String name = crew.get(1);
        for (int i = 1; i < name.length(); i++) {
            String sequenceName = name.substring(i - 1, i + 1);

            if (isDuplicateName(sequenceName)) {
                String reportEmail = sequenceNamesMap.get(sequenceName);
                addReportEmails(reportEmail, email);
            }

            sequenceNamesMap.put(sequenceName, email);
        }

    }

    private static boolean isDuplicateName(String sequenceName) {

        if (sequenceNamesMap.get(sequenceName) == null) {
            return false;
        } else {
            return true;
        }

    }

    private static void addReportEmails(String reportEmail1, String reportEmail2) {

        if (isNotSameEmail(reportEmail1, reportEmail2)) {
            reportEmailsSet.add(reportEmail1);
            reportEmailsSet.add(reportEmail2);
        }

    }

    private static boolean isNotSameEmail(String reportEmail1, String reportEmail2) {

        if (reportEmail1.equals(reportEmail2)) {
            return false;
        } else {
            return true;
        }

    }

    private static List<String> getSortList() {
        return reportEmailsSet.stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }

}
