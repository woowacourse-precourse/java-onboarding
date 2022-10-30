package onboarding;


/*
* 1. number를 10으로 나눈 몫 * 3 만큼 ++, number를 10으로 나눈 나머지 / 3 만큼 ++
* 2.
* 3. 1, 2 반복
*
* */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i < Math.log10(number)+1; i++) {
            //현재 검사하는 자릿수를 나타내는 변수
            int tmpDigits = (int) Math.pow(10, i);

            answer += (number / tmpDigits) * 3 * (tmpDigits / 10);
            answer += (number % tmpDigits) / (3 * (tmpDigits / 10)) * (tmpDigits / 10);
            char secondDigitsNumber = ((number % tmpDigits) + "").charAt(0);

            if (secondDigitsNumber == '3' || secondDigitsNumber == '6' || secondDigitsNumber == '9') {
                answer -= tmpDigits / 10 - (number % (tmpDigits / 10) + 1);
            }
        }

        return answer;
    }

    /*
     * 1. 1~number 범위의 수 i에 대해서 반복한다.
     * 2. i의 각 자릿수에 포함 된 3,6,9의 개수만큼 answer에 더한다.
     * 3. answer을 반환한다.
     * */
    public static int solution2(int number) {
        int answer =0;
        for (int i = 1; i < number + 1; i++) {
            answer += count369(i);
        }

        return answer;
    }

    private static int count369(int n) {
        String str = n + "";
        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            char tmpchar = str.charAt(i);
            if (tmpchar == '3' || tmpchar == '6' || tmpchar == '9') answer++;
        }
        return answer;
    }
}
