package ru.hackass122.pathfinderhelper.unit.ancestry;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;
import ru.hackass122.pathfinderhelper.common.enums.Attribute;
import ru.hackass122.pathfinderhelper.common.enums.Language;
import ru.hackass122.pathfinderhelper.common.enums.Size;
import ru.hackass122.pathfinderhelper.game_data.dto.request.AncestryCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.AncestryResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.creation.AncestryCreationResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.Ancestry;
import ru.hackass122.pathfinderhelper.game_data.mapper.AncestryDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.repository.entity.AncestryRepository;
import ru.hackass122.pathfinderhelper.game_data.service.SpecialAbilityService;
import ru.hackass122.pathfinderhelper.game_data.service.TraitService;
import ru.hackass122.pathfinderhelper.game_data.service.impl.AncestryServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AncestryServiceImplTest {

    @Mock
    private AncestryRepository ancestryRepository;

    @Mock
    private AncestryDtoMapper ancestryDtoMapper;

    @Mock
    private SpecialAbilityService specialAbilityService;

    @Mock
    private TraitService traitService;

    @InjectMocks
    private AncestryServiceImpl ancestryService;

    @Test
    void shouldReturnAncestryByCode() {
        String code = "foo_ancestry";
        Ancestry ancestry = mock(Ancestry.class);
        AncestryResponseDto dto = new AncestryResponseDto("foo_ancestry",
                "Foo",
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null);

        when(ancestryRepository.findAncestryByCode(code)).thenReturn(Optional.of(ancestry));
        when(ancestryDtoMapper.entityToResponseDto(ancestry)).thenReturn(dto);

        AncestryResponseDto result = ancestryService.getAncestryDtoByCode(code);

        assertThat(result.code()).isEqualTo("foo_ancestry");
        verify(ancestryRepository).findAncestryByCode(code);
    }

    @Test
    void shouldReturnListOfAncestries() {
        Ancestry ancestry1 = mock(Ancestry.class);
        Ancestry ancestry2 = mock(Ancestry.class);
        Ancestry ancestry3 = mock(Ancestry.class);
        List<Ancestry> ancestryList = List.of(ancestry1, ancestry2, ancestry3);

        AncestryResponseDto ancestryResponseDto1 = mock(AncestryResponseDto.class);
        AncestryResponseDto ancestryResponseDto2 = mock(AncestryResponseDto.class);
        AncestryResponseDto ancestryResponseDto3 = mock(AncestryResponseDto.class);
        List<AncestryResponseDto> ancestryResponseDtoList = List.of(ancestryResponseDto1,
                ancestryResponseDto2,
                ancestryResponseDto3);


        when(ancestryRepository.findAll()).thenReturn(ancestryList);
        when(ancestryDtoMapper.entityToResponseDto(ancestry1)).thenReturn(ancestryResponseDto1);
        when(ancestryDtoMapper.entityToResponseDto(ancestry2)).thenReturn(ancestryResponseDto2);
        when(ancestryDtoMapper.entityToResponseDto(ancestry3)).thenReturn(ancestryResponseDto3);

        List<AncestryResponseDto> result = ancestryService.getAllAncestriesDto();

        assertThat(result).isEqualTo(ancestryResponseDtoList);
        verify(ancestryRepository).findAll();
    }

    @Test
    void shouldCreateNewAncestry() {
        AncestryCreationRequestDto ancestryCreationRequestDto = new AncestryCreationRequestDto("FooName",
                "FooDescription",
                10,
                Size.MEDIUM,
                20,
                Set.of(Attribute.INTELLIGENCE, Attribute.CHARISMA),
                Set.of(Attribute.CONSTITUTION),
                Set.of(Language.CHTHONIAN),
                Set.of("foobar"),
                Set.of("foobar"),
                Set.of("foobar"),
                Set.of("foobar"),
                false);

        Ancestry entity = mock(Ancestry.class);
        Ancestry saved = mock(Ancestry.class);

        AncestryResponseDto ancestryResponseDto = new AncestryResponseDto("fooname_ancestry",
                "FooName",
                "FooDescription",
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null);

        when(ancestryDtoMapper.creationRequestDtoToEntity(ancestryCreationRequestDto)).thenReturn(entity);
        when(ancestryRepository.save(entity)).thenReturn(saved);
        when(ancestryDtoMapper.entityToResponseDto(saved)).thenReturn(ancestryResponseDto);

        AncestryResponseDto result = ancestryService.createAncestry(ancestryCreationRequestDto);

        assertThat(result.code()).isEqualTo("fooname_ancestry");
        verify(ancestryRepository).save(entity);
    }

    @Test
    void shouldReturnAncestryCreationOptions() {
        AncestryCreationResponseDto result = ancestryService.getAncestryCreationOptions();
        assertThat(result).isNotNull();
    }

    @Test
    void shouldThrowExceptionIfAncestryAlreadyExists() {
        AncestryCreationRequestDto dto = mock(AncestryCreationRequestDto.class);

        when(ancestryDtoMapper.creationRequestDtoToEntity(dto)).thenReturn(mock(Ancestry.class));
        when(ancestryRepository.save(any())).thenThrow(new DataIntegrityViolationException("duplicate key"));

        assertThatThrownBy(() -> ancestryService.createAncestry(dto))
                .isInstanceOf(DataIntegrityViolationException.class)
                .hasMessageContaining("duplicate");

        verify(ancestryRepository).save(any());
    }


}
