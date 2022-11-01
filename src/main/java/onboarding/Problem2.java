package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        
        int chk = 0;
		StringBuffer str = new StringBuffer(cryptogram);
		for(int i=0; i < str.length()-1; i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				//System.out.println(str.charAt(i+1));
				str.delete(i, i+2);
				i--;
				chk++;
			}
		}
		//System.out.println("-> "+str);
		cryptogram = str.toString();
		if( chk !=0 ) { cryptogram = delRep(s); }
		return cryptogram;   
    }
}
