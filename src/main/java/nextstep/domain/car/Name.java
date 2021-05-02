package nextstep.domain.car;

public class Name {

    private final static int MAX_NAME_LENGTH = 5;

    private String value;

    public Name(String value) {
        if (value.length() > MAX_NAME_LENGTH) {
            throw new RuntimeException("자동차 이름은 5자리를 초과할 수 없습니다.");
        }

        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
