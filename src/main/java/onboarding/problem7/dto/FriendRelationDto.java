package onboarding.problem7.dto;

import java.util.List;

public class FriendRelationDto {
	private String friendA;
	private String friendB;

	public FriendRelationDto(List<String> form) {
		this.friendA = form.get(0);
		this.friendB = form.get(1);
	}

	public String getFriendA() {
		return friendA;
	}

	public String getFriendB() {
		return friendB;
	}
}
