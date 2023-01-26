package com.cybertek.tests.day11_file_upload;

import org.testng.annotations.Test;

public class FIlePathExample {

    @Test
    public void test(){

        // C:\Users\aksumustafa16\IdeaProjects\TestNGProject\src\test\resources\textfile.txt

        String projectPat = System.getProperty("user.dir");
        String relativePath = "src/test/resources/textfile.txt";
        String filePath = projectPat + "/" + relativePath;

    }
}
