package onboarding;

class remove_dup{
	String temp = new String();
	
	
	String s = new String();
	
	remove_dup() {
	}
	
	
	remove_dup(String s) {
		this.s = s;
	}
	
	void add_temp(String s){
		if(!s.isEmpty()) {
			temp = s;
		}
		
	}
	
	String remove(String s) {
		String s1, s2;
		
		int i;
		
		add_temp(s);
		
		for(i = 1; i < s.length(); i++) {		
			if(temp.charAt(i - 1) == s.charAt(i)) {
				
				s1 = s.substring(0,i-1);
				s2 = s.substring(i+1, s.length());
				
				this.s = s1.concat(s2);
			}
		}
		
		return this.s;
	}
	
	boolean end_check() {
		int i;
		
		for(i = 0; i < s.length()-1; i++) {		
			if(s.charAt(i) == s.charAt(i+1)) {
				return true;
			}
		}
		return false;
	}
	
	String result() {
		
		if(s.isEmpty()) {
			return s;
		}else 
			while(true) {
				if(end_check()) {
					remove(s);	
				}else {
					return s;
				}
			}
	}
}

public class Problem2 {
    public static String solution(String cryptogram) {
		
    	
		String s = new String(cryptogram);
		
		remove_dup d = new remove_dup(s);
		
		return d.result();

	}
}