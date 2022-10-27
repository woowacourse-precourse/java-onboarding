package onboarding.problem2;

public class StringConverter {

    public static String charArrToString(char[] chars) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char aChar : chars) {
            stringBuilder.append(aChar);
        }

        return stringBuilder.toString();
    }
}
