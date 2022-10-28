package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
    private static final Map<String, Set<String>> studentsInfo = new HashMap<String, Set<String>>();
    private static final Set<String> DUPLICATED_STUDENTS = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {
        for (List<String> info : forms) {
            saveStudentsInfo(info);
        }
        findDuplicatedStudents();
        List<String> answer = List.of("answer");
        return answer;
    }

    private static void saveStudentsInfo(List<String> info) {
        String emailId = getEmailId(info.get(0));
        String name = info.get(1);

        for (int i = 0; i < name.length() - 1; i++) {
            String partOfName = name.substring(i, i + 2);
            if (!studentsInfo.containsKey(partOfName)) {
                Set<String> emailIds = new HashSet<String>();
                emailIds.add(emailId);
                studentsInfo.put(partOfName, emailIds);
                continue;
            }
            studentsInfo.get(partOfName).add(emailId);
        }
    }

    private static String getEmailId(String email) {
        int idx = email.indexOf("@");
        return email.substring(0, idx);
    }

    private static void findDuplicatedStudents() {
        for (Set<String> emailIds : studentsInfo.values()) {
            if (emailIds.size() >= 2) {
                DUPLICATED_STUDENTS.addAll(emailIds);
            }
        }
    }
}
