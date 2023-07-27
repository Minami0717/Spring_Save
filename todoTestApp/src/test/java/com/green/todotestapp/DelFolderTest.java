package com.green.todotestapp;

import com.green.todotestapp.utils.MyFileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;

public class DelFolderTest {
    @Test
    public void delFolder() {
        String path = MyFileUtils.getAbsolutePath("/home2");

//        File folder = new File(path);
//        if (folder.exists()) {
//            folder.delete();
//        }

        MyFileUtils.delFolder(path);
    }
}
