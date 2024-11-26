package com.ll.domain.wiseSaying.controller;

import java.util.Scanner;

public class WiseSayingController {
    private int lastId;

    WiseSayingController() {
        this.lastId = 0;
    }

    public void register(Scanner scanner) {
        System.out.println("명언 : ");
        System.out.println("작가 : ");

        int id = ++lastId;

        System.out.println(id + "번 명언이 등록되었습니다.");
    }
}
