package com.ll.domain.wiseSaying.repository;

import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private int lastId;
    private final List<WiseSaying> wiseSayingList;

    public WiseSayingRepository() {
        this.lastId = 0;

        this.wiseSayingList = new ArrayList<>();
    }

    public WiseSaying save(WiseSaying wiseSaying) {
        wiseSaying.setId(++lastId);
        wiseSayingList.add(wiseSaying);
        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return wiseSayingList;
    }
}
