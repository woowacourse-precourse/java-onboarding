package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    public static class Students {
        private static final int MIN_STUDENT_SIZE = 1;
        private static final int MAX_STUDENT_SIZE = 10000;
        private List<Student> students;

        public Students(List<Student> students) {
            validStudents(students);
            this.students = students;
        }

        private void validStudents(List<Student> students) {
            if (!(students.size() >= MIN_STUDENT_SIZE && students.size() <= MAX_STUDENT_SIZE)) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }

        public List<String> getDuplicationEmails() {
            List<Student> students = this.students;
            List<String> result = new ArrayList<>();
            for (int i = 0; i < students.size() - 1; i++) {
                Student student = students.get(i);
                String nickName = student.getNickName();
                String email = student.getEmail();
                for (int j = 0; j < nickName.length() - 1; j++) {
                    String subNickname = nickName.substring(j, j+2);
                    for (int k = i+1; k < students.size(); k++) {
                        Student nowStudent = students.get(k);
                        String nowNickname = nowStudent.getNickName();
                        if (nowNickname.contains(subNickname)) {
                            result.add(email);
                            result.add(nowStudent.getEmail());
                        }
                    }
                }
            }
            return result.stream()
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());
        }
    }

    public static class Student {

        private static final int NICKNAME_POSITION = 1;

        private static final int EMAIL_POSITION = 0;
        private static final String EMAIL_CUTTER = "@";
        private static final String EMAIL_FORM = "email.com";
        private String nickName;
        private String email;

        public Student(List<String> info) {
            validNickName(info.get(NICKNAME_POSITION));
            validEmailSet(info.get(EMAIL_POSITION));
            this.nickName = info.get(NICKNAME_POSITION);
            this.email = info.get(EMAIL_POSITION);
        }

        public String getNickName() {
            return this.nickName;
        }
        public String getEmail() {
            return this.email;
        }
        private void validEmailSet(String email) {
            if (!email.contains(EMAIL_CUTTER)) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            String[] split = email.split(EMAIL_CUTTER);
            if (split.length != 2) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            if (!split[1].equals(EMAIL_FORM)) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }

        private void validNickName(String nickName) {
            if (!nickName.matches("^[가-힣]*$")) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            if (!(nickName.length() >= 1 && nickName.length() <= 20)) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
    }
    public static List<String> solution(List<List<String>> forms) {
        Students students = new Students(forms.stream()
                                                .map(form -> new Student(form))
                                                .collect(Collectors.toList()));
        return students.getDuplicationEmails();
    }
}
