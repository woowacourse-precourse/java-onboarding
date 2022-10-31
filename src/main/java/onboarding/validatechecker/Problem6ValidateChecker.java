package onboarding.validatechecker;

import java.util.List;

public class Problem6ValidateChecker {
	public static void isFormValidate(List<List<String>> form){
		isFormNotNull(form);
		isCrewSizeInRange(form);
	}

	private static void isCrewSizeInRange(List<List<String>> form) {
		if(form.size() == 0 || form.size() > 10000)
			throw new IllegalArgumentException("크루의 수는 1이상이거나, 10,000이하여야합니다.");
	}

	private static void isFormNotNull(List<List<String>> form) {
		if(form == null)
			throw new IllegalArgumentException("입력된 Form이 null입니다.");
	}

}
