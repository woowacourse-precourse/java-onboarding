package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char str[] = n.toCharArray();
		char tmp;
		int len = str.length;
		
		for (int i = 0 ; i<len/2;i++) {
			tmp=str[i];
			str[i]=str[len-i-1];
			str[len-i-1]=tmp;
		}
		answer = new String(str);
        return answer;
    }
}
 