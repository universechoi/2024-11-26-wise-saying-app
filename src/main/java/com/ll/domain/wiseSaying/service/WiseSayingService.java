package com.ll.domain.wiseSaying.service;

import com.ll.domain.wiseSaying.entity.WiseSaying;
import com.ll.domain.wiseSaying.repository.WiseSayingMemoryRepository;
import com.ll.domain.wiseSaying.repository.WiseSayingRepository;

import java.util.List;
import java.util.Optional;

public class WiseSayingService {

    private static WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        wiseSayingRepository = new WiseSayingMemoryRepository();
    }

    public WiseSaying add(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(0, content, author);
        return wiseSayingRepository.save(wiseSaying);
    }

    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }

    public static boolean deleteById(int id) {
        return wiseSayingRepository.deleteById(id);
    }

    public static Optional<WiseSaying> findById(int id) {
        return wiseSayingRepository.findById(id);
    }

    public void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);

        wiseSayingRepository.save(wiseSaying);
    }
}
