package onboarding;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Students studentList = new Students(forms);

        return studentList.getEmail();
    }


}

class Students {
    private List<Student> studentList = new ArrayList<>();

    public Students(List<List<String>> forms) {
        for (List list : forms) {
            this.studentList.add(new Student(String.valueOf(list.get(0)), String.valueOf(list.get(1))));
        }
    }
    public List<String> getEmail() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < this.studentList.size(); i++) {
            String nickname = "";
            String[] arr = studentList.get(i).getNickName().split("");
            System.out.println(Arrays.toString(arr));
            for (int j = 1; j < arr.length; j++) {
                nickname = arr[j - 1] + arr[j];
                System.out.println("현제 검사할 닉네임 : " + nickname);
                for (Student s : studentList) {
                    if (s.getNickName().contains(nickname)) {
                        System.out.println("검열된 닉네임 : " + s.getNickName());
                        System.out.println("검열된 이메일 : " + s.getEmail());
                        if (studentList.get(i).getNickName().equals(s.nickName)) {
                            continue;
                        }
                        list.add(s.getEmail());
                    }
                }

            }
        }


        return list.stream().distinct().sorted().collect(Collectors.toList());
    }
}

class Student {
    String email;
    String nickName;


    public Student(String email, String nickName) {
        this.email = email;
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public String getNickName() {
        return nickName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "email='" + email + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

