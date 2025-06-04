package ru.hackass122.pathfinderhelper.game_data.service.impl;

import org.springframework.stereotype.Component;
import ru.hackass122.pathfinderhelper.game_data.dto.request.AncestryCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.AncestryResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.Ancestry;
import ru.hackass122.pathfinderhelper.game_data.entity.AttributeModifiers;
import ru.hackass122.pathfinderhelper.game_data.service.AncestryDtoMapper;

@Component
public class AncestryDtoMapperImpl implements AncestryDtoMapper {

    @Override
    public AncestryResponseDto ancestryToResponseDto(Ancestry ancestry) {

        return new AncestryResponseDto(ancestry.getId(),
                ancestry.getCode(),
                ancestry.getName(),
                ancestry.getDescription(),
                ancestry.getHitPoints(),
                ancestry.getSize(),
                ancestry.getSpeed(),
                ancestry.getAttributeModifiers().getBoosts(),
                ancestry.getAttributeModifiers().getFlaws(),
                ancestry.getLanguages(),
                ancestry.getSpecialAbilities(),
                ancestry.getHeritages(),
                ancestry.getAncestryFeats(),
                ancestry.getTraits(),
                ancestry.isDeprecated());
    }

    @Override
    public Ancestry ancestryCreationRequestDtoToAncestry(AncestryCreationRequestDto ancestryCreationRequestDto) {
        AttributeModifiers attributeModifiers = new AttributeModifiers(ancestryCreationRequestDto.boosts(),
                ancestryCreationRequestDto.flaws());
        Ancestry ancestry = new Ancestry(ancestryCreationRequestDto.hitPoints(),
                ancestryCreationRequestDto.size(),
                ancestryCreationRequestDto.speed(),
                attributeModifiers,
                ancestryCreationRequestDto.languages(),
                ancestryCreationRequestDto.specialAbilities(),
                ancestryCreationRequestDto.heritages(),
                ancestryCreationRequestDto.ancestryFeats(),
                ancestryCreationRequestDto.traits(),
                null,
                ancestryCreationRequestDto.name(),
                ancestryCreationRequestDto.description(),
                ancestryCreationRequestDto.deprecated(),
                null);
        return ancestry;
    }
}
