package de.unibayreuth.se.teaching.list.business.impl;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Step definitions for the Cucumber tests of the doubly-linked list.
 */
public class CucumberDoublyLinkedListSteps {
    private static final Logger logger = LoggerFactory.getLogger(CucumberDoublyLinkedListSteps.class);

    private DoublyLinkedList list;
    private double value;
    private double[] arrayFromValues;
    private double[] arrayFromList;

    @Before
    public void initialization() {
        list = new DoublyLinkedList();
    }

    // Given -----------------------------------------------------------------------

    @Given("^an empty list$")
    public void anEmptyList() {
        Assertions.assertTrue(list.isEmpty());
    }

    @Given("^I have elements with the following values in my list:$")
    public void iHaveElementsWithTheFollowingValuesInMyList(List<Double> values) {
        values.forEach(list::append);
        arrayFromValues = values.stream().mapToDouble(Double::doubleValue).toArray();
    }

    // When -----------------------------------------------------------------------

    @When("^I append an element with value (\\d+.\\d+)$")
    public void iAppendAnElementWithValue(double value) {
        this.value = value;
        list.append(value);
    }

    @When("^I convert the list to an array$")
    public void iConvertTheListToAnArray() {
        arrayFromList = list.asArray();
    }

    @When("^I invert the list$")
    public void iInvertTheList() {
        logger.info("%s not implemented yet.".formatted(Thread.currentThread().getStackTrace()[1].getMethodName()));
    }

    @When("I insert {double}")
    public void iInsert(double arg0) {
        list.insert(arg0);
    }

    // Then -----------------------------------------------------------------------

    @Then("^the list should contain that element$")
    public void theListShouldContainThatElement() {
        Assertions.assertArrayEquals(new double[]{value}, list.asArray());
    }

    @Then("^the array should contain the same elements in the same order$")
    public void theArrayShouldContainTheSameElementsInTheSameOrder() {
        Assertions.assertArrayEquals(arrayFromValues, arrayFromList);
    }

    @Then("^the list should contain the elements in the following order:$")
    public void theListShouldContainTheElementsInTheFollowingOrder(List<Double> values) {
        logger.info("%s not implemented yet.".formatted(Thread.currentThread().getStackTrace()[1].getMethodName()));
    }

    @Then("the list should contain {int} element(s)")
    public void theListShouldContainElement(int count) {
        Assertions.assertEquals(count, list.getLength());
    }

    @Then("the list should be the following")
    public void theListShouldBeTheFollowing(List<Double> values) {
        Assertions.assertEquals(list.getLength(), values.size());
        double[] array = list.asArray();
        for (int i = 0; i < values.size(); i++) {
            Assertions.assertEquals(values.get(i), array[i]);
        }
    }
}
