public class FinancialForecaster {

    // Recursive approach
    public static double forecastRecursive(double currentValue, double rate, int years) {
        if (years == 0) return currentValue;
        return forecastRecursive(currentValue, rate, years - 1) * (1 + rate);
    }

    // Optimized recursive approach with memoization
    public static double forecastMemoized(double currentValue, double rate, int years, Double[] memo) {
        if (years == 0) return currentValue;
        if (memo[years] != null) return memo[years];
        memo[years] = forecastMemoized(currentValue, rate, years - 1, memo) * (1 + rate);
        return memo[years];
    }

    // Iterative approach (best for performance)
    public static double forecastIterative(double currentValue, double rate, int years) {
        for (int i = 0; i < years; i++) {
            currentValue *= (1 + rate);
        }
        return currentValue;
    }

    public static void main(String[] args) {
        double currentValue = 10000;
        double rate = 0.10; // 10% annual growth
        int years = 5;

        System.out.printf("Recursive: ₹%.2f\n", forecastRecursive(currentValue, rate, years));

        Double[] memo = new Double[years + 1];
        System.out.printf("Memoized: ₹%.2f\n", forecastMemoized(currentValue, rate, years, memo));

        System.out.printf("Iterative: ₹%.2f\n", forecastIterative(currentValue, rate, years));
    }
}
