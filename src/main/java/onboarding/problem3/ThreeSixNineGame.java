package onboarding.problem3;

public class ThreeSixNineGame implements IMiniGame<ThreeSixNine>{


	@Override
	public ThreeSixNine run(ThreeSixNine data) {
		for(long i = data.getStartClapCount(); i <= data.getEndClapCount(); i++){
			data.addExecutedClapCount(getExecutedClapCount(i));
		}

		return data;
	}


	private int getExecutedClapCount(long clap){
		int executionCount = 0;

		for(char i : Long.toString(clap).toCharArray()){
			int value = Character.getNumericValue(i);

			if(value != 0 && value % 3 == 0){
				executionCount++;
			}
		}

		return executionCount;
	}
}
