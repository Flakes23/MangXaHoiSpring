package com.nhom6.mxh.Services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//tao cloud luu anh
@Service
@Slf4j
public class CloudinaryService {
    public Cloudinary cloudinary;

    // contructor
    public CloudinaryService() {
        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("cloud_name", "dcpgsw3cc");
        valuesMap.put("api_key", "228294847414865");
        valuesMap.put("api_secret", "zSkBjH2j-ZY1MAFsF2RIyu0N4pI");
        cloudinary = new Cloudinary(valuesMap);
    }

    // tai hinh anh len cloud
    public Map upload(MultipartFile multipartFile) throws IOException {
        log.info("Uploading photo to clound: {}", multipartFile.getOriginalFilename());
        File file = convert(multipartFile);
        Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        if (!Files.deleteIfExists(file.toPath())) {
            log.error("Unable to upload file: {}", file.getAbsolutePath());
            throw new IOException("Unable to upload temporary file: " + file.getAbsolutePath());
        }
        return result;
    }

    // xoa anh tren cloud
    public Map delete(String id) throws IOException {
        log.info("Deleting photo from cloud: {}", id);
        return cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
    }

    // chuyen anh thanh file
    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();
        return file;
    }

    public String getImageUrl(String publicId) {
        return cloudinary.url().generate(publicId);
    }

    public String getPublicId(String url) {
        // URL mẫu:
        // http://res.cloudinary.com/dgts7tmnb/image/upload/v1718723087/oax0ufrlkzdyjslbxv0c.png
        String[] parts = url.split("/");
        String publicIdWithExtension = parts[parts.length - 1];
        String publicId = publicIdWithExtension.split("\\.")[0];
        // tra ve oax0ufrlkzdyjslbxv0c
        return publicId;
    }
}
