package net.greg.examples.salient.errorhandling;


public final class Driver {

  public static void main(String ... args) {
    new Driver().process();
  }


  public void process() {

    try {

      Base base = new Base();

      Delegate delegate = new Delegate();


      System.err.println("\n\nCASE A - base.benignMethod()");
      base.benignMethod();

      System.err.println("\n\nCASE B - delegate.benignMethod()");
      delegate.benignMethod();


      System.err.println("\n\nCASE C - base.troubleMethod()");
      base.troubleMethod();

      System.err.println("\n\nCASE D - delegate.troubleMethod()");
      delegate.troubleMethod();
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


  public static final String REDB = "\033[1;31m";
  public static final String GRNB = "\033[1;32m";

  private static final String NC = "\u001B[0m";

  private static final String RED = "\u001B[31m";
  private static final String GRN = "\u001B[32m";
}
