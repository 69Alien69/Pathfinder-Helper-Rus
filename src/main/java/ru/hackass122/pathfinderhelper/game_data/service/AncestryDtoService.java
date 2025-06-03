package ru.hackass122.pathfinderhelper.game_data.service;

import ru.hackass122.pathfinderhelper.game_data.dto.response.AncestryResponseDto;


public interface AncestryDtoService {
    AncestryResponseDto getAncestryDtoByCode(String code);
}
