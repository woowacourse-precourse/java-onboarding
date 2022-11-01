package onboarding.problem1.service;

import onboarding.problem1.domain.Score;
import onboarding.problem1.utils.Constants;

public class GameResultService {
    public static int getResult(Score pobi, Score crong){
        int pobiMaxScore = pobi.getMaxScore();
        int crongMaxScore = crong.getMaxScore();

        if(pobiMaxScore > crongMaxScore){
            return Constants.POBI_WIN_RESULT;
        }
        if(crongMaxScore > pobiMaxScore){
            return Constants.CRONG_WIN_RESULT;
        }

        return Constants.DRAW_RESULT;
    }
}
