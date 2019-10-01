package com.revature.tests;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.builder.SpringApplicationBuilder;


import com.revature.assignforce.AssignForceTrainerServiceApplication;

public class TestAssignForceTrainerServiceApplication {
	@SuppressWarnings("static-access")
	@Test
    public void testMain() {
		AssignForceTrainerServiceApplication hey = new AssignForceTrainerServiceApplication();
		SpringApplicationBuilder hello = Mockito.mock(SpringApplicationBuilder.class);
		hey.setLauncher(hello);
		hey.main(new String[] { "test1", "test2" });
        //PowerMockito.verifyNew(SpringApplicationBuilder.class).withNoArguments();
        Mockito.verify(hello).run(new String[] { "test1", "test2" });
     }
//	
//	@Test
//	public void testMainInstantiation() {
//		AssignForceTrainerServiceApplication hey = new AssignForceTrainerServiceApplication();
//	}

}
