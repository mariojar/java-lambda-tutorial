package it.java.edu.java8;

import java.time.Clock;
import java.time.Instant;

public class ClockMain {

    public static void main(String[] args) {
        Clock clock = Clock.systemUTC();
        Instant now = clock.instant();
        System.out.println(now);

    }
}
