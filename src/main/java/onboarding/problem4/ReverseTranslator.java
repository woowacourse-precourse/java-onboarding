package onboarding.problem4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReverseTranslator {

	public String generate(String word){
		StringBuilder reversedWordBuilder = new StringBuilder();

		for(char i : word.toCharArray()){
			int asciiCode = getAscii(i);
			int reversedAsciiCode = convertToReversedAscii(asciiCode);
			String reversedText = Character.toString(reversedAsciiCode);

			reversedWordBuilder.append(reversedText);
		}

		return reversedWordBuilder.toString();
	}


	private boolean isInRange(int asciiCode){
		ASCII lowerAscii = ASCII.LOWER_CASE_START_INDEX;
		ASCII upperAscii = ASCII.UPPER_CASE_START_INDEX;
		ASCII commonOffset = ASCII.COMMON_INDEX_OFFSET;

		boolean isRange = false;

		if(asciiCode >= lowerAscii.getValue()
			&& asciiCode <= lowerAscii.getValue() + commonOffset.getValue()){
			isRange = true;
		}

		if(asciiCode >= upperAscii.getValue()
			&& asciiCode <= upperAscii.getValue() + commonOffset.getValue()){
			isRange = true;
		}

		return isRange;
	}


	private int getAscii(char text){
		return (int) text;
	}

	private int convertToReversedAscii(int asciiCode){
		if(!isInRange(asciiCode)){
			return asciiCode;
		}


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
