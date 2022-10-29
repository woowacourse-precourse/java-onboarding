package onboarding;

import java.util.List;
import java.util.Random;
//임의로 책 펼치는 기능
//페이지번호를 더하거나 곱해서 높은걸로 반환하는 기능
//포비가 이기면 1  크롱이 이기면 2 무승부 0 예외 -1리턴
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    public static int RandomPage(int pagemax){
        Random random = new Random();
        int page= random.nextInt(pagemax)+1;
        return page;
    }
}