package onboarding.validatechecker;

import java.util.List;

public class Problem6ValidateChecker {
	public static void isFormValidate(List<List<String>> forms){
		isFormsNotNull(forms);
		isFormNotNull(forms);
		areEmailAndNickNameNotNull(forms);
		isCrewSizeInRange(forms);


	}

	private static void areEmailAndNickNameNotNull(List<List<String>> forms){
		for (List<String> form : forms)
			if(form.get(0) == null || form.get(1) == null)
				throw new IllegalArgumentException("닉네임 또는 이메일이 null입니다.");
	}

	private static void isFormNotNull(List<List<String>> forms) {
		for (List<String> form : forms) {
			if(form == null)
				throw new IllegalArgumentException("입력된 form이 null입니다.");
		}
	}

	private static void isCrewSizeInRange(List<List<String>> forms) {
		if(forms.size() == 0 || forms.size() > 10000)
			throw new IllegalArgumentException("크루의 수는 1이상이거나, 10,000이하여야합니다.");
	}

	private static void isFormsNotNull(List<List<String>> forms) {
		if(forms == null)
			throw new IllegalArgumentException("입력된 forms가 null입니다.");
	}

}
