package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
    	
    	int ln = cryptogram.length();

		while(true){
			cryptogram = cryptogram.replaceAll("(([a-z])\\2{1,})","");
			//연속된 같은 문자 (2개이상)을 변환
			
			
			//cryptogram의 길이가 변화되지 않으면 연속하는 알파벳이 없다고 판단
			if(ln == cryptogram.length())
				return cryptogram;
			else 
				ln = cryptogram.length();
		}
    }
}
