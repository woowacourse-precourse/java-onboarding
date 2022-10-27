package onboarding;

import java.util.List;

class Problem1 {

    static class Score {
        private Page page;
        private int maxValue;

        private void findMaxValue() {
            int tmp=0;
            for(int i=0 ; i<2 ; i++){
                tmp = Math.max(tmp, sumOfEachNum(i));
                tmp = Math.max(tmp, productOfEachNum(i));
            }
            this.maxValue = tmp;
        }

        private int sumOfEachNum(int idx) {      // 0: 왼쪽페이지 | 1: 오른쪽 페이지
            String num = String.valueOf(page.get(idx));
            int tmp=0;
            for(int i=0 ; i<num.length() ; i++){
                tmp+=num.charAt(i)-'0';
            }
            return tmp;
        }
        private int productOfEachNum(int idx) {
            String num = String.valueOf(page.get(idx));
            int tmp=0;
            for(int i=0 ; i<num.length() ; i++){
                tmp*=num.charAt(i)-'0';
            }
            return tmp;
        }

        public Score(List<Integer> page) {
            this.page = new Page(page);
            findMaxValue();
        }
    }

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