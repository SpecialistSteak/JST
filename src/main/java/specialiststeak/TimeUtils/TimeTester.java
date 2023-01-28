package specialiststeak.TimeUtils;

import java.util.ArrayList;

public class TimeTester implements TimedCode {
    private ArrayList<Times> times;

    /**
     * Creates a new TimeTester object.
     */
    public TimeTester() {
        times = new ArrayList<>();
    }

    /**
     * Runs the code and times it.
     *
     * @param code The code to run.
     */
    public static long runCode(Runnable code) {
        long start = System.nanoTime();
        code.run();
        long end = System.nanoTime();
        return (end - start);
    }

    public void runTimedCode(Runnable code) {
        this.startTimer();
        code.run();
        this.stopTimer();
    }

    public void runTimedCode(Runnable code, String title) {
        this.startTimer(title);
        code.run();
        this.stopTimer();
    }

    /**
     * Starts a timer with no title.
     */
    public void startTimer() {
        times.add(new Times(System.nanoTime(), 0, 0));
    }

    /**
     * Starts a timer with a title.
     *
     * @param title The title of the timer.
     */
    public void startTimer(String title) {
        times.add(new Times(System.nanoTime(), 0, 0, title));
    }

    /**
     * Stops the timer and adds the elapsed time to the list of times.
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
     * Iterates through the list of times and returns all the timers in a string with the time units specified.
     *
     * @return The total time elapsed.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TimeTester {");
        for (Times time : times) {
            sb.append("\n\t").append(time.toString()).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }

    /**
     * Iterates through the list of times and returns all the timers in a string with the time units specified.
     *
     * @param timeTester The time units to use.
     * @return The total time elapsed.
     */
    public String toString(TimeUnits timeTester) {
        StringBuilder sb = new StringBuilder();
        sb.append("TimeTester {");
        for (Times time : times) {
            sb.append("\n\t").append(time.toString(timeTester)).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}
