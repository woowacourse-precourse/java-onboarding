package onboarding;
import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        /*
            List<Integer> ans =  Collections.emptyList(); 를 아무리
            편집하려 해봤자 안되니까 위 문장처럼 바꿔주도록 하자.
        * */
        int[] arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int i=0; i<9; i++){
            int term = money / arr[i];
            answer.add(term);
            money %= arr[i];
        }
        return answer;
    }
}
