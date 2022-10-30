package onboarding;

import java.util.List;

class Problem1 {

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;
		return answer;
	}

	private enum Status {
		POBI_WIN(1), CRONG_WIN(2), DRAW(0), ERROR(-1);

		private final int result;

		Status(int result) {
			this.result = result;
		}

		public int getResult() {
			return result;
		}
	}

	private static class Member {

		private String nickname;
		private Page page;

		private Member(String nickname, Page page) {
			this.nickname = nickname;
			this.page = page;
		}

		public static Member of(String nickname, List<Integer> pages) {
			return new Member(nickname, Page.of(pages));
		}

		public String getNickname() {
			return nickname;
		}

		public Page getPage() {
			return page;
		}

	}

	private static class Page {

		private int left;
		private int right;

		private Page(int left, int right) {
			this.left = left;
			this.right = right;
		}

		public static Page of(List<Integer> pages) {
			return new Page(pages.get(0), pages.get(1));
		}

		public int getLeft() {
			return left;
		}

		public int getRight() {
			return right;
		}

	}

	private static class Book {

		public static final int MIN_PAGE = 1;
		public static final int MAX_PAGE = 400;

	}

	private static class Game {

	}

}