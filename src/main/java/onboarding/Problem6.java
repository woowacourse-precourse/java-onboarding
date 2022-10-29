package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        permutation(0,2,0, forms.get(0).get(1),"");
        return answer;
    }
    public static void permutation(int depth, int n, int idx, String name, String s){
        if(depth == n){
            System.out.println(s);
        }
        for(int i=idx; i<name.length(); i++){
            permutation(depth+1, n, i+1, name, s+name.charAt(i));
        }
    }
}
