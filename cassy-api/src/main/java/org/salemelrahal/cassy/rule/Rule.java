package org.salemelrahal.cassy.rule;

import org.salemelrahal.cassy.model.field.Field;

/**
 * Provides the logic for determining a Field state, given the
 * previous field state. Most cellular automaton are defined by
 * this logic.
 *
 */
public interface Rule {
	public Field calculateNextField(Field field);
}
