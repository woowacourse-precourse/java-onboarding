package onboarding.problem1.controller;

import onboarding.problem1.domain.Score;
import onboarding.problem1.service.GameResultService;
import onboarding.problem1.service.ScoreService;
import onboarding.problem1.utils.Constants;
import onboarding.problem1.utils.validator.InputListValidator;
import onboarding.problem1.utils.validator.exception.InvalidListException;
import java.util.List;

public class PageNumberGame {
    private int result;

    public PageNumberGame startGame(List<Integer> pobi, List<Integer> crong){
        try{
            InputListValidator.validateArray(pobi);
            InputListValidator.validateArray(crong);

            Score pobiScore= new Score(ScoreService.calculateScore(pobi));
            Score crongScore = new Score(ScoreService.calculateScore(crong));

            this.result= GameResultService.getResult(pobiScore, crongScore);

        }catch (InvalidListException e){
            this.result = Constants.EXCEPT_RESULT;
        }
        return this;
    }

    public int getGameResult(){
        return result;
    }
}
