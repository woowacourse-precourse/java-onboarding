package onboarding.problem1;

public class Book {

	private int leftPageNumber;
	private int rightPageNumber;

	public int getLeftPageNumber() {
		return leftPageNumber;
	}

	public int getRightPageNumber() {
		return rightPageNumber;
	}


	private Book(int leftPageNumber, int rightPageNumber) {
		this.leftPageNumber = leftPageNumber;
		this.rightPageNumber = rightPageNumber;
	}


	public static Book.BookBuilder builder() {
		return new Book.BookBuilder();
	}

	public static class BookBuilder {
		private int leftPageNumber;
		private int rightPageNumber;


		BookBuilder() {
		}

		public Book.BookBuilder leftPageNumber(int leftPageNumber) {
			this.leftPageNumber = leftPageNumber;
			return this;
		}

		public Book.BookBuilder rightPageNumber(int rightPageNumber) {
			this.rightPageNumber = rightPageNumber;
			return this;
		}

		public Book build() {
			return new Book(this.leftPageNumber, this.rightPageNumber);
		}

	}
}
