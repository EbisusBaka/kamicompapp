package ebisus.monkagiga.kamicompapp.core.domain

import okhttp3.internal.and
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

class Blowfish(private val key: String) {

    fun decrypt(hash: String): String {
        val kd: ByteArray = key.toByteArray(Charsets.UTF_8)

        val ks = SecretKeySpec(kd, "Blowfish")
        val cipher = Cipher.getInstance("Blowfish")
        cipher.init(Cipher.DECRYPT_MODE, ks)

        val decrypted = cipher.doFinal(hexStringToByteArray(hash))

        return String(decrypted.map {
            it.toInt()
                .toChar()
        }
            .toCharArray())
    }

    fun encrypt(text: String): String {
        val kd: ByteArray = key.toByteArray(Charsets.UTF_8)

        val ks = SecretKeySpec(kd, "Blowfish")
        val cipher = Cipher.getInstance("Blowfish")
        cipher.init(Cipher.ENCRYPT_MODE, ks)

        val encrypted = cipher.doFinal(
            text.toByteArray(Charsets.UTF_8)
        )

        return byteArrayToHexString(encrypted)
    }

    private fun hexStringToByteArray(hex: String): ByteArray {
        val l = hex.length
        val data = ByteArray(l / 2)
        var i = 0
        while (i < l) {
            data[i / 2] = ((Character.digit(hex[i], 16) shl 4)
                + Character.digit(hex[i + 1], 16)).toByte()
            i += 2
        }
        return data
    }

    private fun byteArrayToHexString(byteArray: ByteArray): String {
        val hexChars = ByteArray(byteArray.size * 2)
        for (j in byteArray.indices) {
            val v: Int = byteArray[j] and 0xFF
            hexChars[j * 2] = HEX_ARRAY[v ushr 4]
            hexChars[j * 2 + 1] = HEX_ARRAY[v and 0x0F]
        }
        return String(hexChars, Charsets.UTF_8)
    }

    companion object {

        private val HEX_ARRAY: ByteArray = "0123456789ABCDEF".toByteArray(Charsets.US_ASCII)
    }
}
