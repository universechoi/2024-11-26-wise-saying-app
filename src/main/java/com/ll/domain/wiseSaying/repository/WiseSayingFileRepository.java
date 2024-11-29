package com.ll.domain.wiseSaying.repository;

import com.ll.domain.wiseSaying.entity.WiseSaying;
import com.ll.standard.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class WiseSayingFileRepository implements WiseSayingRepository{
    private int lastId;
    private final List<WiseSaying> wiseSayingList;

    public WiseSayingFileRepository() {
        this.lastId = 0;
        this.wiseSayingList = new ArrayList<>();
    }

    public WiseSaying save(WiseSaying wiseSaying) {
        if (!wiseSaying.isNew()) {
            return wiseSaying;
        }

        wiseSaying.setId(++lastId);

        Map<String, Object> wiseSayingMap = wiseSaying.toMap();
        String josnStr = Util.json.toString(wiseSayingMap);

        Util.file.set("db/test/wiseSaying/1.json", josnStr);

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
