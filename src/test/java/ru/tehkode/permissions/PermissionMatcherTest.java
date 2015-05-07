
package ru.tehkode.permissions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public abstract class PermissionMatcherTest {
	
	protected PermissionMatcher matcher;
	
	@Test
	public void testCaseInsensitivity() {
		assertTrue(matcher.isMatches("PERMISSION.*", "permission.Case.Are.does.NOT.matter"));
	}
	
	// @Test
	public void testRanges() {
		// low boundary
		assertTrue(matcher.isMatches("permission.range.(100-200)", "permission.range.100"));
		// mid range
		assertTrue(matcher.isMatches("permission.range.(100-200)", "permission.range.150"));
		// high boundary
		assertTrue(matcher.isMatches("permission.range.(100-200)", "permission.range.200"));
		
		// out range
		assertFalse(matcher.isMatches("permission.range.(100-200)", "permission.range.99"));
		assertFalse(matcher.isMatches("permission.range.(100-200)", "permission.range.201"));
		
	}
	
	@Test
	public void testSpecialPermissions() {
		assertTrue(matcher.isMatches("-permission.*", "permission.anything"));
		assertTrue(matcher.isMatches("#permission.*", "permission.anything"));
		
		assertTrue(matcher.isMatches("-#permission.*", "permission.anything"));
		
		assertFalse(matcher.isMatches("permission.*", "#permission.anything"));
	}
}
