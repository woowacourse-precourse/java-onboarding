package onboarding;

public class Problem3 {
    public static int solution(int number) {

        // 예외 처리
        if (number < 1 || number > 10000) {
            return -1;
        }

        int answer = 0;

        // 자리수 확인
        int length = String.valueOf(number).length();

        // 한자리수면 바로 리턴 가능
        if (length == 1) {
            return number/3;
        }

        // 자리수 별 최대 횟수 저장용
        int[] arr = new int[length];

        // 1의 자리
        answer = number % 10 / 3;
        arr[0] = 10 / 3;
        number /= 10;

        // 10의 자리 부터
        for (int i = 1; i < length; i++) {
            // 자리수 별로 나누기
            int temp = number % 10;

            // 손뼉 그냥 치는 경우
            answer += (temp % 3) * arr[i - 1];

            // 손뼉 한번 더 치는 경우
            answer += (temp / 3) * (arr[i - 1] + (int) Math.pow(10, i));

            // 자리수 별로 최대 횟수 저장
            arr[i] = (7 * arr[i - 1]) + (3 * ((arr[i - 1]) + (int) Math.pow(10, i)));

            // 자리수 내리기
            number = number /= 10;
        }

        return answer;
    }
}
