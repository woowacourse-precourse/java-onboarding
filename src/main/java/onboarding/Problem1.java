package onboarding;

import java.util.List;

/**
 * 기능 요구사항
 * 1. 한 페이지를 담당하는 클래스를 작성한다.
 * 2. 클래스 내부의 메서드를 통해서 큰 수를 구한다.
 * 3. pobi의 큰 수와 crong의 큰 수를 비교해서 1, 0, -1을 리턴한다.
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        Page pobiPage = new Page(pobi.get(1));
        Page crongPage = new Page(crong.get(1));

        int pobiMaxNum = pobiPage.getMaxNum();
        int crongMaxNum = crongPage.getMaxNum();

        answer = winOrLose(pobiMaxNum, crongMaxNum);

        return answer;
    }

    public static int winOrLose(int pobiMaxNum, int crongMaxNum){
        return pobiMaxNum == crongMaxNum ? 0 : pobiMaxNum > crongMaxNum ? 1 : -1;
    }
}
class Page{
    private final char[] numberOfPages;
    public Page(int page){
        this.numberOfPages = String.valueOf(page).toCharArray();
    }

    public int getMaxNum(){
        int sum = 1, mul = 1;
        for(char c : numberOfPages){
            sum += (c - 48);
            mul *= (c - 48);
        }
        return Math.max(sum, mul);
    }

}