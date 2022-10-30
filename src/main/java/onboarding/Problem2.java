package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		
		String crypto = cryptogram;
		
		while (true) {
			String decoded = decodeLogic(crypto);
			if (crypto.equals(decoded)) {
				crypto = decoded;
				break;
			} else {
				crypto = decoded;
			}
		}
		
		return crypto;
	}
	
	private static String decodeLogic(String cryptogram) {
		for (int i = 0; i < cryptogram.length() - 1; i++) {
			if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
				String beforeStr = cryptogram.substring(0, i);
				String afterStr = cryptogram.substring(i + 2);
				
				cryptogram = beforeStr + afterStr;
				i--;
			}
		}
		return cryptogram;
	}
}
