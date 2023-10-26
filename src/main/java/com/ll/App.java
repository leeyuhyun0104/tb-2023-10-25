package com.ll;

import java.util.Scanner;

class App {
    void run() {
        int count = 0;

        while(true) {
            System.out.println("== 명언 앱 ==");

            System.out.print("명령) ");

            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();

            if(cmd.equals("종료")){
                break;
            }
            else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content= scanner.nextLine();

                System.out.print("작가 : ");
                String author= scanner.nextLine();

                count++;
                System.out.printf("%d번 명언이 등록되었습니다.\n", count);
            }
        }
    }
}
