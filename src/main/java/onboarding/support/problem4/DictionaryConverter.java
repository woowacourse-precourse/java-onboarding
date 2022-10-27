package onboarding.support.problem4;

public class DictionaryConverter {

    private String convertedString;

    public DictionaryConverter() {

    }

    public String getConvertedString() {
        return convertedString;
    }

    public static boolean isUpper(char alphabet) {
        return alphabet >= 'A' && alphabet <= 'Z';
    }
}
