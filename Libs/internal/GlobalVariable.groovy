package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object baseUrl
     
    /**
     * <p></p>
     */
    public static Object pageLoadWT
     
    /**
     * <p></p>
     */
    public static Object response
     
    /**
     * <p></p>
     */
    public static Object randomNum
     
    /**
     * <p></p>
     */
    public static Object successStep
     
    /**
     * <p></p>
     */
    public static Object elementPresentWT
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += TestCaseMain.getParsedValues(RunConfiguration.getOverridingParameters())
    
            baseUrl = selectedVariables['baseUrl']
            pageLoadWT = selectedVariables['pageLoadWT']
            response = selectedVariables['response']
            randomNum = selectedVariables['randomNum']
            successStep = selectedVariables['successStep']
            elementPresentWT = selectedVariables['elementPresentWT']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
