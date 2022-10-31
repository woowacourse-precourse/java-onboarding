package onboarding.problem3;

public class ClapCounter implements Counter<Integer>{

    public static final int DEFAULT_CLAP_COUNT = 0;
    private Integer clapCount;

    public ClapCounter() {
        this.clapCount = DEFAULT_CLAP_COUNT;
    }

    @Override
    public void countUp() {
        this.clapCount++;
    }

    @Override
    public Integer getCount() {
        return this.clapCount;
    }
}
