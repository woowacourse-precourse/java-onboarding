package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char[] ch1 = {'Z','Y','X','W','V','U','T','S','R','Q','P','O','N',
        		'M','L','K','J','I','H','G','F','E','D','C','B','A'};
        char[] ch2 = {'z','y','x','w','v','u','t','s','r','q','p','o','n',
        		'm','l','k','j','i','h','g','f','e','d','c','b','a'};
        
        for(int i=0;i<word.length();i++) {
        	if(word.charAt(i)>='A'&&word.charAt(i)<='Z') {
        		sb.append(ch1[(int)word.charAt(i)-65]);
        	}else if(word.charAt(i)>='a'&&word.charAt(i)<='z') {
        		sb.append(ch2[(int)word.charAt(i)-97]);
        	}else {
        		sb.append(word.charAt(i));
        	}
        }
        answer = sb.toString();
        return answer;
    }
}
