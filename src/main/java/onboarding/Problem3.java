package onboarding;

public class Problem3 {
	
	public static int tsnAnswer(Integer num) {
		int cnt = 0;
		// 1 부터 num 까지 반복  
		for (int i = 1 ; i <= num ; i++) {
			
			// charAt 사용을 위해 문자열로 변환 
			String strNum = String.valueOf(i);
			// 문자 자리수 만큼 반복
			for (int j = 0 ; j < strNum.length() ; j++) {
				// 숫자중에 3,6,9 있으면 cnt +1    
				if(strNum.charAt(j) == '3' || strNum.charAt(j) == '6' || strNum.charAt(j) == '9') {
					cnt += 1;
				}
				
			}
		}return cnt;	
	}
	
    public static int solution(int number) {
    	return tsnAnswer(number);
    }
}
