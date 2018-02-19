package org.shil.omr.test;

import java.io.FileReader;
import java.util.Random;

import javax.script.Invocable;
import javax.script.ScriptEngine; 
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Test failed
 * @author vanis
 *
 */
public class CallJavaScript {
	
	public static void main(String[] args) {
	
		try {
			
			Random r = new Random(System.currentTimeMillis());
		ScriptEngineManager manager = new ScriptEngineManager();   
		ScriptEngine engine = manager.getEngineByName("javascript");     
	
		String jsFileName = "abc.js";
	
		FileReader reader = new FileReader(jsFileName); 
		engine.eval(reader);
		Invocable invoke = (Invocable)engine;
		String result = (String)invoke.invokeFunction("findseed", r.nextLong());
		
		System.out.println(result);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
