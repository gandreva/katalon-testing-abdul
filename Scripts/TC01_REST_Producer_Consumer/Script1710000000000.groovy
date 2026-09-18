import custom.ApiHelper
import com.kms.katalon.core.util.KeywordUtil

String baseUrl = "https://jsonplaceholder.typicode.com/posts"

// 1. PRODUCER: Katalon memproduksi dan mengirim payload
KeywordUtil.logInfo("[PRODUCER] Mengirim request pembuatan data baru...")
String payload = '{"title":"automated test","body":"katalon task submission","userId":1}'
String postResponse = ApiHelper.sendPost(baseUrl, payload)

KeywordUtil.logInfo("Response dari POST: " + postResponse)
assert postResponse.contains("automated test") : "Gagal memverifikasi payload pada response POST"

// 2. CONSUMER: Katalon membaca resource dari endpoint
KeywordUtil.logInfo("[CONSUMER] Mengambil data dari endpoint server...")
String getResponse = ApiHelper.sendGet(baseUrl + "/1")

KeywordUtil.logInfo("Response dari GET: " + getResponse)
assert getResponse.contains("id") : "Gagal membaca data dari server GET response"

KeywordUtil.markPassed("Pengujian REST API (Producer & Consumer) berhasil.")
