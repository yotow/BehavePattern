import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RandomsTest {
    private final int min = 90;
    private final int max = 100;
    private final Iterator<Integer> iterator = new Randoms(min, max).iterator();

    @Test
    public void iteratorTest() {
        for (int i = 0; i < (max - min) * 100; i++) {
            int r = iterator.next();
            assertThat(r, allOf(greaterThanOrEqualTo(min), lessThanOrEqualTo(max)));
        }
    }

    @Test
    public void iteratorMaxEdgeTest() {
        for (int i = 0; i < (max - min) * 100; i++) {
            int r = iterator.next();
            if (r == max)
                assertThat(r, equalTo(max));
        }
    }

    @Test
    public void iteratorMinEdgeTest() {
        for (int i = 0; i < (max - min) * 100; i++) {
            int r = iterator.next();
            if (r == min)
                assertThat(r, equalTo(min));
        }
    }
}
