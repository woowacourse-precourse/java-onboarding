package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;

        // 둘중 하나라도 값이 이상하다면 예외(-1) 반환
        if (isInvalid(pobi) || isInvalid(crong))
            return answer;

        int pobiScore = score(pobi);
        int crongScore = score(crong);

        if (pobiScore > crongScore)
            answer = 1;
        else if (crongScore > pobiScore)
            answer = 2;
        else
            answer = 0;

        return answer;
    }

    public static int score(List<Integer> pages){
        int sum = 0;
        int product = 1;
        for (Integer page: pages){
            while (page > 0){
                sum += page % 10;
                product *= page % 10;
                page /= 10;
            }
        }
        return Math.max(sum, product);
    }

    public static boolean isInvalid(List<Integer> pages){
        // 페이지가 시작 면이거나 마지막 면일 경우, 예외
        if(pages.get(0) == 1 || pages.get(0) == 399)
            return true;

        // 페이지가 2개 이상 들어오면 예외
        if (pages.size() != 2)
                return true;

        // 연속된 페이지가 아닌 경우 예외
        if ((pages.get(1) - pages.get(0)) != 1)
            return true;

        // 왼쪽이 홀수가 아니거나 오른쪽이 짝수가 아닌 경우 예외
        if (pages.get(0) % 2 != 1)
            return true;
        else if (pages.get(1) % 2 != 0)
            return true;

        // 페이지의 범위(1~400페이지)를 나가면 예외
        for (int page: pages){
            if (page > 400 || page < 1)
                return true;
        }

        return false;
    }
}