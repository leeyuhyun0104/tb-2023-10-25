package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {
    int quotationId = 0;
    List<Quotation> quotationList = new ArrayList<>();

    void run() {
        System.out.println("== 명언 앱 ==");
        List<Quotation> quotationList = new ArrayList<>();

        while (true) {
            System.out.print("명령) ");

            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionWrite();
            } else if (cmd.equals("목록")) {
                actionList();
            } else if (cmd.startsWith("삭제?id=")) {
                actionRemove(cmd);
            }
        }
    }
//========================================================================

    void actionWrite() {

        System.out.print("명언 : ");
        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine();

        System.out.print("작가 : ");
        String author = scanner.nextLine();

        quotationId++;
        int id = quotationId;

        Quotation q = new Quotation(id, content, author);
        quotationList.add(q);

        System.out.printf("%d번 명언이 등록되었습니다.\n", quotationId);
    }

    void actionList() {

        if (quotationList.isEmpty())
            System.out.println("등록된 명언이 없습니다.");

        else {
            System.out.println("번호 / 명언 / 작가");
            System.out.println("-----------------------");

            for (int i = quotationList.size() - 1; i >= 0; i--) {
                /*System.out.println(quotationList.get(i));*/
                Quotation q = quotationList.get(i);
                System.out.printf("%d / %s / %s\n", q.id, q.content, q.author);
            }
        }
    }

    void actionRemove(String cmd) {
        try {
            int start = "삭제?id=".length();
            int removeId = Integer.parseInt(cmd.substring(start));
            if (removeId >= 1 && removeId <= quotationList.size()) {
                quotationList.remove(removeId - 1);

                for (int i = 0; i < quotationList.size(); i++) {
                    quotationList.get(i).id = i + 1;
                }
                System.out.printf("%d번 명언이 삭제되었습니다.\n", removeId);
            }
            else{
                System.out.println("존재하지않는 명언입니다.");
            }
        }
        catch (NumberFormatException e) {
            System.out.println("올바른 명령 형식이 아닙니다.");
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("유효하지 않은 명언 번호입니다.");
        }
    }

}

