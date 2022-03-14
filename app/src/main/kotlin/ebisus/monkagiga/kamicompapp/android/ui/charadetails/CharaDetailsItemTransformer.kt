package ebisus.monkagiga.kamicompapp.android.ui.charadetails

import ebisus.monkagiga.kamicompapp.core.domain.ImageResourceProvider
import ebisus.monkagiga.kamicompapp.core.domain.embedded.KamihimeDetails
import javax.inject.Inject

class CharaDetailsItemTransformer @Inject constructor(
    private var imageResourceProvider: ImageResourceProvider
) {

    fun transform(id: Long, kamihimeDetails: KamihimeDetails?, sfw: Boolean): List<CharaDetailsItem> {
        return buildList<CharaDetailsItem> {
            add(
                CharaDetailsItem.Image(
                    imageUrl = imageResourceProvider.getPath(
                        "illust-com-kneeshot",
                        "chara",
                        id,
                        0,
                        "png",
                        sfw = sfw
                    ),
                    sfw = sfw
                )
            )
            kamihimeDetails?.abilities?.forEach {
                add(
                    CharaDetailsItem.Ability(
                        ability = it,
                        abilityIconUrl = imageResourceProvider.getPath(
                            "coreimg",
                            "abilityicon",
                            it.ability.abilityIconId,
                            null,
                            "png",
                            sfw = false
                        )
                    )
                )
            }
        }
    }
}
