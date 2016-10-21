package com.sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("test-rules");
        	//kSession.getAgenda().getActivationGroup("test");
        	DroolsTest drools= new DroolsTest();
            kSession.insert(drools.testMethod());
            //kSession.insert(drools.getTestModel(TestModel.TESTINTEGER1));
            kSession.insert(drools.getTestModel());
            kSession.setGlobal("testDroolsList", new ArrayList<String>());

            int rules= kSession.fireAllRules();
            System.out.println(rules);
           List<String> list=  (List<String>) kSession.getGlobal("testDroolsList");
           for(String string:list){
        	   System.out.println(string+" geting from list");
           }
           
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    private TestModel getTestModel(){
    	
    	TestModel testModel = new TestModel();
    	testModel.setTestString("Test Model");
    	testModel.setTestInteger(TestModel.TESTINTEGER1);
    	testModel.setTestInteger1(TestModel.TESTINTEGER2);
    	return testModel;
    }
    private Message testMethod() {
    	
        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);
        
        return message;
	}
    
    private TestModel getTestModel(Integer status){
    	
    	TestModel testModel = new TestModel();
    	testModel.setTestString("Test Model");
    	testModel.setTestInteger(status);
    	return testModel;
    }
}
