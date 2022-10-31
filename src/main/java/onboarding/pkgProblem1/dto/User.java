package onboarding.pkgProblem1.dto;

import onboarding.pkgProblem1.service.CalculateMaxService;

import java.util.List;

public class User {
    private static CalculateMaxService calService = new CalculateMaxService();
    private int returnNumberIfWin;
    private List<Integer> userPageList;
    private int maxScore;

    public User(int returnNumberIfWin, List<Integer> userPageList) {
        this.returnNumberIfWin = returnNumberIfWin;
        this.userPageList = userPageList;
        this.maxScore = calService.ReturnMaxScore(userPageList);
    }

    public int getMaxScore() {
        return maxScore;
    }

    public int getReturnNumberIfWin() { return returnNumberIfWin; }
}
