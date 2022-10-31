package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        //포비와 크롱이 가질 수 있는 제일 큰 수 구하기
        int pobiLeftPageMaxNum = maxNum(sumNum(pobi.get(0)), multiplyNum(pobi.get(0)));
        int pobiRightPageMaxNum = maxNum(sumNum(pobi.get(1)), multiplyNum(pobi.get(1)));
        int crongLeftPageMaxNum = maxNum(sumNum(crong.get(0)), multiplyNum(crong.get(0)));
        int crongRightPageMaxNum = maxNum(sumNum(crong.get(1)), multiplyNum(crong.get(1)));

        int pobiNum = maxNum(pobiLeftPageMaxNum, pobiRightPageMaxNum);
        int crongNum = maxNum(crongLeftPageMaxNum, crongRightPageMaxNum);

        //포비가 이겼을 경우
        if (pobiNum > crongNum) {
            answer = 1;
        }
        //크롱이 이겼을 경우
        if (pobiNum < crongNum) {
            answer = 2;
        }
        //무승부의 경우
        if (pobiNum == crongNum) {
            answer = 0;
        }
        //왼쪽 페이지에는 홀수, 오른쪽 페이지에는 짝수 번호가 오면서 책의 시작면이나 마지막 면이 나왔을 경우
        if (pobi.get(0) == 1 || crong.get(1) == 400) {
            answer = -1;
        }
        //매개변수로 주어진 페이지들이 연속된 번호가 아닌 경우
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            answer = -1;
        }
        return answer;
    }

    //입력받은 숫자의 각 자릿수를 더하는 메서드
    private static int sumNum(int num) {
        int result = 0;
        while (num > 0) {
            result += num%10;
            num /= 10;
        }
        return result;
    }

    //입력받은 숫자의 각 자릿수를 곱하는 메서드
    private static int multiplyNum(int num) {
        int result = 1;
        while (num > 0) {
            result = result*(num%10);
            num /= 10;
        }
        return result;
    }

    //입력받은 두 숫자 중 더 큰 수를 반환하는 메서드
    private static int maxNum(int a, int b) {
        int result = 0;
        if (a > b) {
            result = a;
            return result;
        }

        if (a < b) {
            result = b;
            return result;
        }

        if (a == b) {
            result = a;
            return result;
        }
        return result;
    }
}