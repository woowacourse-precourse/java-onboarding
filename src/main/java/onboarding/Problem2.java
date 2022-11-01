package onboarding;

import java.util.regex.Pattern;

public class Problem2 {
	public static void main(String[] args) {
		String cryptogram="";
		String pattern ="^[a-z]+$";
		if(Pattern.matches(pattern,cryptogram)) {
			if(cryptogram.length()>1000) {
				cryptogram = cryptogram.substring(0,1000);
			}else {
				solution(cryptogram);
			}
		}
	}		
	
	public static String solution(String cryptogram) {
		String answer="";
		StringBuffer sb = new StringBuffer();
		boolean check = false;
		int length = cryptogram.length();
		for(int i=0;i<length-1;i++) {
			char c1 = cryptogram.charAt(i);
			if(c1==cryptogram.charAt(i+1)) {
				check=true;
				for(int j =i+1;j<cryptogram.length();j++) {
					if(c1!=cryptogram.charAt(j)) {
						i=j-1;
						if(i==length-2) {    //끝자리가 aat경우 
							sb.append(cryptogram.charAt(length-1));
						}
						break;
					}
				}
				
			}else {
				sb.append(c1);
				if(i==length-2) {     //at로 끝나는 경우
					sb.append(cryptogram.charAt(length-1));
				}
			}
		}
		if(check==true) {
			check=false;
			answer = solution(new String(sb));
		}
		else {
			answer = new String(sb);
		}
		return answer;
	}

}


