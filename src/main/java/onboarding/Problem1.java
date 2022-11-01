package onboarding;

import java.util.List;

/**
 * [ Validator ]
 *  - is_odd() = 홀수인지 검증
 *  - is_even() = 짝수인지 검증
 *  - is_continuous = 연속된 페이지 인지 검증
 *  - is_proper_page_list() = 알맞은 페이지 리스트가 들어왔는지 검증
 *  - is_all_proper() = 두 사람의 페이지 리스트가 모두 알맞은 리스트인지 검증
 *
 * [ Calculator ]
 *  - show_bigger_num() = 받은 두 매개변수 중 더 큰 숫자를 반환
 *  - sum_page_number() = 현재 페이지의 모든 숫자를 더한 값 반환
 *  - multiple_page_number() = 현재 페이지의 모든 숫자를 곱한 값 반환
 *  - get_higher_score_in_page() = 매개변수로 받은 페이지로 만든 최고 스코어를 반환
 *  - get_final_score() = 매개변수로 받은 리스트의 두 페이지로 만든 최종 스코어를 반환
 *
 * [ Judge 클래스 ]
 * ERROR = -1, POBI = 1, CRONG = 2, DRAW = 0
 *
 *  - show_exception() = 오류를 반환한다.
 *  - show_result() = 결과를 반환한다
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Validator validator = new Validator();
        Judge judge = new Judge();
        if (!validator.is_all_proper(pobi, crong)) {
            return judge.show_exception();
        }
        Calculator calculator = new Calculator();
        return judge.show_winner(calculator.get_final_score(pobi), calculator.get_final_score(crong));
    }
}

class Validator {
    private boolean is_odd(int num) {
        return num % 2 == 1;
    }

    private boolean is_even(int num) {
        return num % 2 == 0;
    }

    private boolean is_continuous(int num1, int num2) {
        return num2 - num1 == 1;
    }

    private boolean is_proper_page_list(List<Integer> list) {
        int l_page = list.get(0);
        int r_page = list.get(1);
        return is_continuous(l_page, r_page) && is_odd(l_page) && is_even(r_page);
    }

    public boolean is_all_proper(List<Integer> pobi, List<Integer> crong) {
        return is_proper_page_list(pobi) && is_proper_page_list(crong);
    }
}

class Calculator {
    private int show_bigger_num(int num1, int num2) {
        if (num1 > num2) {
            return num1;
        }
        return num2;
    }

    private int sum_page_number(int page) {
        int sum = 0;
        while (page > 0) {
            sum += page % 10;
            page /= 10;
        }
        return sum;
    }

    private int multiple_page_number(int page) {
        int multiple = 1;
        while (page > 0) {
            multiple *= page % 10;
            page /= 10;
        }
        return multiple;
    }

    private int get_higher_score_in_page(int page) {
        return show_bigger_num(sum_page_number(page), multiple_page_number(page));
    }

    public int get_final_score(List<Integer> list) {
        return show_bigger_num(get_higher_score_in_page(list.get(0)), get_higher_score_in_page(list.get(1)));
    }
}

class Judge {
    private final int ERROR = -1;
    private final int DRAW = 0;
    private final int POBI = 1;
    private final int CRONG = 2;

    public int show_exception() {
        return ERROR;
    }

    public int show_winner(int pobi_score, int crong_score) {
        if (pobi_score == crong_score) {
            return DRAW;
        }
        if (pobi_score > crong_score) {
            return POBI;
        }
        return CRONG;
    }
}
