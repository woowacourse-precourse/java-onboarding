package onboarding.problem1;

import java.util.List;

public class PageNumberGame {
    private AddingPagesCommand addingPagesCommand;
    private ResultCommand resultCommand;

    public void setAddingPagesCommand(AddingPagesCommand addingPagesCommand) {
        this.addingPagesCommand = addingPagesCommand;
    }

    public void setResultCommand(ResultCommand resultCommand) {
        this.resultCommand = resultCommand;

    }

    public void addPages(Pager pager, List<Integer> pageNumbers) {
        addingPagesCommand.execute(pager, pageNumbers);
    }

    public int result(Pager pager) {
        return resultCommand.execute(pager);
    }
}
