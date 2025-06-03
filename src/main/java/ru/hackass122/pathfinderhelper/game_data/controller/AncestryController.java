package ru.hackass122.pathfinderhelper.game_data.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hackass122.pathfinderhelper.game_data.dto.request.AncestryRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.AncestryResponseDto;
import ru.hackass122.pathfinderhelper.game_data.service.AncestryDtoService;

import java.util.List;

@RestController
@RequestMapping("/api/game_data/ancestry")
public class AncestryController {
    AncestryDtoService ancestryDtoService;

    public AncestryController(AncestryDtoService ancestryDtoService) {
        this.ancestryDtoService = ancestryDtoService;
    }

    @GetMapping("/{ancestryCode}")
    public ResponseEntity<AncestryResponseDto> getAncestryDtoByAncestryCode(@PathVariable String ancestryCode) {
        AncestryResponseDto ancestryResponseDto = ancestryDtoService.getAncestryDtoByCode(ancestryCode);
        return ResponseEntity.ok(ancestryResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<AncestryResponseDto>> getAllAncestries() {
        return null; // TODO
    }

    @PostMapping("/create")
    public ResponseEntity<AncestryResponseDto> createAncestry(@RequestBody AncestryRequestDto ancestryRequestDto) {
        return null; // TODO
    }

    @GetMapping("/create")
    public ResponseEntity<AncestryResponseDto> getAncestryCreation() {
        return null; // TODO
    }
}
