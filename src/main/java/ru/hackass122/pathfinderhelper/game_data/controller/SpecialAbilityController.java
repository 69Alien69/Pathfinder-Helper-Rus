package ru.hackass122.pathfinderhelper.game_data.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hackass122.pathfinderhelper.game_data.dto.request.SpecialAbilityCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpecialAbilityResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.creation.SpecialAbilityCreationResponseDto;
import ru.hackass122.pathfinderhelper.game_data.service.SpecialAbilityService;

import java.util.Set;

@RestController
@RequestMapping("/api/game_data/special_ability")
public class SpecialAbilityController {
    private final SpecialAbilityService specialAbilityService;

    public SpecialAbilityController(SpecialAbilityService specialAbilityService) {
        this.specialAbilityService = specialAbilityService;
    }

    @GetMapping
    public ResponseEntity<Set<SpecialAbilityResponseDto>> getAllSpecialAbilities() {
        Set<SpecialAbilityResponseDto> specialAbilityResponseDtos =
                specialAbilityService.getAllSpecialAbilityResponseDtos();
        return ResponseEntity.ok(specialAbilityResponseDtos);
    }

    @GetMapping("/{specialAbilityCode}")
    public ResponseEntity<SpecialAbilityResponseDto> getSpecialAbilityByCode(@PathVariable String specialAbilityCode) {
        SpecialAbilityResponseDto specialAbilityResponseDto = specialAbilityService.getSpecialAbilityResponseDtoByCode(specialAbilityCode);
        return ResponseEntity.ok(specialAbilityResponseDto);
    }

    @GetMapping("/create")
    public ResponseEntity<SpecialAbilityCreationResponseDto> getSpecialAbilityCreation() {
        SpecialAbilityCreationResponseDto specialAbilityCreationResponseDto = specialAbilityService.getSpecialAbilityCreationOptions();
        return ResponseEntity.ok(specialAbilityCreationResponseDto);
    }

    @PostMapping("/create")
    public ResponseEntity<SpecialAbilityResponseDto> createSpecialAbility(@RequestBody SpecialAbilityCreationRequestDto specialAbilityCreationRequestDto) {
        SpecialAbilityResponseDto specialAbilityResponseDto = specialAbilityService.createSpecialAbility(specialAbilityCreationRequestDto);
        return ResponseEntity.ok(specialAbilityResponseDto);
    }
}
