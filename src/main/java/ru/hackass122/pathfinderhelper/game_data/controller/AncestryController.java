package ru.hackass122.pathfinderhelper.game_data.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "Ancestry_Controller", description = "Контроллер для народов")
@RestController
@RequestMapping("/api/game_data/ancestry")
public class AncestryController {
    AncestryService ancestryService;

    public AncestryController(AncestryService ancestryService) {
        this.ancestryService = ancestryService;
    }

    @Operation(summary = "Получение народа по коду",
    description = "Возвращает народ с соответствующим уникальным кодом")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Народ найден"),
            @ApiResponse(responseCode = "404", description = "Народ не найден")
    })
    @GetMapping("/{ancestryCode}")
    public ResponseEntity<AncestryResponseDto> getAncestryByAncestryCode(
            @Parameter(description = "Уникальный код народа", required = true, example = "dwarf_ancestry")
            @PathVariable String ancestryCode) {
        AncestryResponseDto ancestryResponseDto = ancestryService.getAncestryDtoByCode(ancestryCode);
        return ResponseEntity.ok(ancestryResponseDto);
    }

    @Operation(summary = "Получение всех народов",
    description = "Возвращает список всех народов из базы данных")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Народы успешно получены")
    })
    @GetMapping
    public ResponseEntity<List<AncestryResponseDto>> getAllAncestries() {
        List<AncestryResponseDto> ancestryResponseDtos = ancestryService.getAllAncestriesDto();
        return ResponseEntity.ok(ancestryResponseDtos);
    }

    @Operation(summary = "Создание народа",
    description = "Создаёт новый народ и возвращает его")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Народ успешно создан")
    })
    @PostMapping("/create")
    public ResponseEntity<AncestryResponseDto> createAncestry(
            @Parameter(name = "Dto создания народа",
                    description = "Содержит необходимую для создания народа информацию")
            @RequestBody AncestryCreationRequestDto ancestryCreationRequestDto) {
        AncestryResponseDto ancestryResponseDto = ancestryService.createAncestry(ancestryCreationRequestDto);
        return ResponseEntity.ok(ancestryResponseDto);
    }

    @Operation(summary = "Получение опций народа", description = "Возвращает необходимые для создания народа объекты")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Опции успешно получены")
    })
    @GetMapping("/create")
    public ResponseEntity<AncestryCreationResponseDto> getAncestryCreation() {
        AncestryCreationResponseDto ancestryCreationResponseDto = ancestryService.getAncestryCreationOptions();
        return ResponseEntity.ok(ancestryCreationResponseDto);
    }
}
