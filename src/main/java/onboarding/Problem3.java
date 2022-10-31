package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        String s;
        String[] ss;
        for(int i=1;i<=number;i++) {
        	s = Integer.toString(i);
        	ss = s.split("");
        	for(String s1:ss) {
        		if(s1.equals("3")||s1.equals("6")||s1.equals("9"))
        			answer++;
        	}
        }
        return answer;
    }
}
