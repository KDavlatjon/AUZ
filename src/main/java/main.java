import model.Result;
import model.User;
import service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Result result;
        Scanner scanner;
        int chance = 1;
        System.out.println("Kabinetga kirish uchun shaxsingizni tasdiqlang !!!");

        while (chance != 0) {
            scanner = new Scanner(System.in);
            System.out.println("Exit => 0, LogIn = > any number");
            chance = scanner.nextInt();

            if (chance != 0){
                System.out.println("Ism kiriting");
                scanner = new Scanner(System.in);
                String name = scanner.nextLine().trim();

                scanner = new Scanner(System.in);
                System.out.println("Parol kiriting: ");
                String password = scanner.nextLine().trim();
                List<User> userList = userService.read();
                System.out.println(userService.search(name, password, userList).getMessage());
            }
        }
    }
}
