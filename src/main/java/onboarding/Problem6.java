package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
    private static final Map<String, Set<String>> INFO_FOR_STUDENTS = new HashMap<String, Set<String>>();
    private static final Set<String> DUPLICATE_STUDENTS = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {
        for (List<String> info : forms) {
            saveInfoForStudent(info);
        }
        findDuplicateStudents();
        return getAnswer();
    }

    private static void saveInfoForStudent(List<String> info) {
        String email = info.get(0);
        String name = info.get(1);
        for (int i = 0; i < name.length() - 1; i++) {
            String partOfName = name.substring(i, i + 2);
            if (!INFO_FOR_STUDENTS.containsKey(partOfName)) {
                Set<String> studentEmails = new HashSet<String>();
                studentEmails.add(email);
                INFO_FOR_STUDENTS.put(partOfName, studentEmails);
                continue;
            }
            INFO_FOR_STUDENTS.get(partOfName).add(email);
        }
    }

    private static void findDuplicateStudents() {
        for (Set<String> studentEmails : INFO_FOR_STUDENTS.values()) {
            if (studentEmails.size() >= 2) {
                DUPLICATE_STUDENTS.addAll(studentEmails);
            }
        }
    }

    private static List<String> getAnswer() {
        ArrayList<String> answer = new ArrayList<>(DUPLICATE_STUDENTS);
        Collections.sort(answer);
        return answer;
    }
}