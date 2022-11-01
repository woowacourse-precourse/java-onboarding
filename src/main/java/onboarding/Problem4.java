package onboarding;

import java.util.regex.Pattern;

public class Problem4 {
	public static void main(String[] args)  {
		String word="";
		if(word.length()>1) {	
			if(word.length()>1000) {
				word = word.substring(0,1000);
			}
			solution(word);
		}
	}
	public static String solution(String word) {
		int endpos=0;
		String pattern ="^[a-zA-Z]$";
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<word.length();i++) {
			String c = word.charAt(i)+"";
			if(Pattern.matches(pattern,c)) {
				if(word.charAt(i)>='a'&&word.charAt(i)<='z') {
					endpos = 'z';
					sb.append((char)(endpos - (int)(word.charAt(i)-'a')));
				}else if(word.charAt(i)>='A'&&word.charAt(i)<='Z'){
					endpos = 'Z';
					sb.append((char)(endpos - (int)(word.charAt(i)-'A')));
				}else {
					sb.append(" ");
				}
			}else {
				sb.append(c);
			}
		}
		String answer = new String(sb);
		return answer;
	}
}
