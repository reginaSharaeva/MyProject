package ru.kpfu.itis.toyshop;

import org.springframework.stereotype.Component;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by Регина on 04.04.2016.
 */
@Component
public class HashMake {

    public String md5Apache(String st) {
        byte[] md5Hex = DigestUtils.md5(st);
        return String.valueOf(md5Hex);
    }
}

