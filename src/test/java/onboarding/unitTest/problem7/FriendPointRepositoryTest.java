package onboarding.unitTest.problem7;

import onboarding.problem7.FriendPointRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
public class FriendPointRepositoryTest {

    @ParameterizedTest(name = "Case {index}")
    @ArgumentsSource(FriendsPointInfoTestData.class)
    void FriendsPointRepositoryTest(List<Object> info, List<String> expected){
        FriendPointRepository repository = new FriendPointRepository();
        addInfo(info, repository);
        assertThat(repository.findRecommendFriendsTop5()).isEqualTo(expected);
    }

    void addInfo(List<Object> info, FriendPointRepository repository){
        for (int i=0; i<info.size(); i+=2){
            repository.addPoint((String) info.get(i), (int) info.get(i+1));
        }
    }

    static class FriendsPointInfoTestData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(List.of("nick",5,"steve",8,"nick",5),
                            List.of("nick", "steve")),
                    Arguments.of(List.of("a",1,"b",2,"c",3,"d",4,"e",5,"f",6),
                            List.of("f","e","d","c","b")),
                    Arguments.of(List.of(), List.of())
            );
        }
    }
}
