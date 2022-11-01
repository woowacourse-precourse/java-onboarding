package onboarding.problem4;

public class ReverseTranslator {

	public String generate(String word){
		StringBuilder reversedWordBuilder = new StringBuilder();

		for(char i : word.toCharArray()){
			int asciiCode = getAscii(i);

			if(!isInLowerRange(asciiCode) && !isInUpperRange(asciiCode)){
				String originText = Character.toString(asciiCode);

				reversedWordBuilder.append(originText);
				continue;
			}

			int reversedAsciiCode = convertToReversedAscii(asciiCode);
			String reversedText = Character.toString(reversedAsciiCode);

			reversedWordBuilder.append(reversedText);
		}

		return reversedWordBuilder.toString();
	}


	private boolean isInLowerRange(int asciiCode){
		ASCII lowerAscii = ASCII.LOWER_CASE_START_INDEX;
		ASCII commonOffset = ASCII.COMMON_INDEX_OFFSET;

		if(asciiCode >= lowerAscii.getValue()
			&& asciiCode <= lowerAscii.getValue() + commonOffset.getValue()){
			return true;
		}

		return false;
	}

	private boolean isInUpperRange(int asciiCode){
		ASCII upperAscii = ASCII.UPPER_CASE_START_INDEX;
		ASCII commonOffset = ASCII.COMMON_INDEX_OFFSET;

		if(asciiCode >= upperAscii.getValue()
			&& asciiCode <= upperAscii.getValue() + commonOffset.getValue()){
			return true;
		}

		return false;
	}


	private int getAscii(char text){
		return (int) text;
	}

	private int convertToReversedAscii(int asciiCode){
		ASCII lowerAscii = ASCII.LOWER_CASE_START_INDEX;
		ASCII upperAscii = ASCII.UPPER_CASE_START_INDEX;
		ASCII commonOffset = ASCII.COMMON_INDEX_OFFSET;

		ASCII startAscii = lowerAscii;

		if(asciiCode <= upperAscii.getValue() + commonOffset.getValue()){
			startAscii = upperAscii;
		}

		return startAscii.getValue() - (asciiCode - startAscii.getValue()) + commonOffset.getValue();
	}
}
