package GenerateRandomDigit;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 * 7 вариант( 10, 11*11 ) K = 2 Критическое значение для хи2 = 16,91898
 */
public class GeneratorDigit {

    //const
    private final int LINE_SEGMENT = 10; // количество отрезков в выборках

    //value
    private final int interval;
    private final int div;
    private final int b;
    private double start;
    private double nextStart;
    private final int countPoint;                          // количество точек
    private double hi;                                           // хи квадрат
    private int[] arrayOne;                                  // массив значений выборки
    private List<Double> dataCoefList;

    // CONSTRUCTORS
    public GeneratorDigit(int countPoint) {
        this.countPoint = countPoint;
        interval = 134456;
        div = 8121;
        b = 28411;
        start = 0.0d;
        nextStart = 0.0d;
        hi = 0.0d;
        dataCoefList = new ArrayList();
    }

    //GETTERS AND SETTERS
    public List getDataCoefList() {
        return this.dataCoefList;
    }

    //WORK FUNCTION
    public double mainFunction(double value) {
        return (div * value + b) % interval;
    }

    public void checkIntervalOne(double value) {
        //Хардкодим интервалы
        dataCoefList.add(value);
        if ((value >= 0) && (value < 0.1)) {
            arrayOne[0]++;
        }
        if ((value >= 0.1) && (value < 0.2)) {
            arrayOne[1]++;
        }
        if ((value >= 0.2) && (value < 0.3)) {
            arrayOne[2]++;
        }
        if ((value >= 0.3) && (value < 0.4)) {
            arrayOne[3]++;
        }
        if ((value >= 0.4) && (value < 0.5)) {
            arrayOne[4]++;
        }
        if ((value >= 0.5) && (value < 0.6)) {
            arrayOne[5]++;
        }
        if ((value >= 0.6) && (value < 0.7)) {
            arrayOne[6]++;
        }
        if ((value >= 0.7) && (value < 0.8)) {
            arrayOne[7]++;
        }
        if ((value >= 0.8) && (value < 0.9)) {
            arrayOne[8]++;
        }
        if ((value >= 0.9) && (value < 1)) {
            arrayOne[9]++;
        }
    }

    public void checkIntervalTwo(double value) {
        //Хардкодим интервалы1
        if ((value >= 0) && (value < 0.09090909090909091)) {
            arrayOne[0]++;
        }
        if ((value >= 0.09090909090909091) && (value < 0.18181818181818182)) {
            arrayOne[1]++;
        }
        if ((value >= 0.18181818181818182) && (value < 0.2727272727272727)) {
            arrayOne[2]++;
        }
        if ((value >= 0.2727272727272727) && (value < 0.36363636363636365)) {
            arrayOne[3]++;
        }
        if ((value >= 0.36363636363636365) && (value < 0.4545454545454546)) {
            arrayOne[4]++;
        }
        if ((value >= 0.4545454545454546) && (value < 0.5454545454545455)) {
            arrayOne[5]++;
        }
        if ((value >= 0.5454545454545455) && (value < 0.6363636363636365)) {
            arrayOne[6]++;
        }
        if ((value >= 0.6363636363636365) && (value < 0.7272727272727274)) {
            arrayOne[7]++;
        }
        if ((value >= 0.7272727272727274) && (value < 0.8181818181818183)) {
            arrayOne[8]++;
        }
        if ((value >= 0.8181818181818183) && (value < 0.9090909090909093)) {
            arrayOne[9]++;
        }
        if ((value >= 0.9090909090909093) && (value < 1)) {
            arrayOne[10]++;
        }
    }

    /**
     * Генерируем одномерную выборку
     */
    public void generatorRunOne() {
        arrayOne = new int[LINE_SEGMENT];
        for (int i = 0; i < countPoint; i++) {
            start = mainFunction(start);
            checkIntervalOne(start / (double) interval);
        }
        for (int i = 0; i < arrayOne.length; i++) {
            System.out.println("Интервал " + (i + 1) + " ,количество входящих точек = " + '\t' + arrayOne[i]);
        }
    }

    /**
     * Генерируем двуменрную выборку
     */
    public void generatorRunTwo() {
        arrayOne = new int[11];

        if (start != 0) {
            start = nextStart;
        }
        for (int j = 0; j < 11; j++) {
            for (int i = 0; i < arrayOne.length; i++) {
                arrayOne[i] = 0;
            }
            System.out.println();
            System.out.println("Двумерная выборка № " + (j + 1));
            for (int i = 0; i < countPoint; i++) {
                start = mainFunction(start);
                checkIntervalTwo(start / (double) interval);
            }
            nextStart = start;
            for (int i = 0; i < arrayOne.length; i++) {
                System.out.println("Интервал " + (i + 1) + " ,количество входящих точек = " + '\t' + arrayOne[i]);
            }
        }
        System.out.println();
    }

    /**
     * Считаем хи-квадрат
     *
     * @return
     */
    public String calcHiSquare() {
        //выбираем, для какой выбоки считаем этот параметр
        int f = 0;
        switch (this.countPoint) {
            case 120: { // для малой
                f = 12;
                break;
            }
            case 1200: { // для средней
                f = 120;
                break;
            }
            case 12000: {    // для большой
                f = 1200;
                break;
            }
        }
        //бежим по всем значениям и пересчитываем hi
        for (int i = 0; i < arrayOne.length; i++) {
            hi += (Math.pow((arrayOne[i] - f), 2) / f);
        }
        return String.valueOf(hi);
    }

    /**
     * Расчитывает математическое ожидание случайной велечины
     *
     * @param list список случайных велечин
     * @return математическое ожидание
     */
    public static double calculateExpectedValue(List<Double> list) {
        double sum = list.stream()
                .mapToDouble(s -> s)
                .sum();
        return sum / list.size();
    }


    /**
     * Расчитать начальный момент случайной велечины
     *
     * @param list список случайныъ велечин
     * @param k степень
     * @return начальный момент
     */
    public static double calculateInitialMoment(List<Double> list, int k) {
        return calculateExpectedValue(list.stream()
                .map(s -> Math.pow(s, k))
                .collect(toList())
        );
    }

    /**
     * Расчитать центральный момент случайной велечины
     *
     * @param list спсок случайных велечин
     * @param k степень
     * @return центральный момент
     */
    public static double calculateCentralMoment(List<Double> list, int k) {
        double expValue = calculateExpectedValue(list);
        return calculateExpectedValue(list.stream()
                .map(s -> Math.pow(s - expValue, k))
                .collect(toList())
        );
    }

    /**
     * Расчитать выборочную дисперсию случайной велечины
     *
     * @param list список случайных велечин
     * @return дисперсия
     */
    public static double calculateDispersion(List<Double> list) {
        return calculateCentralMoment(list, 2);
    }

    /**
     * Посчитать коэффициент автокорелляции
     *
     * @param list список случайных велечин
     * @param k шаг
     * @return коэффициент автокорелляции
     */
    public static double calculateAutocorrelation(List<Double> list, int k) {
        List<Double> forCalculationList
                = list.stream()
                .map(s -> s -= 0.5)
                .collect(toList());
        // количество пар использованых для расчета
        int manyPairs = 0;
        List<Double> resultList = new ArrayList<>();
        for (int i = 0; i < forCalculationList.size(); i++) {
            double mult = forCalculationList.get(i);
            if (i + k < forCalculationList.size()) {
                mult *= forCalculationList.get(i + k);
                manyPairs++;
                resultList.add(mult);
            }
        }

        for (int i = 0; i < resultList.size(); i++) {
            double res = resultList.get(i);
            resultList.set(i, res / manyPairs);
        }

        double sum = resultList.stream()
                .mapToDouble(s -> s)
                .sum();

        return sum / calculateDispersion(list);
    }

    public static double calculateConfidenceInterval(List<Double> list, Double t) {
        return t * Math.sqrt(calculateDispersion(list) / list.size());
    }


}
