package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
		
		// 1부터 number까지
		for(int i = 1; i <= number; i++){
			String strNum = String.valueOf(i);

			// 자릿수 확인
			for(int j = 0 ; j < strNum.length(); j++){
				char target = strNum.charAt(j);
				if(target == '3' || target == '6' || target == '9'){
					System.out.println("i = " + i);
					answer++;
				}
			}
		}
		
        return answer;
    }
}
