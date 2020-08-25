package com.ai.doc.compose.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/17
 * @Version: 1.0
 **/
public class Directory extends FileSystemNode {
    private List<FileSystemNode> subNodes = new ArrayList<>();

    public Directory(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        int numOfFiles = 0;
        for (FileSystemNode fileOrDir:subNodes){
            numOfFiles += fileOrDir.countNumOfFiles();
        }
        return numOfFiles;
    }

    @Override
    public long countSizeOfFile() {
        long sizeOfFiles = 0;
        for (FileSystemNode fileOrDir:subNodes){
            sizeOfFiles += fileOrDir.countSizeOfFile();
        }
        return sizeOfFiles;
    }
    public void addSubNode(FileSystemNode fileOrDir){
        subNodes.add(fileOrDir);
    }
    public void removeSubNode(FileSystemNode fileOrDir){
        int size = subNodes.size();
        int i = 0;
        for (;i<size;i++){
            if (subNodes.get(i).getPath().equalsIgnoreCase(fileOrDir.getPath())){
                break;
            }
        }
        if (i<size){
            subNodes.remove(i);
        }
    }
}
