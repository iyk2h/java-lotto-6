package lotto;

import lotto.exception.ExceptionManager;

public class Money {
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private void validate(int money) {
        if (money % 1000 != 0) {
            ExceptionManager.throwIllegalArgumentExceptionWithMsg("1,000원 단위로 입력해야 합니다.");
        }
    }
}
