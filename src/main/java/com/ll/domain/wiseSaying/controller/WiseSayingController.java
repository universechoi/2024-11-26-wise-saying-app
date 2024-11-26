package com.ll.domain.wiseSaying.controller;

import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private List<WiseSaying> wiseSayingList;
    private int lastId;

    public WiseSayingController() {
        this.lastId = 0;
        this.wiseSayingList = new ArrayList<>();
    }

    public void register(Scanner scanner) {
        System.out.println("명언 : ");
        String content = scanner.nextLine();

        System.out.println("작가 : ");
        String author = scanner.nextLine();

        int id = ++lastId;

        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayingList.add(wiseSaying);

        System.out.println(id + "번 명언이 등록되었습니다.");
    }

    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        System.out.println("2 / 작자미상 / 과거에 집착하지 마라.");
        System.out.println("1 / 작자미상 / 현재를 사랑하라.");
    }
}
