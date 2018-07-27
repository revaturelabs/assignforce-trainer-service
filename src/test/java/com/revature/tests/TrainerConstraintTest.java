package com.revature.tests;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Size;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.assignforce.beans.Cert;
import com.revature.assignforce.beans.SkillIdHolder;
import com.revature.assignforce.beans.Trainer;
import com.revature.assignforce.beans.Unavailability;

public class TrainerConstraintTest {
	
	private static Validator validator;
	

	  @BeforeClass
	   public static void setUp() {
	      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	      validator = factory.getValidator();
	   }
	  
	  
	  //test that the @NotNull constraint works on firstName
	  
	  @Test
	   public void firstNameIsNullTest() {
		  Cert c1 = new Cert(1, "AWS");
			Cert c2 = new Cert(3, "Java");
			Cert c3 = new Cert(5, "SQL");
			Unavailability u1 = new Unavailability(1, new Date(192933L), new Date(30L), "Family matter");
			Unavailability u2 = new Unavailability(1, new Date(10000L), new Date(20000L), "Medical check up");
			SkillIdHolder s1 = new SkillIdHolder(7);
			SkillIdHolder s2 = new SkillIdHolder(8);
			SkillIdHolder s3 = new SkillIdHolder(10);
			HashSet<Cert> certSet = new HashSet<Cert>();
			certSet.add(c1);
			certSet.add(c2);
			certSet.add(c3);
			HashSet<Unavailability> unavailabilitySet = new HashSet<Unavailability>();
			unavailabilitySet.add(u1);
			unavailabilitySet.add(u2);
			HashSet<SkillIdHolder> skillSet = new HashSet<SkillIdHolder>();
			skillSet.add(s1);
			skillSet.add(s2);
			skillSet.add(s3);
			Trainer t1 = new Trainer(1, null, "Washington", true, 1, unavailabilitySet, 
					"dWashington@gmail.com", skillSet, certSet, "I am a Professional", "www.linkedin.com");

	      Set<ConstraintViolation<Trainer>> constraintViolations =
	      validator.validate( t1 );

	      
	      
	    for(ConstraintViolation<Trainer> myConstraint: constraintViolations) {
	    	System.out.println(myConstraint.getMessage());
	    }
	 
	 
	      assertEquals( 1, constraintViolations.size() );
	      assertEquals(
		 	         "firstName cannot be null",
		 	         constraintViolations.iterator().next().getMessage()
		 	      );
		      
	     
	   }
	  
	  
	// Test @Size(min = 1, max = 128) works
	  @Test
	   public void firstNameIsEmptyStringTest() {
		  Cert c1 = new Cert(1, "AWS");
			Cert c2 = new Cert(3, "Java");
			Cert c3 = new Cert(5, "SQL");
			Unavailability u1 = new Unavailability(1, new Date(192933L), new Date(30L), "Family matter");
			Unavailability u2 = new Unavailability(1, new Date(10000L), new Date(20000L), "Medical check up");
			SkillIdHolder s1 = new SkillIdHolder(7);
			SkillIdHolder s2 = new SkillIdHolder(8);
			SkillIdHolder s3 = new SkillIdHolder(10);
			HashSet<Cert> certSet = new HashSet<Cert>();
			certSet.add(c1);
			certSet.add(c2);
			certSet.add(c3);
			HashSet<Unavailability> unavailabilitySet = new HashSet<Unavailability>();
			unavailabilitySet.add(u1);
			unavailabilitySet.add(u2);
			HashSet<SkillIdHolder> skillSet = new HashSet<SkillIdHolder>();
			skillSet.add(s1);
			skillSet.add(s2);
			skillSet.add(s3);
			Trainer t1 = new Trainer(1, "", "Washington", true, 1, unavailabilitySet, 
					"dWashington@gmail.com", skillSet, certSet, "I am a Professional", "www.linkedin.com");

	      Set<ConstraintViolation<Trainer>> constraintViolations =
	      validator.validate( t1 );

	      
	
	      assertEquals( 1, constraintViolations.size() );
	      assertEquals(
		 	         "size must be between 1 and 128",
		 	         constraintViolations.iterator().next().getMessage()
		 	      );
		      
	     
	   }
	  
	  
	// Test @Size(min = 1, max = 128) constraint works for lastName 
	  @Test
	   public void lastNameIsEmptyStringTest() {
		  Cert c1 = new Cert(1, "AWS");
			Cert c2 = new Cert(3, "Java");
			Cert c3 = new Cert(5, "SQL");
			Unavailability u1 = new Unavailability(1, new Date(192933L), new Date(30L), "Family matter");
			Unavailability u2 = new Unavailability(1, new Date(10000L), new Date(20000L), "Medical check up");
			SkillIdHolder s1 = new SkillIdHolder(7);
			SkillIdHolder s2 = new SkillIdHolder(8);
			SkillIdHolder s3 = new SkillIdHolder(10);
			HashSet<Cert> certSet = new HashSet<Cert>();
			certSet.add(c1);
			certSet.add(c2);
			certSet.add(c3);
			HashSet<Unavailability> unavailabilitySet = new HashSet<Unavailability>();
			unavailabilitySet.add(u1);
			unavailabilitySet.add(u2);
			HashSet<SkillIdHolder> skillSet = new HashSet<SkillIdHolder>();
			skillSet.add(s1);
			skillSet.add(s2);
			skillSet.add(s3);
			Trainer t1 = new Trainer(1, "George", "", true, 1, unavailabilitySet, 
					"dWashington@gmail.com", skillSet, certSet, "I am a Professional", "www.linkedin.com");

	      Set<ConstraintViolation<Trainer>> constraintViolations =
	      validator.validate( t1 );

	      
	
	      assertEquals( 1, constraintViolations.size() );
	      assertEquals(
		 	         "size must be between 1 and 128",
		 	         constraintViolations.iterator().next().getMessage()
		 	      );
		      
	     
	   }
	  
	  
	// Test @NotNull for email

	  @Test
	   public void emailIsNullTest() {
		  Cert c1 = new Cert(1, "AWS");
			Cert c2 = new Cert(3, "Java");
			Cert c3 = new Cert(5, "SQL");
			Unavailability u1 = new Unavailability(1, new Date(192933L), new Date(30L), "Family matter");
			Unavailability u2 = new Unavailability(1, new Date(10000L), new Date(20000L), "Medical check up");
			SkillIdHolder s1 = new SkillIdHolder(7);
			SkillIdHolder s2 = new SkillIdHolder(8);
			SkillIdHolder s3 = new SkillIdHolder(10);
			HashSet<Cert> certSet = new HashSet<Cert>();
			certSet.add(c1);
			certSet.add(c2);
			certSet.add(c3);
			HashSet<Unavailability> unavailabilitySet = new HashSet<Unavailability>();
			unavailabilitySet.add(u1);
			unavailabilitySet.add(u2);
			HashSet<SkillIdHolder> skillSet = new HashSet<SkillIdHolder>();
			skillSet.add(s1);
			skillSet.add(s2);
			skillSet.add(s3);
			Trainer t1 = new Trainer(1, "George", "Washington", true, 1, unavailabilitySet, 
					null, skillSet, certSet, "I am a Professional", "www.linkedin.com");

	      Set<ConstraintViolation<Trainer>> constraintViolations =
	      validator.validate( t1 );

	      
	
	      assertEquals( 1, constraintViolations.size() );
	      assertEquals(
		 	         "email must not be null",
		 	         constraintViolations.iterator().next().getMessage()
		 	      );
		      
	     
	   }
	  
	  
	// Test @Email for email

		  @Test
		   public void emailIsInWrongFormatTest() {
			  Cert c1 = new Cert(1, "AWS");
				Cert c2 = new Cert(3, "Java");
				Cert c3 = new Cert(5, "SQL");
				Unavailability u1 = new Unavailability(1, new Date(192933L), new Date(30L), "Family matter");
				Unavailability u2 = new Unavailability(1, new Date(10000L), new Date(20000L), "Medical check up");
				SkillIdHolder s1 = new SkillIdHolder(7);
				SkillIdHolder s2 = new SkillIdHolder(8);
				SkillIdHolder s3 = new SkillIdHolder(10);
				HashSet<Cert> certSet = new HashSet<Cert>();
				certSet.add(c1);
				certSet.add(c2);
				certSet.add(c3);
				HashSet<Unavailability> unavailabilitySet = new HashSet<Unavailability>();
				unavailabilitySet.add(u1);
				unavailabilitySet.add(u2);
				HashSet<SkillIdHolder> skillSet = new HashSet<SkillIdHolder>();
				skillSet.add(s1);
				skillSet.add(s2);
				skillSet.add(s3);
				Trainer t1 = new Trainer(1, "George", "Washington", true, 1, unavailabilitySet, 
						"wringnl", skillSet, certSet, "I am a Professional", "www.linkedin.com");

		      Set<ConstraintViolation<Trainer>> constraintViolations =
		      validator.validate( t1 );

		      
		
		      assertEquals( 1, constraintViolations.size() );
		      assertEquals(
			 	         "email is not in valid format",
			 	         constraintViolations.iterator().next().getMessage()
			 	      );
			      
		     
		   }
	  



}
