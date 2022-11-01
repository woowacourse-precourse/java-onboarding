package onboarding.problem7;

import java.util.List;

public class InputFriends {

	public static final int MIN_FRIENDS_SIZE = 1;
	public static final int MAX_FRIENDS_SIZE = 10000;

	public InputFriends(List<List<String>> inputFriends) {
		validateInputFriends(inputFriends);
		for (List<String> inputFriend : inputFriends) {
			Friend friend = new Friend(inputFriend);
		}
	}

	private void validateInputFriends(List<List<String>> inputFriends) {
		if (inputFriends.size() < MIN_FRIENDS_SIZE || inputFriends.size() > MAX_FRIENDS_SIZE) {
			throw new IllegalArgumentException("친구 관계 정보는 1 이상 10,000 이하인 리스트입니다.");
		}
	}
}
