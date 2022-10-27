package onboarding.support.problem4;

public class DictionaryConverter {

    private String convertedString;

    public DictionaryConverter() {

    }

    public String getConvertedString() {
        return convertedString;
    }

    private static boolean checkEmptySpace(char original) {
        return original == Constants.getEmptySpace();
    }

    public static int getBaseCharacterASCII(char alphabet) {
        int base = Constants.getLowerCaseBase();
        if (isUpper(alphabet)) base = Constants.getUpperCaseBase();
        return base;
    }

    public static boolean isUpper(char alphabet) {
        return alphabet >= 'A' && alphabet <= 'Z';
    }
}
