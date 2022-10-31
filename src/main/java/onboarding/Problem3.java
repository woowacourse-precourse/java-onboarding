package onboarding;

/*

[기능 목록]
1. 입력받은 문자열에 3, 6, 9 가 포함되면 그 갯수를 카운트를 하는 메서드
2. 1번 메서드를 활용하여 현재 순회중인 문자열이 몇 개의 박수를 쳐야하는지 카운트 하는 메슫
3. 총 박수를 몇번 처야하는지 카운트하는 메서드 2번 메서드를 이용해야한다.
 */

public class Problem3 {

    // 현재 순회중인 수를 인덱스로 슬라이싱하여
    // 박수를 쳐도 되는 수 인지 확인하는 메서드
    // 1 이면 박수를 쳐야 하는 수
    // 0 이면 박수를 치지 않아야 하는 수
    public static int isCountableNumber(int index, String currentValue) {
        if (currentValue.charAt(index) == '3') {
            return 1;
        } else if (currentValue.charAt(index) == '6') {
            return 1;
        } else if (currentValue.charAt(index) == '9') {
            return 1;
        }
        return 0;
    }

    // 현재 순회중인 값이 몇 번의 박수를 쳐야하는지 세는 메서드
    public static int countClap(String currentValue) {

        int currentValueLength = currentValue.length();
        int count = 0;

        for (int j = 0; j < currentValueLength; j++) {
            count += isCountableNumber(j, currentValue);
        }
        return count;
    }

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
