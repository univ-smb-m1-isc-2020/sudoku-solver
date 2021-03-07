package sudoku.solver;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

class RegionTest {

    private final Value[] columnValues = {
            Value.EMPTY,
            Value.NINE,
            Value.FOUR,
            Value.EMPTY,
            Value.EMPTY,
            Value.SIX,
            Value.ONE,
            Value.EIGHT,
            Value.SEVEN
    };

    private final Column column = new Column(columnValues);

    @Test
    void should_return_available_fillings() {

        // Given
        HashSet<Value> expectedFillings = new HashSet<>();
        expectedFillings.add(Value.TWO);
        expectedFillings.add(Value.THREE);
        expectedFillings.add(Value.FIVE);

        // When
        HashSet<Value> columnFillings = (HashSet<Value>) column.getPossibleFillings();

        // Then
        assertThat(columnFillings).isEqualTo(expectedFillings);
    }
}