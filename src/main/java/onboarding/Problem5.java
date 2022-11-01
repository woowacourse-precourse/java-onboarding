package onboarding;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) { // greed 알고리즘을 활용하여 설정함
        List<Integer> answer = new ArrayList<>();
        List<Integer> corrency = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        for (int i = 0; i < corrency.toArray().length; i++){
            int use_corrency = corrency.get(i);
            if (money % use_corrency == 0 && money / use_corrency == 0){
                answer.add(i,0);
            }
            else {
                int num_corrency = money / use_corrency;
                answer.add(i, num_corrency);
                money = money - (num_corrency * use_corrency);
            }
        }
        return answer;
    }
}
