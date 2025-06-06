package ru.hackass122.pathfinderhelper.game_data.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hackass122.pathfinderhelper.game_data.dto.request.FeatCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.creation.FeatCreationResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.FeatResponseDto;
import ru.hackass122.pathfinderhelper.game_data.service.FeatService;

import java.util.Set;

@RestController
@RequestMapping("/api/game_data/feat")
public class FeatController {

    private final FeatService featService;

    public FeatController(FeatService featService) {
        this.featService = featService;
    }

    @GetMapping
    public ResponseEntity<Set<FeatResponseDto>> getAllFeats() {
        Set<FeatResponseDto> featResponseDtos = featService.getAllFeatResponseDtos();
        return ResponseEntity.ok(featResponseDtos);
    }

    @GetMapping("/{featCode}")
    public ResponseEntity<FeatResponseDto> getFeatByCode(@PathVariable String featCode) {
        FeatResponseDto featResponseDto = featService.getFeatResponseDtoByCode(featCode);
        return ResponseEntity.ok(featResponseDto);
    }

    @GetMapping("/create")
    public ResponseEntity<FeatCreationResponseDto> getFeatCreation() {
        FeatCreationResponseDto featCreationResponseDto = featService.getFeatCreationOptions();
        return ResponseEntity.ok(featCreationResponseDto);
    }

    @PostMapping("/create")
    public ResponseEntity<FeatResponseDto> createFeat(@RequestBody FeatCreationRequestDto featCreationRequestDto) {
        FeatResponseDto featResponseDto = featService.createFeat(featCreationRequestDto);
        return ResponseEntity.ok(featResponseDto);
    }
}
