package onboarding;

import java.util.regex.Pattern;

public class Problem3 {
	public static void main(String[] args) {
		String pattern = "^[0-9]+$";
		int number = 0;
		if(Pattern.matches(pattern,number+"")) {
			if(number>=1 && number<=10000) {
				solution(number);
			}
		}
	}
	public static int solution(int number) {
		int answer=0;
		for(int i =1;i<=number;i++) {
			String str = String.valueOf(i);
			String[] numstr = str.split("");
			for(int j=0;j<numstr.length;j++) {
				if(numstr[j].equals("3")|| numstr[j].equals("6")|| numstr[j].equals("9")) {
					answer+=1;
				}
			}
		}
		return answer;
	}
}


