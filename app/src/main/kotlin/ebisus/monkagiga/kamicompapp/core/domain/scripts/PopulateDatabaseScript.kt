package ebisus.monkagiga.kamicompapp.core.domain.scripts

import ebisus.monkagiga.kamicompapp.core.domain.repository.EidolonRepository
import ebisus.monkagiga.kamicompapp.core.domain.repository.KamihimeRepository
import javax.inject.Inject

class PopulateDatabaseScript @Inject constructor(
    private val kamihimeRepository: KamihimeRepository,
    private val eidolonRepository: EidolonRepository
) {

    suspend fun populate() {
        PopulateKamihimeScript().populate(kamihimeRepository)
        PopulateEidolonScript().populate(eidolonRepository)
    }
}
