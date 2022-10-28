package onboarding.problem1;

import onboarding.problem1.utils.Validator;

import java.util.List;

public class Pages {
    private int left;
    private int right;

    public Pages(List<Integer> pages) {
        this.left = pages.get(0);
        this.right = pages.get(1);
    }
}
