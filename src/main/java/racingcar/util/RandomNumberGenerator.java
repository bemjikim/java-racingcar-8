package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    // TODO:  camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 를 활용하여 랜덤 숫자 추출
    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
