package br.com.matheus.machado.shorturl.test;

import br.com.matheus.machado.shorturl.entity.Url;
import br.com.matheus.machado.shorturl.repository.UrlRepository;
import br.com.matheus.machado.shorturl.service.impl.UrlServiceImpl;
import br.com.matheus.machado.shorturl.service.specification.UrlSpecification;
import java.util.Optional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import org.springframework.data.jpa.domain.Specification;

public class UrlServiceTest {

    @InjectMocks
    private UrlServiceImpl instance;

    @Mock
    private UrlRepository repository;

    public UrlServiceTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        initMocks(this);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testFindById() {
        System.out.println("findById");
        Long id = 1L;
        Optional<Url> expResult = Optional.of(mock(Url.class));
        when(repository.findById(anyLong())).thenReturn(expResult);
        Optional<Url> result = instance.findById(id);
        assertEquals(expResult, result);
        verify(repository).findById(id);
    }

    @Test
    public void testFindByAlias() {
        System.out.println("findByAlias");
        String alias = "teste";
        Specification<Url> spec = UrlSpecification.byAlias(alias);
        Optional<Url> expResult = Optional.of(mock(Url.class));
        when(repository.findOne(any(Specification.class))).thenReturn(expResult);
        Optional<Url> result = repository.findOne(spec);
        assertEquals(expResult, result);
        verify(repository).findOne(spec);
    }

    @Test
    public void testSave() {
        System.out.println("save");
        Url url = new Url();
        Url expResult = mock(Url.class);
        when(repository.save(any(Url.class))).thenReturn(expResult);
        Url result = instance.save(url);
        assertEquals(expResult, result);
        verify(repository).save(url);
    }

}
