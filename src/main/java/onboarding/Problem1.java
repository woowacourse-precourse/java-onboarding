package onboarding;

import java.util.List;
import java.util.Map;

class Problem1 {

    private static final int firstPageNumber = 0;
    private static final int lastPageNumber = 401;

    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    private static final Map<String, Integer> scoreMenu =
            Map.of("pobi", 1, "crong", 2, "draw", 0, "exception", -1);

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        // 1. [예외처리] 페이지 번호 입력

        // 시작면(0) 또는 마지막면(401) 입력한 경우
        if (isOutRange(pobi) || isOutRange(crong))
            return scoreMenu.get("exception");

        // 왼쪽페이지가 홀수가 아닌 경우
        if (!isOddNumber(pobi.get(LEFT)) || !isOddNumber(crong.get(LEFT)))
            return scoreMenu.get("exception");

        // 오른쪽페이지가 짝수가 아닌 경우
        if (!isEvenNumber(pobi.get(RIGHT)) || !isEvenNumber(crong.get(RIGHT)))
            return scoreMenu.get("exception");


        int answer = Integer.MAX_VALUE;
        return answer;
    }

    // 책의 시작 면이나 마지막 면이 있는지 확인하는 메서드
    public static boolean isOutRange(List<Integer> pageList) {
        return pageList.contains(firstPageNumber) || pageList.contains(lastPageNumber);
    }

    // 홀수인지 확인하는 메서드
    public static boolean isOddNumber(int number) {
        return number%2!=0;
    }

    // 짝수인지 확인하는 메서드
    public static boolean isEvenNumber(int number) {
        return number%2==0;
    }


}