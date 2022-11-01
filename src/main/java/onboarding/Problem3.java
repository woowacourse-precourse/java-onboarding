package onboarding;

public class Problem3 {
    static Problem3 pro = new Problem3();

    /**
     * 3,6,9 게임을 하는데 특정 값을 받았을 때 해당 값까지 게임을 할 때 나와야하는 박수의 수를 더해야한다.
     * 특정 값을 각 자릿 수 별로 배열에 담아 각 자릿 수를 3,6,9와 비교하여 수를 계산한다.
     * 총 반복 수는 특정 값 만큼 반복한다.
     *
     * @param number
     * @return 총 박수의 수
     */

    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            // number 값을 각 자릿 수 별로 배열로 변경
            int[] arr = pro.numberToArr(i);

            // arr 로 변환한 값의 3,6,9 의 수를 구한다.
            answer += pro.calResult(arr);
        }

        return answer;
    }

    // 받은 값을 int 배열에 각 자릿 수 별로 담는다.
    public int[] numberToArr(int number) {
        int numLen = Integer.toString(number).length();
        int[] arr = new int[numLen];

        // 매개변수로 받은 값을 각 자릿 수 별로 배열에 넣는다. arr[0] = 0의 자리, arr[1] = 10의 자리..
        for (int i = 0; i < numLen; i++) {
            arr[i] = number % 10;
            number /= 10;
        }

        return arr;
    }

    // 매개변수로 받은 arr의 값에서 3,6,9 수를 계산하여 return
    public int calResult(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += pro.checkClap(arr[i]);
        }
        return result;
    }

    // 매개변수로 받은 값이 3,6,9 면 박수를 치는 것으로 1을 return
    public int checkClap(int checkNum) {
        if (checkNum % 3 == 0 && checkNum != 0) {
            return 1;
        }
        return 0;
    }
}
