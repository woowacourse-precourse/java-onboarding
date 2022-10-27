package onboarding;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Calculator calculator = new Calculator();
        int pobiNum = calculator.getMaxNumbers(pobi);
        int crongNum = calculator.getMaxNumbers(crong);

        if(pobiNum == -1 || crongNum == -1) return -1;
        else if(pobiNum > crongNum) return 1;
        else if(pobiNum < crongNum) return 2;
        else return 0;
    }

}
class Calculator {
    public Calculator(){}
    public boolean validateCheck(List<Integer> numArr){
        return Math.abs(numArr.get(0) - numArr.get(1)) == 1;
    }

    public int getMaxNumbers(List<Integer> numArr){
        if(!validateCheck(numArr)) return -1;
        List<String> strArr = convertStrArr(numArr);
        return Math.max(calcNums(strArr,"sum"), calcNums(strArr,"mul"));
    }

    public List<String> convertStrArr(List<Integer> numArr) {
        return numArr.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    public List<Integer> convertStrToNumArr(List<String> arr, int index){
        List<Integer> list = new LinkedList<>();
        for(char temp : arr.get(index).toCharArray()){
            list.add(temp - '0');
        }
        return list;
    }

    public int sumNums(List<Integer> list){
        return list.stream().reduce(0, Integer::sum);
    }

    public int mulNums(List<Integer> arr){
        return arr.stream().reduce(1, (a, b) -> a * b);
    }

    public int calcNums(List<String> arr, String type) {
        List<Integer> leftNum = convertStrToNumArr(arr,0);
        List<Integer> rightNum = convertStrToNumArr(arr,1);
        if(type.equals("sum")){
            return Math.max(sumNums(leftNum),sumNums(rightNum));
        }
        return Math.max(mulNums(leftNum),mulNums(rightNum));
    }
}