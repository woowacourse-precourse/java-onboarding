package onboarding;

public class Problem3 {
    // 처음 아이디어
    // 문자열로 숫자들을 계속 추가하는 함수 생성
    // 문자열에서 3,6,9가 들어간 개수 추출하기

    public static String numberToString(int number) {
        String numbers = "";
        for(int i = 1; i <= number; i++) {
            numbers += Integer.toString(i);
        }
        return numbers;
    }

    public static int findNumbers(String numbers) {
        int count = 0;
        for(int i = 0; i < numbers.length(); i++) {
            if(numbers.charAt(i) == 3 || numbers.charAt(i) == 6 || numbers.charAt(i) == 9) {
                count++;
            }
        }
        return count;
    }

    public static int solution(int number) {
        String allNumbers = numberToString(number);
        return findNumbers(allNumbers);
    }
}
