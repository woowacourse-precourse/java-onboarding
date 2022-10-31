package onboarding.validatechecker;

import java.util.List;

public class Problem6ValidateChecker {
	public static void isFormValidate(List<List<String>> form){
		isFormNotNull(form);

	}

	private static void isFormNotNull(List<List<String>> form) {
		if(form == null)
			throw new IllegalArgumentException("입력된 Form이 null입니다.");
	}

}
