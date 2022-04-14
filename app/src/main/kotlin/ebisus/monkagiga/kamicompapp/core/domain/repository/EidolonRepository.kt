package ebisus.monkagiga.kamicompapp.core.domain.repository

import ebisus.monkagiga.kamicompapp.core.domain.dao.EidolonDao
import ebisus.monkagiga.kamicompapp.core.domain.entities.Eidolon
import javax.inject.Inject

class EidolonRepository @Inject constructor(
    private val eidolonDao: EidolonDao
) {

    suspend fun getEidolon(id: Long): Eidolon? = eidolonDao.getEidolon(id)

    suspend fun getEidolonList(): List<Eidolon> = eidolonDao.getEidolonList()

    suspend fun updateEidolon(Eidolon: Eidolon) {
        eidolonDao.clearEidolon(Eidolon.id)
        val eidolonId = eidolonDao.updateEidolon(Eidolon)
    }
}
