package ebisus.monkagiga.kamicompapp.core.domain.entities

enum class MetadataKey(val metadataType: MetadataType) {
    STATUS_ID(MetadataType.INTEGER),
    AMOUNT(MetadataType.FLOAT)
}
