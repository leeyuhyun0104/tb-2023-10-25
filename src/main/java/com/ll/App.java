package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {
    void run() {
        System.out.println("== 명언 앱 ==");
        int quotationId = 0;
        List<Quotation> quotationList = new ArrayList<>();

        while(true) {

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

                quotationId++;
                int id = quotationId;
                System.out.printf("%d번 명언이 등록되었습니다.\n", quotationId);

                Quotation q = new Quotation(id, content, author);
                quotationList.add(q);

            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("-----------------------");
                for(int i = quotationList.size()-1; i>=0; i--){
                    System.out.println(quotationList.get(i));
                }
            }
        }
    }
}
