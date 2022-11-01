package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        
        //숫자 1부터 number까지 반복 for문
        for(int i=1; i<=number; i++) {
        	//현재 숫자를 자리수로 잘라 배열에 저장
        	String numberStr[] = String.valueOf(i).split("");
        	//자리수 마다 3, 6, 9가 들어가면 박수 횟수 +1
        	for(int a=0; a<numberStr.length; a++) {
        		if(Integer.parseInt(numberStr[a])== 3 || Integer.parseInt(numberStr[a])== 6 || Integer.parseInt(numberStr[a])== 9) {
        			answer++;
        		}
        	}
        	
        }
        
        return answer;
    }
}
