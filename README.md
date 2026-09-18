# Katalon Automation Test - REST API & Apache Kafka

Repositori ini memuat implementasi technical test otomasi pengujian menggunakan **Katalon Studio** berbasis **Java**:
1. **RESTful API Testing**: Implementasi HTTP client murni untuk menguji peran Katalon sebagai data producer (HTTP POST) dan data consumer (HTTP GET).
2. **Kafka Consumer Testing**: Menggunakan library Apache Kafka Client bawaan Java untuk mengonsumsi message dari topic broker.

---

## Prasyarat Lingkungan
- Katalon Studio (v8.x atau yang lebih baru)
- JDK 11 atau JDK 17
- Jar file `kafka-clients` diletakkan di dalam direktori `Drivers/`

---

## Detail Pengujian

### 1. REST API (Producer & Consumer)
- **Keyword**: `custom.ApiHelper.java`
- **Test Case**: `TC01_REST_Producer_Consumer`
- **Skenario**:
  - Katalon memproduksi request POST yang berisi JSON payload ke mock service.
  - Katalon mengonsumsi data via GET request dan memvalidasi keutuhan respon body.

### 2. Kafka Consumer
- **Keyword**: `custom.KafkaConsumerHelper.java`
- **Test Case**: `TC02_Kafka_Consumer`
- **Skenario**:
  - Inisialisasi properti Kafka Consumer (`bootstrap.servers`, `group.id`, deserializer).
  - Melakukan `poll()` ke topic target untuk memverifikasi penerimaan record.
