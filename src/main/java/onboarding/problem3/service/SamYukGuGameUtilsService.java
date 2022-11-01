package onboarding.problem3.service;

import onboarding.problem3.constants.SamYukGuGameConstants;

import java.util.ArrayList;
import java.util.List;

public class SamYukGuGameUtilsService {
    public static int getHandClapCount(int value){
        return getCountSamYukGuInList(integerSlice(value));
    }

    private static ArrayList<Integer> integerSlice(int value){
        ArrayList<Integer> slicedIntList = new ArrayList<>();

        while (value > 0){
            slicedIntList.add(value % 10);
            value /= 10;
        }

        return slicedIntList;
    }

    private static int getCountSamYukGuInList(ArrayList<Integer> list){
        int result = 0;

        for(int value : list){
            result += checkSamYukGu(value);
        }

        return result;
    }

    private static int checkSamYukGu(int value){
        switch (value){
            case SamYukGuGameConstants.SAM:
            case SamYukGuGameConstants.YUK:
            case SamYukGuGameConstants.GU:
                return 1;
        }
        return 0;
    }


}
