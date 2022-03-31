package service;

import static java.lang.Long.MAX_VALUE;

public class GenerateId implements IdGenerator {

    @Override
    public long generate() {
        long a = 1;
        return (long) (Math.random() * (MAX_VALUE - a) + a);
    }
}
