package onboarding;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        if (isPageException(pobi) || isPageException(crong)) return -1;

        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        if (pobiScore > crongScore) answer = 1;
        if (pobiScore < crongScore) answer = 2;

        return answer;
    }

    static int addPageNum(Integer pageNum){
        int result = 0;
        String pageStr = pageNum.toString();
        for(String numToken : pageStr.split("")){
            result += Integer.parseInt(numToken);
        }

        return result;
    }

    static int mulPageNum(Integer pageNum){
        int result = 1;
        String pageStr = pageNum.toString();
        for(String numToken : pageStr.split("")){
            result *= Integer.parseInt(numToken);
        }

        return result;
    }

    static int getScore(List<Integer> pageNums){
        // TODO: . 을 줄이는 방향으로 리팩토링
        Stream<Integer> pageStream = pageNums.stream();
        IntStream pageResult = pageStream.mapToInt(p -> Integer.max(addPageNum(p), mulPageNum(p)));
        return pageResult.max().getAsInt();
    }

    static boolean isPageException(List<Integer> pageNums){
        int left = pageNums.get(0);
        int right = pageNums.get(1);

        return ! ((1 < left && left % 2 == 1) && (right < 400 && right % 2 == 0)
                && (left + 1 == right));
    }
}