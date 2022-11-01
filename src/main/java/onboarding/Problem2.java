package onboarding;

public class Problem2 {
	public static String solution(String cryptogram)  {
		validation(cryptogram);
		return decrypt(cryptogram);
	}
	
	public static String decrypt(String cryptogram) {
		boolean fact = Boolean.TRUE;
		StringBuilder MyString = new StringBuilder(cryptogram);

		int length = MyString.length();
		for (int i = 0; i < MyString.length(); i++) {
			if(i >= length-1) {
				break;
			}
			if (MyString.charAt(i) == MyString.charAt(i+1)) {
				fact = Boolean.FALSE;
				MyString = MyString.deleteCharAt(i);
				length = length - 1;
				MyString = MyString.deleteCharAt(i);
				length = length - 1;

			}
		} 
		String result = null;

		if(fact) {
			result = MyString.toString();
		}
		else {
			result = decrypt(MyString.toString());
		}
		return result;
	}
	
	private static void validation(String cryptogram) {
		if( cryptogram == null || cryptogram.isEmpty()) {
			throw new IllegalArgumentException("길이가 1 이상 문자열이어야 합니다.");
		}
		
		if( cryptogram.length() > 1000) {
			throw new IllegalArgumentException("길이가 1000 이하 문자열이어야 합니다.");
		}
		
		for( int i=0; i<cryptogram.length(); i++) {
			char c = cryptogram.charAt(i);
			if( c < 'a' || 'z' < c) {
				throw new IllegalArgumentException("알파벳은 소문자로만 이루어져야 합니다.");
			}
		}
	}
}
