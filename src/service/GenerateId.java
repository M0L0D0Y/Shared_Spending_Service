package service;

import static java.lang.Long.MAX_VALUE;

public class GenerateId {
    long a = 1;
    long b = MAX_VALUE;

    public long generate() {
        return (long) (Math.random() * (b - a) + a);
    }
}
