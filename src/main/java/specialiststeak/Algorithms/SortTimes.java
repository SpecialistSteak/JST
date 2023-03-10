package specialiststeak.Algorithms;

import specialiststeak.TimeUtils.TimeUnits;
import specialiststeak.TimeUtils.Times;

public class SortTimes extends Times implements Comparable {
    private final String sortName;

    /**
     * Creates a new Times object.
     *
     * @param startTime   The start time in nanoseconds.
     * @param endTime     The end time in nanoseconds.
     * @param elapsedTime The elapsed time in nanoseconds.
     */
    public SortTimes(long startTime, long endTime, long elapsedTime, String sortName) {
        super(startTime, endTime, elapsedTime);
        this.setElapsedTime(elapsedTime);
        this.sortName = sortName;
    }

    /**
     * Creates a new Times object.
     *
     * @return A string representation of the Times object.
     */
    @Override
    public String toString() {
        return String.format("%-25s: %sns",
                getSortName(), getElapsedTime());
    }

    /**
     * Creates a new Times object.
     *
     * @param timeUnits The time units to use.
     * @return A string representation of the Times object.
     */
    @Override
    public String toString(TimeUnits timeUnits) {
        return sortName + ": " + super.toString(timeUnits);
    }

    /**
     * Creates a new Times object.
     *
     * @return The name of the sort algorithm.
     */
    public String getSortName() {
        return sortName;
    }

    @Override
    public int compareTo(Object o) {
        return Long.compare(getElapsedTime(), ((SortTimes) o).getElapsedTime());
    }
}