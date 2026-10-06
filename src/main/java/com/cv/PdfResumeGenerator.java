package com.cv;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

import java.util.List;

public class PdfResumeGenerator {

    public void generate(Resume resume, String outputPath, String imagePath) {

        try {
            PdfWriter writer = new PdfWriter(outputPath);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.setMargins(35, 40, 35, 40);

            // Türkçe karakterleri destekleyen font
            PdfFont font = PdfFontFactory.createFont(
                    "src/main/resources/segoeui.ttf",
                    PdfEncodings.IDENTITY_H,
                    PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED
            );

            document.setFont(font);

            PersonalInfo personalInfo = resume.getPersonalInfo();

            // =========================
            // ÜST BÖLÜM
            // =========================

            Table headerTable = new Table(
                    UnitValue.createPercentArray(new float[]{1, 2.5f})
            );

            headerTable.setWidth(UnitValue.createPercentValue(100));

            // Fotoğraf
            ImageData imageData = ImageDataFactory.create(imagePath);
            Image profileImage = new Image(imageData);

            profileImage.setWidth(110);
            profileImage.setHeight(130);

            Cell imageCell = new Cell()
                    .add(profileImage)
                    .setBorder(Border.NO_BORDER);

            headerTable.addCell(imageCell);

            // İsim ve iletişim bilgileri
            Cell informationCell = new Cell()
                    .setBorder(Border.NO_BORDER)
                    .setPaddingLeft(20);

            informationCell.add(
                    new Paragraph(personalInfo.getFullName())
                            .setFontSize(25)
                            .setBold()
                            .setFontColor(
                                    new DeviceRgb(35, 55, 75)
                            )
            );

            informationCell.add(
                    new Paragraph(personalInfo.getTitle())
                            .setFontSize(15)
                            .setFontColor(
                                    new DeviceRgb(80, 90, 100)
                            )
                            .setMarginBottom(8)
            );

            informationCell.add(
                    new Paragraph(
                            "E-posta: " + personalInfo.getEmail()
                    ).setFontSize(10)
            );

            informationCell.add(
                    new Paragraph(
                            "Telefon: " + personalInfo.getPhone()
                    ).setFontSize(10)
            );

            informationCell.add(
                    new Paragraph(
                            "Adres: " + personalInfo.getAddress()
                    ).setFontSize(10)
            );

            headerTable.addCell(informationCell);

            document.add(headerTable);

            // Ayırıcı çizgi
            Table separator = new Table(
                    UnitValue.createPercentArray(new float[]{1})
            );

            separator.setWidth(UnitValue.createPercentValue(100));

            Cell separatorCell = new Cell()
                    .setBorder(Border.NO_BORDER)
                    .setBackgroundColor(
                            new DeviceRgb(35, 55, 75)
                    )
                    .setHeight(4);

            separator.addCell(separatorCell);

            document.add(separator);

            // =========================
            // PROFİL
            // =========================

            addSectionTitle(document, "PROFİL");

            document.add(
                    new Paragraph(
                            "Java ve backend geliştirme alanında çalışan, "
                                    + "nesne yönelimli programlama ve yazılım "
                                    + "geliştirme süreçlerine ilgi duyan bir "
                                    + "yazılım geliştiricisiyim."
                    )
                            .setFontSize(10.5f)
                            .setMarginBottom(10)
            );

            // =========================
            // EĞİTİM
            // =========================

            addSectionTitle(document, "EĞİTİM");

            Education education = resume.getEducation();

            document.add(
                    new Paragraph(
                            education.getSchoolName()
                    )
                            .setBold()
                            .setFontSize(12)
                            .setMarginBottom(2)
            );

            document.add(
                    new Paragraph(
                            education.getDepartment()
                                    + " | "
                                    + education.getPeriod()
                    )
                            .setFontSize(10.5f)
                            .setMarginBottom(10)
            );

            // =========================
            // İŞ DENEYİMLERİ
            // =========================

            addSectionTitle(document, "İŞ DENEYİMLERİ");

            List<WorkExperience> experiences =
                    resume.getWorkExperiences();

            for (WorkExperience experience : experiences) {

                document.add(
                        new Paragraph(
                                experience.getCompanyName()
                        )
                                .setBold()
                                .setFontSize(12)
                                .setFontColor(
                                        new DeviceRgb(35, 55, 75)
                                )
                                .setMarginBottom(2)
                );

                document.add(
                        new Paragraph(
                                experience.getPosition()
                                        + " | "
                                        + experience.getPeriod()
                        )
                                .setFontSize(10.5f)
                                .setBold()
                                .setMarginBottom(3)
                );

                document.add(
                        new Paragraph(
                                experience.getDescription()
                        )
                                .setFontSize(10)
                                .setMarginBottom(8)
                );
            }

            // =========================
            // TEKNİK YETENEKLER
            // =========================

            addSectionTitle(document, "TEKNİK YETENEKLER");

            document.add(
                    new Paragraph(
                            "Java  •  Nesne Yönelimli Programlama  •  "
                                    + "Maven  •  PDF Oluşturma  •  "
                                    + "Git / GitHub"
                    )
                            .setFontSize(10.5f)
                            .setMarginBottom(5)
            );

            document.close();

            System.out.println(
                    "CV başarıyla oluşturuldu: " + outputPath
            );

        } catch (Exception e) {

            System.out.println(
                    "PDF oluşturulurken hata oluştu: "
                            + e.getMessage()
            );
        }
    }

    // Bölüm başlıklarını oluşturan yardımcı metot
    private void addSectionTitle(
            Document document,
            String title
    ) {

        document.add(
                new Paragraph(title)
                        .setFontSize(13)
                        .setBold()
                        .setFontColor(
                                new DeviceRgb(35, 55, 75)
                        )
                        .setMarginTop(6)
                        .setMarginBottom(5)
        );
    }
}