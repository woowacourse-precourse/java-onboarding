package onboarding;

import java.util.List;

class Problem1 {

    static final int INVALID = -1;
    static final int DRAW = 0;
    static final int POBI_WINS = 1;
    static final int CRONG_WINS = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(invalid(pobi) || invalid(crong)) return INVALID;

        int pobi_score = get_score(pobi);
        int crong_score = get_score(crong);

        if(pobi_score == crong_score) return DRAW;
        else if(pobi_score > crong_score) return POBI_WINS;
        else return CRONG_WINS;
    }

    static int get_score(List<Integer> page_list){
        int page_number = page_list.get(0);
        int score = Math.max(add_digits(page_number), multiply_digits(page_number));
        page_number += 1;
        score = Math.max(score, add_digits(page_number));
        score = Math.max(score, multiply_digits(page_number));
        return score;
    }

    static int multiply_digits(int number){
        String number_to_string = Integer.toString(number);
        int result = 1;
        for(int i=0; i<number_to_string.length(); i++){
            result *= number_to_string.charAt(i) - '0';
        }
        return result;
    }

    static int add_digits(int number){
        String number_to_string = Integer.toString(number);
        int result = 0;
        for(int i=0; i<number_to_string.length(); i++){
            result += number_to_string.charAt(i) - '0';
        }
        return result;
    }

    static boolean invalid(List<Integer> list){
        int left = list.get(0);
        int right = list.get(1);

        if(left+1 != right) return true;
        if(left%2 == 0) return true;
        if(out_of_bound(left) || out_of_bound(right)) return true;
        return false;
    }

    static boolean out_of_bound(int number){
        if(number >= 1 && number <= 400) return false;
        return true;
    }

}