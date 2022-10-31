package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;
        answer = getAnswer(number); // 1부터 number까지 쳐야하는 손뼉의 총 개수
        return answer;
    }

    // 1부터 number까지 쳐야하는 손뼉의 총 개수를 반환하는 함수
    private static int getAnswer(int number) {
        int totalClap = 0; // 쳐야하는 손뼉의 총 개수
        int curNumber = 1; // 현재 확인하고 있는 숫자

        // 확인하는 숫자가 매개변수로 주어진 숫자보다 커지기 전까지
        while (curNumber <= number) {
            totalClap += countClap(curNumber); // 현재 확인하고 있는 숫자 하나에서 쳐야하는 손뼉의 개수 더하기
            curNumber++; // 확인 숫자 update
        }

        return totalClap;
    }

    // 한 숫자에서 쳐야하는 손뼉의 개수를 반환하는 함수
    private static int countClap(int number) {
        int clap = 0; // 쳐야하는 손뼉의 개수
        String numberToString = Integer.toString(number); // number를 문자열로 변환 (각 자리의 숫자를 index로 접근하기 위함)

        for (int i = 0; i < numberToString.length(); i++) {
            int digit = numberToString.charAt(i) - '0'; // 각 자리의 숫자

            // 값이 3, 6, 9 중 하나라면 clap + 1
            if (digit == 3 || digit == 6 || digit == 9) {
                clap++;
            }
        }

        return clap;
    }

}
