package onboarding.validatechecker;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6ValidateChecker {
	private static final int EMAIL = 0;
	private static final int NICKNAME = 1;
	private static final String EMAIL_DOMAIN = "email.com";
	private static final String KOREAN_PATTERN = "^[가-힣]*$";
	public static void isFormsValidate(List<List<String>> forms){
		isFormsNotNull(forms);
		isFormNotNull(forms);
		areEmailAndNickNameNotNull(forms);
		isCrewSizeInRange(forms);
		isEmailSizeInRange(forms);
		isNickNameSizeInRange(forms);
		isEmailContainDomain(forms);
		isNickNameContainOnlyKorean(forms);
		isEmailUnDuplicated(forms);
	}

	private static void isEmailUnDuplicated(List<List<String>> forms) {
		Set<String> emailSet = new HashSet<>();
		List<String> emailList = forms.stream().flatMap(List::stream).filter(str -> str.contains(EMAIL_DOMAIN))
			.collect(Collectors.toList());
		for(String email : emailList)
			if(!emailSet.add(email))
				throw new IllegalArgumentException("이메일에 중복이 존재합니다.");
	}

	private static void isNickNameContainOnlyKorean(List<List<String>> forms) {
		for (List<String> form : forms)
			if(!form.get(NICKNAME).matches(KOREAN_PATTERN))
				throw new IllegalArgumentException("닉네임의 길이가 0이거나, 20자 이상입니다.");
	}

	private static void isEmailContainDomain(List<List<String>> forms) {
		for (List<String> form : forms)
			if(!form.get(EMAIL).contains(EMAIL_DOMAIN))
				throw new IllegalArgumentException("이메일의 도메인이 email.com이 아닙니다.");
	}

	private static void isNickNameSizeInRange(List<List<String>> forms) {
		for (List<String> form : forms)
			if(form.get(NICKNAME).length() == 0 || form.get(NICKNAME).length() >= 20)
				throw new IllegalArgumentException("닉네임의 길이가 0이거나, 20자 이상입니다.");
	}

	private static void isEmailSizeInRange(List<List<String>> forms) {
		for (List<String> form : forms)
			if(form.get(EMAIL).length() < 11 || form.get(EMAIL).length() > 20)
				throw new IllegalArgumentException("이메일 길이가 11자 미만이거나, 20자 초과입니다.");
	}

	private static void areEmailAndNickNameNotNull(List<List<String>> forms){
		for (List<String> form : forms)
			if(form.get(EMAIL) == null || form.get(NICKNAME) == null)
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
