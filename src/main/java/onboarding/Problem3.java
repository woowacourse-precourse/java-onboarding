package onboarding;

public class Problem3 {
    // 처음 아이디어
    // 문자열로 숫자들을 계속 추가하는 함수 생성
    // ex. 1부터4까지 = "1234"
    // for문을 이 문자열의 개수만큼 실행시켜 해당 index에 3,6,9가 들어갔을 때 그 개수를 세는 함수 만들기

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
            if(numbers.charAt(i) == '3' || numbers.charAt(i) == '6' || numbers.charAt(i) == '9') {
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
