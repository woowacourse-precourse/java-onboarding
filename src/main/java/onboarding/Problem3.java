package onboarding;

public class Problem3 {
    public static int solution(int num) {
        int answer = 0;
        
        int cnt = 0;
		String str;
		
		for(int i=1; i<num+1; i++) {
			str = Integer.toString(i);
			
			for(int j=0; j < str.length(); j++) {
				int temp = Character.getNumericValue(str.charAt(j));
				//System.out.println(temp);
				if(temp==3 || temp==6 || temp==9) {
					cnt++;
				}
			}
		}
		return cnt;
    }
}
