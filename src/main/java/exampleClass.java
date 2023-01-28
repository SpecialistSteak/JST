public class exampleClass implements Comparable<exampleClass> {
    int a;
    int b;
    int c;

    public exampleClass(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public exampleClass() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }

    public String toString() {
        return String.format("a = %d| b = %d| c = %d|", a, b, c);
    }

    @Override
    public int compareTo(exampleClass o) {
        return (this.a + this.b + this.c) - (o.a + o.b + o.c);
    }
}
