package it.java.edu.java8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


// Nashorn engine is planned to be removed from a future JDK release
public class NashornMain {

        public static void main(String[] args) {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("nashorn");

            try {
                engine.eval("print('Hello, Nashorn');");
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        }

}
