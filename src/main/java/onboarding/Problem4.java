package onboarding;

class bluefrog_interpreter{
	String s = new String();
	char[] a;
	char upper[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	char lower[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	int temp[] = {25, 23, 21, 19, 17, 15, 13, 11, 9, 7, 5, 3, 1, -1, -3, -5, -7, -9, -11, -13, -15, -17, -19, -21, -23, -25};
	int i, j;
	int index = 0;
	
	bluefrog_interpreter(){
	}
	
	bluefrog_interpreter(String s){
		this.s = s;
		this.a = s.toCharArray();
	}
	
	String getToString(){
		for(i = 0; i < s.length(); i++) {
			if(s.charAt(i) >= 65 && s.charAt(i) <= 90 || s.charAt(i) >= 97 && s.charAt(i) <= 122) {
				for(j = 0; j < 26; j++) {
					if(s.charAt(i) == upper[j] || s.charAt(i) == lower[j]) {
						index = j;
					}
				}
				a[i] = (char) (s.charAt(i) + temp[index]);
			}
		}
		return String.valueOf(a);
	}
	
}



public class Problem4 {
    public static String solution(String word) {
    	
    	bluefrog_interpreter frog = new bluefrog_interpreter(word);
        
		return frog.getToString();
    }
}
