package GenerateRandomDigit;

public class Main {

    public static void main(String[] args) {

        GeneratorDigit smallSample = new GeneratorDigit(120); // малая выборка
        GeneratorDigit normalSample = new GeneratorDigit(1200); // средняя выборка
        GeneratorDigit bigSample = new GeneratorDigit(12000); // большая выборка

        ////////////////////////ОДНОМЕРНАЯ ВЫБОРКА////////////////////////
        System.out.println("\n////////////////////////ОДНОМЕРНАЯ МАЛАЯ ВЫБОРКА////////////////////////");
        smallSample.generatorRunOne();
        System.out.println("\n////////////////////////ОДНОМЕРНАЯ СРЕДНЯЯ ВЫБОРКА////////////////////////");
        normalSample.generatorRunOne();
        System.out.println("\n////////////////////////ОДНОМЕРНАЯ БОЛЬШАЯ ВЫБОРКА////////////////////////");
        bigSample.generatorRunOne();

        System.out.println("\n////////////////////////ХИ-КВАДРАТ////////////////////////");
        System.out.println("Хи-квадрат малой выборки = " + smallSample.calcHiSquare());
        System.out.println("Хи-квадрат средней выборки = " + normalSample.calcHiSquare());
        System.out.println("Хи-квадрат большой выборки = " + bigSample.calcHiSquare());

        ////////////////////////ДВУМЕРНАЯ ВЫБОРКА////////////////////////
        System.out.println("\n////////////////////////ДВУМЕРНОЕ ПОСТРОЕНИЕ МАЛОЙ ВЫБОРКИ////////////////////////");
        smallSample.generatorRunTwo();
        System.out.println("////////////////////////ДВУМЕРНОЕ ПОСТРОЕНИЕ СРЕДНЕЙ ВЫБОРКИ////////////////////////");
        normalSample.generatorRunTwo();
        System.out.println("////////////////////////ДВУМЕРНОЕ ПОСТРОЕНИЕ БОЛЬШОЙ ВЫБОРКИ////////////////////////");
        bigSample.generatorRunTwo();

        System.out.println("\n////////////////////////КОЭФФИЦИЕНТ-t////////////////////////");

        System.out.println("\n////////////////////////МАЛАЯ ВЫБОРКА////////////////////////");
        System.out.println("Начальный момент");
        System.out.println(smallSample.calculateInitialMoment(smallSample.getDataCoefList(), 1));
        System.out.println(smallSample.calculateInitialMoment(smallSample.getDataCoefList(), 2));
        System.out.println("Центральный момент");
        System.out.println(smallSample.calculateCentralMoment(smallSample.getDataCoefList(), 1));
        System.out.println(smallSample.calculateCentralMoment(smallSample.getDataCoefList(), 2));
        System.out.println("Автокореляция");
        System.out.println(smallSample.calculateAutocorrelation(smallSample.getDataCoefList(), 2));
        System.out.println("Доверительный интервал");
        System.out.println(0.5 - smallSample.calculateConfidenceInterval(smallSample.getDataCoefList(), 1.69));
        System.out.println(0.5 + smallSample.calculateConfidenceInterval(smallSample.getDataCoefList(), 1.69));
        System.out.println("Мат ожидание");
        System.out.println(smallSample.calculateDispersion(smallSample.getDataCoefList()));


        System.out.println("\n////////////////////////СРЕДНЯЯ ВЫБОРКА////////////////////////");
        System.out.println("Начальный момент");
        System.out.println(normalSample.calculateInitialMoment(normalSample.getDataCoefList(), 1));
        System.out.println(normalSample.calculateInitialMoment(normalSample.getDataCoefList(), 2));
        System.out.println("Центральный момент");
        System.out.println(normalSample.calculateCentralMoment(normalSample.getDataCoefList(), 1));
        System.out.println(normalSample.calculateCentralMoment(normalSample.getDataCoefList(), 2));
        System.out.println("Автокореляция");
        System.out.println(normalSample.calculateAutocorrelation(normalSample.getDataCoefList(), 2));
        System.out.println("Доверительный интервал");
        System.out.println(0.5 - normalSample.calculateConfidenceInterval(normalSample.getDataCoefList(), 1.69));
        System.out.println(0.5 + normalSample.calculateConfidenceInterval(normalSample.getDataCoefList(), 1.69));
        System.out.println("Мат ожидание");
        System.out.println(normalSample.calculateDispersion(normalSample.getDataCoefList()));

        System.out.println("\n////////////////////////БОЛЬШАЯ ВЫБОРКА////////////////////////");
        System.out.println("Начальный момент");
        System.out.println(bigSample.calculateInitialMoment(bigSample.getDataCoefList(), 1));
        System.out.println(bigSample.calculateInitialMoment(bigSample.getDataCoefList(), 2));
        System.out.println("Центральный момент");
        System.out.println(bigSample.calculateCentralMoment(bigSample.getDataCoefList(), 1));
        System.out.println(bigSample.calculateCentralMoment(bigSample.getDataCoefList(), 2));
        System.out.println("Автокореляция");
        System.out.println(bigSample.calculateAutocorrelation(bigSample.getDataCoefList(), 2));
        System.out.println("Доверительный интервал");
        System.out.println(0.5 - bigSample.calculateConfidenceInterval(bigSample.getDataCoefList(), 1.69));
        System.out.println(0.5 + bigSample.calculateConfidenceInterval(bigSample.getDataCoefList(), 1.69));
        System.out.println("Мат ожидание");
        System.out.println(bigSample.calculateDispersion(bigSample.getDataCoefList()));

    }
}
