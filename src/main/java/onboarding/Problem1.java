package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = whoIsWinner(pobi, crong);
        return answer;
    }

    private static int getSum(int[] pageNumber) {
        int result = 0;
        for (int number : pageNumber) {
            result += number;
        }
        return result;
    }

    private static int getMulti(int[] pageNumber) {
        int result = 1;
        for (int number : pageNumber) {
            result *= number;
        }
        return result;
    }

    private static int getPageScore(int sidePageNumber) {
        int[] pageNumber = Stream.of(String.valueOf(sidePageNumber).split("")).mapToInt(Integer::parseInt).toArray();
        int sumValue = getSum(pageNumber);
        int multiValue = getMulti(pageNumber);
        return multiValue == 0 ? -1 : sumValue > multiValue ? sumValue : multiValue;
    }

    private static int whoIsWinner(List<Integer> pobi, List<Integer> crong) {
        List<Integer> pobiPageScores = new ArrayList<>();
        pobiPageScores.add(getPageScore(pobi.get(0)));
        pobiPageScores.add(getPageScore(pobi.get(1))); 

        List<Integer> crongPageScores = new ArrayList<>();
        crongPageScores.add(getPageScore(crong.get(0)));
        crongPageScores.add(getPageScore(crong.get(1))); 

        if(pobiPageScores.contains(-1) || crongPageScores.contains(-1)) {
            return -1;
        }

        int pobiScore = (pobiPageScores.get(0) > pobiPageScores.get(1)) ? pobiPageScores.get(0) : pobiPageScores.get(1);
        int crongScore = (crongPageScores.get(0) > crongPageScores.get(1)) ? crongPageScores.get(0) : crongPageScores.get(1);

        return (pobiScore > crongScore) ? 1 : (pobiScore == crongScore) ? 0 : 2;
    }
}