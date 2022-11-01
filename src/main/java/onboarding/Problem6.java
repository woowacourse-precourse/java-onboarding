package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
//        System.out.println(forms.get(0).get(0));
        for(int i=0;i<forms.size();++i){
//            System.out.println(forms.size());
            String curStr=forms.get(i).get(1);
            String targetStr="";
            for(int j=0;j<curStr.length();++j){
//                String partialStr=
            }
        }
        return answer;
    }
//    public static void main(String[] args){
//        List<List<String>> forms = List.of(
//                    List.of("jm@email.com", "제이엠"),
//                    List.of("jason@email.com", "제이슨"),
//                    List.of("woniee@email.com", "워니"),
//                    List.of("mj@email.com", "엠제이"),
//                    List.of("nowm@email.com", "이제엠")
//            );
//        List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
//        Problem6.solution(forms);
////        System.out.println(answer1.get(0));
//    }
}
