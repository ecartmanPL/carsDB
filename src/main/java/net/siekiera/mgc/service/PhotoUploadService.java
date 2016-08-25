package net.siekiera.mgc.service;

import net.siekiera.mgc.configuration.Const;
import net.siekiera.mgc.model.Zdjecie;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
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
                sciezka = Const.uploadPath + fileNameAddHash(name);
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

    /**
     * Metoda pobiera DataUrl i sciezke i zapisuje dataurl do sciezki
     */
    public void saveDataUrlAsFile (String dataUrl, String path) {
        dataUrl = dataUrl.replaceFirst("data:image/jpeg;base64,", "");
        BufferedImage bi = null;
        byte[] decodedBytes = DatatypeConverter.parseBase64Binary(dataUrl);
        try {
            bi = ImageIO.read(new ByteArrayInputStream(decodedBytes));
            File outputFile = new File(Const.uploadPath + path);
            ImageIO.write(bi, "jpeg", outputFile);
        }
        catch(Exception e) {
            log.error("Błąd w metodzie saveDataUrlAsFile" + e.getMessage());
        }
        finally {
            bi.flush();
        }
    }

}
