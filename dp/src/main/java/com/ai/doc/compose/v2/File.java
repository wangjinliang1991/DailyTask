package com.ai.doc.compose.v2;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/17
 * @Version: 1.0
 **/
public class File extends FileSystemNode {
    public File(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        return 1;
    }

    @Override
    public long countSizeOfFile() {
        java.io.File file = new java.io.File(path);
        if (!file.exists()) return 0;
        return file.length();
    }
}
