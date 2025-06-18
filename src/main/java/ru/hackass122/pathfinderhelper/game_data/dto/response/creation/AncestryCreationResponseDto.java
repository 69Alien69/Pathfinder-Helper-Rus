package ru.hackass122.pathfinderhelper.game_data.dto.response.creation;

import io.swagger.v3.oas.annotations.media.Schema;
import ru.hackass122.pathfinderhelper.common.enums.Attribute;
import ru.hackass122.pathfinderhelper.common.enums.Language;
import ru.hackass122.pathfinderhelper.common.enums.Size;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpecialAbilityResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.TraitResponseDto;

import java.util.Set;

@Schema(description = "Dto с опциями для создания народа")
public record AncestryCreationResponseDto(@Schema(description = "Возможные размеры персонажа")
                                          Set<Size> sizes,

                                          @Schema(description = "Все характеристики")
                                          Set<Attribute> attributes,

                                          @Schema(description = "Все языки")
                                          Set<Language> languages,

                                          @Schema(description = "Все специальные возможности")
                                          Set<SpecialAbilityResponseDto> specialAbilitiesResponseDtos,

                                          @Schema(description = "Все дескрипторы")
                                          Set<TraitResponseDto> traitsResponseDtos) {
}
