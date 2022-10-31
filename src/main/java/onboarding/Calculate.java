package onboarding;

import java.util.List;

class Calculate {
    int num1, num2;

    public Calculate(List<Integer> name) {
        this.num1 = name.get(0);
        this.num2 = name.get(1);
    }

    int exception() {
        if((num1 < 0) || (num1 > 400) || (num2 < 0) || (num2 > 400)) { // 없는 페이지
            return -1;
        } else if(((num1 % 2) == 0) || ((num2 % 2) != 0)) { // 페이지 홀수, 짝수 판단
            return -1;
        } else if(num1 >= num2) { // 페이지 번호 확인
            return -1;
        } else if((num1 + 1) != num2) { // 페이지 번호 확인
            return -1;
        } else {
            return 0;
        }
    }

    int add() {
        int tmp1 = num1, tmp2 = num2;
        int score1 = 0, score2 = 0;

        while(tmp1 > 0) {
            score1 = score1 + (tmp1 % 10);
            tmp1 = tmp1 / 10;
        }
        while(tmp2 > 0) {
            score2 = score2 + (tmp2 % 10);
            tmp2 = tmp2 / 10;
        }

        return Math.max(score1, score2);
    }

    int multiply() {
        int tmp1 = num1, tmp2 = num2;
        int score1 = 1, score2 = 1;

        while(tmp1 > 0) {
            score1 = score1 * (tmp1 % 10);
            tmp1 = tmp1 / 10;
        }
        while(tmp2 > 0) {
            score2 = score2 * (tmp2 % 10);
            tmp2 = tmp2 / 10;
        }

        return Math.max(score1, score2);
    }

    int compare(int num1, int num2) {
        return Math.max(num1, num2);
    }
}
