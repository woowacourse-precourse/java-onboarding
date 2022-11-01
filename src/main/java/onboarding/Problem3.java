package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        
        for (int i=1; i<=number; i++) {
        	//입력받은 숫자의 각 자리를 추출하기 위해 String으로 형변환
        	String str = String.valueOf(i);
        	//n자리 수의 n만큼 반복
        	for(int j=0; j<str.length(); j++) {
        		//각 자리 숫자 추출 & 3,6,9일 때 박수 카운트
        		int num = Integer.parseInt(String.valueOf(str.charAt(j)));
        		if ( num!=0 && num%3== 0 ) answer++ ;	
        	}
        }
        return answer;
    }   
}