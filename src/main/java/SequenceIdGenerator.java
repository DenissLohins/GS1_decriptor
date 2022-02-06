class SequenceIdGenerator {
    private static long sequenceId;

    private SequenceIdGenerator() {
    }

    public static long generateId() {
        return sequenceId++;
    }

    public static void reset() {
        sequenceId = 0;
    }
}
