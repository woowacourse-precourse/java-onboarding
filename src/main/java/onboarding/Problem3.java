package onboarding;


// 뭔가 하드코딩한 느낌이나서 다시 살펴보면 좋을 것 같음
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

    // 총 몇 번의 박수를 쳐야하는지 검사하는 메서드
    public static int extractResult(int number) {
        int result = 0;

        for (int i = 1; i < number + 1; i++) {
            String currentValue = String.valueOf(i);
            result += countClap(currentValue);
        }
        return result;
    }


    public static int solution(int number) {
        return extractResult(number);
    }
}
