package onboarding;

import onboarding.problem1.service.PageGameService;
import onboarding.problem2.validation.CryptogramValidator;
import onboarding.problem3.validation.ThreeSixNineValidator;
import onboarding.problem4.validation.BlueFrogValidator;
import onboarding.problem5.validation.WalletValidator;
import onboarding.problem6.validation.CrewValidator;
import onboarding.problem7.validation.MemberValidator;
import onboarding.problem7.validation.RelationsValidator;
import onboarding.problem7.validation.VisitorsValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest {
    @Nested
    @DisplayName("문제 1 테스트")
    class Problem1Test {
        @Nested
        @DisplayName("문제 1 성공 케이스 테스트")
        class Problem1SuccessTest {
            @Test
            @DisplayName("최고 점수가 같을 때 0을 반환")
            void case1() {
                List<Integer> pobi = List.of(97, 98);
                List<Integer> crong = List.of(197, 198);
                int result = PageGameService.TIE;
                assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
            }

            @Test
            @DisplayName("포비의 최고 점수가 더 높을 때 1 반환")
            void case2() {
                List<Integer> pobi = List.of(131, 132);
                List<Integer> crong = List.of(211, 212);
                int result = PageGameService.PLAYER1_WINNER_RETURN_VALUE;
                assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
            }

            @Test
            @DisplayName("크롱의 최고 점수가 더 높을 때 2 반환")
            void case3() {
                List<Integer> pobi = List.of(211, 212);
                List<Integer> crong = List.of(131, 132);
                int result = PageGameService.PLAYER2_WINNER_RETURN_VALUE;
                assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
            }

            @Test
            @DisplayName("오른쪽에서 왼쪽으로 읽는 책의 경우 왼쪽 페이지의 숫자가 더 클 수 있음")
            void case4() {
                List<Integer> pobi = List.of(101, 100);
                List<Integer> crong = List.of(211, 212);
                int result = PageGameService.PLAYER2_WINNER_RETURN_VALUE;
                assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
            }
        }

        @Nested
        @DisplayName("문제 1 실패 케이스 테스트")
        class Problem1FailureTest {
            @Test
            @DisplayName("비정상적인 입력값 - 페이지 수가 연속되지 않음")
            void case1() {
                List<Integer> pobi = List.of(99, 102);
                List<Integer> crong = List.of(211, 212);
                int result = PageGameService.EXCEPTION_RETURN_VALUE;
                assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
            }

            @Test
            @DisplayName("비정상적인 입력값 - 왼쪽 페이지가 홀수가 아님")
            void case2() {
                List<Integer> pobi = List.of(100, 101);
                List<Integer> crong = List.of(211, 212);
                int result = PageGameService.EXCEPTION_RETURN_VALUE;
                assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
            }

            @Test
            @DisplayName("비정상적인 입력값 - 첫 번째 페이지 미만으로 책을 펼칠 수 없음")
            void case3() {
                List<Integer> pobi = List.of(0, 1);
                List<Integer> crong = List.of(211, 212);
                int result = PageGameService.EXCEPTION_RETURN_VALUE;
                assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
            }

            @Test
            @DisplayName("비정상적인 입력값 - 마지막 페이지를 초과하여 책을 펼칠 수 없음")
            void case4() {
                List<Integer> pobi = List.of(400, 401);
                List<Integer> crong = List.of(211, 212);
                int result = PageGameService.EXCEPTION_RETURN_VALUE;
                assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
            }

            @Test
            @DisplayName("비정상적인 입력값 - pobi 와 crong 의 길이가 2와 다를 수 없음")
            void case5() {
                List<Integer> pobi = List.of(301, 302, 303);
                List<Integer> crong = List.of(211, 212);
                int result = PageGameService.EXCEPTION_RETURN_VALUE;
                assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
            }
        }
    }

    @Nested
    @DisplayName("문제 2 테스트")
    class Problem2Test {
        @Nested
        @DisplayName("문제 2 성공 케이스 테스트")
        class Problem2SuccessTest {
            @Test
            @DisplayName("보편적인 해독 알고리즘 성공 케이스")
            void case1() {
                String cryptogram = "browoanoommnaon";
                String result = "brown";
                assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
            }

            @Test
            @DisplayName("해독 결과로 빈 문자열이 나올 수 있음")
            void case2() {
                String cryptogram = "zyelleyz";
                String result = "";
                assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
            }

            @DisplayName("3개 이상의 연속된 중복 문자열이 나와도 정상적으로 수행됨")
            @Test
            void case3() {
                String cryptogram = "bannnana";
                String result = "bna";
                assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
            }

            @Test
            @DisplayName("문자열 사이에 띄어쓰기가 있으면 띄어쓰기 제거 후 정상작동")
            void case4() {
                // given
                String cryptogram = "b r  o w o a  no  om   mn  a o n";
                String result = "brown";

                // when & then
                assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
            }
        }

        @Nested
        @DisplayName("문제 2 실패 케이스 테스트")
        class Problem2FailureTest {
            @Test
            @DisplayName("비정상적인 입력값 - 문자열 길이가 최대치를 초과하는 경우 예외 발생")
            void case1() {
                // given
                String cryptogram = "aaaaaaaaaa".repeat(101);

                assertThat(cryptogram.length())
                        .isGreaterThan(1000);

                // when && then
                assertThatThrownBy(() -> Problem2.solution(cryptogram))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(String.format(
                                CryptogramValidator.INVALID_STRING_LENGTH_RANGE_MESSAGE_FORMAT,
                                CryptogramValidator.CRYPTOGRAM,
                                CryptogramValidator.MIN_LENGTH,
                                CryptogramValidator.MAX_LENGTH
                        ));
            }

            @Test
            @DisplayName("비정상적인 입력값 - 문자열이 빈 경우 예외 발생")
            void case2() {
                // given
                String cryptogram = "";

                // when && then
                assertThatThrownBy(() -> Problem2.solution(cryptogram))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(String.format(
                                CryptogramValidator.INVALID_STRING_LENGTH_RANGE_MESSAGE_FORMAT,
                                CryptogramValidator.CRYPTOGRAM,
                                CryptogramValidator.MIN_LENGTH,
                                CryptogramValidator.MAX_LENGTH
                        ));
            }
        }
    }

    @Nested
    @DisplayName("문제 3 테스트")
    class Problem3Test {
        @Nested
        @DisplayName("문제 3 성공 케이스 테스트")
        class Problem3SuccessTest {
            @Test
            @DisplayName("보편적인 369 게임 성공 케이스")
            void case1() {
                int number = 13;
                int result = 4;
                assertThat(Problem3.solution(number)).isEqualTo(result);
            }

            @Test
            @DisplayName("보편적인 369 게임 성공 케이스2")
            void case2() {
                int number = 33;
                int result = 14;
                assertThat(Problem3.solution(number)).isEqualTo(result);
            }

            @Test
            @DisplayName("보편적인 369 게임 성공 케이스3")
            void case3() {
                int number = 49;
                int result = 25;
                assertThat(Problem3.solution(number)).isEqualTo(result);
            }
        }

        @Nested
        @DisplayName("문제 3 실패 케이스 테스트")
        class Problem3FailureTest {
            @Test
            @DisplayName("비정상적인 입력값 - 최대 범위를 초과한 숫자를 입력하면 예외 발생")
            void case1() {
                int number = 10001;
                assertThatThrownBy(() -> Problem3.solution(number))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(String.format(
                                ThreeSixNineValidator.INVALID_NUMBER_RANGE_MESSAGE_FORMAT,
                                ThreeSixNineValidator.NUMBER,
                                ThreeSixNineValidator.MIN_RANGE,
                                ThreeSixNineValidator.MAX_RANGE
                        ));
            }

            @Test
            @DisplayName("비정상적인 입력값 - 최소 범위 미만인 숫자를 입력하면 예외 발생")
            void case2() {
                int number = 0;
                assertThatThrownBy(() -> Problem3.solution(number))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(String.format(
                                ThreeSixNineValidator.INVALID_NUMBER_RANGE_MESSAGE_FORMAT,
                                ThreeSixNineValidator.NUMBER,
                                ThreeSixNineValidator.MIN_RANGE,
                                ThreeSixNineValidator.MAX_RANGE
                        ));
            }
        }
    }

    @Nested
    @DisplayName("문제 4 테스트")
    class Problem4Test {
        @Nested
        @DisplayName("문제 4 성공 케이스 테스트")
        class Problem4SuccessTest {
            @Test
            @DisplayName("대문자는 대문자로, 소문자는 소문자로 청개구리 실행")
            void case1() {
                String word = "I love you";
                String result = "R olev blf";
                assertThat(Problem4.solution(word)).isEqualTo(result);
            }

            @Test
            @DisplayName("알파벳 외 문자는 그대로 반환")
            void case2() {
                String word = "$aVe ¥0U";
                String result = "$zEv ¥0F";
                assertThat(Problem4.solution(word)).isEqualTo(result);
            }
        }

        @Nested
        @DisplayName("문제 4 실패 케이스 테스트")
        class Problem4FailureTest {
            @Test
            @DisplayName("길이가 1,000을 초과하는 문자열이 들어오면 예외 발생")
            void case1() {
                String word = "VALIDWORDS".repeat(101);
                assertThatThrownBy(() -> Problem4.solution(word))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(String.format(
                                BlueFrogValidator.INVALID_STRING_LENGTH_RANGE_MESSAGE_FORMAT,
                                BlueFrogValidator.SENTENCE,
                                BlueFrogValidator.MIN_LENGTH,
                                BlueFrogValidator.MAX_LENGTH
                        ));
            }

            @Test
            @DisplayName("길이가 1 미만인 문자열이 들어오면 예외 발생")
            void case2() {
                String word = "";
                assertThatThrownBy(() -> Problem4.solution(word))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(String.format(
                                BlueFrogValidator.INVALID_STRING_LENGTH_RANGE_MESSAGE_FORMAT,
                                BlueFrogValidator.SENTENCE,
                                BlueFrogValidator.MIN_LENGTH,
                                BlueFrogValidator.MAX_LENGTH
                        ));
            }
        }
    }

    @Nested
    @DisplayName("문제 5 테스트")
    class Problem5Test {
        @Nested
        @DisplayName("문제 5 성공 케이스 테스트")
        class Problem5SuccessTest {
            @Test
            @DisplayName("최소한의 잔돈 수로 돈을 교환하여 반환1")
            void case1() {
                int money = 50_237;
                List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
                assertThat(Problem5.solution(money)).isEqualTo(result);
            }

            @Test
            @DisplayName("최소한의 잔돈 수로 돈을 교환하여 반환2")
            void case2() {
                int money = 15_000;
                List<Integer> result = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
                assertThat(Problem5.solution(money)).isEqualTo(result);
            }

            @Test
            @DisplayName("십만 단위 이상의 돈 또한 정확히 계산한다.")
            void case3() {
                int money = 600_500;
                List<Integer> result = List.of(12, 0, 0, 0, 1, 0, 0, 0, 0);
                assertThat(Problem5.solution(money)).isEqualTo(result);
            }
        }

        @Nested
        @DisplayName("문제 5 실패 케이스 테스트")
        class Problem5FailureTest {
            @Test
            @DisplayName("비정상적인 입력값 - 1,000,000을 초과하는 입력값에 대해 예외 발생")
            void case1() {
                int money = 1_000_001;
                assertThatThrownBy(() -> Problem5.solution(money))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(String.format(
                                WalletValidator.INVALID_NUMBER_RANGE_MESSAGE_FORMAT,
                                WalletValidator.MONEY,
                                WalletValidator.MIN_RANGE,
                                WalletValidator.MAX_RANGE
                        ));
            }

            @Test
            @DisplayName("비정상적인 입력값 - 1 미만인 입력값에 대해 예외 발생")
            void case2() {
                int money = 0;
                assertThatThrownBy(() -> Problem5.solution(money))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(String.format(
                                WalletValidator.INVALID_NUMBER_RANGE_MESSAGE_FORMAT,
                                WalletValidator.MONEY,
                                WalletValidator.MIN_RANGE,
                                WalletValidator.MAX_RANGE
                        ));
            }
        }
    }

    @Nested
    @DisplayName("문제 6 테스트")
    class Problem6Test {
        @Nested
        @DisplayName("문제 6 성공 케이스 테스트")
        class Problem6SuccessTest {
            @Test
            @DisplayName("두 글자 이상이 '연속적으로' 겹치는 경우에 중복된 이름을 가진 크루로 판단한다.")
            void case1() {
                List<List<String>> forms = List.of(
                        List.of("jm@email.com", "제이엠"),
                        List.of("jason@email.com", "제이슨"),
                        List.of("woniee@email.com", "워니"),
                        List.of("mj@email.com", "엠제이"),
                        List.of("nowm@email.com", "이제엠")
                );
                List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
                assertThat(Problem6.solution(forms)).isEqualTo(result);
            }

            @Test
            @DisplayName("세 글자 이상 겹치는 경우에도 정상적으로 작동한다.")
            void case2() {
                List<List<String>> forms = List.of(
                        List.of("jm@email.com", "롬뭄무야"),
                        List.of("jason@email.com", "이뭄무야"), // 세 글자 겹침!
                        List.of("woniee@email.com", "이박사"),
                        List.of("mj@email.com", "삼성증권이사장"),
                        List.of("nowm@email.com", "증성증권차장님"), // 세 글자 겹침!
                        List.of("baak@email.com", "빡빡이아조씨")
                );
                List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com", "nowm@email.com");
                assertThat(Problem6.solution(forms)).isEqualTo(result);
            }

            @Test
            @DisplayName("result 는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거한다.")
            void case3() {
                List<List<String>> forms = List.of(
                        List.of("A@email.com", "간장게장"),
                        List.of("B@email.com", "간장게장"),
                        List.of("D@email.com", "간장게장"),
                        List.of("D@email.com", "간장게장"),
                        List.of("D@email.com", "간장게장"),
                        List.of("F@email.com", "간장게장")
                );
                List<String> result = List.of("A@email.com", "B@email.com", "D@email.com", "F@email.com");
                assertThat(Problem6.solution(forms)).isEqualTo(result);
            }
        }

        @Nested
        @DisplayName("문제 6 실패 케이스 테스트")
        class Problem6FailureTest {
            @Test
            @DisplayName("검증할 크루가 한 명도 없는 경우 예외 발생")
            void case1() {
                List<List<String>> forms = List.of();
                assertThatThrownBy(() -> Problem6.solution(forms))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(String.format(
                                CrewValidator.INVALID_LIST_SIZE_RANGE_MESSAGE_FORMAT,
                                CrewValidator.CREW,
                                CrewValidator.USER_LIST_SIZE_MIN_RANGE,
                                CrewValidator.USER_MIST_SIZE_MAX_RANGE
                        ));
            }

            @Test
            @DisplayName("검증할 크루가 10,000명을 초과하는 경우 예외 발생")
            void case2() {
                List<List<String>> forms = new ArrayList<>();
                for (int i = 0; i < 10_001; i++) {
                    forms.add(Arrays.asList("human@email.com", "휴먼"));
                }

                assertThatThrownBy(() -> Problem6.solution(forms))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(String.format(
                                CrewValidator.INVALID_LIST_SIZE_RANGE_MESSAGE_FORMAT,
                                CrewValidator.CREW,
                                CrewValidator.USER_LIST_SIZE_MIN_RANGE,
                                CrewValidator.USER_MIST_SIZE_MAX_RANGE
                        ));
            }

            @DisplayName("이메일 형식에 부합하지 않는 경우 예외 발생")
            @ParameterizedTest(name = "{displayName} {index} - {0}")
            @MethodSource("onboarding.ApplicationTest#invalidEmailFormat")
            void case3(String email, String name) {
                List<List<String>> forms = List.of(
                        List.of(email, name)
                );

                assertThatThrownBy(() -> Problem6.solution(forms))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(String.format(
                                CrewValidator.STRING_DISMATCH_TO_REGEX_MESSAGE_FORMAT,
                                CrewValidator.EMAIL,
                                CrewValidator.EMAIL_DESCRIPTION
                        ));
            }

            @DisplayName("유효한 이메일 도메인이 아닌 경우 예외 발생")
            @ParameterizedTest(name = "{displayName} {index} - {0}")
            @MethodSource("onboarding.ApplicationTest#invalidEmailDomain")
            void case4(String email, String name) {
                List<List<String>> forms = List.of(
                        List.of(email, name)
                );

                assertThatThrownBy(() -> Problem6.solution(forms))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(String.format(
                                CrewValidator.INVALID_EMAIL_DOMAIN_MESSAGE_FORMAT,
                                CrewValidator.VALID_EMAIL_DOMAIN)
                        );
            }

            @Test
            @DisplayName("이메일 길이가 11자 미만일 경우 예외 발생")
            void case5() {
                List<List<String>> forms = List.of(
                        List.of("@email.com", "간장게장")
                );

                assertThatThrownBy(() -> Problem6.solution(forms))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(String.format(
                                CrewValidator.INVALID_STRING_LENGTH_RANGE_MESSAGE_FORMAT,
                                CrewValidator.EMAIL,
                                CrewValidator.MIN_EMAIL_LENGTH,
                                CrewValidator.MAX_EMAIL_LENGTH
                        ));
            }

            @Test
            @DisplayName("이메일 길이가 20자 이상일 경우 예외 발생")
            void case6() {
                List<List<String>> forms = List.of(
                        List.of("somedayoverthemountain@email.com", "간장게장")
                );

                assertThatThrownBy(() -> Problem6.solution(forms))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(String.format(
                                CrewValidator.INVALID_STRING_LENGTH_RANGE_MESSAGE_FORMAT,
                                CrewValidator.EMAIL,
                                CrewValidator.MIN_EMAIL_LENGTH,
                                CrewValidator.MAX_EMAIL_LENGTH
                        ));
            }

            @Test
            @DisplayName("닉네임 길이가 1자 미만일 경우 예외 발생")
            void case7() {
                List<List<String>> forms = List.of(
                        List.of("valid@email.com", "")
                );

                assertThatThrownBy(() -> Problem6.solution(forms))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(String.format(
                                CrewValidator.INVALID_STRING_LENGTH_RANGE_MESSAGE_FORMAT,
                                CrewValidator.NAME,
                                CrewValidator.MIN_NAME_LENGTH,
                                CrewValidator.MAX_NAME_LENGTH
                        ));
            }

            @Test
            @DisplayName("닉네임 길이가 20자 이상일 경우 예외 발생")
            void case8() {
                List<List<String>> forms = List.of(
                        List.of("valid@email.com", "작명규칙을아득히넘는청개구리의나쁜닉네임")
                );

                assertThatThrownBy(() -> Problem6.solution(forms))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(String.format(
                                CrewValidator.INVALID_STRING_LENGTH_RANGE_MESSAGE_FORMAT,
                                CrewValidator.NAME,
                                CrewValidator.MIN_NAME_LENGTH,
                                CrewValidator.MAX_NAME_LENGTH
                        ));
            }

            @Test
            @DisplayName("닉네임에 한글이 아닌 글자가 포함되어 있으면 예외 발생")
            void case9() {
                List<List<String>> forms = List.of(
                        List.of("valid@email.com", "한글NotHangeul")
                );

                assertThatThrownBy(() -> Problem6.solution(forms))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(String.format(
                                CrewValidator.STRING_DISMATCH_TO_REGEX_MESSAGE_FORMAT,
                                CrewValidator.NAME,
                                CrewValidator.KOREAN_ONLY_DESCRIPTION
                        ));
            }
        }
    }

    public static Stream<Arguments> invalidEmailFormat() {
        return Stream.of(
                Arguments.of("@hoho@email.com", "이메일기호두개"),
                Arguments.of("배달의민족@email.com", "한글이메일")
        );
    }

    public static Stream<Arguments> invalidEmailDomain() {
        return Stream.of(
                Arguments.of("validman@gmail.com", "지메일"),
                Arguments.of("validman@email.net", "이메일닷넷")
        );
    }

    @Nested
    @DisplayName("문제 7 테스트")
    class Problem7Test {
        @Nested
        @DisplayName("문제 7 성공 케이스 테스트")
        class Problem7SuccessTest {
            @Test
            @DisplayName("이미 친구관계인 친구는 제외하고 추천 친구 목록을 만든다.")
            void case1() {
                String user = "mrko";
                List<List<String>> friends = List.of(
                        List.of("donut", "andole"),
                        List.of("donut", "jun"),
                        List.of("donut", "mrko"),
                        List.of("shakevan", "andole"),
                        List.of("shakevan", "jun"),
                        List.of("shakevan", "mrko")
                );
                List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
                List<String> result = List.of("andole", "jun", "bedi");
                assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
            }

            @Test
            @DisplayName("추천할 친구가 없는 경우는 주어지지 않는다.")
            void case2() {
                String user = "mrko";
                List<List<String>> friends = List.of(
                        List.of("donut", "mrko"),
                        List.of("shakevan", "mrko"),
                        List.of("melon", "mrko"),
                        List.of("mrko", "apple"),
                        List.of("banana", "mrko")
                );
                List<String> visitors = List.of("apple", "apple", "donut", "shakevan");
                List<String> result = List.of();
                assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
            }

            @Test
            @DisplayName("추천 점수가 같은 경우는 이름순으로 정렬한다.")
            void case3() {
                String user = "mrko";
                List<List<String>> friends = List.of(
                        List.of("a", "mrko"),
                        List.of("a", "c"),
                        List.of("b", "a"),
                        List.of("b", "d"),
                        List.of("a", "e")
                );
                List<String> visitors = List.of("c", "b", "e");
                List<String> result = List.of("b", "c", "e");
                assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
            }
        }

        @Nested
        @DisplayName("문제 7 실패 케이스 테스트")
        class Problem7FailureTest {
            @Nested
            @DisplayName("문제 7 실패 케이스 테스트 - user 입력값")
            class Problem7CrewFailureTest {
                @Test
                @DisplayName("user가 null이면 예외 발생")
                void test1() {
                    String user = null;
                    List<List<String>> friends = List.of(
                            List.of("donut", "andole"),
                            List.of("donut", "jun"),
                            List.of("donut", "mrko"),
                            List.of("shakevan", "andole"),
                            List.of("shakevan", "jun"),
                            List.of("shakevan", "mrko")
                    );
                    List<String> visitors = List.of("C", "B", "E");
                    assertThatThrownBy(() -> Problem7.solution(user, friends, visitors))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(
                                    String.format(
                                            MemberValidator.INVALID_STRING_LENGTH_RANGE_MESSAGE_FORMAT,
                                            MemberValidator.USER_ID,
                                            MemberValidator.MIN_ID_LENGTH_RANGE,
                                            MemberValidator.MAX_ID_LENGTH_RANGE
                                    ));
                }

                @Test
                @DisplayName("user의 길이가 1 미만이면 예외 발생")
                void test2() {
                    String user = "";
                    List<List<String>> friends = List.of(
                            List.of("donut", "andole"),
                            List.of("donut", "jun"),
                            List.of("donut", "mrko"),
                            List.of("shakevan", "andole"),
                            List.of("shakevan", "jun"),
                            List.of("shakevan", "mrko")
                    );
                    List<String> visitors = List.of("C", "B", "E");
                    assertThatThrownBy(() -> Problem7.solution(user, friends, visitors))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(
                                    String.format(
                                            MemberValidator.INVALID_STRING_LENGTH_RANGE_MESSAGE_FORMAT,
                                            MemberValidator.USER_ID,
                                            MemberValidator.MIN_ID_LENGTH_RANGE,
                                            MemberValidator.MAX_ID_LENGTH_RANGE
                                    ));
                }

                @Test
                @DisplayName("user의 길이가 30을 초과하면 예외 발생")
                void test3() {
                    String user = "policeshowedupatmydoorwithawarrant";
                    List<List<String>> friends = List.of(
                            List.of("donut", "andole"),
                            List.of("donut", "jun"),
                            List.of("donut", "mrko"),
                            List.of("shakevan", "andole"),
                            List.of("shakevan", "jun"),
                            List.of("shakevan", "mrko")
                    );
                    List<String> visitors = List.of("C", "B", "E");
                    assertThatThrownBy(() -> Problem7.solution(user, friends, visitors))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(
                                    String.format(
                                            MemberValidator.INVALID_STRING_LENGTH_RANGE_MESSAGE_FORMAT,
                                            MemberValidator.USER_ID,
                                            MemberValidator.MIN_ID_LENGTH_RANGE,
                                            MemberValidator.MAX_ID_LENGTH_RANGE
                                    ));
                }
            }

            @Nested
            @DisplayName("문제 7 실패 케이스 테스트 - relations 입력값")
            class Problem7RelationsFailureTest {
                @Test
                @DisplayName("relations 배열이 null이면 예외 발생")
                void test4() {
                    String user = "mrko";
                    List<List<String>> friends = null;
                    List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
                    assertThatThrownBy(() -> Problem7.solution(user, friends, visitors))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(String.format(
                                    RelationsValidator.INVALID_LIST_SIZE_RANGE_MESSAGE_FORMAT,
                                    RelationsValidator.RELATIONS,
                                    RelationsValidator.MIN_RELATIONS_SIZE,
                                    RelationsValidator.MAX_RELATIONS_SIZE
                            ));
                }

                @Test
                @DisplayName("relations 배열이 비어 있으면 예외 발생")
                void test5() {
                    String user = "mrko";
                    List<List<String>> friends = List.of();
                    List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
                    assertThatThrownBy(() -> Problem7.solution(user, friends, visitors))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(String.format(
                                    RelationsValidator.INVALID_LIST_SIZE_RANGE_MESSAGE_FORMAT,
                                    RelationsValidator.RELATIONS,
                                    RelationsValidator.MIN_RELATIONS_SIZE,
                                    RelationsValidator.MAX_RELATIONS_SIZE
                            ));
                }

                @Test
                @DisplayName("relations 배열이 10,000을 넘어가면 예외 발생")
                void test6() {
                    String user = "mrko";
                    List<List<String>> friends = new ArrayList<>();
                    for (int i = 0; i < 10_001; i++) {
                        friends.add(List.of("a", "a"));
                    }
                    List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
                    assertThatThrownBy(() -> Problem7.solution(user, friends, visitors))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(String.format(
                                    RelationsValidator.INVALID_LIST_SIZE_RANGE_MESSAGE_FORMAT,
                                    RelationsValidator.RELATIONS,
                                    RelationsValidator.MIN_RELATIONS_SIZE,
                                    RelationsValidator.MAX_RELATIONS_SIZE
                            ));
                }

                @Test
                @DisplayName("relations 각 원소의 길이가 2가 아닌 경우 예외 발생")
                void test7() {
                    String user = "mrko";
                    List<List<String>> friends = List.of(
                            List.of("donut", "mrko"),
                            List.of("shakevan", "mrko", "apple"),
                            List.of("melon", "mrko"),
                            List.of("mrko", "apple"),
                            List.of("banana", "mrko")
                    );
                    List<String> visitors = List.of("apple", "apple", "donut", "shakevan");
                    assertThatThrownBy(() -> Problem7.solution(user, friends, visitors))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(String.format(
                                    RelationsValidator.INVALID_LIST_SIZE_RANGE_MESSAGE_FORMAT,
                                    RelationsValidator.RELATION,
                                    RelationsValidator.RELATION_SIZE,
                                    RelationsValidator.RELATION_SIZE
                            ));
                }

                @Test
                @DisplayName("사용자 아이디가 알파벳 소문자가 아니면 예외 발생")
                void test8() {
                    String user = "mkdr";
                    List<List<String>> friends = List.of(
                            List.of("donut", "andole"),
                            List.of("DONUT", "jun"),
                            List.of("donut", "mrko"),
                            List.of("shakevan", "andole"),
                            List.of("shakevan", "jun"),
                            List.of("shakevan", "mrko")
                    );
                    List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
                    assertThatThrownBy(() -> Problem7.solution(user, friends, visitors))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(String.format(
                                    MemberValidator.STRING_DISMATCH_TO_REGEX_MESSAGE_FORMAT,
                                    MemberValidator.USER_ID,
                                    MemberValidator.ALPHABET_LOWERCASE_ONLY_DESCRIPTION
                            ));
                }
            }

            @Nested
            @DisplayName("문제 7 실패 케이스 테스트 - visitor 입력값")
            class Problem7VisitorsFailureTest {
                @Test
                @DisplayName("visitor 배열이 null 이면 예외 발생")
                void test8() {
                    String user = "mrko";
                    List<List<String>> friends = List.of(
                            List.of("donut", "mrko"),
                            List.of("shakevan", "mrko"),
                            List.of("melon", "mrko"),
                            List.of("mrko", "apple"),
                            List.of("banana", "mrko")
                    );
                    List<String> visitors = null;
                    assertThatThrownBy(() -> Problem7.solution(user, friends, visitors))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(String.format(
                                    VisitorsValidator.INVALID_LIST_SIZE_RANGE_MESSAGE_FORMAT,
                                    VisitorsValidator.VISITORS,
                                    VisitorsValidator.MIN_VISITORS_SIZE,
                                    VisitorsValidator.MAX_VISITORS_SIZE
                            ));
                }

                @Test
                @DisplayName("visitor 배열이 10,000을 넘어가면 예외 발생")
                void test9() {
                    String user = "mrko";
                    List<List<String>> friends = List.of(
                            List.of("donut", "andole"),
                            List.of("donut", "jun"),
                            List.of("donut", "mrko"),
                            List.of("shakevan", "andole"),
                            List.of("shakevan", "jun"),
                            List.of("shakevan", "mrko")
                    );
                    List<String> visitors = new ArrayList<>();
                    for (int i = 0; i < 10_001; i++) {
                        visitors.add("a");
                    }
                    assertThatThrownBy(() -> Problem7.solution(user, friends, visitors))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(String.format(
                                    VisitorsValidator.INVALID_LIST_SIZE_RANGE_MESSAGE_FORMAT,
                                    VisitorsValidator.VISITORS,
                                    VisitorsValidator.MIN_VISITORS_SIZE,
                                    VisitorsValidator.MAX_VISITORS_SIZE
                            ));
                }

                @Test
                @DisplayName("사용자 아이디가 알파벳 소문자가 아니면 예외 발생")
                void test10() {
                    String user = "Mkdr";
                    List<List<String>> friends = List.of(
                            List.of("donut", "andole"),
                            List.of("donut", "jun"),
                            List.of("donut", "mrko"),
                            List.of("shakevan", "andole"),
                            List.of("shakevan", "jun"),
                            List.of("shakevan", "mrko")
                    );
                    List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
                    assertThatThrownBy(() -> Problem7.solution(user, friends, visitors))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(String.format(
                                    MemberValidator.STRING_DISMATCH_TO_REGEX_MESSAGE_FORMAT,
                                    MemberValidator.USER_ID,
                                    MemberValidator.ALPHABET_LOWERCASE_ONLY_DESCRIPTION
                            ));
                }

                @Test
                @DisplayName("동일한 친구 관계가 중복해서 주어지면 예외 발생")
                void test11() {
                    String user = "mkdr";
                    List<List<String>> friends = List.of(
                            List.of("andole", "donut"),
                            List.of("donut", "andole"),
                            List.of("donut", "mrko"),
                            List.of("shakevan", "andole"),
                            List.of("shakevan", "jun"),
                            List.of("shakevan", "mrko")
                    );
                    List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
                    assertThatThrownBy(() -> Problem7.solution(user, friends, visitors))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(RelationsValidator.DUPLICATING_RELATION_MESSAGE);
                }
            }
        }
    }
}
