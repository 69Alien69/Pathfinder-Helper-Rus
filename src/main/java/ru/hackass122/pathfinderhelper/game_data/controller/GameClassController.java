package ru.hackass122.pathfinderhelper.game_data.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hackass122.pathfinderhelper.game_data.dto.request.GameClassCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.GameClassResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.creation.GameClassCreationResponseDto;
import ru.hackass122.pathfinderhelper.game_data.service.GameClassService;

import java.util.Set;

@RestController
@RequestMapping("/api/class")
public class GameClassController {

    private final GameClassService gameClassService;

    public GameClassController(GameClassService gameClassService) {
        this.gameClassService = gameClassService;
    }

    @GetMapping
    public ResponseEntity<Set<GameClassResponseDto>> getAllGameClasses() {
        Set<GameClassResponseDto> responseDtos = gameClassService.getAllGameClassResponseDtos();
        return ResponseEntity.ok(responseDtos);
    }

    @GetMapping("/{gameClassCode}")
    public ResponseEntity<GameClassResponseDto> getGameClassByCode(@PathVariable String gameClassCode) {
        GameClassResponseDto responseDto = gameClassService.getGameClassResponseDtoByCode(gameClassCode);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/create")
    public ResponseEntity<GameClassResponseDto> createGameClass(@RequestBody GameClassCreationRequestDto requestDto) {
        GameClassResponseDto responseDto = gameClassService.createGameClass(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/create")
    public ResponseEntity<GameClassCreationResponseDto> getGameClassCreationOptions() {
        GameClassCreationResponseDto creationResponseDto = gameClassService.getGameClassCreationOptions();
        return ResponseEntity.ok(creationResponseDto);
    }
}
