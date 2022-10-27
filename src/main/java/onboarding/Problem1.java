package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Game game_pobi = new Game(pobi);
        Game game_crong = new Game(crong);
        int pobi_score = game_pobi.getResult();
        int crong_score = game_crong.getResult();

        if (pobi_score == -1 | crong_score == -1) {
            return -1;
        }
        else if (pobi_score > crong_score) {
            return 1;
        }
        else if (pobi_score < crong_score) {
            return 2;
        }
        else {return 0;}
    }
}


class Calculator {
    List<Integer> pages;

    Calculator(List<Integer> pages) {
        this.pages = pages;
    }

    int returnScore(){
        int page1_score = getScore(pages.get(0));
        int page2_score = getScore(pages.get(1));
        return Integer.max(page1_score, page2_score);
    }
    int getScore(int page) {
        int max_page = Integer.max(getSum(page), getMulti(page));
        return max_page;
    }

    int getSum(int page) {
        int sum = 0;
        while (page>0) {
            int q = page/10;
            int r = page%10;
            sum += r;
            page = q;
        }
        return sum;
    }

    int getMulti(int page) {
        int multi = 1;
        while (page>0) {
            int q = page/10;
            int r = page%10;
            multi *= r;
            page = q;
        }
        return multi;
    }
}

class Game {
    List<Integer> pages;

    Game(List<Integer> pages) {
        this.pages = pages;
    }

    private boolean validate() {
        int page1 = pages.get(0);
        int page2 = pages.get(1);

        // 시작 면이나 마지막 면이 나오도록 책을 펼치는 경우
        if (page1 == 1 | page2 == 400) {
            return false;
        }
        // [왼쪽 페이지 번호, 오른쪽 페이지 번호]가 오류가 있는 경우
        else if (page2 != page1 + 1) {
            return false;
        }
        // 왼쪽 페이지가 홀수가 아니거나, 오른쪽 페이지가 짝수가 아닌 경우
        else if (page1 % 2 != 1 | page2 % 2 != 0) {
            return false;
        }
        else {return true;}
    }

    int getResult() {
        // validate()이 true일 때만 Calculator 클래스로 계산
        if (validate()) {
            Calculator cal = new Calculator(pages);
            int result = cal.returnScore();
            return result;
        }
        // validate()이 false일 때 -1 반환
        else {
            return -1;
        }
    }
}
