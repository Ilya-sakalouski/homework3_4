package ru.mail.ilya6697089.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandles;
import java.nio.charset.StandardCharsets;

import ru.mail.ilya6697089.service.Task1Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task1 implements Task1Service {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public void runTask1() {
        try {
            File file = new File("./src/main/resources/DBFile.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                logger.info(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        //        FileInputStream fis = null;
        //        InputStreamReader isr = null;
        //        int b;
        //
        //        try {
        //            fis = new FileInputStream("./src/main/resources/DBFile.txt");
        //            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        //            while ((b = isr.read()) != (-1)) {
        //                logger.info((char) b);
        //            }
        //        } catch (FileNotFoundException e) {
        //            logger.error(e.getMessage(), e);
        //        } catch (IOException e) {
        //            logger.error(e.getMessage(), e);
        //        } finally {
        //            try {
        //                assert fis != null;
        //                fis.close();
        //            } catch (IOException e) {
        //                logger.error(e.getMessage(), e);
        //            }
        //            try {
        //                assert isr != null;
        //                isr.close();
        //            } catch (IOException e) {
        //                logger.error(e.getMessage(), e);
        //            }
    }

}
