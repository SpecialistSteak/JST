package specialiststeak.TimeUtils;

import static specialiststeak.TimeUtils.TimeUnits.staticConvertTime;

public class Times{
    private long startTime;
    private long endTime;
    private long elapsedTime;
    private String title;

    /**
     * Creates a new Times object.
     *
     * @param startTime   The start time in nanoseconds.
     * @param endTime     The end time in nanoseconds.
     * @param elapsedTime The elapsed time in nanoseconds.
     */
    public Times(long startTime, long endTime, long elapsedTime) {
        this.startTime = startTime;
        this.endTime = 0;
        this.elapsedTime = 0;
        this.title = "";
    }

    /**
     * Creates a new Times object.
     *
     * @param startTime   The start time in nanoseconds.
     * @param endTime     The end time in nanoseconds.
     * @param elapsedTime The elapsed time in nanoseconds.
     * @param title       The title of the times object.
     */
    public Times(long startTime, long endTime, long elapsedTime, String title) {
        this.startTime = startTime;
        this.endTime = 0;
        this.elapsedTime = 0;
        this.title = title;
    }

    /**
     * @return The start time in nanoseconds.
     */
    public long getStartTime() {
        return startTime;
    }

    /**
     * @return The "string-ified" times object.
     */
    public String toString() {
        return "Times" + (
                (getTitle() == null || getTitle().equals("")) ?
                        "" :
                        (": \"" + getTitle() + "\"")) + " {" +
                "\n\t\tstartTime= " + startTime +
                "ns,\n\t\tendTime= " + endTime +
                "ns,\n\t\telapsedTime= " + elapsedTime +
                "ns\n\t}";
    }

    /**
     * Returns the "string-ified" times object with the time units specified.
     *
     * @param timeUnits The time units to use.
     * @return The "string-ified" times object.
     */
    public String toString(TimeUnits timeUnits) {
        return "Times" + ((getTitle() == null || getTitle().equals("")) ? "" : (": \"" + getTitle())) + "\" {" +
                "\n\t\tstartTime= " + staticConvertTime(startTime, timeUnits) + timeUnits.toString() +
                "\n\t\tendTime= " + staticConvertTime(endTime, timeUnits) + timeUnits.toString() +
                ",\n\t\telapsedTime= " + staticConvertTime(elapsedTime, timeUnits) + timeUnits.toString() +
                "\n\t}";
    }

    /**
     * sets the end time
     *
     * @param endTime the end time in nanoseconds
     */
    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    /**
     * sets the elapsed time
     *
     * @param l the elapsed time in nanoseconds
     */
    public void setElapsedTime(long l) {
        this.elapsedTime = l;
    }

    /**
     * @return the end time in nanoseconds
     */
    public long getElapsedTime() {
        return elapsedTime;
    }

    /**
     * Sets the title of the times object
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the title of the times object
     */
    public String getTitle() {
        return title;
    }
}