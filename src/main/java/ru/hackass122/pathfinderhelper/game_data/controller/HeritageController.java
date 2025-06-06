package ru.hackass122.pathfinderhelper.game_data.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hackass122.pathfinderhelper.game_data.dto.request.HeritageCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.HeritageResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.creation.HeritageCreationResponseDto;
import ru.hackass122.pathfinderhelper.game_data.service.HeritageService;

import java.util.Set;

@RestController
@RequestMapping("/api/game_data/heritage")
public class HeritageController {
    private final HeritageService heritageService;

    public HeritageController(HeritageService heritageService) {
        this.heritageService = heritageService;
    }

    @GetMapping
    public ResponseEntity<Set<HeritageResponseDto>> getAllHeritages() {
        Set<HeritageResponseDto> heritageResponseDtos = heritageService.getAllHeritageResponseDtos();
        return ResponseEntity.ok(heritageResponseDtos);
    }

    @GetMapping("/{heritageCode}")
    public ResponseEntity<HeritageResponseDto> getHeritageByCode(@PathVariable String heritageCode) {
        HeritageResponseDto heritageResponseDto = heritageService.getHeritageResponseDtoByCode(heritageCode);
        return ResponseEntity.ok(heritageResponseDto);
    }

    @GetMapping("/create")
    public ResponseEntity<HeritageCreationResponseDto> getHeritageCreation() {
        HeritageCreationResponseDto heritageCreationResponseDto = heritageService.getHeritageCreationOptions();
        return ResponseEntity.ok(heritageCreationResponseDto);
    }

    @PostMapping("/create")
    public ResponseEntity<HeritageResponseDto> createHeritage(@RequestBody HeritageCreationRequestDto heritageCreationRequestDto) {
        HeritageResponseDto heritageResponseDto = heritageService.createHeritage(heritageCreationRequestDto);
        return ResponseEntity.ok(heritageResponseDto);
    }
}
