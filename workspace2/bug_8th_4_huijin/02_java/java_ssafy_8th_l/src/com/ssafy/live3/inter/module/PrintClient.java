package com.ssafy.live3.inter.module;

public class PrintClient {
    private Printer printer;
    
    public void setPrinter(Printer printer) { //printer 설정
        this.printer = printer;
    }
    
    public void printThis(String fileName) {
        printer.print(fileName);
    }
}
