package com.cursoandroidstudio.rexcryptoeducation.helper;

import android.util.Base64;

/**
 * Created by filip
 */
public class Base64Custom {

    public static String base64Code(String text){
        return Base64.encodeToString(text.getBytes(), Base64.DEFAULT ).replaceAll("(\\n|\\r)","");
    }

    public static String base64Decode(String encodedText){
        return new String( Base64.decode(encodedText, Base64.DEFAULT) );
    }

}
