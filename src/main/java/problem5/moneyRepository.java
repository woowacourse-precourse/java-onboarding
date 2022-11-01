package problem5;

public class moneyRepository {

    // 화폐 단위 저장소 기능
    public static int[] postMoney(){

        int[] moneyRepository = new int[9];

        moneyRepository[0] = 50000;
        moneyRepository[1] = 10000;
        moneyRepository[2] = 5000;
        moneyRepository[3] = 1000;
        moneyRepository[4] = 500;
        moneyRepository[5] = 100;
        moneyRepository[6] = 50;
        moneyRepository[7] = 10;
        moneyRepository[8] = 1;

        return moneyRepository;
    }
}
