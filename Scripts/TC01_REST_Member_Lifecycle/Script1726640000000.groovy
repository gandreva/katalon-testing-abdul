import custom.ApiHelper
import com.kms.katalon.core.util.KeywordUtil
import groovy.json.JsonSlurper

String baseUrl = "https://jsonplaceholder.typicode.com/users"

// 1. PRODUCER: Membuat data Member baru via POST
KeywordUtil.logInfo("Executing: POST Member")
String createPayload = '{"name":"Yohanes Kevin","username":"ykevin","email":"kevin@example.com"}'
String postResult = ApiHelper.executeHttpRequest(baseUrl, "POST", createPayload)
KeywordUtil.logInfo("POST Output: " + postResult)
assert postResult.startsWith("CODE:201") || postResult.startsWith("CODE:200") : "Gagal POST Member"

// 2. CONSUMER: Mengambil seluruh daftar Member via GET
KeywordUtil.logInfo("Executing: GET All Member")
String getAllResult = ApiHelper.executeHttpRequest(baseUrl, "GET", null)
assert getAllResult.startsWith("CODE:200") : "Gagal GET All Member"

// 3. CONSUMER: Mengambil spesifik member (ID: 1)
KeywordUtil.logInfo("Executing: GET Spesifik Member")
String getSingleResult = ApiHelper.executeHttpRequest(baseUrl + "/1", "GET", null)
assert getSingleResult.startsWith("CODE:200") : "Gagal GET Spesifik Member"

// 4. PRODUCER: Update member via PUT
KeywordUtil.logInfo("Executing: PUT Member")
String updatePayload = '{"name":"Yohanes Kevin Updated","username":"ykevin_edit"}'
String putResult = ApiHelper.executeHttpRequest(baseUrl + "/1", "PUT", updatePayload)
assert putResult.startsWith("CODE:200") : "Gagal PUT Member"

// 5. Menghapus member via DELETE
KeywordUtil.logInfo("Executing: DELETE Member")
String deleteResult = ApiHelper.executeHttpRequest(baseUrl + "/1", "DELETE", null)
assert deleteResult.startsWith("CODE:200") : "Gagal DELETE Member"

KeywordUtil.markPassed("Semua siklus pengujian CRUD Member API berhasil dieksekusi.")
