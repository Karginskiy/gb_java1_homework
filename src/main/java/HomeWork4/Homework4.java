package HomeWork4;

public class Homework4 {

    public static void main(String[] args) {

        Employee[] employees = new Employee[5];
        
        employees[0] = new Employee("Kargin N", "student", "hei@spark-mail.ru",
                                    "+7-988-255-08-60", 150000, 22);
        employees[1] = new Employee("Zinovyev R", "president", "zinovyev@ruslan.com",
                                    "+7-913-252-99-22", 1000000, 32);
        employees[2] = new Employee("Osvald L-H", "bibliographer", "harvey@osvald.com",
                "+7-913-222-33-55", 10000, 24);
        employees[3] = new Employee("Bezumniy Max", "anti-utopist", "mad@max.com",
                "+7-913-252-99-22", 0, 35);
        employees[4] = new Employee("John Kennedy", "president", "deadjohn@shot.com",
                "+7-913-252-99-00", 0, 46);

        for (Employee employee : employees) {
            if (employee.age > 40) {
                System.out.println(employee);
            }
        }

    }

    private static class Employee {

        String name;
        String position;
        String email;
        String phone;
        int salary;
        int age;

        Employee(String name, String position, String email,
                 String phone, int salary, int age) {

            this.name = name;
            this.position = position;
            this.email = email;
            this.phone = phone;
            this.salary = salary;
            this.age = age;

        }

        @Override
        public String toString() {
            return "name='" + name + '\'' +
                    ", position='" + position + '\'' +
                    ", email='" + email + '\'' +
                    ", phone='" + phone + '\'' +
                    ", salary=" + salary +
                    ", age=" + age;
        }
    }


}
