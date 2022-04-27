package proj2;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import proj2.PokemonTest;

public class PokemonTestRunner {
	public static void main(String[] args) {
	      Result result = JUnitCore.runClasses(PokemonTest.class);
			
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
			
	      System.out.println(result.wasSuccessful());
	   }
}
