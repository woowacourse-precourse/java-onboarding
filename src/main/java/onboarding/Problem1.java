package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        System.out.println(maxScore(pobi));
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    // 점수 최고점 구하기
    private static int maxScore(List<Integer> pageList){
        List<Integer> scoreList = new ArrayList<>();
        for (Integer page : pageList) {
            int[] splitPage = splitNum(page);
            scoreList.add(sumSplitNum(splitPage));
            scoreList.add(multipleSplitNum(splitPage));
        }
        return scoreList.stream().max(Comparator.comparing(x -> x)).get();
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