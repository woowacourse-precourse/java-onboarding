package onboarding.problem4;

public class TreeFrog implements Frog {
    private final String momSays;

    public TreeFrog(String momSays) {
        this.momSays = momSays;
    }

    @Override
    public String repeatAfter() {
        String[] spellings = momSays.split("");
        for (int index = 0; index < spellings.length; index++) {
            char spelling = spellings[index].charAt(0);
            spellings[index] = convert(spelling);
        }
        return String.join("", spellings);
    }

    /**
     * @param spelling 은 1글자 char이다.
     * @return 청개구리 사전에 의해 변환된 char을 다시 String으로 변환하여 반환
     */
    private String convert(char spelling) {
        // lower case
        if ('a' <= spelling && spelling <= 'z') {
            spelling = (char) ('a' + ('z' - spelling));
        }
        //upper case
        else if ('A' <= spelling && spelling <= 'Z') {
            spelling = (char) ('A' + ('Z' - spelling));
        }
        return String.valueOf(spelling);
    }
}
