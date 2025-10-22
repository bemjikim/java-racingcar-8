package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static racingcar.util.Validator.validateCarName;

public class DelimiterService {
    private static final String delimiter = ",";

    public List<String> splitDelimiter(String user_input) {
        List<String> carNameList = Arrays.asList(Stream.of(user_input.split(delimiter))
                                                       .map(String::trim)
                                                       .toArray(String[]::new));
        validateCarNameList(carNameList);

        return carNameList;
    }

    public void validateCarNameList(List<String> carNameList) {
        validateCarName(carNameList);
    }
}
