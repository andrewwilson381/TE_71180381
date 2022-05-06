import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class UnitTestExample {

    @Test


    private static Stream<Arguments> providePrice(){
        return Stream.of(
                Arguments.of(0, 2000000),
                Arguments.of(10, 13000000),
                Arguments.of(22, 30000000),
                Arguments.of(40f, 42000000),
                Arguments.of(-1, -100000),
                Arguments.of(-1, 4000000),
                Arguments.of(-1, 1500000000)
        );
    }

    @ParameterizedTest
    @MethodSource("providePrice")
    void parameterizedTestPajak(double expected, double salary){
        Assertions.assertEquals(expected, SystemPajak.getPajak(salary));
    }
}
