package lotto;

import static lotto.constants.LottoConstants.LOTTO_END;
import static lotto.constants.LottoConstants.LOTTO_SIZE;
import static lotto.constants.LottoConstants.LOTTO_START;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ExceptionManager;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        checkLottoSize(numbers);
        checkLottoNumRange(numbers);
        checkDuplicate(numbers);
    }

    private void checkLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            ExceptionManager.throwIllegalArgumentExceptionWithMsg(LOTTO_SIZE + "개의 숫자만 가질 수 있습니다.");
        }
    }

    private void checkLottoNumRange(List<Integer> numbers) {
        numbers.stream().filter(number -> number < LOTTO_START || number > LOTTO_END).findAny()
                .ifPresent(number -> ExceptionManager.throwIllegalArgumentExceptionWithMsg(
                        "로또의 숫자는 " + LOTTO_START + "~" + LOTTO_END + "까지 가능합니다."));
    }

    private void checkDuplicate(List<Integer> numbers) {
        Set<Integer> setNumbers = new HashSet<>(numbers);
        if (setNumbers.size() != numbers.size()) {
            ExceptionManager.throwIllegalArgumentExceptionWithMsg("로또의 숫자는 중복될 수 없습니다.");
        }
    }
}
