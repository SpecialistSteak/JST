package specialiststeak.Algorithms;

import specialiststeak.TimeUtils.Times;

import java.util.ArrayList;

public class SortTimeTester {
    private ArrayList<SortTimes> times;

    /**
     * Runs the code and returns the amount of time it took to run as a long
     *
     * @param code The code to run
     * @return The amount of time it took to run
     */
    public static long runCode(Runnable code) {
        long start = System.nanoTime();
        code.run();
        long end = System.nanoTime();
        return (end - start);
    }

    /**
     * Adds a time to the list of times
     *
     * @param time The time to add
     */
    public void addTime(SortTimes time) {
        times.add(time);
    }

    /**
     * Creates a new SortTimeTester object
     */
    public SortTimeTester() {
        times = new ArrayList<>();
    }

    /**
     * Starts a timer for a sort
     *
     * @param sortName The name of the sort
     */
    public void startTimer(String sortName) {
        times.add(new SortTimes(System.nanoTime(), 0, 0, sortName));
    }

    /**
     * Stops the timer for the last sort
     */
    public void stopTimer() {
        long endTime = System.nanoTime();
        if (times.isEmpty()) {
            throw new IllegalStateException("No timer has been started");
        }
        Times lastTime = times.get(times.size() - 1);
        lastTime.setEndTime(endTime);
        lastTime.setElapsedTime(endTime - lastTime.getStartTime());
    }

    /**
     * Gets the times for all the sorts
     *
     * @return The times for all the sorts
     */
    public ArrayList<SortTimes> getTimes() {
        return times;
    }

    /**
     * @param time the time to set the last time to
     */
    public void setLastTime(long time) {
        if (times.isEmpty()) throw new IllegalStateException("No timer has been started");

        times.get(times.size() - 1).setElapsedTime(time);
    }

    public void setTimes(ArrayList<SortTimes> times) {
        this.times = times;
    }

    /**
     * Clears all the times
     */
    public void clear() {
        times.clear();
    }

    /**
     * Prints the results of the sort times
     */
    public void printResults() {
        for (SortTimes t : times) {
            System.out.println(t.toString());
        }
    }

    /**
     * Gets the results of the sort times
     *
     * @return The results of the sort times
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (SortTimes t : times) {
            sb.append(t.toString()).append("\r\n");
        }
        return sb.toString();
    }
}
