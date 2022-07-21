import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    private final int max;
    private final int min;
    protected Random random;

    public Randoms(int min, int max) {
        this.min = min;
        this.max = max;
        random = new Random();
    }

    private int getRandomNumber() {
        int res = random.nextInt(max - min) + min;
        if (random.nextDouble() < 0.5) {
            res++;
        }
        return res;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                return getRandomNumber();
            }
        };
    }
}
