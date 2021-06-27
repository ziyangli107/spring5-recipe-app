package guru.springframework.services;

import guru.springframework.domains.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RecipeServiceImplTest {

    @InjectMocks
    private RecipeServiceImpl recipeService;

    @Mock
    private RecipeRepository recipeRepository;

    private Set<Recipe> recipes;


    @Before
    public void setUp() throws Exception {
        recipes = new HashSet<>();
        recipes.add(new Recipe());
    }

    @Test
    public void getRecipes() {
        when(recipeRepository.findAll()).thenReturn(recipes);
        Set<Recipe> result = recipeService.getRecipes();
        verify(recipeRepository,times(1)).findAll();
        assertEquals(1,result.size());
    }
}