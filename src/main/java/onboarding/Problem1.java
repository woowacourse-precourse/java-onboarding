package onboarding;

import java.util.List;

// 책을 임의로 펼친다.                                                              두 페이지의 값을 저장
// 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.      페이지의 모든 자리 수를 더하거나
// 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.    곱하는 함수 구현
// 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.                                      두 수의 비교를 통해 큰 수를 구함
// 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.                                   두 사람의 큰 수를 비교
// 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.                                 예외처리

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        
        int pobi_score = get_score(pobi);
        int crong_score = get_score(crong);

        answer = who_wins(pobi_score, crong_score);

        return answer;
    }

    public static int who_wins(int x, int y) {
        if(x < 0 || y < 0)
            return -1;
        if(x == y)
            return 0;
        if(x > y)
            return 1;
        if(x < y)
            return 2;
        return -1;
    }


    public static int get_score(List<Integer> pages){
        if (pages.size() < 0 || pages.size() > 2)
            return -1;
        int left = pages.get(0);
        int right = pages.get(1);

        if(left%2 !=1 || right%2 != 0)
            return -1;
        if (right - left != 1)
            return -1;
        if(left == 1||right ==400)
            return -1;

        int left_score = get_pageScore(left);
        int right_score = get_pageScore(right);

        return left_score >= right_score ? left_score : right_score;
    }

    public static int get_pageScore(int num){
        int hen = 0;

        if (num >= 100){
            hen = num /100;
            num = num -hen*100;
        }
        
        int ten = num / 10;
        int one = num % 10;

        return get_biggest(one, ten, hen);
    }

    public static int get_biggest(int one, int ten, int hen){

        int sum = 0;
        int pro = 0;
        sum = one + ten + hen;

        if(hen != 0 && ten != 0)
            pro = one * ten * hen;
        else if(hen == 0 && ten != 0)
            pro = one * ten;
        else if(hen == 0 && ten == 0)
            pro = one;

        return sum >= pro ? sum : pro;
    }

}