package specialiststeak;

import specialiststeak.Algorithms.SortTimeTester;
import specialiststeak.Algorithms.Sorts.LameSort;
import specialiststeak.Algorithms.Sorts.MergeSort;
import specialiststeak.Algorithms.Sorts.QuickSort;
import specialiststeak.Population.Types;
import specialiststeak.TestingUtils.StackTester;
import specialiststeak.TimeUtils.TimeTester;
import specialiststeak.TimeUtils.TimeUnits;
import specialiststeak.memoryutils.MemoryTester;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

import static specialiststeak.Algorithms.Shuffle.shuffle;
import static specialiststeak.Algorithms.SortAlgorithms.testAll;
import static specialiststeak.Population.Convert.toIntArray;
import static specialiststeak.Population.PopulateArray.cloneAndModify;
import static specialiststeak.Population.PopulateArray.populate;
import static specialiststeak.TestingUtils.TypeTester.getVarType;
import static specialiststeak.TimeUtils.TimeTester.runCode;
import static specialiststeak.TimeUtils.TimeUnits.SECONDS;
import static specialiststeak.TimeUtils.TimeUnits.staticConvertTime;
import static specialiststeak.memoryutils.CSV.CSVToGraph.convertToGraph;
import static specialiststeak.memoryutils.MemoryTester.getLineNumber;
import static specialiststeak.memoryutils.MemoryTesterToCSV.convertToCSV;
public class ExampleProgram {
    public static void main(String[] args) throws FileNotFoundException, IllegalAccessException {
        /*TimeTester example usage*/
        TimeTester timeTester = new TimeTester();
        timeTester.startTimer("Optional timer name");
        System.out.println("Something would happen here...");
        timeTester.stopTimer();

        timeTester.runTimedCode(() -> {
            System.out.println("Something would happen here...");
        }, "runTimedCode() example");

        System.out.println(timeTester.toString(TimeUnits.MICROSECONDS));
        System.out.println(timeTester);

        line();
        System.out.println(SECONDS.convertTime(runCode(() -> {
        })) + SECONDS.toString());
        System.out.println(staticConvertTime(runCode(() -> {
        }), TimeUnits.NANOSECONDS) + "ns");
        line();

        /*TypeTester example usage*/
        var object = new Object();
        var object2 = 43;
        var object3 = "Hello World!";
        System.out.println("Generic Object var type: " + getVarType(object).toString());
        System.out.println("int var type: " + getVarType(object2).toString());
        System.out.println("String var type: " + getVarType(object3).toString());
        // This only returns the size of primitives, not objects. You'd need to use something like java.Instrumentation for that.
        System.out.println("Generic Object size: " + getVarType(object).getApproximateStorageSize());
        System.out.println("int size: " + getVarType(object2).getApproximateStorageSize());
        System.out.println("String size: " + getVarType(object3).getApproximateStorageSize());
        line();

        /*StackTester example usage*/
        StackTester stackTester = new StackTester();
        stackTester.logStackTrace(getLineNumber());
        stackTester.printLog();
        System.out.println("MainClass.main");
        stackTester.logStackTrace(getLineNumber());
        try {
            stackTester.saveLogToFile(new File("log.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        line();

        /*MemoryTester example usage*/
        MemoryTester memoryTester = new MemoryTester();
        memoryTester.logUsedMemory(getLineNumber());
        String lotOfMemory = Arrays.toString(populate(Types.STRING, 10_000_000)); //This will use a lot of memory for the example
        memoryTester.logUsedMemory(getLineNumber());
        System.out.println(memoryTester.getMemoryUsage().toString());
        line();

        /*SortAlgorithms example usage*/
        // Note: If you're sorting a primitive array, you can use Arrays.sort() instead of my method ArraysSort()
        Integer[] array = {3, 2, 1, 5, 4, 6, 3, 8, 6, 10};
        new QuickSort().sort(array);
        System.out.println(Arrays.toString(array));
        shuffle(array);
        memoryTester.logUsedMemory(getLineNumber());
        System.out.println(Arrays.toString(array));
        line();

        /*PopulateArray example usage*/
        Integer[] arr = new Integer[1000];
        arr = (Integer[]) populate(Types.INT, 1000);
        exampleClass[] arr2 = new exampleClass[1000];
        for (int i = 0; i < arr2.length; i++) {
            // cloneAndModify is a method I made to clone an object and modify its values.
            // It should go in and modify each primitive value in the object and all the objects it contains.
            // If there are any objects that are not primitives, it will just clone them.
            // It does require a public constructor with the same parameters as the class.
            arr2[i] = (exampleClass) cloneAndModify(new exampleClass(1, 1, 1));
        }
        System.out.println("Each object in array has had its values modified.\nArray of ExampleClass objects before sorting:");
        for (exampleClass exampleClass : arr2) {
            System.out.print(exampleClass + ", ");
        }
        memoryTester.logUsedMemory(getLineNumber());
        System.out.println();
        line();

        SortTimeTester[] sortTimeTesters = new SortTimeTester[10];
        for (int i = 0; i < sortTimeTesters.length; i++) {
            sortTimeTesters[i] = (SortTimeTester) cloneAndModify(new SortTimeTester());
        }

        Integer[] allsame = new Integer[10_000];
        Arrays.fill(allsame, 1);

        Integer[] terriblyLongArray = new Integer[10_000_000];
        for (int i = 0; i < terriblyLongArray.length; i++) {
            terriblyLongArray[i] = (int) (Math.random() * 100);
        }

        line();

        /*testAll example usage*/
        // This is just a simple test. It's not always representative of the actual performance of the algorithm.
        // And make sure you know which algorithm to use when, as some are better than others in certain situations.
        // testAll requires the class to implement Comparable

        testAll(arr, 50);
        line();
        testAll(arr2, 50);
        line();
        testAll(array, 50);
        line();
        testAll(allsame);
        line();
        System.out.println("Lame" + runCode(() -> {
            new LameSort().sort(terriblyLongArray);
        }));
        shuffle(terriblyLongArray);
        System.out.println("Merge" + runCode(() -> {
            new MergeSort().sort(terriblyLongArray);
        }));

        memoryTester.logUsedMemory(getLineNumber());

        /*PopulateArray example usage*/
        int[] intArray = toIntArray(populate(Types.INT, 1_000));
        var t = intArray[0];
        System.out.println(Arrays.toString(intArray));
        // Just for proof :)
        switch (getVarType(t)) {
            case OBJECT -> System.out.println("t is an Object");
            case INT -> System.out.println("t is an int");
            default -> System.out.println("t is not an Object or an int");
        }
        memoryTester.logUsedMemory(getLineNumber());
        line();

        convertToCSV(memoryTester, new File("memory_points.csv"));

        //Convert a memory points CSV file to a graph png file using JFreeChart
        /* Dependency for your pom.xml if you want to use the convertToGraph() method
        <dependencies>
            <dependency>
                <groupId>org.jfree</groupId>
                <artifactId>jfreechart</artifactId>
                <version>1.0.19</version>
            </dependency>
        </dependencies>
        */
        convertToGraph("memory_points.csv");
    }

    // Just for convenience
    public static void line() {
        System.out.println("_______________________________________________________");
    }
}

