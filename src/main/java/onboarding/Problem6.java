package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        HashSet<Integer> index = new HashSet();
        List<List<String>> nickSplitArr = new ArrayList<>();

        for(int i=0; i < forms.size();i++){
            ArrayList<String> nickSplit = new ArrayList();
            String nickname = forms.get(i).get(1);
            System.out.println(nickname);
            for(int k=0; k<nickname.length()-1;k++){
                nickSplit.add(nickname.substring(k,k+2));
            }
            nickSplitArr.add(nickSplit);
        }
        System.out.println(nickSplitArr);
        return answer;
    }
}
