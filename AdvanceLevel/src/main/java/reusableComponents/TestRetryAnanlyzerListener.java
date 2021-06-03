package reusableComponents;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class TestRetryAnanlyzerListener implements IAnnotationTransformer {

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		/*annotation.setRetryAnalyzer(TestRetryAnalyzer.class);*/
		
		 IRetryAnalyzer retry = annotation.getRetryAnalyzer();

	        if (retry == null)  {
	        	annotation.setRetryAnalyzer(TestRetryAnalyzer.class);
	        }
		
	}

	
}
