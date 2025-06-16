package ru.hackass122.pathfinderhelper.game_data.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.hackass122.pathfinderhelper.game_data.dto.request.PrerequisiteCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.PrerequisiteResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.creation.PrerequisiteCreationResponseDto;
import ru.hackass122.pathfinderhelper.game_data.service.PrerequisiteService;

@RestController("/api/prerequisite")
public class PrerequisiteController {

    final private PrerequisiteService prerequisiteService;

    public PrerequisiteController(PrerequisiteService prerequisiteService) {
        this.prerequisiteService = prerequisiteService;
    }

    @GetMapping("/{prerequisiteCode}")
    public ResponseEntity<PrerequisiteResponseDto> getPrerequisite(@PathVariable String prerequisiteCode) {

        PrerequisiteResponseDto prerequisiteResponseDto = prerequisiteService.getPrerequisiteDtoByCode(prerequisiteCode);
        return ResponseEntity.ok(prerequisiteResponseDto);
    }

    @GetMapping("/create")
    public ResponseEntity<PrerequisiteCreationResponseDto> getPrerequisiteCreationOptions() {
        PrerequisiteCreationResponseDto creationResponseDto = prerequisiteService.getPrerequisiteCreationOptions();
        return ResponseEntity.ok(creationResponseDto);
    }

    @PostMapping("/create")
    public ResponseEntity<PrerequisiteResponseDto> createPrerequisite(@RequestBody PrerequisiteCreationRequestDto requestDto){

        PrerequisiteResponseDto prerequisiteResponseDto = prerequisiteService.createPrerequisite(requestDto);

        return ResponseEntity.ok(prerequisiteResponseDto);
    }

}
