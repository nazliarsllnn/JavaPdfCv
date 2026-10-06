package com.cv;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        PersonalInfo personalInfo = new PersonalInfo(
                "Nazlı Arslan",
                "Software Engineer",
                "nazliaslan938@gmail.com",
                "0555 555 55 55",
                "Sakarya, Türkiye"
        );

        Education education = new Education(
                "Sakarya Üniversitesi",
                "Yazılım Mühendisliği",
                "2021 - 2025"
        );

        WorkExperience experience1 = new WorkExperience(
                "AAA Şirketi",
                "Java Developer",
                "2023 - 2024",
                "Java tabanlı uygulamaların geliştirilmesi ve "
                        + "bakım süreçlerinde görev aldım."
        );

        WorkExperience experience2 = new WorkExperience(
                "XYZ Yazılım",
                "Backend Developer",
                "2024 - 2025",
                "Backend servislerinin geliştirilmesi ve "
                        + "veritabanı işlemlerinin yönetilmesinde görev aldım."
        );

        WorkExperience experience3 = new WorkExperience(
                "Nare Software",
                "Web Geliştirici",
                "2025 - Günümüz",
                "Şirket için gerekli ve uygun web siteleri geliştirdim ve "
                        + "geliştirmeye devam ediyorum."
        );

        List<WorkExperience> workExperiences = Arrays.asList(
                experience1,
                experience2,
                experience3
        );

        Resume resume = new Resume(
                personalInfo,
                education,
                workExperiences
        );

        PdfResumeGenerator generator = new PdfResumeGenerator();

        generator.generate(
                resume,
                "cv.pdf",
                "src/main/resources/profile.jpeg"
        );
    }
}