package com.ai.doc.visitor.v4;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/19
 * @Version: 1.0
 **/
public class Extractor implements Visitor {
    @Override
    public void visit(PdfFile pdfFile) {
        //...
        System.out.println("Extract pdf.");
    }

    @Override
    public void visit(PPTFile pptFile) {
        //...
        System.out.println("Extract ppt.");
    }

    @Override
    public void visit(WordFile wordFile) {
        //...
        System.out.println("Extract word.");
    }
}
