package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        // 내림차순으로 박수 숫자 확인
        while (number > 0) {
        	answer += calClap(number);
        	number--;
        }
        return answer;
    }
    
    // 숫자에 해당하는 박수 숫자 구하기
    private static int calClap(int num) {
    	int count = 0;
    	while (num > 0) {
    		int remainder = num % 10;
    		if (remainder == 3 || remainder == 6 || remainder == 9) {
    			count++;
    		}
    		num /= 10;
    	}
    	return count;
    }
}
