package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    /*
    static List<String> subName(List<List<String>> forms){
        for(int i=0; i<forms.get(i).get(1).length(); i++){
            String substring = forms.get(i).get(1).substring(i, i+3);
        }
    }
    static findDup(List<List<String>> forms){
        for(int i=0; i<forms.size(); i++){
            for(int j=0; j<forms.get(i).get(1).length()-1; j++){
                String substring = forms.get(i).get(1).substring(j, j+2);
                if()
            }
        }
    } */
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        List<String> a = forms.get(1);
        int b = forms.size();
        List<String> c = new ArrayList<>();
        System.out.println(c);
        System.out.println(a);
        System.out.println(b);
    }
}
