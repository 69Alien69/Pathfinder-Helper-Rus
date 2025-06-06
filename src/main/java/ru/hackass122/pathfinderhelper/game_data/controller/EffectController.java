package ru.hackass122.pathfinderhelper.game_data.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hackass122.pathfinderhelper.game_data.dto.request.EffectCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.EffectResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.creation.EffectCreationResponseDto;
import ru.hackass122.pathfinderhelper.game_data.service.EffectService;

import java.util.Set;

@RestController
@RequestMapping("/api/game_data/effect")
public class EffectController {

    private final EffectService effectService;

    public EffectController(EffectService effectService) {
        this.effectService = effectService;
    }

    @GetMapping
    public ResponseEntity<Set<EffectResponseDto>> getAllFeats() {
        Set<EffectResponseDto> effectResponseDtos = effectService.getAllEffectResponseDtos();
        return ResponseEntity.ok(effectResponseDtos);
    }

    @GetMapping("/{effectCode}")
    public ResponseEntity<EffectResponseDto> getEffectByCode(@PathVariable String effectCode) {
        EffectResponseDto effectResponseDto = effectService.getEffectResponseDtoByCode(effectCode);
        return ResponseEntity.ok(effectResponseDto);
    }

    @GetMapping("/create")
    public ResponseEntity<EffectCreationResponseDto> getEffectCreation() {
        EffectCreationResponseDto effectCreationResponseDto = effectService.getEffectCreationOptions();
        return ResponseEntity.ok(effectCreationResponseDto);
    }

    @PostMapping("/create")
    public ResponseEntity<EffectResponseDto> createFeat(@RequestBody EffectCreationRequestDto effectCreationRequestDto) {
        EffectResponseDto effectResponseDto = effectService.createFeat(effectCreationRequestDto);
        return ResponseEntity.ok(effectResponseDto);
    }
}
