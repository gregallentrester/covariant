package net.greg.examples.salient.errorhandling;

import static net.greg.examples.salient.errorhandling.PropagatesExceptions.REDB;
import static net.greg.examples.salient.errorhandling.PropagatesExceptions.GRNB;
import static net.greg.examples.salient.errorhandling.PropagatesExceptions.NC;


public final class Delegate extends Base {

  protected Delegate covariantIdentity() { return this; }

  public void benignMethod() {
    System.err.println(getClass() + " == Delegate.benignMethod()");

    super.benignMethod();
  }

  public void troubleMethod() throws RuntimeException {
    System.err.println(getClass() + " == Delegate.troubleMethod()");

    try {
      super.troubleMethod();
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
