package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        // 첫 번째 페이지는 홀수여야 한다.
        if(pobi.get(0)%2==0||crong.get(0)%2==0){
            return answer = -1;
        }
        // 두 번째 페이지는 짝수여야 한다.
        else if (pobi.get(1)%2==1||crong.get(1)%2==1) {
            return  answer = 1;
        }
        // 손실 된 페이지가 있어선 안된다.
        else if (pobi.get(0)+1 != pobi.get(1) || crong.get(0)+1 != crong.get(1)) {
            return answer = -1;
        }
        // 첫 번째 페이지나 마지막 페이지는 열 수 없다.
        else if (pobi.get(0)==1||crong.get(0)==1||pobi.get(1)==400||crong.get(1)==400){
            return answer = -1;
        }

        // 조건에 따른 결과값
        if(resultNmb(pobi)>resultNmb(crong)){
            answer = 1;
        } else if (resultNmb(pobi)<resultNmb(crong)) {
            answer = 2;
        }else{
            answer = 0;
        }

        return answer;
    }

    // 모두 더한 값과 곱한 값중 큰 값을 리턴
    public static int resultNmb(List<Integer> character){
        int resultNmb = 0;

        for(int idx = 0; idx<character.size(); idx++){
            int additionNumber = addition(sprNmb(character.get(idx)));
            int multipleNumber = multiple(sprNmb(character.get(idx)));
            resultNmb = resultNmb>(additionNumber>multipleNumber?additionNumber:multipleNumber)?resultNmb:(additionNumber>multipleNumber?additionNumber:multipleNumber);
        }
        return resultNmb;
    }

    // 숫자를 문자열로 변경후 각 자리수를 다시 인트 배열로 리턴
    public static int[] sprNmb(int characterNmb){
        return Stream.of(Integer.toString(characterNmb).split("")).mapToInt(Integer::parseInt).toArray();
    }

    // 인트 배열로 받은 전달인자 값을 모두 순차적으로 더해준 값을 리턴
    public static int addition(int[] nmbArray){
        return Arrays.stream(nmbArray).reduce((a,b)-> a+b).getAsInt();
    }

    // 인트 배열로 받은 전달인자 값을 모두 순차적으로 곱해준 값을 리턴
    public static int multiple(int[] nmbArray){
        return Arrays.stream(nmbArray).reduce((a,b)-> a*b).getAsInt();
    }
}