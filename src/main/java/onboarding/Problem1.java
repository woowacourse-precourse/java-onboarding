package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    // 페이지 번호를 자리수별로 분할하는 함수
    // input : 페이지 번호
    // output: 분할된 자리수가 있는 리스트
    private static List<Integer> splitInt(int num) {
        List<Integer> list = new ArrayList<>();

        String str = String.valueOf(num);
        String[] digits = str.split("(?<=.)");

        for (int i = 0; i < digits.length; i ++) {
            list.add(Integer.parseInt(digits[i]));
        }

        return list;
    }

    // 페이지 번호 자리수별로 합, 곱을 시행한 다음 가장 큰 값을 구하는 함수
    // input : 자리수로 분할된 페이지 번호
    // output: 자리수로 합, 곱 시행한 값들 중 가장 큰 값
    private static int mulSum(List<Integer> list) {
        // 왼쪽, 오른쪽 페이지 숫자 모두 더하기
        int sum = list.get(0);
        int mul = list.get(0);

        for(int i = 1; i < list.size(); i ++) {
            sum += list.get(i);
            mul *= list.get(i);
        }

        int result = (sum > mul) ? sum : mul;
        return result;
    }

    // 페이지 번호로 점수를 구하는 함수
    // input : 페이지 번호가 담긴 배열
    // output: 왼쪽, 오른쪽 페이지의 합, 곱 중에 가장 큰 값
    private static int getScore(List<Integer> list) {
        List<Integer> left = splitInt(list.get(0));
        List<Integer> right = splitInt(list.get(1));

        int leftBiggest = mulSum(left);
        int rightBiggest = mulSum(right);

        return (leftBiggest > rightBiggest) ? leftBiggest : rightBiggest;
    }

    // 예외 처리용 함수 > 페이지 번호가 이어지지 않을 때
    // input : 페이지 번호가 담긴 배열
    // output: 검사 여부(true: 합격, false: 불합격)
    private static boolean examine(List<Integer> list) {
        int left = list.get(0);
        int  right = list.get(1);

        if (left + 1 != right)
            return false;

        return true;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        // 예외 처리 > 페이지 번호가 이어지지 않는 경우
        if (examine(pobi) == false || examine(crong) == false)
            return -1;

        int answer = Integer.MAX_VALUE;
        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        answer = (pobiScore > crongScore) ? 1 : 0;
        return answer;
    }

//    public static void main(String[] args) {
//        List<Integer> pobi = List.of(99, 102);
//        List<Integer> crong = List.of(211, 212);
//        solution(pobi, crong);
//    }
}