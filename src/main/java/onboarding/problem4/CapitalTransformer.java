package onboarding.problem4;

import java.util.stream.IntStream;

class CapitalTransformer implements Transformer {
    private final StringBuilder capitalBuilder;

    public CapitalTransformer(String target) {
        this.capitalBuilder = new StringBuilder(target);
        IntStream.range(0, capitalBuilder.length()).forEach(this::transform);
    }

    public String getTransformed() {
        return capitalBuilder.toString();
    }

    private void transform(int index) {
        if (!isCapital(index)) {
            return;
        }
        char afterAlphabet = inverseAlphabet(capitalBuilder.charAt(index));
        capitalBuilder.setCharAt(index, afterAlphabet);
    }

    private boolean isCapital(int index) {
        return 'A' <= capitalBuilder.charAt(index) && capitalBuilder.charAt(index) <= 'Z';
    }

    private Character inverseAlphabet(char before) {
        return (char) ('Z' - (before - 'A'));
    }
}
