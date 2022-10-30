package onboarding;


public class Problem3_2 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i < Math.log10(number)+1; i++) {
            int tmpDigits = (int) Math.pow(10, i);
            answer += (number / tmpDigits) * 3 * (tmpDigits / 10); // 3921 -> 3 * 3 * 100
            answer += (number % tmpDigits) / (3 * (tmpDigits / 10)) * (tmpDigits / 10); // 3921 -> 3821 % 1000 -> 821 -> 2*100
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

    public static void main(String[] args) {
        System.out.println(solution2(13));
    }
}
