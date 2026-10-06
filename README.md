# Java PDF CV Generator

Java programlama dili kullanılarak geliştirilmiş, kullanıcıya ait kişisel bilgiler, eğitim bilgileri ve iş deneyimlerini kullanarak PDF formatında CV oluşturan bir uygulamadır.

Proje, Java ve iText PDF kütüphanesi kullanılarak geliştirilmiştir. Oluşturulan CV içerisinde kişisel bilgiler, profil fotoğrafı, eğitim bilgileri, iş deneyimleri ve teknik yetenekler düzenli bir şekilde gösterilmektedir.

---

## 📌 Projenin Amacı

Bu projenin amacı, Java programlama dili kullanılarak nesne yönelimli programlama prensiplerinin uygulanması ve iText kütüphanesi kullanılarak dinamik olarak PDF dosyası oluşturulmasıdır.

Program içerisinde kullanıcı bilgileri Java nesneleri içerisinde tutulmakta ve bu bilgiler `PdfResumeGenerator` sınıfı tarafından işlenerek PDF formatında CV'ye dönüştürülmektedir.

---

# 🛠 Kullanılan Teknolojiler

- Java
- Maven
- iText PDF 8
- IntelliJ IDEA
- Git
- GitHub
- Segoe UI TrueType Font
- PDF dosya formatı
- ChatGPT

---

# 🧩 Kullanılan Sınıflar ve Nesneler

Projede farklı sorumluluklara sahip sınıflar oluşturulmuştur. Her sınıf belirli bir veri grubunu veya işlemi yönetmektedir.

## 1. PersonalInfo

`PersonalInfo` sınıfı kişinin temel kişisel bilgilerini tutmak için kullanılmıştır.

Tutulan bilgiler:

- Ad Soyad
- Ünvan
- E-posta
- Telefon
- Adres

### Neden kullanıldı?

Kişisel bilgilerin tek bir sınıf içerisinde tutulması, kodun daha düzenli ve yönetilebilir olmasını sağlar.

Örneğin:

```java
PersonalInfo personalInfo = new PersonalInfo(
    "Nazlı Arslan",
    "Software Engineer",
    "nazliarslan938@gmail.com",
    "0555 555 55 55",
    "Sakarya, Türkiye"
);
