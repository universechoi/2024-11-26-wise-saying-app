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

            String[] cmdBits = cmd.split("\\?");
            String actionName = cmdBits[0];

            switch(actionName) {
                case "종료":
                    systemController.exit();
                    return ;
                case "등록":
                    wiseSayingController.register(scanner);
                    break;
                case "목록":
                    wiseSayingController.list();
                    break;
                case "삭제":
                    wiseSayingController.delete(cmd);
                    break;
            }
        }
    }
}
