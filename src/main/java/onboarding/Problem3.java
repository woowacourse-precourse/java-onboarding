package onboarding;

public class Problem3 { // n번 까지 반복하여 사이에 3,6,9가 몇 개나 들어가는지 갯수 세기
    public static int solution(int number) {
    	int answer = 0; // 총 박수 횟수
    	for (int i = 1; number >= i;i++) {
    		String temp = String.valueOf(i); // 현재 주목한 숫자를 문자로
    		temp = temp.replaceAll("[0124578]", ""); // 정규식으로 3,6,9만 남김
    		answer = answer + temp.length();
    	}
        return answer;
    }
}
