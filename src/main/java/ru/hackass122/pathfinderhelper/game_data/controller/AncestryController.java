package ru.hackass122.pathfinderhelper.game_data.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hackass122.pathfinderhelper.game_data.dto.request.AncestryCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.creation.AncestryCreationResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.AncestryResponseDto;
import ru.hackass122.pathfinderhelper.game_data.service.AncestryService;

import java.util.List;

@RestController
@RequestMapping("/api/game_data/ancestry")
public class AncestryController {
    AncestryService ancestryService;

    public AncestryController(AncestryService ancestryService) {
        this.ancestryService = ancestryService;
    }

    @GetMapping("/{ancestryCode}")
    public ResponseEntity<AncestryResponseDto> getAncestryByAncestryCode(@PathVariable String ancestryCode) {
        AncestryResponseDto ancestryResponseDto = ancestryService.getAncestryDtoByCode(ancestryCode);
        return ResponseEntity.ok(ancestryResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<AncestryResponseDto>> getAllAncestries() {
        List<AncestryResponseDto> ancestryResponseDtos = ancestryService.getAllAncestriesDto();
        return ResponseEntity.ok(ancestryResponseDtos);
    }

    @PostMapping("/create")
    public ResponseEntity<AncestryResponseDto> createAncestry(@RequestBody AncestryCreationRequestDto ancestryCreationRequestDto) {
        AncestryResponseDto ancestryResponseDto = ancestryService.createAncestry(ancestryCreationRequestDto);
        return ResponseEntity.ok(ancestryResponseDto);
    }

    @GetMapping("/create")
    public ResponseEntity<AncestryCreationResponseDto> getAncestryCreation() {
        AncestryCreationResponseDto ancestryCreationResponseDto = ancestryService.getAncestryCreationOptions();
        return ResponseEntity.ok(ancestryCreationResponseDto);
    }
}
