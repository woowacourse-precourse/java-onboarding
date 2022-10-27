package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		String answer = "answer";
		
		while (true) {
			boolean flag = true;
			for (int i = 0; i < cryptogram.length()-1; i++) {
				if(cryptogram.charAt(i) == cryptogram.charAt(i+1)){
					String beforeStr = cryptogram.substring(0, i);
					String afterStr = cryptogram.substring(i + 2);
					
					cryptogram = beforeStr + afterStr;
					i--;
					
					flag = false;
				}
			}
			if(flag){
				break;
			}
		}
		
		answer = cryptogram;
		
		return answer;
	}
}
