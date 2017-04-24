package org.fundacionjala.pivotal.framework.util;

/**
 * Class interface that automates test cases steps.
 *
 * @author       Rosario Garcia
 * @version      %I%, %G%
 * @since        1.0
 */
@FunctionalInterface
public interface IAutomationStep {
    /**
     * Method to execute steps according to the
     * subclasses defined.
     */
    void executeStep();
}
