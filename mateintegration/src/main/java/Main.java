import com.flexionmobile.codingchallenge.integration.Integration;
import com.flexionmobile.codingchallenge.integration.IntegrationTestRunner;
import com.impl.IntegrationImpl;

/**
 * Created by Mate on 2017.08.22..
 */
public class Main {

    public static void main(String[] args) {
        IntegrationTestRunner tester = new IntegrationTestRunner();
        Integration myIntegration = new IntegrationImpl();
        tester.runTests(myIntegration);

    }
}
