package com.ll.domain.wiseSaying.service;

import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {
    private int lastId;
    private List<WiseSaying> wiseSayingList;

    public WiseSayingService() {
        this.lastId = 0;
        this.wiseSayingList = new ArrayList<>();
    }

    public WiseSaying add(String content, String author) {

        WiseSaying wiseSaying = new WiseSaying(++lastId, content, author);
        wiseSayingList.add(wiseSaying);
        return wiseSaying;
    }


    public List<WiseSaying> findAll() {
        return wiseSayingList;
    }
}
