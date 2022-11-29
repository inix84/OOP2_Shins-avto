package transport;
import java.time.LocalDate;

public class Car {
    public static class Key {
        private final boolean remoteEngineStart;// Удаленный Запуск Двигателя
        private final boolean keylessAccess; //Бесключевой Доступ

        public Key (boolean remoteEngineStart, boolean keylessAccess) { // конструктор
            this.remoteEngineStart = remoteEngineStart;
            this.keylessAccess = keylessAccess;
        }

        public Key() { // конструктор c пустыми полями
            this(false,false);
        }

        public boolean isRemoteEngineStart() {
            return remoteEngineStart;
        }

        public boolean isKeylessAccess() {
            return keylessAccess;
        }
    }

    public static class Insurance { // страховка
    private final LocalDate validityPeriod; //Срок Действия страховки
    private final double cost;//    Стоимость
    private final String number;//Номер

        public Insurance(LocalDate validityPeriod, double cost, String number) {
            if (validityPeriod==null) {
                this.validityPeriod = LocalDate.now().plusDays(365);
            } else {
                this.validityPeriod=validityPeriod;
            }

            this.cost = cost;
            if (number==null) {
                this.number="123456789";
            } else {
                this.number = number;
            }
        }
        public Insurance() { // дефолтный

            this (null,10_000D,null);
        }
        public LocalDate getValidityPeriod() {
            return validityPeriod;
        }

        public double getCost() {
            return cost;
        }

        public String getNumber() {
            return number;
        }
        public void checkValidityPeriod() {
            if(validityPeriod.isBefore(LocalDate.now()) || validityPeriod.isEqual(LocalDate.now())) {
                System.out.println("Оформить новую страховку!!!");
            }
        }
        public void checkNunber () {
            if (number.length()!=9) {
                System.out.println("Номер страховки некорректный!");
            }
        }

    }


    private final String brand; //марка
    private final String model; // модель
    private double engineVolume; // обьем двигателя
    private String color; // цвет кузова
    private final int productionYear; // год произвдства
    private final String productionCountry; // страна сборки

    private String transmission; //«Коробка передач»,
    private final String bodyType; // «Тип кузова»,
    private String registrationNumber; //«Регистрационный номер»,
    private final int numberOfSeats; //«Количество мест»
    private boolean summerTyres; // летняя резина

    private Key key; // данные о ключе
    private Insurance insurance; // данные о страховке

    public Car (String brand, // конструтокр нормальный
         String model,
         int productionYear,
         String productionCountry,
         String color,
         double engineVolume,
         String transmission,
         String bodyType,
         String registrationNumber,
         int numberOfSeats,
         boolean summerTyres,
         Key key,
         Insurance insurance) {

        if (brand!=null && brand.length()!=0) {
            this.brand = brand;
        } else {
            this.brand = "default";
        }
        if (model!=null && model.length()!=0) {
            this.model=model;
        } else {
            this.model = "default";
        }
        if (engineVolume>0) {
            this.engineVolume = engineVolume;
        } else {
            this.engineVolume = 1.5;
        }
        if (color!=null && color.length()!=0) {
            this.color = color;
        } else {
            this.color = "белый";
        }
        if (productionCountry!=null && productionCountry.length()!=0) {
            this.productionCountry = productionCountry;
        } else {
            this.productionCountry = "default";
        }
        if (productionYear>0) {
            this.productionYear = productionYear;
        } else {
            this.productionYear =2000 ;
        }
        this.setTransmission(transmission); // на сете условия ввода данных

        if (bodyType!=null && bodyType.length()!=0) {
            this.bodyType = bodyType;
        } else {
            this.bodyType = "default";
        }
        this.setRegistrationNumber(registrationNumber); // на сете условия ввода

        if (numberOfSeats>0) {
            this.numberOfSeats = numberOfSeats;
        } else {
            this.numberOfSeats = 2;
        }
        this.setSummerTyres (summerTyres); // на сете условия не нуля
        if (key==null) {
            this.key = new Key();
        } else {
            this.key = key;
        }

        if (insurance==null) {
            this.insurance = new Insurance();
        } else {
            this.insurance = insurance;
        }
    }


    public Car (String brand, // конструтокр попроще с пустыми полями
                String model,
                int productionYear,
                String productionCountry,
                String color,
                double engineVolume,
                String transmission,
                String bodyType,
                String registrationNumber,
                int numberOfSeats,
                boolean summerTyres) {
        this (brand,
                model,
        productionYear,
        productionCountry,
        color,
        engineVolume,
        transmission,
        bodyType,
        registrationNumber,
        numberOfSeats,
        summerTyres,
                 new Key (),
                new Insurance ()
        );
    }


    @Override
    public String toString() {
        return "АВТО:" +
                "бренд=" + getBrand() +
                ", модель=" + getModel() +
                ", объем двигателя=" + getEngineVolume() +
                ", цвет=" + getColor() +
                ", год выпуска=" + getProductionYear() +
                ", страна сборки=" + getProductionCountry() +
                ", коробка передач=" + getTransmission() +
                ", тип кузова=" + getBodyType() +
                ", рег.номер=" + getRegistrationNumber() +
                ", количество мест=" + getNumberOfSeats() +
                ", " + (isSummerTyres() ? "летняя " : "зимняя ") + "резина" +
                ", " + (getKey().isKeylessAccess() ?  "бесключевой доступ" : "ключевой доступ") +
                ", " + (getKey().isRemoteEngineStart() ?  "удаленый запуск" : "обычный запуск") +
                ", номер страховки:" + getInsurance().getNumber()  +
                ", стоимость страховки:" + getInsurance().getCost()  +
                ", срок действия страховки:" + getInsurance().getValidityPeriod();
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        if (transmission!=null && transmission.length()!=0) {
            this.transmission = transmission;
        } else {
            this.transmission = "default";
        }
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber!=null && registrationNumber.length()!=0) {
            this.registrationNumber = registrationNumber;
        } else {
            this.registrationNumber = "х000хх000";
        }

    }

    public boolean isSummerTyres() { //  это геттер??
        return summerTyres;
    }

    public void setSummerTyres(boolean summerTyres) {
        this.summerTyres = summerTyres;
        }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public String getProductionCountry() {
        return productionCountry;
    }

    public String getBodyType() {
        return bodyType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public void changeTyres() {
        summerTyres = !summerTyres;
        }
    private boolean isCorrectRegNumber() {
        if (registrationNumber.length()!=9) {
            return  false;
        }
        char[] chars = registrationNumber.toCharArray();
        if (!Character.isAlphabetic(chars[0]) ||
                !Character.isAlphabetic(chars[4]) ||
                !Character.isAlphabetic(chars[5])) {
            return  false;
        }
        return  Character.isDigit(chars[1]) &&
                Character.isDigit(chars[2]) &&
                        Character.isDigit(chars[3]) &&
                                Character.isDigit(chars[6]) &&
                                        Character.isDigit(chars[7]) &&
                                                Character.isDigit(chars[8]);
    }
    
    public void CorrectRegNumber () {
        if (isCorrectRegNumber()) {
            System.out.println("Номер модели "+
                    getBrand()+ " "+
                    getModel()+
                    " задан корректно!");
        } else {
            System.out.println("Номер модели "+
                    getBrand()+ " "+
                    getModel()+
                    " задан не корректно!");
        }
    }
    public Insurance getInsurance() {
        return insurance;
    }
    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
}

