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


	public boolean isValid(String word){
		String wordWithoutSpace = word.replaceAll(" ", "");
		Pattern pattern = Pattern.compile("^[a-zA-Z]*$");
		Matcher matcher = pattern.matcher(wordWithoutSpace);

		return matcher.find();
	}


	private int getAscii(char text){
		return (int) text;
	}

	private int convertToReversedAscii(int asciiCode){
		if(asciiCode == ASCII.WHITE_SPACE.getValue()){
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
