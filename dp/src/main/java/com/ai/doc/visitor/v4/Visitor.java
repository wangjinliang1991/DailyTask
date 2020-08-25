package com.ai.doc.visitor.v4;

/**
 * @Description: TODO
 * @Author:
 * @Date: 2020/8/19
 * @Version:
 **/
public interface Visitor {
    void visit(PdfFile pdfFile);
    void visit(PPTFile pptFile);
    void visit(WordFile wordFile);
}
