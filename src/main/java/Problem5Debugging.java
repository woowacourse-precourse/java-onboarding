import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5Debugging {
    public static void main(String[] args) {
        int money1 = 50_237;

        List<Integer> answer = new ArrayList<>();

        int money = 176_767;

        List<Integer> moneyUnitArray = new ArrayList<>(Arrays.asList(50000,10000,5000,1000,500,100,50,10,1));


        int numberOfKindOfMoney = moneyUnitArray.size(); //화폐 단위 개수는 총 9개이다.

        for (int i = 0; i < numberOfKindOfMoney ; i++) {
            answer.add(money/moneyUnitArray.get(i));
            money %= moneyUnitArray.get(i);
        }
    }
}
