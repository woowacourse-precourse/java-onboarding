package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    static final int LEFT = 0, RIGHT = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;

        try{
            PageList pobiPage = new PageList(pobi);
            PageList crongPage = new PageList(crong);

            int pobiScore = pobiPage.calcMaxScore();
            int crongScore = crongPage.calcMaxScore();

            if(pobiScore > crongScore){
                answer = 1;
            }else if(pobiScore < crongScore){
                answer = 2;
            }else{
                answer = 0;
            }

        }catch (IllegalArgumentException illegalArgumentException){}

        return answer;
    }

    // 일급 컬렉션
    static class PageList{
        private static final int FIXED_PAGELIST_LENGTH = 2;
        private final List<Integer> pageList;

        public PageList(List<Integer> pageList){
            validatePageLength(pageList);
            validatePageDiff(pageList);

            this.pageList = pageList;
        }

        public void validatePageLength(List<Integer> pageList){
            if(pageList.size() != FIXED_PAGELIST_LENGTH){
                throw new IllegalArgumentException("페이지 리스트의 길이는 2입니다.");
            }
        }

        public void validatePageDiff(List<Integer> pageList){
            if(pageList.get(RIGHT) - pageList.get(LEFT) != 1){
                throw new IllegalArgumentException("오른쪽 페이지가 왼쪽 페이지보다 1 커야 합니다.");
            }
        }

        public int calcMaxScore(){
            List<Integer> scoreList = new ArrayList<>();

            for(int i = 0; i <= 1; i++) {

                int page = pageList.get(i);

                int sumScore = 0;
                int mulScore = 1;

                for (int j = 100; j > 0; j /= 10) {
                    if (j > page) {
                        continue;
                    }
                    sumScore += page / j;
                    mulScore *= page / j;

                    page %= j;
                }

                scoreList.add(sumScore);
                scoreList.add(mulScore);
            }

            return Collections.max(scoreList);
        }
    }
}