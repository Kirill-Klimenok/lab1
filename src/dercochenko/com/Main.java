package dercochenko.com;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        //Task 1
        Task_1 sum;
        sum = (x, y, z) -> x + y + z;
        System.out.println(sum.operation(1, 2, 3));

        Task_1 multiplication;
        multiplication = (x, y, z) -> x * y * z;
        System.out.println(multiplication.operation(1, 2, 3));
        Factorial factorial;
        factorial = (x) -> {
            int fac = x;
            for (int i = 1; i < x; i++) {
                fac = fac * i;
            }
            return fac;
        };
        System.out.println(factorial.fact(3));

        PrimeNumber primeNumber;
        primeNumber = (x) -> {
            int k = 0;
            for (int i = 2; i < x; i++) {
                if (x % x == 0) {
                    if (x % i == 0) {
                        k++;
                    }
                }

            }
            if (k == 0) {
                return ("число простое");
            } else {
                return ("число сложное");
            }

        };
        System.out.println(primeNumber.prime(10));

        //Task 2
/*Задание 2. Создайте и вызовите следующие лямбда-выражения. Обязательно использовать лямбду, как параметр метода.
 Метод находит сумму элементов массива, которые соответствуют условию лямбда-выражения.
Варианты лямбда-выражений:
■ Проверка на четность;
■ Проверка на нечетность;
■ Число находится в диапазоне от A до B;
■ Проверка на кратность параметру A.
*/
        //1
        int[] mass = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int a = 9, b = 10;
        EvenNumber evenNumber;

        evenNumber = (number) -> number % 2 == 0;

        System.out.println(sum(evenNumber, mass));

        //2
        evenNumber = (number) -> number % 2 != 0;

        System.out.println(sum(evenNumber, mass));


        //3
        evenNumber = (number) -> number >= a && number <= b;

        System.out.println(sum(evenNumber, mass));

        //4
        evenNumber = (number) -> number % a == 0;
        System.out.println(sum(evenNumber, mass));

        //Task 3

        //1
        maxMin<Double> max = (firstNumber, secondNumber) -> firstNumber > secondNumber ? firstNumber : secondNumber;
        System.out.println("Max: " + max.maxOrMin(12.841124, 12.841123));

        //2
        maxMin<Integer> min = (firstNumber, secondNumber) -> firstNumber < secondNumber ? firstNumber : secondNumber;
        System.out.println("Min: " + min.maxOrMin(19, 25));


        //Task 3.2
        maxMinOfThree<Double> maxInNumbers = (number1, number2, number3) -> {
            if (number1 < number2) number1 = number2;
            if (number1 < number3) number1 = number3;
            return number1;
        };

        System.out.println("Max: " + maxInNumbers.maxOrMin(1.04, 1.22, 1.13));

        maxMinOfThree<Integer> minInNumbers = (number1, number2, number3) -> {
            if (number1 > number2) number1 = number2;
            if (number1 > number3) number1 = number3;
            return number1;
        };

        System.out.println("Min: " + minInNumbers.maxOrMin(4, 5, 1));

        //Task4
        Task4<Integer> maxNumber = (number) -> {
            if (number.length > 3) return null;
            else if (number.length == 3) {
                if (number[0] > number[1]) number[0] = number[1];
                if (number[0] < number[2]) number[0] = number[2];
                return number[0];
            } else if (number.length == 2) return number[0] > number[1] ? number[0] : number[1];
            return number[0];
        };
        System.out.println("Test: " + maxNumber.method(12, 43, 28));
    }


    public static int sum(EvenNumber evenNumber, int[] mass) {
        int result = 0;
        for (int i : mass)
            if (evenNumber.isFit(i)) result += i;

        return result;
    }

    /**
     * Task 1
     */
    interface Task_1 {
        int operation(int x, int y, int z);
    }

    /**
     * Task 1
     */
    interface Factorial {
        int fact(int x);
    }

    /**
     * Task 1
     */
    interface PrimeNumber {
        String prime(int x);
    }

    /**
     * Task2
     * 4 points
     */
    interface EvenNumber {
        boolean isFit(int number);
    }

    /**
     * Task 3.z
     * 2 points
     */
    interface maxMin<T extends Comparable> {
        T maxOrMin(T firstNumber, T secondNumber);
    }

    /**
     * Task 3.2
     * 2 points
     */
    interface maxMinOfThree<T extends Comparable> {
        T maxOrMin(T number1, T number2, T number3);
    }

    /**
     * Task 4
     * 1 point
     */
    interface Task4<T extends Comparable> {
        T method(T... number);
    }
}


