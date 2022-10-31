package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int[] result = new int[10001];
        result[0] = result[1] = result[2] = 0; // 0, 1, 2는 3이하이므로 0으로 처리

        for (int i = 3; i <= number; i++) {
            result[i] = result[i-1]; // 이전 값을 현재 값에 중첩시킨다.
            int tmp = i;

            while(tmp > 0){
                int decimal = tmp % 10; //10으로 나눠 자릿 수를 구한다.
                if(decimal == 3 || decimal == 6 || decimal == 9){
                    result[i]++; //3, 6, 9가 나오면 이전 중첩 값에 1을 추가한다.
                }
                tmp /= 10;
            }
        }
        return result[number];
    }
}
