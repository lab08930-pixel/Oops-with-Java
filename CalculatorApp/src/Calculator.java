public class Calculator {

    public int add(int a, int b) { return a + b; }
    public float add(float a, float b) { return a + b; }
    public float add(int a, float b) { return a + b; }
    public float add(float a, int b) { return a + b; }

    public int subtract(int a, int b) { return a - b; }
    public float subtract(float a, float b) { return a - b; }
    public float subtract(int a, float b) { return a - b; }
    public float subtract(float a, int b) { return a - b; }

    public int multiply(int a, int b) { return a * b; }
    public float multiply(float a, float b) { return a * b; }
    public float multiply(int a, float b) { return a * b; }
    public float multiply(float a, int b) { return a * b; }


    public float division(float a, float b) {
        if (b == 0) {
            System.out.println("Error: Cannot divide by zero!");
            return 0.0f;
        }
        return a / b;
    }
    public float division(int a, int b) { return division((float)a, (float)b); }
    public float division(int a, float b) { return division((float)a, b); }
    public float division(float a, int b) { return division(a, (float)b); }
}