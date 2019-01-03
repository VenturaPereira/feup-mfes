import java.io.Console;
import java.util.Scanner;

public class StudentScreen {

    private Scanner scanner;
    private String username, password;

    public void clrsrc() {
        for (int i = 0; i < 100; i++) System.out.println("\f");
    }
    public void print_logo() {
        System.out.println(" __          ___ ___  __   __         ___  ___  __   __  ");
        System.out.println("/__` |  | | |__   |  |__) |__) | |\\ |  |  |__  |__) /__` ");
        System.out.println(".__/ |/\\| | |     |  |    |  \\ | | \\|  |  |___ |  \\ .__/ ");
        System.out.println("The fastest university-focused printing service\f");
    }

    public StudentScreen() {
        this.scanner = new Scanner(System.in);
    }

    public void spinner_animation(int seconds) {
        try {
            for (int i = 0; i < seconds; i++) {
                System.out.print("-"); Thread.sleep(250);
                System.out.print("\b\\"); Thread.sleep(250);
                System.out.print("\b|"); Thread.sleep(250);
                System.out.print("\b/"); Thread.sleep(250);
                System.out.print("\b");
            } System.out.println();
        } catch (InterruptedException e) { e.printStackTrace(); }
    }

    public void display_login_screen() {
        while (true) {
            this.clrsrc(); this.print_logo();
            System.out.println("[Login]\n");
            System.out.print("Username:\t");
            this.username = this.scanner.next();
    
            System.out.print("Password:\t");
            this.password = new String(System.console().readPassword());
    
            System.out.print("\nVerifying credentials... "); this.spinner_animation(1);
            this.display_student_dashboard();
        }
    }

    public void display_student_dashboard() {
        int selection = -1;

        while (selection != 3) {
            this.clrsrc(); this.print_logo();
            System.out.println("[Login] > [Student Dashboard]\n");
            System.out.println("1.\tUpload new document\n2.\tSee printing queue\n3.\tLogout");
            switch (selection = this.scanner.nextInt()) {
                case 1: System.out.println("TODO: Document uploading goes here!"); break;
                case 2: System.out.println("TODO: Printing queue goes here!"); break;
            }
        }
    }

    public void display_printer_dashboard() {
        this.clrsrc(); this.print_logo();
        System.out.println("1.\tPrint\n2.\tSee printing queue\n3.\tReport malfunction");
    }
    public static void main(String[] args) {
        StudentScreen ss = new StudentScreen();
        ss.display_login_screen();
        ss.scanner.close();
    }
}