package com.example.stamper;

import org.wickedsource.docxstamper.replace.typeresolver.image.Image;

@lombok.Data
public class DocContext {

    private Data data;
    private Image qrcode;
}
