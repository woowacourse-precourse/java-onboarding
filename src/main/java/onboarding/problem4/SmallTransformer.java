package onboarding.problem4;

import java.util.stream.IntStream;

class SmallTransformer implements Transformer {
    private final StringBuilder smallBuilder;

    public SmallTransformer(String target) {
        this.smallBuilder = new StringBuilder(target);
        IntStream.range(0, smallBuilder.length()).forEach(this::transform);
    }

    public String getTransformed() {
        return smallBuilder.toString();
    }

    private void transform(int index) {
        if (!isCapital(index)) {
            return;
        }
        char afterAlphabet = inverseAlphabet(smallBuilder.charAt(index));
        smallBuilder.setCharAt(index, afterAlphabet);
    }

    private boolean isCapital(int index) {
        return 'a' <= smallBuilder.charAt(index) && smallBuilder.charAt(index) <= 'z';
    }

    private Character inverseAlphabet(char before) {
        return (char) ('z' - (before - 'a'));
    }
}
