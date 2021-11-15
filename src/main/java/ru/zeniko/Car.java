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
     * Конструктор - создание нового объекта
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
     * Конструктор - создание нового объекта
     *
     * @param engineVolume - объем двигателя в литрах
     * @param power        - мощность двигателя в л.с.
     * @param body         - тип кузова
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
     * Конструктор - создание нового объекта
     *
     * @param car - объект класса Car
     * @see Car#Car()
     * @see Car#Car(float, int, Boby)
     */
    Car(Car car) {
        if (car != null){
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
     * @param engineVolume мощность двигателя в л.с.
     */
    public boolean setEngineVolume(float engineVolume) {
        if (engineVolume < 0f || engineVolume >= Car.MAXENGINEVOLUME) {
            System.out.println(format("Значение объема двигателя %3.1f вне диапазона [%3.1f, %3.1f)",
                    engineVolume, 0f, Car.MAXENGINEVOLUME));
            return false;
        } else {

            this.engineVolume = ((int)(engineVolume*10))/10.0f;
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
     * @param power - мощность двигателя в л.с.
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
     * @param body - тип кузова
     */
    public void setBody(Boby body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return format("Тип кузова: %s \nОбъем двигателя: %3.1f л.\nМощность двигателя: %d л.с.\n",
                body == null ? "не установлен" : body, engineVolume, power);
    }

    static class Drawing{

        public static void printConstantsCar(){
            System.out.println(format("Максимальное значение объема двигателя: %3.1f л. \nМаксимальное значение мощности двигателя: %d",
                    MAXENGINEVOLUME, MAXPOWER));
        }

        public static boolean setMaxEngineVolume(float value){
            if (value < 0f) {
                System.out.println("Значение объема двигателя меньше нуля");
                return false;
            } else {
                MAXENGINEVOLUME = ((int)(value*10))/10.0f;
                return true;
            }
        }
        public static boolean setMaxPower(int value){
            if (value < 0f) {
                System.out.println("Значение мощности двигателя меньше нуля");
                return false;
            } else {
                MAXPOWER = value;
                return true;
            }
        }
    }
}
