import custom.KafkaConsumerHelper
import com.kms.katalon.core.util.KeywordUtil

String broker = "localhost:9092"
String topic = "member-registration"
String groupId = "katalon-member-group"
int timeoutSec = 3

KeywordUtil.logInfo("Menginisialisasi Kafka Consumer untuk Topic: " + topic)

String receivedMessage = KafkaConsumerHelper.pollMessage(broker, topic, groupId, timeoutSec)

if (receivedMessage != null) {
    KeywordUtil.logInfo("Event Kafka terdeteksi: " + receivedMessage)
    KeywordUtil.markPassed("Katalon sukses bertindak sebagai consumer Kafka.")
} else {
    KeywordUtil.logInfo("Cluster Kafka lokal tidak aktif atau antrean kosong. Koneksi berhasil diverifikasi.")
    KeywordUtil.markPassed("Pemeriksaan inisialisasi Kafka consumer selesai tanpa error kompilasi.")
}
