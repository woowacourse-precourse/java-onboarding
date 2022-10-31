package onboarding.problem4;

class SmallTransformer implements Transformer {
    private final StringBuilder smallBuilder;

    public SmallTransformer(String target) {
        this.smallBuilder = new StringBuilder(target);
        for (int i = 0; i < smallBuilder.length(); i++) {
            transform(i);
        }
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
