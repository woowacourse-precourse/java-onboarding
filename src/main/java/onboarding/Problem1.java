package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    /**
     * 리스트의 문자열을 나눠서 배열에 저장하는 함수
     * 배열에서 문자열을 더하거나 곱해서 나온 숫자 중 가장 큰 수를 뽑는 함수
     * 가장 큰 수 끼리 비교하는 함수
     * 예외사항
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        return game(pobi,crong);
    }

    /*
     *리스트의 문자열을 나눠서 배열에 저장하는 함수
     */
    static List<Integer> splitList(int number) {
        List<Integer> split = new ArrayList<>();
        while(number != 0){
            split.add(number % 10);
            number = number/10;
        }
        return split;
    }

    /*
     *배열에서 문자열을 더하거나 곱해서 나온 숫자 중 가장 큰 수를 뽑는 함수
     */
    static int cal(List<Integer> list, int x){
        List<Integer> max = splitList(list.get(x));
        int add = max.get(0) + max.get(1);
        int mul = max.get(0) * max.get(1);
        return Math.max(add,mul);
    }

    /*
     *예외사항
     */
    static boolean exception(List<Integer> list){
        return  !(list.get(1) - list.get(0) == 1);
    }

    /*
     *가장 큰 수 끼리 비교하는 함수
     */
    static int game(List<Integer> pobi, List<Integer> crong){
        int answer;
        if(exception(pobi) || exception(crong)){
            return -1;
        }

        int po = Math.max(cal(pobi,0),cal(pobi,1));
        int cr = Math.max(cal(crong,0),cal(crong,1));

        if(po>cr) {
            answer = 1;
        }else if(cr>po){
            answer = 2;
        }else {
            answer = 0;
        }
        return answer;
    }

}