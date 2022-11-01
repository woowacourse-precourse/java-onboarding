package onboarding.problem4;

public class FrogTransformer implements Transformer {
    private final String target;

    public FrogTransformer(NormalWord words) {
        this.target = words.getWords();
    }

    public String getTransformed() {
        String CapitalTransformed = new CapitalTransformer(target).getTransformed();
        return new SmallTransformer(CapitalTransformed).getTransformed();
    }
}
