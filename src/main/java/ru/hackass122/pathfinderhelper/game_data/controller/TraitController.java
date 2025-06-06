package ru.hackass122.pathfinderhelper.game_data.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hackass122.pathfinderhelper.game_data.dto.request.TraitCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.TraitResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.creation.TraitCreationResponseDto;
import ru.hackass122.pathfinderhelper.game_data.service.TraitService;

import java.util.Set;

@RestController
@RequestMapping("/api/game_data/trait")
public class TraitController {

    private final TraitService traitService;

    public TraitController(TraitService traitService) {
        this.traitService = traitService;
    }

    @GetMapping
    public ResponseEntity<Set<TraitResponseDto>> getAllTraits() {
        Set<TraitResponseDto> traitResponseDtos = traitService.getAllTraitResponseDtos();
        return ResponseEntity.ok(traitResponseDtos);
    }

    @GetMapping("/{traitCode}")
    public ResponseEntity<TraitResponseDto> getTraitByCode(@PathVariable String traitCode) {
        TraitResponseDto traitResponseDto = traitService.getTraitResponseDtoByCode(traitCode);
        return ResponseEntity.ok(traitResponseDto);
    }

    @GetMapping("/create")
    public ResponseEntity<TraitCreationResponseDto> getTraitCreation() {
        TraitCreationResponseDto traitCreationResponseDto = traitService.getTraitCreationOptions();
        return ResponseEntity.ok(traitCreationResponseDto);
    }

    @PostMapping("/create")
    public ResponseEntity<TraitResponseDto> createTrait(@RequestBody TraitCreationRequestDto traitCreationRequestDto) {
        TraitResponseDto traitResponseDto = traitService.createTrait(traitCreationRequestDto);
        return ResponseEntity.ok(traitResponseDto);
    }
}
