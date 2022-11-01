package onboarding;

public class Page {
	private int left;
	private int right;

	public Page(int left, int right) {
		this.left = left;
		this.right = right;
	}

	public int getLeft() {
		return left;
	}

	public int getRight() {
		return right;
	}

	public boolean isValid() {
		if (!isRgihtPage() || isFirstPage() || isLastpage()) {
			return false;
		}
		return true;
	}

	public boolean isRgihtPage() {
		return this.right - this.left == 1;
	}

	public boolean isFirstPage() {
		if (left == 1) {
			return true;
		}

		if (right == 2) {
			return true;
		}

		return false;
	}

	public boolean isLastpage() {
		if (left == 399) {
			return true;
		}

		if (right == 400) {
			return true;
		}

		return false;
	}

}

