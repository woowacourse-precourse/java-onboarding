package service.problem5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5ServiceImpl implements  Problem5Serviceable{

    public List<Integer> getChanges(int money){
        for(int i=0; i<CASH.length; i++){
            CHANGES[i] = (money / CASH[i]);
            money = money - (CASH[i] * CHANGES[i]);
        }

        return Arrays.stream(CHANGES).boxed().collect(Collectors.toList());
    }
}
