package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        List<Character> answer_list = new ArrayList<>();
        for (int i = 0; i < answer.length(); i++) {
            answer_list.add(answer.charAt(i));
        }
        int count = 0;

        do {
            count = 0;
            Set<Integer> index_set = new HashSet<>();
            List<Integer> index_list = new ArrayList<>();
            for(int i = 0; i < answer_list.size()-1; i++){
                if (answer_list.get(i) == answer_list.get(i+1)){
                    index_set.add(i);
                    index_set.add(i+1);
                    count += 1;
                } // if - 앞뒤문자비교
            }//for
            List<Character> answer_list2 = new ArrayList<>();
            for (int i = 0; i < answer_list.size(); i++) {
                if (index_set.contains(i)) {
                    continue;
                }
                answer_list2.add(answer_list.get(i));
            }
            answer_list = new ArrayList<>(answer_list2);
        } while(count != 0);

        answer = "";
        for (int i = 0; i < answer_list.size(); i++) {
            answer += answer_list.get(i);
        }//for

        return answer;
    }
}
