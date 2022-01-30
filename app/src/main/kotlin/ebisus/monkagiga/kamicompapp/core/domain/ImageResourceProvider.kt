package ebisus.monkagiga.kamicompapp.core.domain

class ImageResourceProvider(private val blowfish: Blowfish) {

    fun getPath(key1: String, key2: String, id: Int, skin: Int?, format: String): String {
        val fullKey = "${key1}_${key2}_" + id.toString()
            .padStart(4, '0') + if (skin != null) "_$skin" else ""
        val encryptedPath = blowfish.encrypt(fullKey)
            .lowercase()
        val subFolder1 = encryptedPath.takeLast(6)
            .take(3)
        val subFolder2 = encryptedPath.takeLast(3)
        return "$RESOURCE_BASE_PATH/$subFolder1/$subFolder2/$encryptedPath.$format"
    }

    companion object {

        private const val RESOURCE_BASE_PATH = "https://cf.static.r.kamihimeproject.dmmgames.com/resources/pc/normal"
    }
}
