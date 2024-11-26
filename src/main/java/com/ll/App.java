package com.ll;

import com.ll.domain.wiseSaying.controller.SystemController;
import com.ll.domain.wiseSaying.controller.WiseSayingController;

import java.util.Scanner;

public class App {
    private final Scanner scanner;
    private final SystemController systemController;
    private final WiseSayingController wiseSayingController;

    public App(Scanner scanner) {
        this.scanner = scanner;
        this.systemController = new SystemController();
        this.wiseSayingController = new WiseSayingController();
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.println("명령) ");

            String cmd = scanner.nextLine();
            if(cmd.equals("종료")) {
                systemController.exit();
                break;
            } else if (cmd.equals("등록")) {
                wiseSayingController.register(scanner);
            } else if (cmd.equals("목록")) {
                wiseSayingController.list();
            }
        }
    }
}
