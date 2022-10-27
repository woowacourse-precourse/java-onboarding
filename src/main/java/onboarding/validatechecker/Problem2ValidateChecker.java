package onboarding.validatechecker;

public class Problem2ValidateChecker {
	public static void isCryptogramValidate(String cryptogram){
		isLengthInRange(cryptogram);
	}

	public static void isLengthInRange(String cryptogram){
		if(cryptogram.length()==0 || cryptogram.length()>1000)
			throw new IllegalArgumentException("cryptogram은 길이가 1 이상 1000 이하인 문자열이다.");
	}

	public static void isCryptogramContainUpper(String cryptogram){
		if(!cryptogram.toLowerCase().equals(cryptogram))
			throw new IllegalArgumentException("cryptogram은 대문자를 포함 할 수 없다.");
	}
}
