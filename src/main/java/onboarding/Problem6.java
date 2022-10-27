package onboarding;


import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Students studentList = new Students(forms);
        List<String> answer = List.of("anms");
//        List<String> answer = studentList.getEmail();
        System.out.println(studentList.getStudentList());
        return answer;
    }


    }

    class Students {
        private List<Student> studentList = new ArrayList<>();

        public Students(List<List<String>> forms) {
            for (List list : forms) {
                this.studentList.add(new Student(String.valueOf(list.get(0)), String.valueOf(list.get(1))));
            }
        }

        public List<Student> getStudentList() {
            return studentList;
        }

//        public List<String> getEmail() {
//            for(Student s : studentList){
//
//        }
    }

    class Student{
        String email;
        String nickName;


        public Student(String email,String nickName){
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

