package ru.hackass122.pathfinderhelper.game_data.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import ru.hackass122.pathfinderhelper.common.enums.Attribute;
import ru.hackass122.pathfinderhelper.common.enums.Language;
import ru.hackass122.pathfinderhelper.common.enums.Size;

import java.util.Set;

@Schema(description = "Dto представляющая запрос на создание персонажа")
public record AncestryCreationRequestDto(@Schema(description = "Название народа", example = "Dwarf")
                                         String name,

                                         @Schema(description = "Описание народа")
                                         String description,

                                         @Schema(description = "Количество начальных пунктов здоровья")
                                         Integer hitPoints,

                                         @Schema(description = "Базовый размер персонажа народа")
                                         Size size,

                                         @Schema(description = "Базовая скорость персонажа народа (кратна 5)")
                                         Integer speed,

                                         @Schema(description = "Характеристики, которые повышает персонаж народа")
                                         Set<Attribute> boosts,

                                         @Schema(description = "Характеристики, которые понижает персонаж народа")
                                         Set<Attribute> flaws,

                                         @Schema(description = "Языки, которые получает персонаж народа")
                                         Set<Language> languages,

                                         @Schema(description = "Коды специальных способностей персонажа," +
                                                 " которые доступны для этого народа")
                                         Set<String> specialAbilitiesCodes,

                                         @Schema(description = "Коды наследий, которые доступны для этого народа")
                                         Set<String> heritagesCodes,

                                         @Schema(description = "Коды черт народа, которые доступны для этого народа")
                                         Set<String> ancestryFeatsCodes,

                                         @Schema(description = "Коды дескрипторов, которые присваиваются народу")
                                         Set<String> traitsCodes,

                                         @Schema(description = "Флаг, является ли данная редакция правил устаревшей")
                                         Boolean legacy) {
}
