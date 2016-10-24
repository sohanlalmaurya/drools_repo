package com.sample;

import java.util.ArrayList;
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
           // kSession.setGlobal("testDroolsList", new ArrayList<String>());
            kSession.setGlobal("docTypeList", new ArrayList<DocTypesModel>());
            kSession.setGlobal("notRequied", false);
            //kSession.setGlobal("docTypesModel", new DocTypesModel());
            //demoAgendaGroup(kSession);
            int rules= kSession.fireAllRules();
            System.out.println(rules);
           
           List<DocTypesModel> docTypesModelList=  (List<DocTypesModel>) kSession.getGlobal("docTypeList");
           for(DocTypesModel docTypesModel:docTypesModelList){
        	   System.out.println("\n\n"+docTypesModel.getId());
        	   System.out.println(docTypesModel.getName());
        	   System.out.println(docTypesModel.getIsMandatory());
           }
           System.out.println("\n\n docTypesModelList.size()="+docTypesModelList.size());
           
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    public static void demoAgendaGroup(KieSession kSession)
    {
        kSession.getAgenda().getAgendaGroup("primary").setFocus();
        DroolsTest drools= new DroolsTest();
        kSession.insert(drools.testMethod());
        kSession.insert(drools.getTestModel(TestModel.TESTINTEGER1));
        kSession.insert(drools.getTestModel());
       // kSession.getAgenda().getAgendaGroup("secondary").setFocus();
        kSession.fireAllRules();             	
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
