package com.ll.domain.wiseSaying.controller;

import com.ll.Command;
import com.ll.domain.wiseSaying.entity.WiseSaying;
import com.ll.domain.wiseSaying.service.WiseSayingService;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private final WiseSayingService wiseSayingService;


    public WiseSayingController() {
        this.wiseSayingService = new WiseSayingService();
    }

    public void register(Scanner scanner) {
        System.out.println("명언 : ");
        String content = scanner.nextLine();

        System.out.println("작가 : ");
        String author = scanner.nextLine();

        WiseSaying wiseSaying=  wiseSayingService.add(content, author);

        System.out.println(wiseSaying.getId() + "번 명언이 등록되었습니다.");
    }

    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        List<WiseSaying> wiseSayingList = wiseSayingService.findAll();

        for (WiseSaying wiseSaying : wiseSayingList.reversed()) {
            System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getContent());
        }
    }

    public void delete(Command cmd) {
        int id = cmd.getParamAsInt("id", 0);

        if (id == 0) {
            System.out.println("id(숫자)를 입력해 주세요.");
        }

        boolean deleted = WiseSayingService.deleteById(id);

        if (deleted) {
            System.out.println(id + "번 명언이 삭제되었습니다.");
        } else {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        }
    }
}
