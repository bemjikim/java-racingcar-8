package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ExtractCarNameService {
    private static final String delimiter = ",";

    public List<String> extractCarName(String user_input) {
        List<String> carNameList = Arrays.asList(Stream.of(user_input.split(delimiter))
                                                       .map(String::trim)
                                                       .toArray(String[]::new));

        return carNameList;
    }
}
