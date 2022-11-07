package onboarding.problem7;

import java.util.List;

import static onboarding.common.CommonMessage.PERMIT_ONLY_LOWERCASE;
import static onboarding.common.CommonValidator.isOnlyContainsLowerCase;

public class InputValueValidator {

    private static final int MIN_VALUE = 1;

    private static final int MAX_VALUE_FOR_STRING = 30;
    private static final int MAX_VALUE_FOR_LIST = 10_000;

    // 전체 검증
    public void validateInputValue(String user, List<List<String>> friends, List<String> visitors) {
        if (isNotValidLength(user)) {
            throw new IllegalArgumentException("닉네임의 길이는 1 이상 30 이하여야 합니다.");
        }

        if (!isOnlyContainsLowerCase(user)) {
            throw new IllegalArgumentException(PERMIT_ONLY_LOWERCASE.message());
        }

        validateFriendsList(friends);

        validateVisitorList(visitors);
    }

    // 문자열 길이 검증
    private boolean isNotValidLength(String name) {
        int length = name.length();
        return MIN_VALUE > length || length > MAX_VALUE_FOR_STRING;
    }

    // 아이디는 소문자만!
    private boolean notOnlyContainsLowerCase(String name) {
        return !name.matches("^[a-z]*$");  // 소문자만 있을 때 true를 반환하는 정규식이라고 한다.
    }

    // friends 리스트/배열 검증
    private void validateFriendsList(List<List<String>> friendsList) {
        int size = friendsList.size();
        if (size < MIN_VALUE || MAX_VALUE_FOR_LIST < size) {
            throw new IllegalArgumentException("배열의 길이가 1 이상 10,000 이하여야 합니다.");
        }

        for (List<String> nameList : friendsList) {
            for (String name : nameList) {
                if (isNotValidLength(name) || notOnlyContainsLowerCase(name)) {
                    throw new IllegalArgumentException("닉네임의 길이는 1 이상 30 이하여야 합니다.");
                }
            }
        }
    }

    // visitor 리스트/배열 검증
    private void validateVisitorList(List<String> visitorList) {
        int size = visitorList.size();
        if (MAX_VALUE_FOR_LIST < size) {
            throw new IllegalArgumentException("배열의 길이가 0 이상 10,000 이하여야 합니다.");
        }

        for (String name : visitorList) {
            if (isNotValidLength(name) || notOnlyContainsLowerCase(name)) {
                throw new IllegalArgumentException("닉네임의 길이는 1 이상 30 이하여야 합니다.");
            }
        }
    }


}
