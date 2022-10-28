package onboarding;
// 1.Brute force
//  >> 10,000이하의 자연수 이고 O(n)으로 해결가능 할 수 있다. 
//  n을 씩 증가시키며 n에 3, 6, 9 가 몇개 들었는지 계산하기.
//  n/1000 , n/100 , n/10 n 을 이용하기 3 6 9 계산하기
// 2. 규칙성찾기. 
// 10의 단위로 끊어서 생각하기. 
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<=number ; i++) {
        	answer += is_clap(i);
        }
        return answer;
    }
    public static int is_clap(int i) {
    	int answer = 0;
    	String tmp = Integer.toString(i);
    	for(int j=0; j<tmp.length(); j++) {
    		char now_num = tmp.charAt(j);
    		if(now_num=='3'||now_num =='6' || now_num=='9') {
    			answer ++;
    		}
    	}
    	return answer;
    }
}
