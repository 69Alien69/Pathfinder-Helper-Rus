package ru.hackass122.pathfinderhelper.game_data.mapper.impl;

import org.springframework.stereotype.Component;
import ru.hackass122.pathfinderhelper.game_data.dto.response.PrerequisiteResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.prerequisite.Prerequisite;
import ru.hackass122.pathfinderhelper.game_data.mapper.PrerequisiteDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.util.PrerequisiteMetadataProvider;

import java.util.Map;

@Component
public class PrerequisiteDtoMapperImpl implements PrerequisiteDtoMapper {

    @Override
    public PrerequisiteResponseDto entityToResponseDto(Prerequisite prerequisite) {
        Map<String, Object> data = PrerequisiteMetadataProvider.getMetadataFor(prerequisite.getType());

        return new PrerequisiteResponseDto(prerequisite.getCode(),
                prerequisite.getName(),
                prerequisite.getDescription(),
                prerequisite.isLegacy(),
                prerequisite.getType(),
                data);
    }
}
