package onboarding;

import java.util.ArrayList;
import java.util.List;

/** 큰 틀의 기능 구현
 * 1. 입력값 체크
 * 2. 페이지 번호 각 자리 덧셈 함수 구현
 * 3. 페이지 번호 각 자리 곳셈 함수 구현
 * 4. 결과 비교 함수
 * **/
/**
 * 1. 입력값 체크
 * - 길이값 : 2인지
 * - 왼쪽 페이지가 홀수 인지
 * - [왼쪽 페이지 번호, 오른쪽 페이지 번호]가 순서대로 들어왔는지
 * - 입력 숫자 : 시작면이나 마지막 또는 0보다 더 작은 값 400보다 더 큰값이 나올 때 결과값
 * */

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

//    public static void main(String[] args){
//        List<Integer> test1 = new ArrayList<Integer>();
//        test1.add(3);
//        test1.add(4);
//        List<Integer> test2 = new ArrayList<Integer>();
//        test2.add(10);
//        test2.add(12);
//        System.out.println(checkInput(test1));
//        System.out.println(checkInput(test2));
//    }
    public static boolean checkInput(List<Integer> inputlist){
        if(checkSize(inputlist))
        {
            if(checkOdd(inputlist) && checkNext(inputlist) && checkVal(inputlist))
                return true;
        }
        return false;
    }
    public static boolean checkSize(List<Integer> inputlist){
        if(inputlist.size() == 2)
            return true;
        return false;
    }
    public static boolean checkNext(List<Integer> inputlist){
        if(inputlist.get(0) == inputlist.get(1) - 1)
            return true;
        return false;
    }
    public static boolean checkOdd(List<Integer> inputlist){
        if(inputlist.get(0) % 2 == 1)
            return true;
        return false;
    }
    public static boolean checkVal(List<Integer> inputlist){
        if(inputlist.get(0) > 0 && inputlist.get(1) < 400)
            return true;
        return false;
    }
}