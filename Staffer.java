public class Staffer {
    public String name;
    public String position;
    public int age;
    public String mailbox;
    public String phone_number;
    public double salary;

    public static void main(String[] args) {

    }

    public Staffer(String name,
                   String position,
                   int age,
                   String mailbox,
                   String phone_number,
                   double salary) {
        this.name = name;
        this.position = position;
        this.age = age;
        this.mailbox = mailbox;
        this.phone_number = phone_number;
        this.salary = salary;
    }

    public void information() {
        System.out.println(" ФИО сотрудника: " + name + "\n должность: " +
                position + "\n возраст: " +
                age + "\n адрес электронной почты: " +
                mailbox + "\n номер телефона: " +
                phone_number + "\n зарплата: " +
                salary);
        System.out.println();
    }


}
