package com.ll;

import java.util.Scanner;

class App {
    void run() {
        while(true) {
            System.out.println("== 명언 앱 ==");

            System.out.print("명령) ");

            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();

            if(cmd.equals("종료")){
                System.out.println("종료합니다.");
                break;
            }

            System.out.printf("입력하신 명령 : %s\n", cmd);
        }
    }
}
