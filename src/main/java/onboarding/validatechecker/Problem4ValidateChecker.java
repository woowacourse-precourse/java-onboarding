package onboarding.validatechecker;

public class Problem4ValidateChecker {
	public static void isWordValidate(String word){
		isWordNotNull(word);
		isWordInRange(word);
	}

	private static void isWordInRange(String word) {
		if(word.length()==0 || word.length()>1000)
			throw new IllegalArgumentException("문자열의 길이는 1 이상 1,000이하여야 합니다,");
	}

	private static void isWordNotNull(String word){
		if(word == null)
			throw new IllegalArgumentException("입력한 문자열이 null입니다.");
	}
}
