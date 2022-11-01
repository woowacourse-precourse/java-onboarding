package onboarding.problem3;

public class Game {
    private GameRecord gameRecord;
    public Integer run(Integer number){
        this.gameRecord = GameRecord.generateEmptyCount();
        for(int i = 1 ; i <=number; i++){
             this.gameRecord = gameRecord.plus(Number.calculateContainThreeOrSizeOrNineCount(i));
        }
        return gameRecord.count();
    }
}
