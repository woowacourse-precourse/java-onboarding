package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1 {
//    public static void main(String[] args) {
//        List<Integer> pobi = List.of(111, 112);
//        List<Integer> crong = List.of(223, 224);
//        System.out.println(Problem1.solution(pobi, crong));
//    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 예외사항 확인
        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) {
            return -1;
        }

        int ScoreOfPobi = compareNums(pobi);
        int ScoreOfCrong = compareNums(crong);

        int answer = ScoreOfPobi > ScoreOfCrong ? 1 : (ScoreOfPobi < ScoreOfCrong ? 2 : 0);
        return answer;
    }

    public static int compareNums(List<Integer> person) {
        List<Integer> scores = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            int plusScore = 0;
            int multiplyScore = 1;
            int page = person.get(i);

            while (page > 0) {
                int n = page % 10;
                plusScore += n;
                multiplyScore *= n;
                page /= 10;
            }

            int highScore = Math.max(plusScore, multiplyScore);
            scores.add(highScore);
        }

        return Collections.max(scores);
    }
}