package onboarding.problem1;

import onboarding.problem1.verifiable.HasInRangePageNumbers;
import onboarding.problem1.verifiable.IsEvenNumberWithSecondPage;
import onboarding.problem1.verifiable.IsOddNumberWithFirstPage;
import onboarding.problem1.verifiable.IsSequentialPageNumbers;

import java.util.List;

public class AddingPagesCommandImpl implements AddingPagesCommand {
    private final Verifier verifier = new Verifier();

    public AddingPagesCommandImpl() {
        verifier.addRule(new HasInRangePageNumbers(1, 400));
        verifier.addRule(new IsSequentialPageNumbers(1));
        verifier.addRule(new IsOddNumberWithFirstPage());
        verifier.addRule(new IsEvenNumberWithSecondPage());
    }

    @Override
    public void execute(Pager pager, List<Integer> pageNumbers) {
        if (verifier.validates(pageNumbers)) {
            pager.addPages(pageNumbers);
        }
    }
}
