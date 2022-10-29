package onboarding;

import java.util.*;

public class Problem6 {

    static class Student implements Comparable<Student> {
        String email;
        int idx;

        public Student(String email, int idx) {
            this.email = email;
            this.idx = idx;
        }

        @Override
        public int compareTo(Student o) {
            return this.email.compareTo(o.email);
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        int size = forms.size();
        Set<Integer> indexSet = new HashSet<>();

        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                String nicknameOne = forms.get(i).get(1);
                String nicknameTwo = forms.get(j).get(1);

                if (!validateDuplication(nicknameOne, nicknameTwo)) {
                    indexSet.add(i);
                    indexSet.add(j);
                }
            }
        }

        List<Student> duplicateStudentList = new ArrayList<>();

        for (int idx: indexSet) {
            String email = forms.get(idx).get(0);
            int splitIdx = email.indexOf('@');
            email = email.substring(0, splitIdx);

            duplicateStudentList.add(new Student(email, idx));
        }

        Collections.sort(duplicateStudentList);



        return answer;
    }

    public static boolean validateDuplication(String nicknameOne, String nicknameTwo) {
        for (int i = 0; i < nicknameOne.length() - 1; i++) {
            String twoWords = nicknameOne.substring(i, i+2);

            if (nicknameTwo.contains(twoWords))
                return false;
        }

        return true;
    }
}
