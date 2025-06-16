package ru.hackass122.pathfinderhelper.game_data.service;

import ru.hackass122.pathfinderhelper.game_data.dto.request.PrerequisiteCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.PrerequisiteResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.creation.PrerequisiteCreationResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.prerequisite.Prerequisite;

import java.util.Set;

public interface PrerequisiteService {
    Set<Prerequisite> getPrerequisitesByCodes(Set<String> codes);
    Set<PrerequisiteResponseDto> getAllPrerequisiteDtos();
    PrerequisiteResponseDto getPrerequisiteDtoByCode(String code);
    PrerequisiteResponseDto createPrerequisite(PrerequisiteCreationRequestDto prerequisiteCreationRequestDto);
    PrerequisiteCreationResponseDto getPrerequisiteCreationOptions();
}
