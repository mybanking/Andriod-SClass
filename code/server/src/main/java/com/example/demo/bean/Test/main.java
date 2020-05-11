package com.example.demo.bean.Test;

import org.python.util.PythonInterpreter;

public class main {
    public static void main(String[] args) {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("a=[5,2,3,9,4,0]; ");   
        interpreter.exec("print(sorted(a));");
    }
}
