package com.back;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    int LastID = 0;
    ArrayList<Quote> quotes = new ArrayList<>();

    void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            if (cmd.equals("종료")) break;
            else if (cmd.equals("등록")) {
                actionWrite();
            } else if (cmd.equals("목록")) {
                actionList();
            } else if (cmd.startsWith("삭제?id=")) {
                actionDelete(getID(cmd));
            } else if (cmd.startsWith("수정?id=")) {
                actionModify(getID(cmd));
            } else System.out.println("잘못된 입력입니다.");
        }

        scanner.close();
    }

    void actionWrite() {
        System.out.print("명언 : ");
        String wiseSaying = scanner.nextLine().trim();
        System.out.print("작가 : ");
        String author = scanner.nextLine().trim();

        Quote quote = write(wiseSaying, author);
        quotes.add(quote);
        System.out.println(LastID + "번 명언이 등록되었습니다.");
    }

    void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        ListIterator<Quote> iterator = quotes.listIterator(quotes.size());
        while (iterator.hasPrevious()) {
            Quote temp = iterator.previous();
            if (temp != null)
                System.out.println(temp);
        }
    }

    void actionDelete(int id) {
        if (id <= 0) {
            System.out.println("잘못된 입력입니다.");
            return;
        }
        if (id > quotes.size() || quotes.get(id - 1) == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }
        quotes.set(id - 1, null);
        System.out.println(id + "번 명언이 삭제되었습니다.");
    }

    void actionModify(int id) {
        if (id <= 0) {
            System.out.println("잘못된 입력입니다.");
            return;
        }
        if (id > quotes.size() || quotes.get(id - 1) == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }
        System.out.println("명언(기존) : " + quotes.get(id - 1).getWiseSaying());
        System.out.print("명언 : ");
        String wiseSaying = scanner.nextLine().trim();
        System.out.println("작가(기존) : " + quotes.get(id - 1).getAuthor());
        System.out.print("작가 : ");
        String author = scanner.nextLine().trim();

        modify(id, wiseSaying, author);
    }

    int getID(String cmd) {
        try {
            return Integer.parseInt(cmd.substring(6));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    Quote write(String wiseSaying, String author) {
        Quote quote = new Quote(++LastID);
        quote.setWiseSaying(wiseSaying);
        quote.setAuthor(author);
        return quote;
    }

    void modify(int id, String wiseSaying, String author) {
        quotes.get(id - 1).setWiseSaying(wiseSaying);
        quotes.get(id - 1).setAuthor(author);
    }
}