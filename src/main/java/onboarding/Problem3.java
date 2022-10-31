package onboarding;

public class Problem3 {
    public static int solution(int number) {
    	
    	int result = 0;

		for(int i = 3; i <= number; i++) {
			result += CheckClapNum(i);
		}
		
		return result;
    }
    
    //입력받은 숫자에 포함된 3,6,9의 개수를 파악하고 그 개수를 반환하는 함수
    private static int CheckClapNum(int num) {
		
		String str = Integer.toString(num);
		//숫자를 문자열로 형변환
		
		return str.replaceAll("[^369]","").length();
		//3,6,9를 제외한 숫자를 모두 없애서 3,6,9의 숫자를 세준다.
	}
}
