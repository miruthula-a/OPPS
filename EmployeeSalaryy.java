import java.util.Scanner;

class Employee {
    String empName, address, mailId, mobileNo;
    int empId;
    double bp, da, hra, pf, staffClub, grossSalary, netSalary;

    void getData() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Employee Name: ");
        empName = sc.nextLine();

        System.out.print("Employee ID: ");
        empId = sc.nextInt();
        sc.nextLine();

        System.out.print("Address: ");
        address = sc.nextLine();

        System.out.print("Mail ID: ");
        mailId = sc.nextLine();

        System.out.print("Mobile No: ");
        mobileNo = sc.nextLine();

        System.out.print("Basic Pay: ");
        bp = sc.nextDouble();
    }

    void display() {
        System.out.println("\nOUTPUT");
        System.out.println("DA = " + da);
        System.out.println("HRA = " + hra);
        System.out.println("PF = " + pf);
        System.out.println("Staff Club Fund = " + staffClub);
        System.out.println("Gross Salary = " + grossSalary);
        System.out.println("Net Salary = " + netSalary);
    }
}

class Programmer extends Employee {
    void calculateSalary() {
        da = bp * 97 / 100;
        hra = bp * 10 / 100;
        pf = bp * 12 / 100;
        staffClub = bp * 1 / 100;

        grossSalary = bp + da + hra;
        netSalary = grossSalary - (pf + staffClub);
    }
}

class AssistantProfessor extends Employee {
    void calculateSalary() {
        da = bp * 110 / 100;
        hra = bp * 20 / 100;
        pf = bp * 12 / 100;
        staffClub = bp * 5 / 100;

        grossSalary = bp + da + hra;
        netSalary = grossSalary - (pf + staffClub);
    }
}

class AssociateProfessor extends Employee {
    void calculateSalary() {
        da = bp * 130 / 100;
        hra = bp * 30 / 100;
        pf = bp * 12 / 100;
        staffClub = bp * 10 / 100;

        grossSalary = bp + da + hra;
        netSalary = grossSalary - (pf + staffClub);
    }
}

class Professor extends Employee {
    void calculateSalary() {
        da = bp * 140 / 100;
        hra = bp * 40 / 100;
        pf = bp * 12 / 100;
        staffClub = bp * 15 / 100;

        grossSalary = bp + da + hra;
        netSalary = grossSalary - (pf + staffClub);
    }
}

public class EmployeeSalaryy {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Programmer");
        System.out.println("2. Assistant Professor");
        System.out.println("3. Associate Professor");
        System.out.println("4. Professor");

        System.out.print("Enter Choice: ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                Programmer p = new Programmer();
                p.getData();
                p.calculateSalary();
                p.display();
                break;

            case 2:
                AssistantProfessor ap = new AssistantProfessor();
                ap.getData();
                ap.calculateSalary();
                ap.display();
                break;

            case 3:
                AssociateProfessor asp = new AssociateProfessor();
                asp.getData();
                asp.calculateSalary();
                asp.display();
                break;

            case 4:
                Professor pr = new Professor();
                pr.getData();
                pr.calculateSalary();
                pr.display();
                break;

            default:
                System.out.println("Invalid Choice");
        }
    }
}