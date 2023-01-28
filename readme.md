# Welcome to PFLib!

PFLib is a simple library with features surrounding quick testing of programs without dependencies or too much code. In the future I plan to add graphing utilities, which can help you visualize your code's performance graphically.

# Installation*
To 'install' pflib, just copy the desired package into your code. Then, remove the package when you're done. No need for dependencies or imports. 

# Algorithms
#### Algorithms:
- Iterative bubble sort
- Arrays.Sort()
- Single pivot quick sort
- Heap sort
- Merge sort
- Insertion sort
- HashMap sort
- Fisher-Yates shuffle

<p>To use any of these sorting algorithms, first make sure you have implemented Comparable in your class:</p>

`class ExampleClass implements Comparable {`
<p>Then, just call upon any of the sort methods to sort your array:</p>

`quicksort(array) //rearranges the array and puts it back in place.`
<p>If you want to call upon the 'testAll' method:</p>

`testAll(array);`
<p>Where the output will look something like:</p>

```
Iterative bubble sort  : 26735800ns
Arrays.sort            : 1816800ns
Standard quick sort    : 645400ns
Standard heap sort     : 1775800ns
Standard merge sort    : 2290000ns
Standard insertion sort: 150100ns
HashMap sort           : 2078700ns
```
<p>It will print out the runtimes for each of the different sort algorithms on your specific array.</p>

# Object Utilities
#### Type Conversions:
- Object[] -> int[]
- Object[] -> double[]
- Object[] -> char[]
- Object[] -> String[]
<p>To use any of these, just pass in a compatible array, and it will return the desired array:</p>

`int[] intArrayFromObject = toIntArray(objectArray[]);`

#### Type Testing:
- getVarType()
- getVarTypeName()
<p>To use any of these, it might look like the following:</p>

```
var t = new ExampleClass();
switch (getVarType(t)) {
  case OBJECT -> {
	  System.out.println("t is an Object");
	  System.out.println(getVarTypeName(t));
  } 
  case INT -> System.out.println("t is an int");  
  default -> System.out.println("t is not an Object or an int");  
}
```
And the output would look something like:

```
t is an int
ExampleClass
```

#### Populating:
- Generate random values of each primitive type/wrapper type
- Generate a string with random values
- Generate a copy of an object:
    - All primitive fields on the object will be randomized
    - All primitive fields on each included sub-object of the object will also be randomized
    - Most arrays of primitives and non-primitives will also be randomized **[WILL ADD MORE SUPPORT FOR THESE TYPES IN FUTURE]**

<p>To generate a random value:</p>

`int i1 = (Integer) getValue(Types.INT);`
<p>Or to generate a random array:</p>

```
Integer[] arr = new Integer[1000];  
arr = (Integer[]) populate(Types.INT, 1000); 
```

<p>To generate new object/s:</p>

``` 
// for this example,ExampleClass has int a, b,and c fields.
ExampleClass[] arr2 = new ExampleClass[1000];  
for (int i = 0; i < arr2.length; i++) {  
  arr2[i] = (ExampleClass) cloneAndModify(new ExampleClass());  
}
```
<p>Where one of the new objects might look something like:</p>

` a = -66539059, b = -1576178770, c = -864918695`


# Time Testing
#### Time testing:
- Time testing code fragments with lambdas
- Time testing without lambdas
- TimeTester object for logging

To get started, a TimeTester object is simply an ArrayList of Times objects:
```
long startTime;  
long endTime;  
long elapsedTime;  
String title;
```
If you want to log multiple different times, you must use the non-static method:
```
TimeTester timeTester = new TimeTester();  
timeTester.startTimer("Optional timer name");  
System.out.println("Something would happen here...");  
timeTester.stopTimer();  
```
Which will add a new entry to the ArrayList including all provided values, or "" if your title is unspecified. To directly pass in code (through lambdas), you can do the following:

`TimeTester.runCode(() -> {});`

If you want to log it with a title (to a TimeTester object):

`TimeTester.runCode(() -> {}, "Quicksort Time"); `

Or if you want to use the static version and save it somewhere else:

`long l1 = runCode(() -> {});`

And to go about printing it, you might do the following:
```
System.out.println(SECONDS.convertTime(TimeTester.runCode(() -> {})) + SECONDS.toString());  
System.out.println(staticConvertTime(TimeTester.runCode(() -> {}), TimeUnits.NANOSECONDS) + "ns");
```

# Memory Usage Testing
Memory Usage Testing:
- MemoryTester object for logging
- getLineNumber() method
- getFreeMemory() method

To get started, a MemoryTester object is simply an ArrayList of MemoryPoint objects:
```
double memoryUsagePercent;  
int lineNumber;
```
If you want to log line numbers and memory usage, you can go about it by doing the following:
```
MemoryTester memoryTester = new MemoryTester();  
memoryTester.logUsedMemory(getLineNumber()); //(you can input any int)  
```

This will add a new point to the ArrayList with the line number and usage percent. If you just want to get the percent of free memory:

`double d1 = getUsableFreeMemory();`

Or to get the percent of used memory:

`double d1 = getUsedMemory();`

After you finish logging memory at different points, you can export the data to a CSV using the convertToCSV() method:

`convertToCSV(memoryTester, new File("memory_points.csv"));`

Which will generate a new CSV file in the root directory. **[THERE WILL BE SUPPORT FOR GRAPHING IT TO AN IMAGE FILE IN THE FUTURE]**
# Stack Logging Testing
#### StackTester:
- StackTester object
- printStack() static and non-static method
- saveLogToFile() method

To get started, a StackTester object is simply an ArrayList of StackElements objects:
```
private final StackTraceElement[] stackTraceElements;  
private final Date currentTime;  
private final int LineNumber;
```
If you want to log line stack traces, you can go about it by doing the following:

```
StackTester stackTester = new StackTester();
stackTester.logStackTrace(getLineNumber());
```

Then, to print out the stack logs:

`stackTester.printLog();`

Or to simply print the stack trace:

`printStack()`

Then, if you want to save it all to a file:
```
try {  
  stackTester.saveLogToFile(new File("log.txt"));  
} catch (Exception e) {  
  e.printStackTrace();  
}  
```

# Thanks for reading this far! I hope you find this library useful. 
####  If you have any questions, feel free to ask me on GitHub, or check the JavaDocs for more information. I plan on adding more features in the future, so stay tuned!
