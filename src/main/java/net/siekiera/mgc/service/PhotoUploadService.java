package net.siekiera.mgc.service;

import net.siekiera.mgc.model.Zdjecie;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by eric on 14.05.2016.
 */
@Service
public class PhotoUploadService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public Zdjecie upload(MultipartFile file) {
        Zdjecie zdjecie = new Zdjecie();
        String sciezka = new String();
        if (!file.isEmpty()) {
            try {
                String name = file.getOriginalFilename();
                sciezka = "/Users/eric/Documents/uploadtest/" + fileNameAddHash(name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File(sciezka)));
                FileCopyUtils.copy(file.getInputStream(), stream);
                stream.close();
            } catch (Exception e) {
                log.error("Blad ladowania pliku!" + e);
            }
        } else {
            log.error("Plik = null!");
        }
        zdjecie.setSciezka(sciezka);
        log.debug("Zwracam zdjecie z pliku:" + file.getOriginalFilename());
        return zdjecie;
    }

    /**
     * Metoda dodaje do nazwy pliku ciag losowych znakow
     * (żeby zminimalizowac ryzyko nadpisania pliku)
     * @param fileName
     * @return
     */
    private String fileNameAddHash (String fileName) {
        String newFileName = new String();
        String[] split = StringUtils.split(fileName, ".");
        newFileName = split[0] + RandomStringUtils.randomAlphabetic(10) + "." + split[1];
        return newFileName;
    }

}
