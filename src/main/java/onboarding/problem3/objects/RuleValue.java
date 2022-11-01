package onboarding.problem3.objects;

public enum RuleValue {

    THREE("3"),
    SIX("6"),
    NINE("9");

    private final String value;

    RuleValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
