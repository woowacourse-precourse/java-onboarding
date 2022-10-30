package onboarding.problem6;

public class MemberList {
	public static final int MAX_SIZE = 100_000;

	public boolean isFull(int length) {
		return length == MAX_SIZE;
	}
}
