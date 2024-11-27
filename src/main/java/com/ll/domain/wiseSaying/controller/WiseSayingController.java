package com.ll.domain.wiseSaying.controller;

import com.ll.Command;
import com.ll.domain.wiseSaying.entity.WiseSaying;
import com.ll.domain.wiseSaying.service.WiseSayingService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class WiseSayingController {
    private final Scanner scanner;
    private final WiseSayingService wiseSayingService;


    public WiseSayingController(Scanner scanner) {
        this.scanner = scanner;
        this.wiseSayingService = new WiseSayingService();
    }

    public void register() {
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

    public void modify(Command cmd) {
        int id = cmd.getParamAsInt("id", 0);

        if (id == 0) {
            System.out.println("id(숫자)를 입력해 주세요.");
        }

        Optional<WiseSaying> opWiseSaying = WiseSayingService.findById(id);

        if (opWiseSaying.isEmpty()) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        WiseSaying wiseSaying = opWiseSaying.get();

        System.out.print("명언(기존) : " + wiseSaying.getContent());
        String content = scanner.nextLine();

        System.out.print("작가(기존) : " + wiseSaying.getAuthor());
        String author = scanner.nextLine();

        wiseSayingService.modify(wiseSaying, content, author);
    }
}
