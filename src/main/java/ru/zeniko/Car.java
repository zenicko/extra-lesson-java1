package ru.zeniko;

import static java.lang.String.format;

/*** Определение перечисляемого типа <b>Boby</b>*/
enum Boby {sedan, stationWagon, hatchback, liftback, crossover, minivan};

/**
 * Класс Car со свойствами <b>engineVolume</b>, <b>power</b> и <b>body</b>.
 * В классе определены константы b>MAXPOWER</b> и <b>MAXENGINEVOLUME</b>.
 *
 * @version 0.1
 * @autor Zenicko.ru
 */

class Car {

    /*** Константа максимальная мощность двигателя */
    private static int MAXPOWER = 2500;

    /*** Константа максимальный объем двигателя */
    private static float MAXENGINEVOLUME = 10L;

    /*** Поле объем двигателя в литрах */
    private float engineVolume;

    /*** Поле мощность двигателя в л.с. */
    private int power;

    /*** Поле тип кузова */
    private Boby body;

    /**
     * Конструктор без параметров
     *
     * @see Car#Car(float, int, Boby)
     * @see Car#Car(Car)
     */
    Car() {
        engineVolume = 0L;
        power = 0;
        body = null;
    }

    /**
     * Конструктор с тремя параметрами
     *
     * @param engineVolume объем двигателя в литрах
     * @param power        мощность двигателя в л.с.
     * @param body         тип кузова
     * @see Car#Car()
     * @see Car#Car(Car)
     */
    Car(float engineVolume, int power, Boby body) {
        if (!setEngineVolume(engineVolume))
            setEngineVolume(0f);
        if (!setPower(power))
            setPower(0);
        setBody(body);
    }

    /**
     * Конструктор с параметром обьект класса {@link Car}
     *
     * @param car объект класса Car
     * @see Car#Car()
     * @see Car#Car(float, int, Boby)
     */
    Car(Car car) {
        if (car != null) {
            setEngineVolume(car.engineVolume);
            setPower(car.power);
            setBody(car.body);
        }
    }

    /**
     * Функция получения значения поля {@link Car#engineVolume}
     *
     * @return возвращает объем двигателя в литрах
     */
    public float getEngineVolume() {
        return engineVolume;
    }

    /***
     * Процедура определения значения поля {@link Car#engineVolume}
     *
     * @param engineVolume объем двигателя в л.
     * @return возвращает true - если все нормально, false - если устанавливаемое значение
     * выходит за границы разумного
     */
    public boolean setEngineVolume(float engineVolume) {
        if (engineVolume < 0f || engineVolume >= Car.MAXENGINEVOLUME) {
            System.out.println(format("Значение объема двигателя %3.1f вне диапазона [%3.1f, %3.1f)",
                    engineVolume, 0f, Car.MAXENGINEVOLUME));
            return false;
        } else {

            this.engineVolume = ((int) (engineVolume * 10)) / 10.0f;
            return true;
        }
    }

    /**
     * Функция получения значения поля {@link Car#power}
     *
     * @return возвращает мощность двигателя в л.с.
     */
    public int getPower() {
        return power;
    }

    /***
     * Процедура определения мощности двигателя {@link Car#power}
     *
     * @param power мощность двигателя в л.с.
     * @return возвращает true - если все нормально, false - если устанавливаемое значение
     * выходит за границы разумного
     */
    public boolean setPower(int power) {
        if (power < 0 || power >= Car.MAXPOWER) {
            System.out.println(format("Значение мощности двигателя %d вне диапазона [%d, %d)",
                    power, 0, Car.MAXPOWER));
            return false;
        } else {
            this.power = power;
            return true;
        }
    }

    /**
     * Функция получения значения поля {@link Car#body}
     *
     * @return возвращает тип кузова
     */
    public Boby getBody() {
        return body;
    }

    /**
     * Процедура определения тип кузова {@link Car#body}
     *
     * @param body тип кузова
     */
    public void setBody(Boby body) {
        this.body = body;
    }

    /***
     * Переопределенный метод для вывода в консоль информации об объекте класса {@link Car}
     *
     * @return возвращает форматированную строку со сведениями об объекте
     * */

    @Override
    public String toString() {
        return format("Тип кузова: %s \nОбъем двигателя: %3.1f л.\nМощность двигателя: %d л.с.\n",
                body == null ? "не установлен" : body, engineVolume, power);
    }

    /***
     * Процедура имитирует звук двигателя. Тональность звука зависит от мощности двигателя.
     *
     * */
    void soundOfEngine(){
        if (power == 0)
            System.out.println("Шшшшш!");
        else if (power > 0 && power <= 75)
            System.out.println("Дыр-дыр-дыр");
        else if (power > 75 && power <= 150)
            System.out.println("Дып-фр-дыр");
        else if (power > 150 && power <= 300)
            System.out.println("Дыр-Фр-фррр");
        else if (power > 300 && power <= 500)
            System.out.println("Фр-фр-фррррр");
        else if (power > 500)
            System.out.println("Ничего слышу! Можно громче!");
    }

    /**
     * Класс Drawing (static nested class). Методы класса устанавливают значения
     * "констант" b>MAXPOWER</b> и <b>MAXENGINEVOLUME</b> класса Car.
     *
     * @version 0.1
     * @autor zenicko.ru
     */
    static class Drawing {

        /***
         * Процедура, выводящая в консоль сведения о максимально допустимых
         * значениях объема двигателя {@link Car#engineVolume} и мощности двигателя {@link Car#power}
         * */
        public static void printConstantsCar() {
            System.out.println(format("Максимальное значение объема двигателя: %3.1f л. \nМаксимальное значение мощности двигателя: %d",
                    MAXENGINEVOLUME, MAXPOWER));
        }

        /***
         * Метод, изменяющий предельное значение объема двигателя {@link Car#engineVolume}
         * @param engineVolume
         * @return возвращает true - если все нормально, false - если устанавливаемое значение
         * выходит за границы разумного
         */

        public static boolean setMaxEngineVolume(float engineVolume) {
            if (engineVolume < 0f) {
                System.out.println("Значение объема двигателя меньше нуля");
                return false;
            } else {
                MAXENGINEVOLUME = ((int) (engineVolume * 10)) / 10.0f;
                return true;
            }
        }

        /***
         * Метод, изменяющий предельное значение объема двигателя {@link Car#power}
         * @param power
         * @return возвращает true - если все нормально, false - если устанавливаемое значение
         * выходит за границы разумного
         */

        public static boolean setMaxPower(int power) {
            if (power < 0f) {
                System.out.println("Значение мощности двигателя меньше нуля");
                return false;
            } else {
                MAXPOWER = power;
                return true;
            }
        }
    }
}
