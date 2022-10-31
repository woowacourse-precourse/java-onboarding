package onboarding.problem2;

class Deleter {
    private final StringBuilder cipher;

    public Deleter(StringBuilder cipher) {
        this.cipher = cipher;
    }

    public void delete(RangeDto range) {
        if (range.getTo() == range.getFrom()) {
            return;
        }
        cipher.delete(range.getFrom(), range.getTo() + 1);
    }
}
