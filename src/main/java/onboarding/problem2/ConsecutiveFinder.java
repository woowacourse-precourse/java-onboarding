package onboarding.problem2;

class ConsecutiveFinder {
    private final StringBuilder target;

    public ConsecutiveFinder(StringBuilder target) {
        this.target = target;
    }


    public int findConsequence(int last) {
        int sameStart = last;

        while (isBeforeSame(last, sameStart)) {
            sameStart--;
        }
        return sameStart;
    }

    private boolean isBeforeSame(int last, int sameStart) {
        if (sameStart == 0) {
            return false;
        }
        return target.charAt(last) == target.charAt(sameStart - 1);
    }
}
