package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        //List<String> answer = List.of("answer");
        ArrayList<String> answer = new ArrayList<>();

        ArrayList<ArrayList<String>> word = new ArrayList<>();

        for (List<String> form : forms) {
            ArrayList<String> word2 = new ArrayList<>();
            String nickname = form.get(1);
            for (int j = 0; j < nickname.length() - 1; j++) {
                word2.add(nickname.substring(j, j + 2));
                //word_list.add(nickname.substring(j,j+2));
            }
            word.add(word2);
        }

        for(int i=0; i<word.size(); i++){
            for(int j=0; j<word.size(); j++){
                for (String s : word.get(j)){
                    //System.out.println(s);
                    if (word.get(i).contains(s) && i!=j){
                        answer.add(forms.get(i).get(0));
                    }
                }
            }
        }
        ArrayList<String> answer2 = new ArrayList<>();

        for(String ans : answer){
            if(!answer2.contains(ans))
                answer2.add(ans);
        }
        answer2.sort(Comparator.naturalOrder());
        return answer2;
    }
}
