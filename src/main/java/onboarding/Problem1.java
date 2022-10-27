package onboarding;

import java.util.List;

class Problem1 {

    static class Page {
        private List<Integer> page;

        public Page(List<Integer> page) {
            if(page.size()!=2) {
                throw new RuntimeException("페이지는 두 개의 값을 입력해야 합니다.");
            }
            if(page.get(0)<=1||page.get(1)>=400) {
                throw new RuntimeException("입력 가능한 페이지 범위를 초과하였습니다.");
            }
            if(page.get(1)-page.get(0)!=1) {
                throw new RuntimeException("잘못된 페이지 값을 입력하였습니다.");
            }
            if(page.get(0)%2==0||page.get(1)%2==1) {
                throw new RuntimeException("잘못된 페이지 값을 입력하였습니다.");
            }
            this.page = page;
        }

        int get(int idx) {
            return page.get(idx);
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}