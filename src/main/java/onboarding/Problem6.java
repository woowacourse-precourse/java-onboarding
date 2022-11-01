package onboarding;

import java.util.ArrayList;
import java.util.List;

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
        List<String> answer = List.of("answer");
        return answer;
    }

    static List<Student> initStudents(List<List<String>> forms) {
        List<Student> students = new ArrayList<>();

        for (List<String> list : forms) {
            students.add(new Student(list.get(0), list.get(1)));
        }

        return students;
    }
}
