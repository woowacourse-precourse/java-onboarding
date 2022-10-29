package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    static List<List<String>> list;
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        list = forms;

        for(int i=0; i<forms.size(); i++) {
            String curName = forms.get(i).get(1);
            permutation(curName, i);
        }

        return answer;
    }
    public static void permutation(String name, int listIdx){
        for(int i=0; i<name.length(); i++){
            if(i+1 >= name.length()) break;
            String s = name.substring(i, i+2);
            System.out.println(s);
        }
    }
}
