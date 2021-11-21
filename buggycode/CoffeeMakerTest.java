import static org.junit.Assert.assertEquals;

import java.util.function.ToIntFunction;

import org.junit.Before;
import org.junit.Test;

import jdk.jfr.Timestamp;

public class CoffeeMakerTest {
	
	/**
	 * The object under test.
	 */
	private CoffeeMaker coffeeMaker;
	private RecipeBook rp;
	
	// Sample recipes to use in testing.
	private Recipe recipe1;
	private Recipe recipe2;
	private Recipe recipe3;
	private Recipe recipe4;

	/**
	 * Initializes some recipes to test with and the {@link CoffeeMaker} 
	 * object we wish to test.
	 * 
	 * @throws RecipeException  if there was an error parsing the ingredient 
	 * 		amount when setting up the recipe.
	 */
	@Before
	public void setUp() throws RecipeException {
		coffeeMaker = new CoffeeMaker();
		
		//Set up for r1
		recipe1 = new Recipe();
		recipe1.setName("Coffee");
		recipe1.setAmtChocolate("1");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setPrice("50");
		
		//Set up for r2
		recipe2 = new Recipe();
		recipe2.setName("Mocha");
		recipe2.setAmtChocolate("20");
		recipe2.setAmtCoffee("3");
		recipe2.setAmtMilk("1");
		recipe2.setAmtSugar("1");
		recipe2.setPrice("75");
		
		//Set up for r3
		recipe3 = new Recipe();
		recipe3.setName("Latte");
		recipe3.setAmtChocolate("0");
		recipe3.setAmtCoffee("3");
		recipe3.setAmtMilk("3");
		recipe3.setAmtSugar("1");
		recipe3.setPrice("100");
		
		//Set up for r4
		recipe4 = new Recipe();
		recipe4.setName("Hot Chocolate");
		recipe4.setAmtChocolate("4");
		recipe4.setAmtCoffee("0");
		recipe4.setAmtMilk("1");
		recipe4.setAmtSugar("1");
		recipe4.setPrice("65");
	}
	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with well-formed quantities
	 * Then we do not get an exception trying to read the inventory quantities.
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test
	public void testAddInventory() throws InventoryException {
		coffeeMaker.addInventory("4","7","0","9");
	}
	
	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with malformed quantities (i.e., a negative 
	 * quantity and a non-numeric string)
	 * Then we get an inventory exception
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test(expected = InventoryException.class)
	public void testAddInventoryException() throws InventoryException {
		coffeeMaker.addInventory("4", "-1", "asdf", "3");
	}
	
	/**
	 * Given a coffee maker with one valid recipe
	 * When we make coffee, selecting the valid recipe and paying more than 
	 * 		the coffee costs
	 * Then we get the correct change back.
	 */
	@Test
	public void testMakeCoffee() {
		coffeeMaker.addRecipe(recipe1);
		assertEquals(25, coffeeMaker.makeCoffee(0, 75));
	}

	/**
	  * The coffee maker should only allow three recipies
	*/
	@Test
	public void testAdd4Recipes() {
		coffeeMaker.addRecipe(recipe1);
		coffeeMaker.addRecipe(recipe2);
		coffeeMaker.addRecipe(recipe3);
		assertEquals(true, coffeeMaker.addRecipe(recipe4));
	}

	//now will return nothing
	//I deleted the value at array position zero so it should come back null but instead comes back as nothing
	//the placeholder does not get deleted but instead stays
	@Test
	public void testDeleteRecipe() throws Exception
	{
		coffeeMaker.addRecipe(recipe1);
		coffeeMaker.addRecipe(recipe2);
		Recipe [] recipeArray = coffeeMaker.getRecipes();
		coffeeMaker.deleteRecipe(0);
		assertEquals(null, recipeArray[0]);
	} 

	//this will have the same error as the recipe delete method
	//except for this method it should return the name of the recipe
	//instead it returns nothing because it is being set to an empty string
	@Test
	public void testEditRecipe() throws RecipeException
	{
		coffeeMaker.addRecipe(recipe1);
		Recipe [] recipeArray = coffeeMaker.getRecipes();
		coffeeMaker.editRecipe(0, recipe1);
		assertEquals(null, recipeArray[0]);
	}

	//fails becasue operator is set incorrectly
	//should equal 20 but instead equals 10
	//it would only pass with a negative value
	@Test
	public void testAddSugarWithNegativeVaule() throws InventoryException {
		Inventory inventory = new Inventory();
		inventory.addSugar("-5");
		assertEquals(10, inventory.getSugar());
	}

	//use ingredients method is adding for coffee
	@Test
	public void testUseIngredients() throws InventoryException {
		Inventory inventory = new Inventory();
		coffeeMaker.addRecipe(recipe1);
		assertEquals(true, inventory.enoughIngredients(recipe1));
	}
}