package com.decryptor.repository;

import org.springframework.stereotype.Component;

@Component
public class SequenceIdGenerator {
    private static int sequenceId;

    SequenceIdGenerator() {
    }

    public static int generateId() {
        return sequenceId++;
    }

    public static void reset() {
        sequenceId = 0;
    }
}
