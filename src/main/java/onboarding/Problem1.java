package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        try {
            int pobiScore = maxScore(pobi);
            int crongScore = maxScore(crong);
            answer = compareScore(pobiScore, crongScore);
        } catch (Exception e) {
            answer = -1;
        }
        return answer;
    }

    // 점수 최고점 구하기
    private static int maxScore(List<Integer> pageList) throws Exception {
        // 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수만이 올 수 있다.
        if (pageList.get(0) % 2 == 0 ) {
            throw new Exception("왼쪽 페이지는 홀수만 올 수 있다..");
        } else if (pageList.get(1) % 2 == 1) {
            throw new Exception("오른쪽 페이지는 짝수만 올 수 있다.");
        } else if (pageList.get(1) - pageList.get(0) != 1) {
            throw new Exception("페이지의 차이는 1이 되어야 한다.");
        }

        List<Integer> scoreList = new ArrayList<>();
        for (Integer page : pageList) {
            if (page < 0 || page > 400) {
                throw new Exception("페이지의 1~399의 범위만 올 수 있다.");
            }
            int[] splitPage = splitNum(page);
            scoreList.add(sumSplitNum(splitPage));
            scoreList.add(multipleSplitNum(splitPage));
        }
        return scoreList.stream().max(Comparator.comparing(x -> x)).get();
    }

    // 점수 비교하기
    // pobi가 승리하면 1, crong이 승리하면 2, 무승부 0, 예외 -1
    private static int compareScore(int pobiScore, int crongScore) {
        int result;
        if (pobiScore > crongScore) {
            result = 1;
        } else if (pobiScore < crongScore) {
            result = 2;
        } else {
            result = 0;
        }
        return result;
    }
    private static int[] splitNum(Integer num) {
        return Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
    }
    private static int sumSplitNum(int[] splitNum){
        return Arrays.stream(splitNum).sum();
    }

    private static int multipleSplitNum(int[] splitNum){
        return Arrays.stream(splitNum).reduce((a, b) -> a * b).getAsInt();
    }



}