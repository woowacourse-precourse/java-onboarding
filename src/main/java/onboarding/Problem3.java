package onboarding;

public class Problem3 {

    /**
     * 기능 목록
     * 1. int형 -> string형으로 변환
     * 2. 해당 숫자 3, 6, 9의 개수 찾기
     */

    /**
     * 1. int형 -> string형으로 변환
     * @param number : 변환할 숫자
     * @return : string으로 변환된 숫자
     */
    static String convert(int number){
        return Integer.toString(number);
    }

    /**
     * 2. 해당 숫자 3, 6, 9의 개수 찾기
     * @param number : 3, 6, 9의 개수를 찾을 숫자
     * @return : 3, 6, 9의 개수
     */
    static int find369(String number){
        int total = 0;

        for (int i = 0; i < number.length(); i++){
            if (number.charAt(i) == '3' || number.charAt(i) == '6' || number.charAt(i) == '9')
                total++;
        }

        return total;
    }

    public static int solution(int number) {
        int answer = 0;

        // 1 ~ number 까지 3, 6, 9의 개수 구하는 반복문
        for (int i = 1; i <= number; i++){
            String num = convert(i);
            answer += find369(num);
        }

        return answer;
    }
}
