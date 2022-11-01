package problem6.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NickNameValidator {
    private final List<String> nickNames;
    private final String REGEX = "^[가-힣]*$";

    public NickNameValidator(Map<String, String> forms) {
        this.nickNames = new ArrayList<>(forms.values());
    }

    public void validate() {
        for (String nickName : nickNames) {
            validateNickNamePattern(nickName);
            validateNickNameLength(nickName);
        }
    }

    private void validateNickNamePattern(String nickName) {
        if(!isValidNickNamePattern(nickName)) {
            throw new IllegalArgumentException("한글로 이루어진 닉네임만 입력 가능합니다.");
        }
    }
    private boolean isValidNickNamePattern(String nickName) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(nickName);
        return matcher.matches();
    }

    private void validateNickNameLength(String nickName) {
        if(!isValidNickNameLength(nickName)) {
            throw new IllegalArgumentException("1 이상 20 미만 길이의 닉네임만 입력 가능합니다.");
        }
    }

    private boolean isValidNickNameLength(String nickName) {
        int length = nickName.length();
        return (length >= 1) && (length < 20);
    }
}
