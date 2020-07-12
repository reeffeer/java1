public class Main {


    public static void main(String[] args) {

        int age_limit = 40;
        Staffer[] staffArray = new Staffer[5];
        staffArray[0] = new Staffer("Бо И Ни", "арт-директор", 36, "boni@bk.ru", "429756347", 270500.4);
        staffArray[1] = new Staffer("Роберт Карл Хартвуд", "моушн-дизайнер", 29, "robkar@bk.ru", "476348709", 124500);
        staffArray[2] = new Staffer("Шон Чхан Дун", "бухгалтер", 53, "shondoone@bk.ru", "479478820", 97350.6);
        staffArray[3] = new Staffer("Джу Май Ким", "директор по персоналу", 37, "kimay@bk.ru", "470037745", 143260);
        staffArray[4] = new Staffer("Фэй Шу Хон", "дизайнер-проектировщик", 31, "fayhon@bk.ru", "4705398026", 112750.5);
        for (int i = 0; i < staffArray.length; i++) {
            if (staffArray[i].age > age_limit) {
               staffArray[i].information();
            }
        }
    }
}
