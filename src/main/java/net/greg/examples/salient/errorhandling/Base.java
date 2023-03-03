package net.greg.examples.salient.errorhandling;

import static net.greg.examples.salient.errorhandling.PropagatesExceptions.REDB;
import static net.greg.examples.salient.errorhandling.PropagatesExceptions.GRNB;
import static net.greg.examples.salient.errorhandling.PropagatesExceptions.NC;


public class Base implements PropagatesExceptions {

  protected Base covariantIdentity() { return this; }

  //  throwing an ArithmeticException in this method would compile, but fail at runtime
  protected void benignMethod() {

    try {

      System.err.println(getClass() + " == Baseclass.benignMethod()");

      throw new ArithmeticException();
    }
    catch (RuntimeException e) {  /* swallow */ }
  }

  protected void troubleMethod() { // throws RuntimeException {
    System.err.println(getClass() + " == Baseclass.troubleMethod()");

    try {

      throw new ArithmeticException();
    }
    catch (Throwable e) {

      System.err.println(
        "\n\n\n" + REDB + "Stacktrace: " + NC +
        "\n ~ Reporting Class: " + getClass().getSimpleName());

      e.printStackTrace();

      System.err.println(
        "\n" + REDB + e.getStackTrace() + NC +
        "\n ~ Reporting Class: " + getClass().getSimpleName());
    }
    finally {
      System.err.println(
      GRNB + "\n\nfinally block" + NC +
      "\n ~ Reporting Class: " + getClass().getSimpleName());

    }
  }
}
