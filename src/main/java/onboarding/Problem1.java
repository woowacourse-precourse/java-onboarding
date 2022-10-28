package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Problem1 {
  public static int solution(List<Integer> pobi, List<Integer> crong) {
    int answer = Integer.MAX_VALUE;
    pobi = BookPageSelect();
    crong = BookPageSelect();

    return answer;
  }

  private static List<Integer> BookPageSelect(){
    List<Integer> bookPageSelect = new ArrayList<>();
    Random random = new Random();
    int randomPageSelect = Integer.MAX_VALUE;
    do{
      randomPageSelect = random.nextInt(200)*2+1;
    }while(randomPageSelect==1||randomPageSelect==399);

    bookPageSelect.add(randomPageSelect);
    bookPageSelect.add(randomPageSelect+1);

    return bookPageSelect;
  }

}