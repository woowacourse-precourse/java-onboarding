////
// A-Z : 65~90, a-z : 97~122
public class Prob4 {
	public String convert(String word) {
		
		char[] wordArr = word.toCharArray();
		int charInt;
		
		for(int i=0; i < wordArr.length; i++) {
			charInt = wordArr[i];
			if(Character.isUpperCase(wordArr[i])) {
				wordArr[i] = (char)(155-charInt);
			} 
			else if(Character.isLowerCase(wordArr[i])) {
				wordArr[i] = (char)(219-charInt);
			}
			else { wordArr[i] = ' '; }
			
			word = new String(wordArr);
		}
			
		return word;
	}
	
	public static void main(String[] args) {
		System.out.println("Problem 4");
		Prob4 prob4 = new Prob4();
		
		String word = "I love you";
		// String word = "ABcd";
		System.out.println(prob4.convert(word));			
	}
}
