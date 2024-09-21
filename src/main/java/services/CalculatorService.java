package services;

public class CalculatorService {
    public Integer factorial(Integer n){
        if (n == 1 || n == 0) return 1;
        else if (n<1) return -1;
        return n*factorial(n-1);
    }

    public Double power(Double base, Double exp){
        return Math.pow(base, exp);
    }

    public Double logarithm(Double n){
        if (n<=0) return Double.NaN;
        return Math.log(n);
    }

    public Double sqrt(Double n){
        if (n<0) return Double.NaN;
        return Math.sqrt(n);
    }
}

