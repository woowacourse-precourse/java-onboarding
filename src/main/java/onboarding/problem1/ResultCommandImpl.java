package onboarding.problem1;

import onboarding.problem1.gradable.MulEachDigits;
import onboarding.problem1.gradable.SumEachDigits;

public class ResultCommandImpl implements ResultCommand {
    private final Grader grader = new Grader();

    public ResultCommandImpl() {
        grader.addRule(new SumEachDigits());
        grader.addRule(new MulEachDigits());
    }

    @Override
    public int execute(Pager pager) {
        Returner returner = new Returner(pager.apply(grader::grade));
        return returner.result();
    }
}
