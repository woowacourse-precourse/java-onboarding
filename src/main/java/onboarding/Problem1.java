package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    static class Game {
        private List<Score> participantList = new ArrayList<>();
        private boolean errorFlag = false;

        void addParticipant(List<Integer> person) {
            try {
                participantList.add(new Score(person));
            } catch(RuntimeException e){
                errorFlag = true;
            }
        }

        int findWinner() {
            if(errorFlag){
                return -1;
            }
            int winner = 0;
            int tmpMax = 0;
            int limit = participantList.size();

            for(int i=0 ; i<limit ; i++) {
                Score tmpScore = participantList.get(i);
                if(tmpScore.maxValue > tmpMax) {
                    winner += i+1;
                    tmpMax = tmpScore.maxValue;
                }
            }

            return (winner>limit) ? 0 : winner;
        }
    }


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
        private final int NECESSARY_INPUT_PAGE_SIZE =2;
        private final int MIN_PAGE_INPUT_VALUE = 1;
        private final int MAX_PAGE_INPUT_VALUE =400;

        private List<Integer> page;

        public Page(List<Integer> page) {
            if(page.size() != NECESSARY_INPUT_PAGE_SIZE) {
                throw new RuntimeException("페이지는 두 개의 값을 입력해야 합니다.");
            }
            if(page.get(0)<=MIN_PAGE_INPUT_VALUE || page.get(1)>=MAX_PAGE_INPUT_VALUE) {
                throw new RuntimeException("입력 가능한 페이지 범위를 초과하였습니다.");
            }
            if(page.get(1)-page.get(0) != 1) {
                throw new RuntimeException("잘못된 페이지 값을 입력하였습니다.");
            }
            if(page.get(0)%2==0 || page.get(1)%2==1) {
                throw new RuntimeException("잘못된 페이지 값을 입력하였습니다.");
            }
            this.page = page;
        }

        int get(int idx) {
            return page.get(idx);
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Game game = new Game();
        game.addParticipant(pobi);      // 순서 변경 불가능
        game.addParticipant(crong);
        return game.findWinner();
    }
}