package onboarding.P1;

import java.util.List;

import static onboarding.P1.PageVerification.*;
import static onboarding.P1.PageCalculation.*;

public class GameResult {
    public int BookGamePlayResult(List<Integer> pobi, List<Integer> crong){
        if(!PageCheck(pobi) || !PageCheck(crong)){
            return -1;
        }
        if(CalculateResult(pobi) > CalculateResult(crong)){
            return 1;
        }else if(CalculateResult(pobi) < CalculateResult(crong)){
            return 2;
        }else{
            return 0;
        }
    }
}
