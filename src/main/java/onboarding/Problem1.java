package onboarding;

import java.util.ArrayList;
import java.util.List;

/** 큰 틀의 기능 구현
 * 1. 입력값 체크
 * 2. 페이지 번호 각 자리 덧셈 함수 구현
 * 3. 페이지 번호 각 자리 곳셈 함수 구현
 * 4. 가장 큰 수 출력을 위한 비교 함수
 * 5. 결과 값 출력을 위한 함수
 *
 * **/
/**
 * 1. 입력값 체크
 * - 길이값 : 2인지
 * - 왼쪽 페이지가 홀수 인지
 * - [왼쪽 페이지 번호, 오른쪽 페이지 번호]가 순서대로 들어왔는지
 * - 입력 숫자 : 시작면이나 마지막 또는 0보다 더 작은 값 400보다 더 큰값이 나올 때 결과값
 * */
/**
 * 2. 페이지 번호 각 자리 덧셈 함수 구현
 * **/

/**
 * 3. 페이지 번호 각 자리 곳셈 함수 구현
 * **/

/**
 * 4. 가장 큰 수 출력을 위한 비교 함수
 * - 두 숫자의 비교함수
 * - 왼쪽 -> 덧셈 , 곱셈 , 오른쪽 -> 덧셈, 곱셈 총 4개의 숫자를 넣을 리스트 만들 함수
 * - 리스트를 통한 비교 위한 함수
 * **/


class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    public static void main(String[] args){
//        List<Integer> test1 = new ArrayList<Integer>();
//        test1.add(3);
//        test1.add(4);
//        List<Integer> test2 = new ArrayList<Integer>();
//        test2.add(10);
//        test2.add(12);
//        System.out.println(checkInput(test1));
//        System.out.println(checkInput(test2));
//        int testNum = 020;
//        System.out.println(sumOfeach(testNum));
//        int testMul = 203;
//        System.out.println(multiplyOfeach(testMul));
        }
    private static boolean checkInput(List<Integer> inputlist){
        if(checkSize(inputlist)&& checkOdd(inputlist) && checkNext(inputlist) && checkVal(inputlist))
        {
            return true;
        }
        return false;
    }
    private static boolean checkSize(List<Integer> inputlist){
        if(inputlist.size() == 2)
            return true;
        return false;
    }
    private static boolean checkNext(List<Integer> inputlist){
        if(inputlist.get(0) == inputlist.get(1) - 1)
            return true;
        return false;
    }
    private static boolean checkOdd(List<Integer> inputlist){
        if(inputlist.get(0) % 2 == 1)
            return true;
        return false;
    }
    private static boolean checkVal(List<Integer> inputlist){
        if(inputlist.get(0) > 0 && inputlist.get(1) < 400)
            return true;
        return false;
    }
    private static int sumOfeach(int num){
        int ret = 0;
        while(num != 0){
            ret += num % 10;
            num = num / 10;
        }
        return ret;
    }
    private static int multiplyOfeach(int num){
        int ret = 1;
        while(num != 0){
            ret *= num % 10;
            num = num / 10;
        }
        return ret;
    }
    private static int compareNum(int left, int right){
        if(left > right)
            return left;
        return right;
    }
    private static int representNum(List<Integer> representList){
        int represent = 0;
        for(int i = 0; i < representList.size(); i++)
        {
            represent = compareNum(represent,representList.get(i));
        }
        return represent;
    }
    private static List<Integer> representList(int oddPage, int evenPage){
        List<Integer> result = new ArrayList<>();
        result.add(sumOfeach(oddPage));
        result.add(multiplyOfeach(oddPage));
        result.add(sumOfeach(evenPage));
        result.add(multiplyOfeach(evenPage));
        return result;
    }
}