package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static racingcar.util.Validation.validateCarName;

// TODO: 이름 수정 필요! 밑에 메서드도
public class DelimiterService {
    private static final String delimiter = ",";

    public List<String> extractCarName(String user_input) {
        List<String> carNameList = Arrays.asList(Stream.of(user_input.split(delimiter))
                                                       .map(String::trim)
                                                       .toArray(String[]::new));
        validateCarNameList(carNameList);

        return carNameList;
    }

    // TODO: 이 validate 과정을 어디로 가져갈지 고민.. Controller로 옮기자!
    public void validateCarNameList(List<String> carNameList) {
        validateCarName(carNameList);
    }
}
