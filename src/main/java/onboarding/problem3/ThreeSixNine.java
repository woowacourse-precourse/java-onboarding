package onboarding.problem3;


public class ThreeSixNine implements IMiniGameData {

	private int executedClapCount;
	private long endClapCount;
	private long startClapCount;

	public long getEndClapCount(){
		return this.endClapCount;
	}

	public long getStartClapCount(){
		return this.startClapCount;
	}

	public void addExecutedClapCount(int executedClapCount){
		this.executedClapCount += executedClapCount;
	}

	public int getExecutedClapCount(){
		return this.executedClapCount;
	}

	private ThreeSixNine(int executedClapCount, long endClapCount, long startClapCount){
		this.executedClapCount = executedClapCount;
		this.endClapCount = endClapCount;
		this.startClapCount = startClapCount;
	}


	public static ThreeSixNineBuilder builder() {
		return new ThreeSixNineBuilder();
	}

	public static class ThreeSixNineBuilder {

		private int executedClapCount;
		private long endClapCount;
		private long startClapCount;

		ThreeSixNineBuilder() {
		}

		public ThreeSixNineBuilder executedClapCount(int executedClapCount) {
			this.executedClapCount = executedClapCount;
			return this;
		}

		public ThreeSixNineBuilder endClapCount(long endClapCount) {
			this.endClapCount = endClapCount;
			return this;
		}

		public ThreeSixNineBuilder startClapCount(long startClapCount) {
			this.startClapCount = startClapCount;
			return this;
		}

		public ThreeSixNine build() {
			return new ThreeSixNine(this.executedClapCount, this.endClapCount, this.startClapCount);
		}

	}
}
