package com.ai.doc.visitor.v4;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/19
 * @Version: 1.0
 **/
public class Compressor implements Visitor {
    @Override
    public void visit(PdfFile pdfFile) {
        //...
        System.out.println("Compress pdf.");
    }

    @Override
    public void visit(PPTFile pptFile) {
        //...
        System.out.println("Compress ppt.");
    }

    @Override
    public void visit(WordFile wordFile) {
        //...
        System.out.println("Compress word.");
    }
}
