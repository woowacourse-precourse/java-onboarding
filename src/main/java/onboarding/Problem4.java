package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String chars = word.chars().parallel()
                .mapToObj(d -> {
                    char c = (char) d;
                    if (Character.isLetter(c)) {
                        if (Character.isUpperCase(c)) {
                            d = 'Z' - d + 'A';
                        } else {
                            d = 'z' - d + 'a';
                        }
                        c = (char) d;
                    }
                    return c;
                })
                // https://www.digitalocean.com/community/tutorials/java-stream-collect-method-examples
                .collect(StringBuilder::new,
                    (builder, c) -> builder.append(c),
                    // StringBuilder implements CharSequence
                    StringBuilder::append
                ).
                // StringBuilder
                toString();
        String answer = chars.toString();
        return answer;
    }
}
