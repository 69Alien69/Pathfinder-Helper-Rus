package ru.hackass122.pathfinderhelper.game_data.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import ru.hackass122.pathfinderhelper.common.enums.Attribute;
import ru.hackass122.pathfinderhelper.common.enums.Language;
import ru.hackass122.pathfinderhelper.common.enums.Size;

import java.util.Set;

@Schema(description = "Dto, представляющий народ персонажа")
public record AncestryResponseDto(@Schema(description = "Уникальный код народа", example = "dwarf_ancestry")
                                  String code,

                                  @Schema(description = "Название народа", example = "Dwarf")
                                  String name,

                                  @Schema(description = "Описание народа")
                                  String description,

                                  @Schema(description = "Базовое количество пунктов здоровья," +
                                          " которое даёт народ персонажу")
                                  Integer hitPoints,

                                  @Schema(description = "Базовый размер персонажа этого народа")
                                  Size size,

                                  @Schema(description = "Базовая скорость персонажа этого народа (кратно 5)")
                                  Integer speed,

                                  @Schema(description = "Характеристики, которые повышаются при выборе этого народа")
                                  Set<Attribute> boosts,

                                  @Schema(description = "Характеристики, которые понижаются при выборе этого народа " +
                                          "(Обычно 1 или 0)")
                                  Set<Attribute> flaws,

                                  @Schema(description = "Языки, которыми владеют представители народа")
                                  Set<Language> languages,

                                  @Schema(description = "Специальные способности, которые получает персонаж этого" +
                                          " народа")
                                  Set<SpecialAbilityResponseDto> specialAbilityResponseDtos,

                                  @Schema(description = "Наследия, доступные при выборе этого народа")
                                  Set<HeritageResponseDto> heritageResponseDtos,

                                  @Schema(description = "Черты народа, доступные персонажу этого народа")
                                  Set<FeatResponseDto> ancestryFeatResponseDtos,

                                  @Schema(description = "Дескрипторы народа")
                                  Set<TraitResponseDto> traitResponseDtos,

                                  @Schema(description = "Флаг, является ли данная редакция правил устаревшей")
                                  Boolean legacy) {
}
