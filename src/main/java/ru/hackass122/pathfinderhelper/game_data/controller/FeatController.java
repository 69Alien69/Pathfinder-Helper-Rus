package ru.hackass122.pathfinderhelper.game_data.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hackass122.pathfinderhelper.game_data.dto.request.FeatCreateRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.FeatResponseDto;

@RestController
@RequestMapping("/api/game_data/feat")
@RequiredArgsConstructor
public class FeatController {

    @PostMapping
    public ResponseEntity<FeatResponseDto> createFeat(Long accountId, FeatCreateRequestDto featCreateRequestDto) {
        return null;
    }
}
