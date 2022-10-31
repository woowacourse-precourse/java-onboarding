package onboarding.prob6.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class JudgeTest {
    private static Stream<Arguments> argumentsStream1() {
        return Stream.of(
            Arguments.of("{안녕}, {안녕} -> true", "안녕", "안녕", true),
            Arguments.of("{제이엠}, {제이엠} -> true", "제이엠", "제이엠", true),
            Arguments.of("{제이엠}, {엠제이} -> true", "제이엠", "엠제이", true),
            Arguments.of("{제이엠}, {제이슨} -> true", "제이엠", "제이슨", true),
            Arguments.of("{제이엠}, {이엠박} -> true", "제이엠", "이엠박", true),
            Arguments.of("{가나다라마바}, {아차타카타가나} -> true", "가나다라마바", "아차타카타가나", true),
            Arguments.of("{가나다라마바}, {아차타카타} -> false", "가나다라마바", "아차타카타", false),
            Arguments.of("{워니}, {워니} -> true", "워니", "워니", true),
            Arguments.of("{워}, {워} -> false", "워", "워", false)
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream1")
    void test1(String message, String origin, String dest, boolean result) {
        Judge judge = new Judge(FormDummy.getForms());
        boolean b = judge.containSameString(origin, dest);
        Assertions.assertEquals(result, b);
    }

    private static Stream<Arguments> argumentsStream2() {
        return Stream.of(
            Arguments.of("{제이슨, 제이엠} -> {true, true}", List.of(
                List.of("kkkk@email", "제이슨"),
                List.of("aaaa@email", "제이엠")
                ), new boolean[]{true, true}),
            Arguments.of("{제이슨, 제이엠, 가나다, 마바사가나} -> {true, true, true, true}", List.of(
                List.of("kkkk@email", "제이슨"),
                List.of("aaaa@email", "제이엠"),
                List.of("bbbb@email", "가나다"),
                List.of("cccc@email", "마바사가나")
            ), new boolean[]{true, true, true, true}),
            Arguments.of("{제이엠, 제이슨, 워니, 엠제이, 이제엠} -> {true, true, false, true, false}", List.of(
                List.of("kkkk@email", "제이엠"),
                List.of("aaaa@email", "제이슨"),
                List.of("bbbb@email", "워니"),
                List.of("cccc@email", "엠제이"),
                List.of("dddd@email", "이제엠")
            ), new boolean[]{true, true, false, true, false}),
            Arguments.of("{박명수, 유재석, 정준하, 정중앙, 정준킹} -> {false, false, true, false, true}", List.of(
                List.of("kkkk@email", "박명수"),
                List.of("aaaa@email", "유재석"),
                List.of("bbbb@email", "정준하"),
                List.of("cccc@email", "정중앙"),
                List.of("dddd@email", "정준킹")
            ), new boolean[]{false, false, true, false, true})
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream2")
    void test2(String message, List<List<String>> forms, boolean[] result) {
        Judge judge = new Judge(forms);
        boolean[] hasSameNickNameArray = judge.getHasSameNickNameArray();
        IntStream.range(0, result.length).forEach(i -> Assertions.assertEquals(result[i], hasSameNickNameArray[i]));
    }

    private static Stream<Arguments> argumentsStream3() {
        return Stream.of(
            Arguments.of("{aaa@mail, bbb@mail}, {true, false} -> {aaa@mail}", List.of(
                List.of("aaa@mail", "제이슨"),
                List.of("bbb@mail", "제엠구")
            ), new boolean[]{true, false}, List.of("aaa@mail")),
            Arguments.of("{aaa@mail, bbb@mail, ccc@mail}, {true, true, true} -> {}", List.of(
                List.of("aaa@mail", "제이슨"),
                List.of("bbb@mail", "제이엠"),
                List.of("ccc@mail", "제이구")
            ), new boolean[]{true, true, true}, List.of("aaa@mail", "bbb@mail", "ccc@mail")),
            Arguments.of("{aaa@mail, bbb@mail, ccc@mail}, {false, false, false} -> {}", List.of(
                List.of("aaa@mail", "박명수"),
                List.of("bbb@mail", "유재석"),
                List.of("ccc@mail", "정준하")
            ), new boolean[]{false, false, false}, Collections.EMPTY_LIST)
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream3")
    void test3(String message, List<List<String>> forms, boolean[] hasSameNickName, List<String> result) {
        Judge judge = new Judge(forms);
        List<String> emails = judge.getResult(hasSameNickName);
        Assertions.assertEquals(result.size(), emails.size());
        IntStream.range(0, result.size()).forEach(i -> Assertions.assertEquals(result.get(i), emails.get(i)));
    }

}
