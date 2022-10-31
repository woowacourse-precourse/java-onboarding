package onboarding;

public class Problem4 {
	static int upperA = 97;
	static int upperZ = 122;
	static int lowera = 65;
	static int lowerz = 90;
	static int dis = upperA - upperZ;
	
    public static String solution(String word) {
        return solve(word);
    }
    
    static String solve(String word) {
    	char[] ch = word.toCharArray();
    	
    	for(int i = 0; i < ch.length; i++) {
    		if(ch[i]==' ') {
    			continue;
    		}
 
    		if(ch[i] >= upperA && ch[i] <= upperZ) {
    			int chN = ch[i];
    			
        		chN += (dis-2*(chN-upperA));
        		ch[i] = (char)chN;
    		}else if(ch[i] >= lowera && ch[i] <= lowerz) {
    			int chN = ch[i];
    			
        		chN += (dis-2*(chN-lowera));
        		ch[i] = (char)chN;
    		}else {
    			continue;
    		}
    	}
    	
    	String res = "";
    	for(int i = 0; i < ch.length; i++) {
    		res += ch[i];
    	}
    	
    	return res;
    }
}
