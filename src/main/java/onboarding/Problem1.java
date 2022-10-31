package onboarding;

import onboarding.problem1.AddingPagesCommandImpl;
import onboarding.problem1.PageNumberGame;
import onboarding.problem1.Pager;
import onboarding.problem1.ResultCommandImpl;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        PageNumberGame game = new PageNumberGame();
        game.setAddingPagesCommand(new AddingPagesCommandImpl());
        game.setResultCommand(new ResultCommandImpl());
        Pager pager = new Pager();
        game.addPages(pager, pobi);
        game.addPages(pager, crong);
        return game.result(pager);
    }
}