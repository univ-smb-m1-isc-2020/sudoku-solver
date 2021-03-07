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
    public void should_return_available_fillings() {

        // Given
        HashSet<Value> fillings = new HashSet<>();
        fillings.add(Value.TWO);
        fillings.add(Value.THREE);
        fillings.add(Value.FIVE);

        // When
        HashSet<Value> columnFillings = (HashSet<Value>) column.getPossibleFillings();

        // Then
        assertThat(columnFillings.equals(fillings));

    }
}