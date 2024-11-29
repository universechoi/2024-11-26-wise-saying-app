package com.ll.domain.wiseSaying.repository;

import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WiseSayingMemoryRepository extends WiseSayingRepository{
    private int lastId;
    private final List<WiseSaying> wiseSayingList;

    public WiseSayingMemoryRepository() {
        this.lastId = 0;

        this.wiseSayingList = new ArrayList<>();
    }

    public WiseSaying save(WiseSaying wiseSaying) {
        if (!wiseSaying.isNew()) {
            return wiseSaying;
        }

        wiseSaying.setId(++lastId);
        wiseSayingList.add(wiseSaying);
        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return wiseSayingList;
    }

    public boolean deleteById(int id) {
        return wiseSayingList.removeIf(wiseSaying -> wiseSaying.getId() == id);
    }

    public Optional<WiseSaying> findById(int id) {
        return wiseSayingList.stream()
                .filter(wiseSaying -> wiseSaying.getId() == id)
                .findFirst();
    }
}
