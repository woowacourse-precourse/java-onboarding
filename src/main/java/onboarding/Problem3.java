package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int[] numArr = new int[5];
        for(int i = 0; i<number;i++) {
        	numArr[0]++;
        	for(int j = 0; j<5 ; j++) {
        		if(numArr[j]==10) {
        			numArr[j+1]++;
        			numArr[j] = 0;
        		}
        	}
        }
        return answer;
    }
}
