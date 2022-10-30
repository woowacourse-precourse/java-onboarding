package onboarding;

import java.util.List;
import java.lang.Object; // library for min & max

class Problem1 {
    public static boolean check_book(List<Integer> name){ // method that check book
        // if the book is normal, return true
        // left page's number must be odd and right must be (left + 1) and even -> normal
        if( (name.get(0) % 2 == 1) && (name.get(1) == name.get(0) + 1)
                && (name.get(0) != 1) && (name.get(1) != 400)){
            return true;
        }
        else {// else, return false
            return false;
        }
    }
    public static int sum_page_num(int page_num, int result){ // initial result must be 0
        if((page_num / 10) == 0){ // if page_num is less than 10, return value
            return result + page_num;
        }else{ // page_num is bigger than 10, repeat
            return sum_page_num(page_num / 10, result + (page_num % 10));
        }
    }
    public static int multi_page_num(int page_num, int result){ // initial result must be 1
        if((page_num / 10) == 0){ // if page_num is less than 10, return value
            return result * page_num;
        }else{ // page_num is bigger than 10, repeat
            return multi_page_num(page_num / 10, result * (page_num % 10));
        }
    }
    public static int get_max_point(List<Integer> name){
        // size of pobi and crong is 2
        int left_page = name.get(0);
        int right_page = name.get(1);
        // compare and get the maximum value
        int result = Math.max(sum_page_num(left_page, 0), multi_page_num(left_page, 1));
        result = Math.max(result, sum_page_num(right_page, 0));
        result = Math.max(result, multi_page_num(right_page, 1));
        return result;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        // check the status of the book
        if (check_book(pobi) && check_book(crong)) {
            // calculate the point
            int pobi_point = get_max_point(pobi);
            int crong_point = get_max_point(crong);

            // compare crong and pobi's result
            if (crong_point > pobi_point) {
                answer = 2;
            } else if (crong_point < pobi_point) {
                answer = 1;
            } else { // crong_point == pobi_point
                answer = 0;
            }
            return answer;
        } else {
            // else(the book is abnormal), return -1
            return -1;
        }

    }
}