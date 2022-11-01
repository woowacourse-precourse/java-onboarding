package onboarding;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static onboarding.Problem1.*;
import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {

@Test
public static void main(String[] args) {
    List<Integer> pobi=new ArrayList<>();
    List<Integer> crong=new ArrayList<>();
    pobi.add(99);
    pobi.add(102);

    crong.add(211);
    crong.add(212);
    System.out.println(solution(pobi,crong));
}
}