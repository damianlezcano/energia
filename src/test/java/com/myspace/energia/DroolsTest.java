package com.myspace.energia;

import java.io.IOException;

import org.drools.compiler.compiler.DroolsParserException;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.definition.KiePackage;
import org.kie.api.definition.rule.Rule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


public class DroolsTest {

	@Test
	public void test1() throws DroolsParserException, IOException {
		
        KieServices kieServices = KieServices.Factory.get();

        KieContainer kContainer = kieServices.getKieClasspathContainer();

        info("Creating kieBase");
        KieBase kieBase = kContainer.getKieBase();

        info("There should be rules: ");
        for ( KiePackage kp : kieBase.getKiePackages() ) {
            for (Rule rule : kp.getRules()) {
                info("kp " + kp + " rule " + rule.getName());
            }
        }

        info("Creating kieSession");
        KieSession session = kieBase.newKieSession();

        info("Now running data");

        Factura t1 = new Factura("t1");
        session.insert(t1);
        session.fireAllRules();

	}
	
	public static void info(String msg) {
		System.out.println(msg);
	}
	
}
