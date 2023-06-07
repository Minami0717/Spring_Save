package com.example.boardpractice.utils;

import java.util.UUID;

public class FileUtils {
    public static String getExt(String fileNm) {
        return fileNm.substring(fileNm.lastIndexOf("."));
    }

    public static String getFileNm(String fileNm) {
        return fileNm.substring(0, fileNm.lastIndexOf("."));
    }

    public static String makeRandomFileNm(String fileNm) {
        return UUID.randomUUID() + getExt(fileNm);
    }
}
