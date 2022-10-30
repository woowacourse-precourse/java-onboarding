package onboarding.problem3.service;

import java.util.ArrayList;

public class SamYukGuGameUtilsService {

    public static ArrayList<Integer> integerSlice(int value){
        ArrayList<Integer> slicedIntList = new ArrayList<>();

        while (value > 0){
            slicedIntList.add(value % 10);
            value /= 10;
        }

        return slicedIntList;
    }


}
