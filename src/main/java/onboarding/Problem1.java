package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1 problem = new Problem1();
        int answer = Integer.MAX_VALUE;

        int pobinumber = problem.findLargeNumber(pobi);
        int crongnumber = problem.findLargeNumber(crong);

        answer = problem.resultOutput(pobinumber, crongnumber);
        return answer;
    }

    public int findLargeNumber(List<Integer> name){
        Problem1 problem = new Problem1();
        int maxnumber = 0;

        int firstnumber = problem.largeValueEachNum(name.get(0));
        int secondnumber = problem.largeValueEachNum(name.get(1));

        if(firstnumber >= secondnumber) {
            maxnumber = firstnumber;
        } else {
            maxnumber = secondnumber;
        }

        return maxnumber;
    }

    public int largeValueEachNum(int number){
        int sumnum = 0;
        int multiplenum = 1;
        int maxnumber = 0;

        String[] splitstring = Integer.toString(number).split("");

        for(int i=0; i<splitstring.length; i++) {
            sumnum += Integer.parseInt(splitstring[i]);
            multiplenum *= Integer.parseInt(splitstring[i]);
        }

        if(sumnum >= multiplenum) {
            maxnumber = sumnum;
        } else {
            maxnumber = multiplenum;
        }

        return maxnumber;
    }

    public int resultOutput(int pobinumber, int crongnumber){
        int result = 0;

        if(pobinumber == crongnumber) {
            result = 0;
        } else if(pobinumber > crongnumber) {
            result = 1;
        } else {
            result = 2;
        }

        return result;
    }
}