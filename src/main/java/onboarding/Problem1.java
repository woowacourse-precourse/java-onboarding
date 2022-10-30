package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 예외 상황 발생 시 -1 반환
        // 최댓값 찾기
        // 결과 판단

        return answer;
    }

    // 예외 경우인지를 판단하는 함수 isException()
    private static boolean isException(List<Integer> pages) {
        // 1. 왼쪽 페이지가 홀수이고, 오른쪽 페이지가 짝수인지 확인
        if (pages.get(0)%2==0 || pages.get(1)%2==1) {
            return true;
        // 2. 두 페이지가 붙어있는지 확인
        } else if (pages.get(0)+1 != pages.get(1)) {
            return true;
        // 3. 시작 면이나 마지막 면이 포함되었는지 확인
        } else if (pages.get(0)==1 || pages.get(1) == 400) {
            return true;
        } else {
            return false;
        }
    }


    // 각 자리수를 추출하는 함수 parseNumber()
    private static int[] parseNumber(Integer number) {
        String numberString = number.toString();
        char[] numberChar = numberString.toCharArray();
        int[] numbers = new int[numberChar.length];

        for (int i=0; i<numberChar.length; i++){
            numbers[i] = numberChar[i]-'0';
        }

        return numbers;
    }

    // 숫자들로 만들 수 있는 최댓값을 찾는 함수 findMax()
    private static int findMax(Integer page) {
        int[] numbers = parseNumber(page);

        int add = 0;
        int mul = 1;
        for (int i=0; i<numbers.length; i++){
            add+=numbers[i];
            mul*=numbers[i];
        }

        return Math.max(add,mul);
    }

}