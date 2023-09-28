package com.example.stamper;

import org.wickedsource.docxstamper.DocxStamper;
import org.wickedsource.docxstamper.DocxStamperConfiguration;
import org.wickedsource.docxstamper.replace.typeresolver.image.Image;

import java.io.*;

public class Stamper {

    public static void main(String[] args) throws IOException {

        DocContext context = new DocContext();
        Data data = new Data();
        data.setDate("01.01.2000");
        data.setKnm("123456789");
        data.setPlace("Тестовое место");
        context.setData(data);

        File image = new File("src/main/resources/код.png");
        Image qrcode = new Image(new FileInputStream(image));

        context.setQrcode(qrcode);

        File initialFile = new File("src/main/resources/Тест.docx");
        InputStream template = new FileInputStream(initialFile);

        OutputStream out = new FileOutputStream("src/main/resources/Result.docx");
        DocxStamper stamper = new DocxStamperConfiguration().build();
        stamper.stamp(template, context, out);
        out.close();

    }

}
