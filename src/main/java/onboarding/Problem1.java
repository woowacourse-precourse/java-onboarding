package onboarding;

import java.util.List;

class Problem1 {
    /*
    * 다음의 기능을 하는 클래스와 메서드를 구현.
    * 1. gamer1과 gamer2의 리스트를 가지고 다음의 기능들을 가진 클래스 PageNumGame
    * 2. 각 자리 숫자를 더하는 메서드 sumValue
    * 3. 각 자리 숫자를 곱하는 메서드 mulValue
    * 4. 왼쪽 페이지와 오른쪽 페이지의 각 자리 숫자를 더하고 곱하고 비교하여 가장 큰수를 리턴하는 메서드 getMaxValue
    * 5. 점수를 비교하여 승자를 정하는 메서드 whoIsWinner
    * 6. 예외사항인지 검사하는 메서드 checkException
    * */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        PageNumGame pobiCrong = new PageNumGame(pobi, crong);
        answer = pobiCrong.whoIsWinner();
        return answer;
    }
}

class PageNumGame {
    List<Integer> gamer1;
    List<Integer> gamer2;

    PageNumGame(List<Integer> gamer1, List<Integer> gamer2){
        this.gamer1 = gamer1;
        this.gamer2 = gamer2;
    }

    // 각 자리 숫자를 더하는 메서드
    int sumValue(int value) {
        int res = (value % 10) + (value % 100 / 10) + (value / 100);
        return res;
    }
    // 각 자리 숫자를 곱하는 메서드
    int mulValue(int value) {
        int res;
        if(value >= 100) {
            res = (value % 10) * (value % 100 / 10) * (value / 100);
        } else if(value >= 10) {
            res = (value % 10) * (value % 100 / 10);
        } else {
            res = (value % 10);
        }
        return res;
    }

    // 왼쪽 페이지와 오른쪽 페이지의 각 자리 숫자를 더하고 곱하여 더 큰 숫자를 반환하는 메서드
    int getMaxValue(int leftValue, int rightValue) {
        int leftMax = Math.max(sumValue(leftValue), mulValue(leftValue));
        int rightMax = Math.max(sumValue(rightValue), mulValue(rightValue));
        int max = Math.max(leftMax, rightMax);
        return max;
    }

    // 점수를 비교하여 승자를 정하는 메서드 whoIsWinner
    int whoIsWinner() {
        int answer = -1;

        if(checkException())
            return answer;

        int gamer1Point = getMaxValue(gamer1.get(0), gamer1.get(1));
        int gamer2Point = getMaxValue(gamer2.get(0), gamer2.get(1));
        if(gamer1Point > gamer2Point) {
            answer = 1;
        } else if (gamer1Point < gamer2Point) {
            answer = 2;
        } else if (gamer1Point == gamer2Point) {
            answer = 0;
        }
        return answer;
    }

    // 예외 사항
    boolean checkException(){
        // 왼쪽 페이지가 홀수, 오른쪽 페이지가 짝수 인지 검증
        if(gamer1.get(0) % 2 == 0 || gamer1.get(1) % 2 == 1) {
            return true;
        }
        if(gamer2.get(0) % 2 == 0 || gamer2.get(1) % 2 == 1) {
            return true;
        }

        // 인접한 페이지인지 검증
        if(gamer1.get(1) - gamer1.get(0) != 1) {
            return true;
        }
        if(gamer2.get(1) - gamer2.get(0) != 1) {
            return true;
        }

        // 시작 면이나 마지막 면이 나오는지 검증
        if(gamer1.get(0) == 1 || gamer1.get(1) == 400
                || gamer2.get(0) == 1 || gamer2.get(1) == 400) {
            return true;
        }

        return false;
    }

}
