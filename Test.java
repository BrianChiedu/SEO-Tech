package dev.brymocodes;

public class Test {
    public static void main(String[] args) {
        //System.out.println(solver(new String[]{"1","2","3","4","5","6","7"}));
        String[] expression = {"1", "1", "1", "o", "Twenty Two", " 1  ", "4"};
        System.out.println(solver(expression));
    }

    public static double solver(String[] expression){

        double[] input = new double[expression.length];
        for(int i = 0; i < expression.length; i++){
            try {
                input[i] = Double.parseDouble(expression[i]);
            } catch (NumberFormatException nfe) {
                input[i] = 0;;
            }
        }

        return add(input.length-1, input);
    }


    public static double add(int n, double... a){
        if (n == 0) {
            return a[n];
        }
        else {
            return a[n] + add(n - 1, a);
        }
    }

}