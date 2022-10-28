package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        
        

		String s = new String("zyelleyz");
		String s1, s2;

		char temp;
		
		
		temp = s.charAt(0);
		while(true) {
			for(int i = 1; i < s.length(); i++) {
				if(temp == s.charAt(i)) {				
					s1 = s.substring(0,i-1);
					s2 = s.substring(i+1, s.length());
				
					System.out.println("s1 : " + s1);
					System.out.println("s2 : " + s2);
				
					s = s1.concat(s2);
					
					System.out.println(s);
					
					if(s == null) {
						break;
					}else {
					i = 0;
					temp = s.charAt(0);
					continue;
					}
				}
				else if(i == s.length()){
					break;
				}
				else
				temp = s.charAt(i);
			}
			
		}
		
        
    }
}
