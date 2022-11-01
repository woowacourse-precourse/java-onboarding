package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Student {

    String Email;
    String NickName;

    Student(String Email, String NickName) {
        this.Email = Email;
        this.NickName = NickName;
    }
}

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<Student> students = initStudents(forms);
        Set<String> overlapNickNames = new HashSet<>();

        return sortAnswer(overlapNickNames);
    }

    static List<Student> initStudents(List<List<String>> forms) {
        List<Student> students = new ArrayList<>();

        for (List<String> list : forms) {
            students.add(new Student(list.get(0), list.get(1)));
        }

        return students;
    }

    static List<String> sortAnswer(Set<String> set) {
        List<String> answer = new ArrayList<>(set);
        Collections.sort(answer);

        return answer;
    }
}
