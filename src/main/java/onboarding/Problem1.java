package onboarding;

import static onboarding.Problem1.Status.*;

import java.util.List;

public class Problem1 {

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		final Member POBI = Member.of("pobi", pobi);
		final Member CRONG = Member.of("crong", crong);
		return Game.play(POBI, CRONG).getResult();
	}

	public enum Status {
		POBI_WIN(1), CRONG_WIN(2), DRAW(0), ERROR(-1);

		private final int result;

		Status(int result) {
			this.result = result;
		}

		public int getResult() {
			return result;
		}
	}

	public static class Member {

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

	public static class Page {

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

	public static class Book {

		public static final int MIN_PAGE = 1;
		public static final int MAX_PAGE = 400;

		public static boolean open(Page page) {
			return (isOdd(page.getLeft()) && isEven(page.getRight())) && isConsecutive(page) && !isOutOfRange(page);
		}

		private static boolean isOutOfRange(Page page) {
			return page.getLeft() <= MIN_PAGE || page.getRight() >= MAX_PAGE;
		}

		private static boolean isConsecutive(Page page) {
			return page.getLeft() + 1 == page.getRight();
		}

		private static boolean isEven(int number) {
			return !isOdd(number);
		}

		private static boolean isOdd(int number) {
			return (number & 1) == 1;
		}

	}

	public static class Game {

		public static int calculateScore(Page page) {
			return Math.max(
				Math.max(addAllDigits(page.getLeft()), addAllDigits(page.getRight())),
				Math.max(multiplyAllDigits(page.getLeft()), multiplyAllDigits(page.getRight()))
			);
		}

		public static Status play(Member pobi, Member crong) {
			if (!Book.open(pobi.getPage()) || !Book.open(crong.getPage())) {
				return ERROR;
			}

			final int pobiScore = calculateScore(pobi.getPage());
			final int crongScore = calculateScore(crong.getPage());

			if (pobiScore > crongScore) {
				return POBI_WIN;
			} else if (pobiScore < crongScore) {
				return CRONG_WIN;
			} else {
				return DRAW;
			}
		}

		private static int multiplyAllDigits(int number) {
			int score = 1;
			while (number != 0) {
				score *= number % 10;
				number /= 10;
			}
			return score;
		}

		private static int addAllDigits(int number) {
			int score = 0;
			while (number != 0) {
				score += number % 10;
				number /= 10;
			}
			return score;
		}

	}

}