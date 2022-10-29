package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int getUserCompare(List<Integer> user){
        int add = Math.max(getDigitsAdd(user.get(0).toString()), getDigitsAdd(user.get(1).toString()));
        int multiply = Math.max(getDigitsMultiply(user.get(0).toString()), getDigitsMultiply(user.get(1).toString()));
        return Math.max(add,multiply);
    }

    public static int getDigitsMultiply(String number){
        Stream<String> stream = Arrays.asList(number.split("")).stream();
        return stream.mapToInt(e -> Integer.parseInt(e)).reduce(1,(a,b)->a*b);
    }

    public static int getDigitsAdd(String number){
        Stream<String> stream = Arrays.asList(number.split("")).stream();
        return stream.mapToInt(e -> Integer.parseInt(e)).sum();
    }

    public static boolean isValidRange(List<Integer> user){
        for(int i=0;i<2;i++)
            if (user.get(i).intValue()<1 || user.get(i).intValue()>400) return false;
        return true;
    }

    public static boolean isValidValue(List<Integer> user){
        if (user.get(0).intValue()%2!=1 || user.get(1).intValue()%2!=0) return false;
        return true;
    }

    public static boolean isValidPage(List<Integer> user){
        if (Math.abs(user.get(1).intValue()-user.get(0).intValue())!=1) return false;
        return true;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!isValidRange(pobi) || !isValidRange(crong))
            return -1;
        if (!isValidValue(pobi) || !isValidValue(crong))
            return -1;
        if (!isValidPage(pobi) || !isValidPage(crong))
            return -1;

        int pobiMax = getUserCompare(pobi);
        int crongMax = getUserCompare(crong);

        if (pobiMax > crongMax) answer=1;
        else if (pobiMax < crongMax) answer=2;
        else answer=0;

        return answer;
    }
}