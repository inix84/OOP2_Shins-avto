package transport;

import transport.Car;

public class Main {
    public static void main(String[] args) {
        Car LadaGranta = new Car(
                "Lada",
                "Granta",
                2015,
                "Россия",
                "желтый",
                1.7,
                "механика",
                "седан",
                "а123аа456",
                4,
                false);
        Car AudiA8 = new Car(
                "Audi",
                "A8 50 L TDI quattro",
                2020,
                "Германия",
                "черный",
                3.0,
                "автомат",
                "грузовой",
                "в258вв147",
                4,
                true);
        Car BMWZ8 = new Car(
                "BMW",
                "Z8",
                2021,
                "Германия",
                "черный",
                3.0,
                "автомат",
                "седан",
                "и269тр147",
                5,
                false);
        Car KiaSportage4 = new Car(
                "Kia",
                "Sportage 4-го поколения",
                2018,
                "Южная Корея",
                "красный",
                2.4,
                "автомат",
                "седан",
                "в708ен999",
                3,
                true);
        Car HyundaiAvante = new Car(
                "Hyundai",
                "Avante",
                2016,
                "Южная Корея",
                "оранжевый",
                1.6,
                "механика",
                "седан",
                "л025ук369",
                4,
                false);
        Car NoName = new Car(
                null,
                "",
                -2015,
                "",
                "",
                -1.7,
                "",
                "",
                "номер",
                0,
                true);
        System.out.println(LadaGranta);
        System.out.println(AudiA8);
        System.out.println(BMWZ8);
        System.out.println(KiaSportage4);
        System.out.println(HyundaiAvante);
        System.out.println(NoName);
        NoName.changeTyres();
        System.out.println(NoName);
        if (NoName.isCorrectRegNumber()) {
            System.out.println("Номер модели "+
                    NoName.getBrand()+ " "+
                    NoName.getModel()+
                    " задан корректно!");
        } else {
            System.out.println("Номер модели "+
                    NoName.getBrand()+ " "+
                    NoName.getModel()+
                    " задан не корректно!");
        }

    }

}