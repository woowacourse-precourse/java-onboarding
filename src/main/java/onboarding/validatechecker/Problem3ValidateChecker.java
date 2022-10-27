package onboarding.validatechecker;

public class Problem3ValidateChecker {
	public static void isNumberValidate(int number){
		if(number<=0 || number>10000)
			throw new IllegalArgumentException("number는 1 이상 10,000 이하인 자연수이다.");
	}
}
