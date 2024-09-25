package co.edu.uco.crosscutting.unittesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import co.edu.uco.crosscutting.helpers.ObjectHelper;

class HelpersUnitTestCase {

	@Test
	void givenWantValidsteIfObjectIsNullWhenObjectIsNullThenResulItTrue() {
		// Arrange: Initial Context
		String object = null;

		// Act: Execute action
		boolean result = ObjectHelper.isNull(object);

		// Assert: Validate result
		assertTrue(result);
	}

	@Test
	void givenWantValidsteIfObjectIsNotNullWhenObjectIsNotNullThenResulItFalse() {
		// Arrange: Initial Context
		var object = "";

		// Act:Execute action
		boolean result = ObjectHelper.isNull(object);

		// ASsert: Validate result
		assertFalse(result);
	}
	
	@Test
	void givenWantGetOriginalValueWhenObjectIsNotNullThenResulIsTheSameObjetc() {
		// Arrange: Initial Context
		var object = "Casa";
		var defaultValue = "Default";

		// Act:Execute action
		var result = ObjectHelper.getDefault(object,defaultValue);

		// ASsert: Validate result
		assertEquals(object, result);
	}
	
	@Test
	void givenWantGetDefaultValueWhenObjectIsNotNullThenResulIsTheSameObjetc() {
		// Arrange: Initial Context
		String object = null;
		var defaultValue = "Default";

		// Act:Execute action
		var result = ObjectHelper.getDefault(object,defaultValue);

		// ASsert: Validate result
		assertEquals(defaultValue, result);
	}
}
